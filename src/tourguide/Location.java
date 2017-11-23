package tourguide;

public class Location {
	private double easting;
	private double northing;
	public Location(double easting, double northing) {
		this.easting = easting;
		this.northing = northing;
	}
	public Location getLocation(){
		return new Location(easting, northing);
	}
	public double getEasting() {
		return easting;
	}
	public double getNorthing() {
		return northing;
	}
}
