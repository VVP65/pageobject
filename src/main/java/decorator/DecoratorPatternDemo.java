package decorator;

public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape polygon = new Polygon();

        Shape greenPolygon = new GreenShapeDecorator(new Polygon());

        Shape greenSquare = new GreenShapeDecorator(new Square());

        System.out.println("Polygon with normal border");
        polygon.draw();

        System.out.println("\nPolygon of green border");
        greenPolygon.draw();

        System.out.println("\nSquare of green border");
        greenSquare.draw();
    }
}