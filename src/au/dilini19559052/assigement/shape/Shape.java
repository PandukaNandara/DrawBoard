package au.dilini19559052.assigement.shape;

import au.dilini19559052.assigement.board.Window;

/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 4:59 PM
 */
public abstract class Shape {
    protected final int rowBase;
    protected final int colBase;

    protected Shape(int rowBase, int colBase) {
        this.rowBase = rowBase;
        this.colBase = colBase;
    }

    public abstract void draw(Window window);

    public abstract void clear(Window window);
}
