package br.starstore.api.modules.payments;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.starstore.api.entities.Payments;

@RestController
public class PaymentsController {

	@Autowired
	private PaymentsService service;

	@PostMapping("/payments")
	@ResponseBody
	public Payments createPayments(@RequestBody Payments payment) {
		return this.service.save(payment);

	}

	@GetMapping("/payments")
	@ResponseBody
	public List<Payments> getAllPayments() {
		return this.service.listAllPayments();
	}

	@GetMapping("/payments/{clientId}")
	@ResponseBody
	public Optional<Payments> getPaymentsByIdClient(@PathVariable("clientId") int idClient) {
		return this.service.getPaymentsByIdClient(idClient);
	}

}
