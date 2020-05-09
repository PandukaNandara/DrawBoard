package com.dilini19559052.assigement.shape;

import com.dilini19559052.assigement.board.Window;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2020-05-09
 * Time: 3:47 PM
 */
final public class Rectangle extends DrawableShape {
    private final int height;
    private final int width;
    protected Rectangle(int rowBase, int colBase, int height, int width, char drawingCharacter) {
        super(rowBase, colBase, drawingCharacter);
        this.height = height;
        this.width = width;
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

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
