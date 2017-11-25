package tourguide;
import java.util.LinkedHashMap;

public class TourLibrary {
	private LinkedHashMap<String, Tour> library = new LinkedHashMap<String, Tour>();
	
	public void addTour(String id, Tour tour){
		library.put(id, tour);
	}
	
	public LinkedHashMap<String, Tour> getMap() {
		return library;
	}
}
