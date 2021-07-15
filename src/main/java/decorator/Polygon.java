package decorator;

public class Polygon implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Polygon");
    }
}