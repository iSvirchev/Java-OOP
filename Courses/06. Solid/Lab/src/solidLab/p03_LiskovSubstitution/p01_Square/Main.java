package solidLab.p03_LiskovSubstitution.p01_Square;

public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5,2);
        Shape square = new Square(2);

        rectangle.getArea();
        square.getArea();
    }
}
