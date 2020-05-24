/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 3:56 PM
 */
public abstract class IncreasableShape extends Shape {

    protected final int rowIncrement;
    protected final int colIncrement;

    protected IncreasableShape(int rowBase, int colBase, int rowIncrement, int colIncrement) {
        super(rowBase, colBase);
        this.rowIncrement = rowIncrement;
        this.colIncrement = colIncrement;
    }
}
