package com.dilini19559052.assigement.shape;

import com.dilini19559052.assigement.board.Window;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2020-05-09
 * Time: 3:48 PM
 */
final public class Circle extends DrawableShape  {

    private final int radius;

    protected Circle(int rowBase,
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

    }

    public int getRadius() {
        return radius;
    }

}
