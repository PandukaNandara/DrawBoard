/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 3:47 PM
 */
final public class Triangle extends IncreasableDrawableShape {
    private int height;

    public Triangle(int rowBase, int colBase, int height, int rowIncrement, int colIncrement, char drawingCharacter) {
        super(rowBase, colBase, drawingCharacter, rowIncrement, colIncrement);
        this.height = height;
    }


    @Override
    public void draw(Window window) {
        draw(window, drawingCharacter);
    }

    /**
     * Read the circle data from string.
     * The format is As below.
     * T,rowIncrement,colIncrement,height,rowBase,colBase,drawingCharacter
     */
    public static Triangle fromData(String data){
        String[] values = data.split(",");
        int rowIncrement = Integer.parseInt(values[1]);
        int colIncrement = Integer.parseInt(values[2]);
        int height = Integer.parseInt(values[3]);
        int rowBase = Integer.parseInt(values[4]);
        int colBase = Integer.parseInt(values[5]);
        char drawingCharacter = values[6].charAt(0);
        return new Triangle(rowBase, colBase, height, rowIncrement, colIncrement, drawingCharacter);
    }

    @Override
    public String toData() {
        return String.format(
                "T,%d,%d,%d,%d,%d,%c",
                rowIncrement,
                colIncrement,
                height,
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
    public String toString() {
        return String.format(
                "Line (%d, %d) (%d) (%d, %d) (%c)",
                rowIncrement,
                colIncrement,
                height,
                rowBase,
                colBase,
                drawingCharacter
        );
    }

    @Override
    protected void draw(Window window, char character) {
        for (int i = 0; i <= height; i++) {
            for (int j = -i; j <= i; j++) {
                int xIncrement = getIncrementValue(j, j);
                int yIncrement = getIncrementValue(i, j);
                window.putCharAt(
                        j == -i || j == i || i == height ? character : ' ',
                        rowBase + yIncrement,
                        colBase + xIncrement
                );
            }
        }
    }

    private int getIncrementValue(int m, int n) {
        return (colIncrement == 1 && rowIncrement == 0) ? n :
                (colIncrement == 0 && rowIncrement == 1)
                        ? m :
                        (colIncrement == -1 && rowIncrement == 0)
                                ? -m : (colIncrement == 0 && rowIncrement == -1) ? -n : 0;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}
