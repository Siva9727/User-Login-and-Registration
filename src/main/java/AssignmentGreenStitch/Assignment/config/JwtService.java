package AssignmentGreenStitch.Assignment.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY = "7538782F413F4428472D4B6150645367566B5970337336763979244226452948";
    public String extractUserEmail(String jToken) {
        return extractClaims(jToken,Claims::getSubject);
    }

    public String generateToken(UserDetails userDetails){
        return generateToken(new HashMap<>(),userDetails);
    }

    public String generateToken(Map<String,Object>extraClaims, UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isTokenValid(String jToken,UserDetails userDetails){
        final String username = extractUserEmail(jToken);
        return(username.equals(userDetails.getUsername()) && !TokenExpired(jToken));
    }

    private boolean TokenExpired(String jToken) {
        return extractExpiration(jToken).before(new Date());
    }

    private Date extractExpiration(String jToken) {
        return extractClaims(jToken,Claims::getExpiration);
    }

    public <T> T extractClaims(String jToken, Function<Claims,T> claimsSolver){
        final Claims claims = extractAllClaims(jToken);
        return claimsSolver.apply(claims);
    }

    public Claims extractAllClaims(String jToken){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(jToken).getBody();
    }

    private Key getSignInKey() {
        byte[] byteCode = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(byteCode);
    }
}
