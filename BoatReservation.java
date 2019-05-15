import java.util.ArrayList;

public class BoatReservation extends Reservation{

	ArrayList<String> preferences = new ArrayList<String>();
	
	public BoatReservation(int timeSlot, String customerName) {
		super(customerName, timeSlot);
		
	}//boat preference is sorted by which boat is entered into the boat reservation first;
	
	public void addBoatPreference(String boatName) {//adds boat to preference
		preferences.add(boatName);
	}
	
	public ArrayList<String> getPreferences(){//return preference arraylist
		return preferences;
	}

}
