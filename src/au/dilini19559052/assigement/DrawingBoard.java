package au.dilini19559052.assigement;

import au.dilini19559052.assigement.shape.Line;
import au.dilini19559052.assigement.shape.Shape;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-20
 * Time: 11:30 PM
 */
public class DrawingBoard {
    private static Scanner scanner = new Scanner(System.in);
    private static Window window = null;
    private static Line selectedLine = null;

    public static void main(String[] args) throws Exception {
        // Create or load a window
        // Display the window with grid added
        System.out.println("Enter the window file name (or NEW): ");
        String name = scanner.nextLine().trim();
        if (name.equalsIgnoreCase("NEW")) {
            System.out.println(
                    "Enter number of rows, number of columns and character (separated by space): ");
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            char ch = scanner.next().trim().charAt(0);
            window = new Window(rows, columns, ch);
            window.addGrid();
        } else {
            window = Window.readSpecFromFile(name);
        }

        boolean repeat = true;
        while (repeat) {
            System.out.println("\n");

            //you may add a call to the refreshImage() method you developed in Task 5
            window.display();

            System.out.println("Add Erase Select Write Quit");
            System.out.println("Up Down Left Right + -");

            String cmd = scanner.next();
            switch (cmd.toUpperCase().charAt(0)) {
                case 'U':
                    goUp();
                    break;
                case 'D':
                    goDown();
                    break;
                case 'L':
                    goLeft();
                    break;
                case 'R':
                    goRight();
                    break;
                case '+':
                    changeTheSize(true);
                    break;
                case '-':
                    changeTheSize(false);
                    break;
                case 'S':
                    selectShape();
                    break;
                case 'A':
                    addShape();
                    break;
                case 'E':
                    deleteShape();
                    break;
                case 'W':
                    writeSpecToFile();
                    break;
                case 'Q':
                    repeat = false;
                    break;    // quit
                default:
                    System.out.println("Wrong option chosen!");
            }
        } // while

        System.out.println("Thank You!");
    }

    private static void changeTheSize(boolean isIncrement) {
        selectedLine.setLength(
                selectedLine.getLength() + (isIncrement ? +1 : -1)
        );
    }

    private static void goRight() {
        if (isSelectAShape())
            selectedLine.setColBase(selectedLine.getColBase() + 1);
        window.refreshImage();
    }


    private static void goLeft() {
        if (isSelectAShape())
            selectedLine.setColBase(selectedLine.getColBase() - 1);
        window.refreshImage();
    }

    private static void goDown() {
        if (isSelectAShape())
            selectedLine.setRowBase(selectedLine.getRowBase() + 1);
        window.refreshImage();
    }

    private static void goUp() {
        if (isSelectAShape())
            selectedLine.setRowBase(selectedLine.getRowBase() - 1);
        window.refreshImage();
    }

    private static boolean isSelectAShape() {
        if (selectedLine != null)
            return true;
        else {
            System.out.println("Please select a shape.");
            return false;
        }
    }

    public static void selectShape() {
        showShapesWithIndex("Select the shape:");
        int shapeIndex = scanner.nextInt();

        Shape shape = window.getShapes().get(shapeIndex - 1);

        if (shape instanceof Line) {
            selectedLine = (Line) shape;
            System.out.println(selectedLine + " Selected!");
        } else {
            System.out.println("Please select a Line.");
        }
    }

    public static void addShape() {
        System.out.println("Line rowBase colBase length rowIncrement colIncrement character");
        int rowBase = scanner.nextInt();
        int colBase = scanner.nextInt();
        int length = scanner.nextInt();
        int rowIncrement = scanner.nextInt();
        int colIncrement = scanner.nextInt();
        char character = scanner.next().trim().charAt(0);
        window.addShape(
                new Line(
                        rowBase,
                        colBase,
                        length,
                        rowIncrement,
                        colIncrement,
                        character
                )
        );
    }

    public static void deleteShape() {
        showShapesWithIndex("Select the shape that you want to delete:");
        int shapeIndex = scanner.nextInt();
        window.getShapes().remove(shapeIndex - 1);
        window.refreshImage();
    }

    private static void showShapesWithIndex(String message) {
        System.out.println(message);
        for (int i = 1; i <= window.getShapes().size(); i++) {
            System.out.printf("%d: %s\n", i, window.getShapes().get(i - 1).toString());
        }
    }

    public static void writeSpecToFile() throws FileNotFoundException {
        System.out.print("File name: ");
        scanner.nextLine();
        String fileName = scanner.nextLine();
        window.writeSpecToFile(fileName);
        System.out.println("Done!");
    }

}
