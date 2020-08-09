package br.starstore.api.modules.users;

import org.springframework.data.jpa.repository.JpaRepository;

import br.starstore.api.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
