package br.starstore.api.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.starstore.api.dto.CreditCardDTO;

@Entity
public class Payments {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int clientId;
	private String nameUser;
	private double totalpayable;
	private CreditCardDTO creditCard;

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public double getTotalpayable() {
		return totalpayable;
	}

	public void setTotalpayable(double totalpayable) {
		this.totalpayable = totalpayable;
	}

	public CreditCardDTO getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardDTO creditCard) {
		this.creditCard = creditCard;
	}

}
