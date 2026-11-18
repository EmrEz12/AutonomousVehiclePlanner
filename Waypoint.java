/**
 * Represents a target navigation waypoint with coordinates, target speed, and task label.
 * Waypoint IS-A TrackableEntity (Inheritance - LO4).
 * 
 * @author Emre Ozguneri
 */
public class Waypoint extends TrackableEntity {

    private double targetSpeed;
    private String actionLabel;

    /**
     * Constructs a validated Waypoint.
     * 
     * @param x           X-coordinate (must be between 0 and 500)
     * @param y           Y-coordinate (must be between 0 and 500)
     * @param targetSpeed Speed in m/s (must be greater than 0)
     * @param actionLabel Description of action at waypoint
     * @throws InvalidWaypointException if coordinates are out of bounds or speed <= 0
     */
    public Waypoint(double x, double y, double targetSpeed, String actionLabel) throws InvalidWaypointException {
        super(x, y);
        if (x < 0 || x > 500 || y < 0 || y > 500) {
            throw new InvalidWaypointException("Coordinates must be within grid bounds (0 to 500).");
        }
        if (targetSpeed <= 0) {
            throw new InvalidWaypointException("Target speed must be greater than 0 m/s.");
        }
        this.targetSpeed = targetSpeed;
        this.actionLabel = (actionLabel == null || actionLabel.trim().isEmpty()) ? "Navigate" : actionLabel.trim();
    }

    public double getTargetSpeed() {
        return targetSpeed;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    @Override
    public String getEntityStatus() {
        return String.format("Waypoint (%.1f, %.1f) | Speed: %.1f m/s | Action: %s", x, y, targetSpeed, actionLabel);
    }

    @Override
    public String toString() {
        return String.format("(%.0f, %.0f) @ %.1f m/s [%s]", x, y, targetSpeed, actionLabel);
    }
}