package br.starstore.api.modules.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.starstore.api.entities.Users;

@Service
public class UsersService {

	@Autowired
	private UsersRepository repository;

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
}
