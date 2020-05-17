package au.dilini19559052.assigement.shape;

import au.dilini19559052.assigement.board.Window;

/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 3:49 PM
 */
final public class Text extends IncreasableShape {

    private final String text;

    public Text(int rowBase,
                   int colBase,
                   String text,
                   int rowIncrement,
                   int colIncrement) {
        super(rowBase, colBase, rowIncrement, colIncrement);
        this.text = text;
    }

    @Override
    public void draw(Window window) {
        for (int i = 0; i < text.length(); i++) {
            window.putCharAt(text.charAt(i), rowBase + (i * rowIncrement), colBase + (i * colIncrement));
        }
    }

    @Override
    public void clear(Window window) {
        for (int i = 0; i <= text.length(); i++) {
            window.putCharAt(' ', rowBase + (i * rowIncrement), colBase + (i * colIncrement));
        }
    }
}
