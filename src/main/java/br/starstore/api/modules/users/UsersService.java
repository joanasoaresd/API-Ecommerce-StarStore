package br.starstore.api.modules.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.stereotype.Service;

import br.starstore.api.config.JwtTokenUtil;
import br.starstore.api.entities.Users;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repository;

	@Autowired
	private JwtTokenUtil jwttoken;

	public Users save(Users user) {
		return this.repository.save(user);
	}

	public List<Users> listAllUsers() {
		return this.repository.findAll();
	}

	public Optional<Users> getUsersById(Integer id) {
		return this.repository.findById(id);

	}

	public Users setUserById(Integer id, Users user) {
		int idOldUser = this.repository.findById(id).get().getId();
		user.setId(idOldUser);
		return save(user);
	}

	public String authenticate(String email, String password) throws Exception {
		try {
			Optional<Users> optUser = repository.findByEmail(email);
			if (optUser.isPresent() && password.equals(optUser.get().getPassword()))
				;
			return this.jwttoken.generateToken(email);

		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
