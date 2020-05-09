package com.dilini19559052.assigement.shape;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2020-05-09
 * Time: 5:00 PM
 */
public abstract class IncreasableDrawableShape extends DrawableShape {

    protected final int rowIncrement;
    protected final int colIncrement;

    protected IncreasableDrawableShape(int rowBase, int colBase, char drawingCharacter, int rowIncrement, int colIncrement) {
        super(rowBase, colBase, drawingCharacter);
        this.rowIncrement = rowIncrement;
        this.colIncrement = colIncrement;
    }

}
