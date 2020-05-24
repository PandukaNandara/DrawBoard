/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 3:49 PM
 */
final public class Text extends IncreasableShape {

    private String text;

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

    /**
     * Read the circle data from string.
     * The format is As below.
     * L,rowIncrement,colIncrement,text,rowBase,colBase
     */
    public static Text fromData(String data){
        String[] values = data.split(",");
        int rowIncrement = Integer.parseInt(values[1]);
        int colIncrement = Integer.parseInt(values[2]);
        String text = values[3];
        int rowBase = Integer.parseInt(values[4]);
        int colBase = Integer.parseInt(values[5]);
        return new Text(rowBase, colBase, text, rowIncrement, colIncrement);
    }

    @Override
    public String toData() {
        return String.format(
                "X,%d,%d,%s,%d,%d",
                rowIncrement,
                colIncrement,
                text,
                rowBase,
                colBase
        );
    }

    @Override
    public String toString() {
        return String.format("Text (%d, %d), (%s), (%d, %d)", rowIncrement, colIncrement, text, rowBase, colBase);
    }

    @Override
    public void clear(Window window) {
        for (int i = 0; i <= text.length(); i++) {
            window.putCharAt(' ', rowBase + (i * rowIncrement), colBase + (i * colIncrement));
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
