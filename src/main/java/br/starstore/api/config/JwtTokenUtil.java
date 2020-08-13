package br.starstore.api.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	private static final long serialVersionUID = -2550185165626007488L;
	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	// JWTClaimsSet claimsSet = new JWTClaimsSet();

	@Value("${jwt.secret}")
	private String secret;

	// retorna o username do token jwt
	public String getUsernameFromToken(String token) {
		return getAllClaimsFromToken(token).getSubject();
	}

	// retorna expiration date do token jwt
	public Date getExpirationDateFromToken(String token) {
		return getAllClaimsFromToken(token).getExpiration();
	}

	
	private Claims getAllClaimsFromToken(String token) {
		System.out.println("Entrou aqui");
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			// ("Could not get all claims Token from passed token");
			claims = null;
		}
		
		return claims;
	}
	
	public String getSecret() {
		return this.secret;
	}

	// check if the token has expired
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	// gera token para user
	public String generateToken(String email) {
		Map<String, Object> claims = new HashMap<String, Object>();
		System.out.println("Criou token");
		return doGenerateToken(claims, email);
	}

	// Cria o token e devine tempo de expiração pra ele
	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	// valida o token
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = getUsernameFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
}
