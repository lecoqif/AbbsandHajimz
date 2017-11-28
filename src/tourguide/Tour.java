package tourguide;

import java.util.LinkedList;
import java.util.logging.Logger;

public class Tour {
	private static Logger logger = Logger.getLogger("tourguide");
	private String id;
	private String title;
	private Annotation annotation;
	private LinkedList<Waypoint> listOfWaypoints = new LinkedList<>();
	private LinkedList<Leg> listOfLegs = new LinkedList<>();

	public Tour(String id, String title, Annotation annotation) {
		this.id = id;
		this.title = title;
		this.annotation = annotation;
	}

	public void addWaypoint(Location loc, Annotation annotation) {
		logger.finer("Creating Waypoint");
		Waypoint wayPoint = new Waypoint(loc, annotation);
		listOfWaypoints.add(wayPoint);
	}

	public String getTitle() {
		return title;
	}

	public String getID() {
		return id;
	}

	public int numberOfLegs() {
		return listOfLegs.size();
	}

	public int numberOfWaypoints() {
		return listOfWaypoints.size();
	}
	
	public Annotation getAnnotation() {
		return annotation;
	}

	public void addLeg(Annotation annotation) {
		logger.finer("Creating leg");
		Leg leg = new Leg(annotation);
		listOfLegs.add(leg);
	}

	public Location getLastWaypoint() {
		return listOfWaypoints.get(listOfWaypoints.size() - 1).getLoc();
	}
	public Annotation getLegAnn(int cStage){
		Leg tmp = listOfLegs.get(cStage);
		return tmp.getAnnotation();
	}
	
	public Location getWaypointLoc(int cStage){
		Waypoint tmp = listOfWaypoints.get(cStage);
		return tmp.getLoc();
	}
}
