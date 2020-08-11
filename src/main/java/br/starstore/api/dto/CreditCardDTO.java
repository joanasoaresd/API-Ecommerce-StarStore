package br.starstore.api.dto;

public class CreditCardDTO {

	private int cartNumber;
	private String creditCardBanner;
	private int cvv;
	private String cardHolderName;
	private String expDate;

	public int getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
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
