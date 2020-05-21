package au.dilini19559052.assigement.shape;

import au.dilini19559052.assigement.Window;

/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 4:59 PM
 */
public abstract class Shape {
    protected int rowBase;
    protected int colBase;

    protected Shape(int rowBase, int colBase) {
        this.rowBase = rowBase;
        this.colBase = colBase;
    }

    public abstract void draw(Window window);
    public abstract String toData();
    public abstract void clear(Window window);

    public int getRowBase() {
        return rowBase;
    }

    public void setRowBase(int rowBase) {
        this.rowBase = rowBase;
    }

    public int getColBase() {
        return colBase;
    }

    public void setColBase(int colBase) {
        this.colBase = colBase;
    }
}
