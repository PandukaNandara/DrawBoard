package com.dilini19559052.assigement.shape;

import com.dilini19559052.assigement.board.Window;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2020-05-09
 * Time: 3:49 PM
 */
final public class Text extends IncreasableShape {

    private final String text;

    protected Text(int rowBase,
                   int colBase,
                   String text,
                   int rowIncrement,
                   int colIncrement) {
        super(rowBase, colBase, rowIncrement, colIncrement);
        this.text = text;
    }

    @Override
    public void draw(Window window) {

    }

    @Override
    public void clear(Window window) {

    }
}
