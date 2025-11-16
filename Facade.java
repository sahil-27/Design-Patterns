/**
 * Facade Pattern is a structural design pattern that provides a simplified interface to a complex subsystem.
 * It hides the complexities of the subsystem and provides a unified interface to the client.
 */

class HotelBooking {
	public void processPayment(double amount){
		System.out.println("Payment processing");
	}
	
	public boolean bookRoom(){
		System.out.println("booked room");
		return true;
	}
}

class CheckInOutProcess {
	public void checkIn(){
		System.out.println("Assigned room");
	}

	public void checkOut(){
		System.out.println("Checked out of room");
	}
}

class OrderFood {
	public void selectItem(){
		System.out.println("Item Selected");
	}
}

class HotelFacade {
	HotelBooking booking;
	CheckInOutProcess checkHotel;
	OrderFood foodService;

	public HotelFacade(){
		this.booking = new HotelBooking();
        this.checkHotel = new CheckInOutProcess();
        this.foodService = new OrderFood();
	}

	public void bookHotel(String name){
		booking.processPayment(1000);
		booking.bookRoom();
		checkHotel.checkIn();
		foodService.selectItem();
	}

	public void checkout(){
		checkHotel.checkOut();
	} 
}

public class Main{
	public static void main(String[] args){
		HotelFacade hotel = new HotelFacade();
		hotel.bookHotel("John");

		hotel.checkOut();
	}
}