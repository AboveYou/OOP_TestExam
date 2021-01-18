public class Car extends Vehicle {

    public Car(double rotation, double positionX, double positionY) {
        super(rotation, positionX, positionY);
    }

    public Car() {
        super(0, 0, 0);
    }

    @Override
    public String toString() {
        return "Car (x: " + positionX + ", y: " + positionY+ ")";
    }

    @Override
    public void render() {
        // println appends linebreak
        System.out.println(this.toString());
    }
}
