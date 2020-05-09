package com.dilini19559052.assigement.shape;

import com.dilini19559052.assigement.board.Window;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2020-05-09
 * Time: 3:44 PM
 */

public abstract class DrawableShape extends Shape {

    protected final char drawingCharacter;

    protected DrawableShape(int rowBase, int colBase, char drawingCharacter) {
        super(rowBase, colBase);
        this.drawingCharacter = drawingCharacter;
    }

    public abstract void draw(Window window);

    public abstract void clear(Window window);

    protected abstract void draw(Window window, char character);

}
