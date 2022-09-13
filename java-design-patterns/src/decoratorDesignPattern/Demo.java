package decoratorDesignPattern;

public class Demo {

    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(circle);
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("Circle with red border");
        redCircle.draw();
    }
}
