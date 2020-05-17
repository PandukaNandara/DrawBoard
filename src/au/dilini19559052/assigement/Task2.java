package au.dilini19559052.assigement;

import au.dilini19559052.assigement.board.Window;
import au.dilini19559052.assigement.shape.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-14
 * Time: 3:00 PM
 */
public class Task2 {
    public static void main(String[] args) {

        // Create a window
        Window w = new Window(20, 30, '*');
        // Draw the ground
        Line ground = new Line(19, 1, 29, 0, 1, '#');
        w.addShape(ground);
        // Draw the post
        Line post = new Line(12, 5, 6, 1, 0, '#');
        w.addShape(post);
        // Draw the light
        Circle light = new Circle(10, 5, 2, '+');
        w.addShape(light);
        // Draw the house
        Rectangle house = new Rectangle(8, 16, 11, 10, '=');
        w.addShape(house);
        // Draw the door
        Rectangle door = new Rectangle(11, 19, 8, 4, '=');
        w.addShape(door);
        // Draw the roof
        Triangle roof = new Triangle(2, 21, 6, 1, 0, '*');
        w.addShape(roof);
        // Display text message
        Text msg = new Text(2, 10, "FOR SALE", 1, 0);

        w.addShape(msg);

        w.display();
    }
}
