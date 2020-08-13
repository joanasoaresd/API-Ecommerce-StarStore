package br.starstore.api.modules.users;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.starstore.api.entities.Users;
import br.starstore.api.exceptions.InvalidUserException;
import br.starstore.api.exceptions.UserAlreadyExistsException;
import br.starstore.api.exceptions.UserNotFoundException;
import br.starstore.api.handlers.Response;

@RestController
public class UsersController {

	@Autowired
	private UsersService service;

	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<?> authenticationToken(@RequestBody Users user) throws ServletException {
		try {
			return new Response().sucefull(this.service.authenticate(user.getEmail(), user.getPassword()));
		} catch (Exception e) {
			return new Response().acessDenied(e.getMessage());
		}
	}

	@GetMapping("/users")
	@ResponseBody
	public ResponseEntity<?> getAllusers() {
		return new Response().sucefull(this.service.listAllUsers());
	}

	@PostMapping("/users")
	@ResponseBody
	public ResponseEntity<?> createUser(@RequestBody Users user) {
		try {
			return new Response().sucefull(this.service.save(user));
		} catch (UserAlreadyExistsException e) {
			return new Response().alreadyExists("User already exists");
		}
		catch (InvalidUserException e) {
			return new Response().invalidParams("This user is invalid");
		}
	}

	@GetMapping("/users/{id}")
	@ResponseBody
	public ResponseEntity<?> getUserById(@PathVariable("id") int id) {
		try {
			return new Response().sucefull(this.service.getUsersById(id));
		} catch (UserNotFoundException e) {
			return new Response().notFound("User not found");
		}
	}

	@PutMapping("/users/{id}")
	@ResponseBody
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Users user) {
		try {
			return new Response().sucefull(this.service.updateUserById(id, user));
		} catch (UserNotFoundException e) {
			return new Response().notFound("User not found to upddate");
		}

	}

}
