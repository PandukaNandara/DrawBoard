/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 3:47 PM
 */
final public class Rectangle extends DrawableShape {
    private int height;
    private int width;

    public Rectangle(int rowBase, int colBase, int height, int width, char drawingCharacter) {
        super(rowBase, colBase, drawingCharacter);
        this.height = height;
        this.width = width;
    }

    /**
     * Read the circle data from string.
     * The format is As below.
     * L,height,width,rowBase,colBase,drawingCharacter
     */
    public static Rectangle fromData(String data){
        String[] values = data.split(",");
        int height = Integer.parseInt(values[1]);
        int width = Integer.parseInt(values[2]);
        int rowBase = Integer.parseInt(values[3]);
        int colBase = Integer.parseInt(values[4]);
        char drawingCharacter = values[5].charAt(0);
        return new Rectangle(rowBase,colBase,height,width,drawingCharacter);
    }

    @Override
    public void draw(Window window) {
        draw(window, drawingCharacter);
    }

    @Override
    public String toData() {
        return String.format("R,%d,%d,%d,%d,%s",
                height,
                width,
                rowBase,
                colBase,
                drawingCharacter);
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

    @Override
    public String toString() {
        return String.format("Rectangle (%d), (%d), (%d, %d), (%s)", height, width, rowBase, colBase, drawingCharacter);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
