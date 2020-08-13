package br.starstore.api.modules.payments;

import org.springframework.data.jpa.repository.JpaRepository;

import br.starstore.api.entities.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Integer> {

}
