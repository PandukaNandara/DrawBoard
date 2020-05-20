package au.dilini19559052.assigement;

import au.dilini19559052.assigement.board.Window;
import au.dilini19559052.assigement.shape.Circle;
import au.dilini19559052.assigement.shape.Shape;
import au.dilini19559052.assigement.shape.Text;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2020-05-20
 * Time: 10:07 PM
 */
public class T5Main {
    public static void main(String[] args) {
        Window window = new Window(100,100,'*');
        window.addGrid();
        Shape shape = new Circle(50,50, 40,'*');
        window.addShapes(shape);
        window.display();
    }
}
