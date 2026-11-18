/**
 * Abstract base class representing any entity on the 2D mission grid
 * that holds X and Y spatial coordinates.
 * Satisfies LO1 (Single Responsibility) and LO4 (Inheritance/Polymorphism).
 * 
 * @author Emre Ozguneri
 */
public abstract class TrackableEntity {

    protected double x;
    protected double y;

    /**
     * Constructs a TrackableEntity at the specified coordinates.
     * 
     * @param x Horizontal coordinate on the grid (0 - 500)
     * @param y Vertical coordinate on the grid (0 - 500)
     */
    public TrackableEntity(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    /**
     * Polymorphic method requiring subclasses to provide a formatted status string.
     * 
     * @return Formatted status description
     */
    public abstract String getEntityStatus();
}