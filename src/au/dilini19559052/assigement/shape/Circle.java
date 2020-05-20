package au.dilini19559052.assigement.shape;

import au.dilini19559052.assigement.board.Window;

/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 3:48 PM
 */
final public class Circle extends DrawableShape {

    private final int radius;

    public Circle(int rowBase,
                  int colBase,
                  int radius,
                  char drawingCharacter) {
        super(rowBase, colBase, drawingCharacter);
        this.radius = radius;
    }


    @Override
    public void draw(Window window) {
        draw(window, drawingCharacter);
    }

    @Override
    public void clear(Window window) {
        draw(window, ' ');
    }

    @Override
    protected void draw(Window window, char character) {
        for (int a = 0; a < 360; a++) {
            double angle = a * Math.PI / 10;
            window.putCharAt(
                    character,
                    rowBase + (int) Math.round(radius * Math.cos(angle)),
                    colBase + (int) Math.round(radius * Math.sin(angle))
            );
        }
    }

    public int getRadius() {
        return radius;
    }

}
