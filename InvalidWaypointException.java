/**
 * Custom exception thrown when a user inputs invalid waypoint coordinates,
 * negative speeds, or corrupted mission file data.
 * Satisfies LO7 (Exception Handling).
 * 
 * @author Emre Ozguneri
 */
public class InvalidWaypointException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new InvalidWaypointException with a descriptive error message.
     * 
     * @param message Details explaining why the waypoint or input is invalid
     */
    public InvalidWaypointException(String message) {
        super(message);
    }
}