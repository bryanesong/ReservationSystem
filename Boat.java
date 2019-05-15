import java.util.Scanner;

public class Boat extends ReservableItem{

	private String name;
	
	public Boat(Scanner sc) {
		super(sc);
		this.name = sc.next();
		super.setResourceID(name);
		System.out.println("Adding Boat Type: "+name);
	}

	@Override
	public int getFitnessValue(Reservation res) { //will return 100-10 times the prefence placement of the boat
		if(res instanceof BoatReservation) {
			BoatReservation temp = (BoatReservation) res;
			int count = 0;
			for(String i : temp.getPreferences()) {
				if(i.equals(name)) {
					return 100-(count*10);
				}
				count++;
			}
			
			
		}else {
			return 0;
		}
		return 0;
	}
	
	public String toString() {
		return "id "+name;
	}

}
