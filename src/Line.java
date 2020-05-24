/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 3:47 PM
 */
final public class Line extends IncreasableDrawableShape {
    private int length;

    public Line(int rowBase,
                int colBase,
                int length,
                int rowIncrement,
                int colIncrement,
                char drawingCharacter) {
        super(rowBase, colBase, drawingCharacter, rowIncrement, colIncrement);
        this.length = length;
    }

    /**
     * Read the circle data from string.
     * The format is As below.
     * L,rowIncrement,colIncrement,length,rowBase,colBase,drawingCharacter
     */
    public static Line fromData(String data){
        String[] values = data.split(",");
        int rowIncrement = Integer.parseInt(values[1]);
        int colIncrement = Integer.parseInt(values[2]);
        int length = Integer.parseInt(values[3]);
        int rowBase = Integer.parseInt(values[4]);
        int colBase = Integer.parseInt(values[5]);
        char drawingCharacter = values[6].charAt(0);
        return new Line(rowBase, colBase, length, rowIncrement, colIncrement, drawingCharacter);
    }

    @Override
    public void draw(Window window) {
        draw(window, drawingCharacter);
    }

    @Override
    public String toData() {
        return String.format(
                "L,%d,%d,%d,%d,%d,%c",
                rowIncrement,
                colIncrement,
                length,
                rowBase,
                colBase,
                drawingCharacter
        );
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

    @Override
    public String toString() {
        return String.format(
                "Line (%d, %d) (%d) (%d, %d) (%c)",
                rowIncrement,
                colIncrement,
                length,
                rowBase,
                colBase,
                drawingCharacter
        );
    }

    public void setLength(int length) {
        this.length = length;
    }
}
