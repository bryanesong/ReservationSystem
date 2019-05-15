import java.util.ArrayList;
import java.util.Arrays;

public class ResManager<ItemType, ResType> {
	//itemType is subclass of ReservableItem
	//resType is a reservation 
	
	ArrayList<ItemType> reservables = new ArrayList<>();//amount of tables/ boats
	ArrayList<ResType> reservations = new ArrayList<>();//amount of people who had stuff reserved
	
	public ResManager() {//no-arg constructor
		
	}
	
	public void addReservable(ReservableItem item) { //adds reservable item to arraylist such as boats or tables
		@SuppressWarnings("unchecked")
		ItemType copy = (ItemType) item;
		reservables.add(copy); //used to 
	}
	
	@SuppressWarnings("unchecked")
	public Reservation makeReservation(Reservation trialRes) { // adds reservation to reservation manager
		int bestFitValue = 0;
		int bestFitIndex = 0;
		int currentValue = 0;
			for(int i = 0;i<reservables.size();i++) {//iterates through reservables
				ReservableItem item = (ReservableItem)reservables.get(i);
				currentValue = item.getFitnessValue(trialRes);
				if(item.getReservations()[trialRes.getTime()] ==null) {	
					if(bestFitValue < currentValue) {//set best score
						bestFitValue = currentValue;
						bestFitIndex = i; //keeps track of bestfit index
					}
				}
			}
			if(bestFitValue ==0) {//checks if the reservation trial doesnt fit any of the criteria
				System.out.println("Unsuccessful Reservation: "+trialRes);//says error message
				return null;
			}else {
				ReservableItem item = (ReservableItem) reservables.get(bestFitIndex);
				item.setReservation(trialRes, trialRes.getTime()); 
				trialRes.setID(item.getID());//sets reservation id
				reservations.add((ResType) trialRes);//adds reservation to the arraylist
				return trialRes;
			}
		
	}
	
	@SuppressWarnings("unchecked")
	public void sortReservations() {//sorts through reservations by id using bubble sort
		int count = 0;
		while(count != reservations.size()-1) {//loops through list multiple times until sorted
			count = 0;
			for(int i = 0;i<reservations.size()-1;i++) {//iterates through list once
				Reservation temp = (Reservation) reservations.get(i);
				Reservation temp2 = (Reservation) reservations.get(i+1);
				if(temp.getCustomer().compareTo(temp2.getCustomer()) >0) {
					reservations.remove(temp);
					reservations.add((ResType)temp);
				}else {
					count++;
				}
			}
		}
		
	}
	
	public String toString() {//toString method for manager class
		String s = "";
		for(ResType i: reservations) {
			Reservation temp = (Reservation)i;
			s+=temp;
		}
		return s;
	}
}
