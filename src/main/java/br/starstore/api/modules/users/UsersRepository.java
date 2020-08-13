package br.starstore.api.modules.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.starstore.api.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Optional<Users> findByEmail(String email);
}
