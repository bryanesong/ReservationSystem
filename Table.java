import java.util.Scanner;

public class Table extends ReservableItem{
	private String id;
	private int numSeats;
	
	public Table(Scanner sc) {//constructor to read in tables
		super(sc);
		
		id = sc.next(); 	
		super.setResourceID(id);
		numSeats = sc.nextInt();

	}
	
	public int getNumSeats() { //returns number of avaliable seats at the table
		return numSeats;
	}
	
	//tostring method
	public String toString() {
		return "ID: "+id+" Seats: "+numSeats;
	}
	

	@Override
	public int getFitnessValue(Reservation res) {
		if(res instanceof RestaurantReservation) {
			RestaurantReservation temp = (RestaurantReservation) res;
			if(temp.getSeatsNeeded() == numSeats) {
				return 100;
			}else if(temp.getSeatsNeeded() > numSeats) {//will return the percentage of seats that can be taken up by party if not 0 or 100
				return 0;
			}else {
				return (int)(((double)temp.getSeatsNeeded() / numSeats)*100);
			}
		}else {
			return 0;
		}
	}
}
