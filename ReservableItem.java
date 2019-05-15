import java.util.Scanner;

//completed
public abstract class ReservableItem {
	
	private String ID;
	private Reservation[] reservations = new Reservation[10];//timeSlot
	private int takenSlots = 0;
	
	public ReservableItem(Scanner sc) {
		//"not actually needed in the parent class"
		//quoted from document
	}
	
	public abstract int getFitnessValue(Reservation res);
	
	
	//getters and setters
	public String getID() {
		return ID;
	}
	
	public void setResourceID(String ID) {
		this.ID = ID;
	}
	
	public Reservation[] getReservations() {
		return reservations;
	}
	
	public void setReservation(Reservation res,int index) {
		reservations[index] = res;
	}
}
