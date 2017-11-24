package tourguide;

public class Mode {
	private TourMode tourMode = TourMode.BROWSEMAIN; // Default priority
	
	public enum TourMode {
		BROWSEMAIN, BROWSESPECIFIC, CREATE, FOLLOW;
	}
	
	public void setMode(TourMode mode){
		this.tourMode = mode;
	}
	
	public TourMode getMode() {
		return tourMode;
	}
}
