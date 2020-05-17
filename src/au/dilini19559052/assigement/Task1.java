package au.dilini19559052.assigement;

import au.dilini19559052.assigement.board.Window;
import au.dilini19559052.assigement.shape.Line;

/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 3:00 PM
 */
public class Task1 {

    public static void main(String[] args) {
        Window window = new Window(20, 20, '*');
        int row = 10, column = 10, length = 5;

        Line line = new Line(row, column, length, 0, 1, '1');
        window.addShape(line);
        line = new Line(row, column, length, 1, 1, '2');
        window.addShape(line);
        line = new Line(row, column, length, 1, 0, '3');
        window.addShape(line);
        line = new Line(row, column, length, 1, -1, '4');
        window.addShape(line);
        line = new Line(row, column, length, 0, -1, '5');
        window.addShape(line);
        line = new Line(row, column, length, -1, -1, '6');
        window.addShape(line);
        line = new Line(row, column, length, -1, 0, '7');
        window.addShape(line);
        line = new Line(row, column, length, -1, 1, '8');
        window.addShape(line);
        window.display();
    }
}
