package com.dilini19559052.assigement.shape;

import com.dilini19559052.assigement.board.Window;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2020-05-09
 * Time: 3:47 PM
 */
final public class Triangle extends IncreasableDrawableShape  {
    private final int height;

    protected Triangle(int rowBase, int colBase, int rowIncrement, int colIncrement, int height, char drawingCharacter) {
        super(rowBase, colBase, drawingCharacter, rowIncrement, colIncrement);
        this.height = height;
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

    public int getHeight() {
        return height;
    }
}
