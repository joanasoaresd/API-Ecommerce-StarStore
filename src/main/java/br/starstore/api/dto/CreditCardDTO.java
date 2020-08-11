package br.starstore.api.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CreditCardDTO {

	@Column(name = "cardNumber")
	private int cardNumber;
	@Column(name = "creditCardBanner")
	private String creditCardBanner;
	@Column(name = "cvv")
	private int cvv;
	@Column(name = "cardHolderName")
	private String cardHolderName;
	@Column(name = "expDate")
	private String expDate;

	public CreditCardDTO() {

	}

	public int getCartNumber() {
		return cardNumber;
	}

	public void setCartNumber(int cartNumber) {
		this.cardNumber = cartNumber;
	}

	public String getCreditCardBanner() {
		return creditCardBanner;
	}

	public void setCreditCardBanner(String creditCardBanner) {
		this.creditCardBanner = creditCardBanner;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

}
