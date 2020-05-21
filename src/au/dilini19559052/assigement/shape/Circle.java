package au.dilini19559052.assigement.shape;

import au.dilini19559052.assigement.Window;

/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 3:48 PM
 */
final public class Circle extends DrawableShape {

    private int radius;

    public Circle(int rowBase,
                  int colBase,
                  int radius,
                  char drawingCharacter) {
        super(rowBase, colBase, drawingCharacter);
        this.radius = radius;
    }


    /**
     * Read the circle data from string.
     * The format is As below.
     * C,rowBase,colBase,radius,drawingCharacter
     */
    public static Circle fromData(String data) {
        String[] values = data.split(",");
        int rowBase = Integer.parseInt(values[1]);
        int colBase = Integer.parseInt(values[2]);
        int radius = Integer.parseInt(values[3]);
        char drawingCharacter = values[4].charAt(0);
        return new Circle(rowBase,colBase, radius,drawingCharacter);
    }


    @Override
    public void draw(Window window) {
        draw(window, drawingCharacter);
    }

    @Override
    public String toData() {
        return String.format(
                "C,%d,%d,%d,%s",
                rowBase,
                colBase,
                radius,
                drawingCharacter
        );
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

    @Override
    public String toString() {
        return String.format(
                "Circle (%d, %d) (%d) (%s)",
                rowBase,
                colBase,
                radius,
                drawingCharacter
        );
    }
}
