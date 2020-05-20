package au.dilini19559052.assigement;

import au.dilini19559052.assigement.board.Window;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 2020-05-17
 * Time: 8:25 PM
 */
public class T4Main {
    public static void main(String[] args) throws FileNotFoundException {
        Window window = Window.readSpecFromFile("T3Drawing.txt");
        if(window != null)
            window.display();
        else
            System.out.println("Error while reading the file.");
    }
}
