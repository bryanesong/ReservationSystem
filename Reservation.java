
public class Reservation implements Comparable {
	
	private String customerName;
	private int timeSlot;
	private String ID;
	
	public Reservation(String customerName, int timeSlot) {
		this.customerName = customerName;
		this.timeSlot = timeSlot;
	}
	
	public void setResourceId(String id) {
		
	}
	
	@Override
	public int compareTo(Object other) {//compare to method
		try {
			if(this.getClass() != other.getClass()) {//checks for same class
				throw new Exception("Cannot compare Reservations");
			}
		}catch(Exception e) {//throws exception otherwise
			e.printStackTrace();
		}
		Reservation copy = (Reservation) other;
		if(this.customerName.equals(copy.customerName)) { //checks if customer name is equal to each other
			return 0;
		}else{
			return this.customerName.compareTo(copy.customerName);
		}
	}
	//getters and setters
	public String getCustomer() {
		return customerName;
	}
	
	public int getTime() {
		return timeSlot;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String s) {
		this.ID = s;
	}
	
	public String toString() {
		return "Name: "+customerName+" Time: "+timeSlot;
	}
	
}
