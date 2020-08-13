package br.starstore.api.modules.payments;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.starstore.api.entities.Payments;

@Service
public class PaymentsService {

	@Autowired
	private PaymentsRepository repository;

	public Payments save(Payments p) {
		return this.repository.save(p);
	}

	public List<Payments> listAllPayments() {
		return this.repository.findAll();
	}

	public Optional<Payments> getPaymentsByIdClient(Integer id) {
		return this.repository.findById(id);
	}

}
