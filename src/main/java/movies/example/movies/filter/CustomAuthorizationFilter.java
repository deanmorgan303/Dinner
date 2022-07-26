package movies.example.movies.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;


import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomAuthorizationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getServletPath().equals("/login")){
            filterChain.doFilter(request,response);
        }else{
            String AuthHeader= request.getHeader(AUTHORIZATION);
            if(AuthHeader !=null && AuthHeader.startsWith("Bearer ")){

                try {

                    String token= AuthHeader.substring("Bearer ".length() );
                    Algorithm algorithm =Algorithm.HMAC256("GAza".getBytes());
                    JWTVerifier tokenVerifier= JWT.require(algorithm).build();
                    DecodedJWT decodedJWT=tokenVerifier.verify(token);
                    String username=decodedJWT.getSubject();
                    String[] roles=decodedJWT.getClaim("roles").asArray(String.class);

                    //System.out.println("decoded user");
                    //System.out.println(username);
                    //System.out.println(decodedJWT);

                    Collection<SimpleGrantedAuthority> authorities= new ArrayList<>();
                    stream(roles).forEach(role ->{
                        authorities.add(new SimpleGrantedAuthority(role));
                    });
                    //System.out.println(authorities);

                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,null,authorities);
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                    filterChain.doFilter(request,response);

                }catch (Exception exception){
                     System.out.println(exception.getMessage());
                     response.setHeader("error",exception.getMessage());
                     //response.sendError(FORBIDDEN.value());
                    Map<String,String> error =new HashMap<>();
                    error.put("error_message",exception.getMessage());
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    new ObjectMapper().writeValue(response.getOutputStream(),error);
                }

            }else{
                filterChain.doFilter(request,response);
            }
        }

    }


}
