package decorator;

import tests.BaseTest;

public class Polygon implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape: Polygon");
    }
}