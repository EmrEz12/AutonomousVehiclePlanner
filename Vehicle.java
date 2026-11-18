/**
 * Simulates the autonomous vehicle moving between waypoints, tracking distance and battery.
 * Vehicle IS-A TrackableEntity (Inheritance - LO4).
 * 
 * @author Emre Ozguneri
 */
public class Vehicle extends TrackableEntity {

    private double currentVelocity;
    private double batteryPercentage;
    private double totalDistanceTraveled;

    /**
     * Initializes the vehicle at starting origin (0, 0) with 100% battery.
     */
    public Vehicle() {
        super(0.0, 0.0);
        this.currentVelocity = 0.0;
        this.batteryPercentage = 100.0;
        this.totalDistanceTraveled = 0.0;
    }

    /**
     * Moves the vehicle to a target waypoint and updates telemetry metrics.
     * 
     * @param target The destination Waypoint
     * @throws InvalidWaypointException if battery is depleted before reaching target
     */
    public void travelTo(Waypoint target) throws InvalidWaypointException {
        double dx = target.getX() - this.x;
        double dy = target.getY() - this.y;
        double segmentDistance = Math.hypot(dx, dy);

        // Battery drain proportional to distance and speed factor
        double energyCost = (segmentDistance * 0.04) + (target.getTargetSpeed() * 0.15);
        if (this.batteryPercentage - energyCost < 0) {
            throw new InvalidWaypointException("Insufficient battery to reach waypoint (" + target.getX() + ", " + target.getY() + ")!");
        }

        this.x = target.getX();
        this.y = target.getY();
        this.currentVelocity = target.getTargetSpeed();
        this.totalDistanceTraveled += segmentDistance;
        this.batteryPercentage -= energyCost;
    }

    /**
     * Resets vehicle telemetry back to initial starting state.
     */
    public void reset() {
        this.x = 0.0;
        this.y = 0.0;
        this.currentVelocity = 0.0;
        this.batteryPercentage = 100.0;
        this.totalDistanceTraveled = 0.0;
    }

    public double getCurrentVelocity() {
        return currentVelocity;
    }

    public double getBatteryPercentage() {
        return batteryPercentage;
    }

    public double getTotalDistanceTraveled() {
        return totalDistanceTraveled;
    }

    @Override
    public String getEntityStatus() {
        return String.format("Pos: (%.1f, %.1f) | Vel: %.1f m/s | Battery: %.1f%%", x, y, currentVelocity, batteryPercentage);
    }
}