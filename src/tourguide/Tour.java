package tourguide;

import java.util.LinkedList;

public class Tour {
	private String id;
	private String title;
	private Annotation annotation;
	private LinkedList<Waypoint> listOfWaypoints = new LinkedList<>();
	private LinkedList<Leg> listOfLegs = new LinkedList<>();
	public Tour(String id, String title, Annotation annotation){
		this.id = id;
		this.title = title;
		this.annotation = annotation; 
	}
	public void addWaypoint(Location loc, Annotation annotation){
		Waypoint wayPoint = new Waypoint(loc, annotation);
		listOfWaypoints.add(wayPoint);
	}
	public String getTitle() {
		return title;
	}
	
	public int numberOfLegs() {
		return listOfLegs.size();
	}
	
	public int numberOfWaypoints() {
		return listOfWaypoints.size();
	}
	public void addLeg(Annotation annotation){
		Leg leg = new Leg(annotation);
		listOfLegs.add(leg);
	}
	public Location getLastWaypoint() {
		return listOfWaypoints.get(listOfWaypoints.size() - 1).getLoc();
	}
}