package au.dilini19559052.assigement.shape;

import au.dilini19559052.assigement.board.Window;

/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 3:47 PM
 */
final public class Triangle extends IncreasableDrawableShape {
    private final int height;

    public Triangle(int rowBase, int colBase, int height, int rowIncrement, int colIncrement, char drawingCharacter) {
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

    public int getHeight() {
        return height;
    }
}
