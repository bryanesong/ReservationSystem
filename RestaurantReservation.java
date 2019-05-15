

public class RestaurantReservation extends Reservation{

	private int seatsNeeded;
	public RestaurantReservation(int seatsNeeded, int timeNeeded,String id) { //consturctor to make a restaurant reservation
		super(id,timeNeeded);
		this.seatsNeeded = seatsNeeded;
		
	}
	
	public int getSeatsNeeded() {
		return seatsNeeded;
	}
	
	public int findFitnessValue(Reservation res) {
		return res.getTime();
	}
	
	@Override //tostring method
	public String toString() {
		return "Name: "+super.getCustomer()+" Time: "+super.getTime()+" Seats Needed: "+seatsNeeded+"\n";
	}
}
