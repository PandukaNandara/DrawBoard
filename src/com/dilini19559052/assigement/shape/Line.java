package com.dilini19559052.assigement.shape;

import com.dilini19559052.assigement.board.Window;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2020-05-09
 * Time: 3:47 PM
 */
final public class Line extends IncreasableDrawableShape{
    private final int length;

    public Line(int rowBase,
                   int colBase,
                   int length,
                   int rowIncrement,
                   int colIncrement,
                   char drawingCharacter) {
        super(rowBase, colBase, drawingCharacter, rowIncrement, colIncrement);
        this.length = length;
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
        for (int i = 0; i <= length; i++) {
            window.putCharAt(character, rowBase + (i * rowIncrement), colBase + (i * colIncrement));
        }
    }

    public int getLength() {
        return length;
    }

}
