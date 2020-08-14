package br.starstore.api.modules.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.stereotype.Service;

import br.starstore.api.config.JwtTokenUtil;
import br.starstore.api.entities.Users;
import br.starstore.api.exceptions.InvalidUserException;
import br.starstore.api.exceptions.UserAlreadyExistsException;
import br.starstore.api.exceptions.UserNotFoundException;
import br.starstore.api.handlers.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repository;

	@Autowired
	private JwtTokenUtil jwttoken;

	@ApiOperation(value = "Cadastrar um novo usuário", response = Response.class, notes = "Essa operação salva um novo registro com as informações de pessoa.")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um ResponseModel com uma mensagem de sucesso", response = Response.class),
			@ApiResponse(code = 500, message = "Caso tenhamos algum erro vamos retornar um ResponseModel com a Exception", response = Response.class) })
	public Users save(Users user) throws UserAlreadyExistsException, InvalidUserException {
		if (repository.findByEmail(user.getEmail()).isPresent()) {
			throw new UserAlreadyExistsException();
		} else if (!isValid(user)) {
			throw new InvalidUserException();
		}
		return this.repository.save(user);
	}

	public List<Users> listAllUsers() {
		return this.repository.findAll();
	}

	public Optional<Users> getUsersById(Integer id) throws UserNotFoundException {
		Optional<Users> user = this.repository.findById(id);
		if (!this.isValid(user.get())) {
			throw new UserNotFoundException();
		}
		return user;

	}

	public Users updateUserById(Integer id, Users user) throws UserNotFoundException {
		if (!(repository.count() == 0 || id < 0 || id > repository.count())) {
			Optional<Users> oldUser = this.repository.findById(id);
			if (oldUser.isPresent()) {
				int idOldUser = oldUser.get().getId();
				user.setId(idOldUser);
				return repository.save(user);
			}
		}
		throw new UserNotFoundException();

	}

	public String authenticate(String email, String password) throws Exception {
		try {
			Optional<Users> optUser = repository.findByEmail(email);
			if (optUser.isPresent() && password.equals(optUser.get().getPassword())) {
				return this.jwttoken.generateToken(email);
			} else {
				throw new BadCredentialsException("INVALID_CREDENTIALS");
			}

		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	public boolean isValid(Users user) {
		return !user.getEmail().isEmpty() && !user.getName().isEmpty() && !user.getPassword().isEmpty();
	}
}
