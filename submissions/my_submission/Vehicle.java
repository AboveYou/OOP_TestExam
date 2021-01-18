import interfaces.IControllable;
import interfaces.IRenderObject;

public abstract class Vehicle implements IControllable, IRenderObject {

    protected double rotation;
    protected double positionX;
    protected double positionY;

    public Vehicle (double rotation, double positionX, double positionY) {
        this.rotation = rotation;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public void turnLeft(double degree) {
        this.rotation += degree;
        if (this.rotation>360) {
            this.rotation -= 360;
        }
        if (this.rotation<0) {
            this.rotation = 360 + this.rotation;
        }
    }

    @Override
    public void turnRight(double degree) {
        this.turnLeft(-degree);
    }

    @Override
    public void moveForward(double distance) {
        double radians = Math.toRadians(this.rotation);
        this.positionY += this.round(Math.sin(radians) * distance, 4);
        this.positionX += this.round(Math.cos(radians) * distance, 4);
    }

    // round the coordinates to x decimal places
    private double round(double num, int places) {
        double round_scale = Math.pow(10, places);
        return Math.round(round_scale * num) / round_scale;
    }

    @Override
    public void moveBackward(double distance) {
        this.moveForward(-distance);
    }

    // setters
    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    // getters
    public double getRotation() {
        return rotation;
    }

    public double getPositionX() {
        return positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        // might be changed to avoid float (double) comparison
        return Double.compare(vehicle.positionX, positionX) == 0 && Double.compare(vehicle.positionY, positionY) == 0;
    }
}