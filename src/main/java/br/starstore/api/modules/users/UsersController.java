package br.starstore.api.modules.users;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.starstore.api.entities.Users;

@RestController
public class UsersController {

	@Autowired
	private UsersService service;

	@GetMapping("/ola")
	public String oi() {
		return "Olá Mundo!";

	}

	@GetMapping("/users")
	@ResponseBody
	public List<Users> getAllusers() {
		return this.service.listAllUsers();
	}

	@PostMapping("/users")
	@ResponseBody
	public Users createUser(@RequestBody Users user) {
		return this.service.save(user);

	}

	@GetMapping("/users/{id}")
	@ResponseBody
	public Optional<Users> getUserById(@PathVariable("Id") int id) {
		return this.service.getUsersById(id);

	}

	@PutMapping("/users/{id}")
	@ResponseBody
	public Users setUserById(@PathVariable("id") int id, @RequestBody Users user) {
		return this.service.setUserById(id, user);

	}

}
