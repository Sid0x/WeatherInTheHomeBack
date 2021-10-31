package skayev.WeatherInTheHomeBack.security;

import io.jsonwebtoken.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class AuthorizationFilter extends OncePerRequestFilter {

    private final String PREFIX = "Bearer ";
    private final String SECRET = "mySecretKey";
    protected final Log logger = LogFactory.getLog(this.getClass());


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION)).ifPresentOrElse(auth2 -> {
                    String token = auth2.replace(PREFIX, "");
                    getJwsClaims(token).ifPresentOrElse(jwsClaim -> {
                                Claims claims = jwsClaim.getBody();
                                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null, null);
                                SecurityContextHolder.getContext().setAuthentication(auth);
                            },
                            SecurityContextHolder::clearContext);
                },
                SecurityContextHolder::clearContext
        );

        chain.doFilter(request, response);
    }

    public Optional<Jws<Claims>> getJwsClaims(String token) {
        try {
            return Optional.ofNullable(Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(token));
        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature - {}", ex);
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token - {}", ex);
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token - {}", ex);
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token - {}", ex);
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty - {}", ex);
        }
        return Optional.empty();
    }

}
