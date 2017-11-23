package tourguide;
import java.util.HashMap;

public class TourLibrary {
	public HashMap<String, Tour> library = new HashMap<String, Tour>();
	
	public void addTour(String id, Tour tour){
		library.put(id, tour);
	}
}
