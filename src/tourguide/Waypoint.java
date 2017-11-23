package tourguide;

public class Waypoint {
	private Location loc;
	private Annotation annotation;
	public Waypoint(Location loc, Annotation annotation){
		this.loc = loc;
		this.annotation = annotation;
	}
}
