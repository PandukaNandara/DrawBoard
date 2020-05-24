import java.io.FileNotFoundException;

/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-17
 * Time: 7:15 PM
 */
public class T3Main {
    public static void main(String[] args) throws FileNotFoundException {
        Window w = new Window(20, 30, '*');

        Line line = new Line(19, 1, 29, 0, 1, '#');

        Line line2 = new Line(12, 5, 6, 1, 0, '#');

        Circle circle = new Circle(10, 5, 2, '+');

        Rectangle rectangle = new Rectangle(8, 16, 11, 10, '=');

        Rectangle rectangle1 = new Rectangle(11, 19, 8, 4, '=');

        Triangle triangle = new Triangle(2, 21, 6, 1, 0, '*');

        Text text = new Text(2, 10, "FOR SALE", 1, 0);
        w.addShapes(line,line2,circle, rectangle, rectangle1, triangle, text);
        w.writeSpecToFile("T3Drawing.txt.");

    }

}
