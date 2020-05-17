package au.dilini19559052.assigement.shape;

import au.dilini19559052.assigement.board.Window;

/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 3:47 PM
 */
final public class Rectangle extends DrawableShape {
    private final int height;
    private final int width;

    public Rectangle(int rowBase, int colBase, int height, int width, char drawingCharacter) {
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
        for (int i = 0; i <= height; i++) {
            for (int j = 0; j <= width; j++) {
                if (i == 0 || i == height) {
                    window.putCharAt(character, rowBase + i, colBase + j);
                } else if (j == 0 || j == width) {
                    window.putCharAt(character, rowBase + i, colBase + j);
                }
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
