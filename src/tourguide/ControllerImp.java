/**
 * 
 */
package tourguide;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author pbj
 */
public class ControllerImp implements Controller {
    private static Logger logger = Logger.getLogger("tourguide");
    private static final String LS = System.lineSeparator();
    private TourLibrary tourLib = new TourLibrary();
    private Tour test;
    private Location loc;
    private ArrayList<Chunk> chunkList = new ArrayList<>();
    private double waypointRadius;
    private double waypointSeparation;

    private String startBanner(String messageName) {
        return  LS 
                + "-------------------------------------------------------------" + LS
                + "MESSAGE: " + messageName + LS
                + "-------------------------------------------------------------";
    }
    
    public ControllerImp(double waypointRadius, double waypointSeparation) {
    	this.waypointRadius = waypointRadius;
    	this.waypointSeparation = waypointSeparation;
    }

    //--------------------------
    // Create tour mode
    //--------------------------

    // Some examples are shown below of use of logger calls.  The rest of the methods below that correspond 
    // to input messages could do with similar calls.
    
    @Override
    public Status startNewTour(String id, String title, Annotation annotation) {
        logger.fine(startBanner("startNewTour"));
        test = new Tour(id, title, annotation);
        tourLib.addTour(id, test);
        Chunk ch = new Chunk.CreateHeader(title, 0, 0);
        chunkList.add(ch);
        return Status.OK;
    }

    @Override
    public Status addWaypoint(Annotation annotation) {
        logger.fine(startBanner("addWaypoint"));
        if(test.numberOfWaypoints() > 0){
        	Location a = loc;
        	Location b = test.getLastWaypoint();
        	double dist = new Displacement(a.getEasting() - b.getEasting(), a.getNorthing() - b.getNorthing()).distance();
        	if(dist < waypointSeparation) return new Status.Error("Waypoint is too close to the previous one.");
        }
        if(test.numberOfLegs() == (test.numberOfWaypoints())){
        	test.addLeg(Annotation.getDefault());
        	test.addWaypoint(loc.getLocation(), annotation);
        } else {        	
        	test.addWaypoint(loc.getLocation(), annotation);
        } 
        Chunk ch = new Chunk.CreateHeader(test.getTitle(), test.numberOfLegs(), test.numberOfWaypoints());
        chunkList.add(ch);
        return Status.OK;
    }

    @Override
    public Status addLeg(Annotation annotation) {
        logger.fine(startBanner("addLeg"));
        
        if(test.numberOfLegs() == test.numberOfWaypoints()){
        	test.addLeg(annotation);
        	Chunk ch = new Chunk.CreateHeader(test.getTitle(), test.numberOfLegs(), test.numberOfWaypoints());
        	chunkList.add(ch);
        	return Status.OK;
        } else {
        	return new Status.Error("No waypoint between legs.");
        }
    }

    @Override
    public Status endNewTour() {
        logger.fine(startBanner("endNewTour"));
        return new Status.Error("unimplemented");
    }

    //--------------------------
    // Browse tours mode
    //--------------------------

    @Override
    public Status showTourDetails(String tourID) {
        return new Status.Error("unimplemented");
    }
  
    @Override
    public Status showToursOverview() {
        return new Status.Error("unimplemented");
    }

    //--------------------------
    // Follow tour mode
    //--------------------------
    
    @Override
    public Status followTour(String id) {
        return new Status.Error("unimplemented");
    }

    @Override
    public Status endSelectedTour() {
        return new Status.Error("unimplemented");
    }

    //--------------------------
    // Multi-mode methods
    //--------------------------
    @Override
    public void setLocation(double easting, double northing) {
    	loc = new Location(easting, northing);
    }

    @Override
    public List<Chunk> getOutput() {
        return chunkList;
    }


}
