/**
 * Adaptor is a structural design pattern that allows objects with incompatible interfaces to work together.
 * It acts as a bridge between two incompatible interfaces by wrapping an existing class with a new interface
 */

interface PaymentGateway {
	void processPayment(double amount);
	boolean validatePayment();
}

class PayPal {
	void sendPayment(double amount){
		System.out.println(amount+" Payment processing via PayPal");
	}

	boolean checkAccount() {
        System.out.println("PayPal account validated");
        return true;
    }
}

class Stripe {
	 void makePayment(double amount) {
        System.out.println("Processing $" + amount + " via Stripe");
    }
    
    boolean verifyCard() {
        System.out.println("Stripe card verified");
        return true;
    }
}

class PayPalAdaptor implements PaymentGateway {
	private PayPal payPal;

	public PayPalAdaptor(PayPal PayPal){
		this.payPal = PayPal;
	}

	@Override
	public void processPayment(double amount){
		payPal.sendPayment(amount);
	}

	@Override
	public boolean validatePayment(){
		return payPal.checkAccount();
	}

}

class StripeAdaptor implements PaymentGateway {
	private Stripe stripe;

	public StripeAdaptor(Stripe stripe){
		this.stripe = stripe;
	}

	@Override
	public void processPayment(double amount){
		stripe.makePayment(amount);
	}

	@Override
	public boolean validatePayment(){
		return stripe.verifyCard();
	}
}

class PaymentService { 
	PaymentGateway payment;
	public PaymentService(String type){
		if(type.equals("Stripe")){
			this.payment = new StripeAdaptor(new Stripe());
		}
		else if(type.equals("PayPal")){
			this.payment = new PayPalAdaptor(new PayPal());
		}
	}

	public void makePayment(double amount){
		if(payment.validatePayment()){
			payment.processPayment(amount);
		}
	}
}

public class Main {
	public static void main(String[] args){
		PaymentService service;
		service = new PaymentService("Stripe");
		service.makePayment(1000);

		service = new PaymentService("PayPal");
		service.makePayment(1000);
	}
}