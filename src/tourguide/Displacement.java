/**
 * Provides the ability to get a distance and bearing from
 * a central reference point given a set of coordinates.
 */
package tourguide;

import java.util.logging.Logger;

public class Displacement {
    private static Logger logger = Logger.getLogger("tourguide");
    /**
     * These are the parameters that are used by the class.
     */
    public double east;
    public double north;
    
    /**
     * Class constructor taking in an east and a north coordinate.
     * @param e represents the east coordinate with reference to the centre.
     * @param n represents the north coordinate with reference to the centre.
     */
    
    public Displacement(double e, double n) {
        logger.finer("East: " + e + "  North: "  + n);
        
        east = e;
        north = n;
    }
    
    /**
     * Function for finding the distance from the input coordinates
     * to the origin.
     * @return the absolute value of the distance 
     */
    
    public double distance() {
        logger.finer("Entering");
        
        return Math.sqrt(east * east + north * north);
    }
    
    // Bearings measured clockwise from north direction.
    /**
     * Function for finding the bearing as measured clockwise from
     * the north direction.
     * @return the angle of the coordinates from the centre
     */
    public double bearing() {
        logger.finer("Entering");
              
        // atan2(y,x) computes angle from x-axis towards y-axis, returning a negative result
        // when y is negative.
        
        double inRadians = Math.atan2(east, north);
        
        if (inRadians < 0) {
            inRadians = inRadians + 2 * Math.PI;
        }
        
        return Math.toDegrees(inRadians);
    }
        
    
    
}
