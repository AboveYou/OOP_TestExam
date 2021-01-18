public class Motorbike extends Vehicle {

    private double tiltAngle;

    public Motorbike(double rotation, double positionX, double positionY, double tiltAngle) {
        super(rotation, positionX, positionY);
        this.tiltAngle = tiltAngle;
    }

    public Motorbike() {
        super(0, 0, 0);
        this.tiltAngle = 0;
    }

    @Override
    public String toString() {
        return "Motorbike (x: " + positionX + ", y: " + positionY+ ")";
    }

    @Override
    public void render() {
        // println appends linebreak
        System.out.println(this.toString());
    }
}
