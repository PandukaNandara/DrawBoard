package au.dilini19559052.assigement;

import au.dilini19559052.assigement.shape.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 3:46 PM
 */
public class Window {
    private final List<List<Character>> drawBoard = new ArrayList<>();
    private final List<Shape> shapes = new ArrayList<>();
    private int numberOfRows;
    private int numberOfColumns;
    private char borderCharacter;

    private boolean isGridEnable = false;

    public Window() {
    }

    public Window(int numberOfRows, int numberOfColumns, char borderCharacter) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.borderCharacter = borderCharacter;
    }

    public Window(int numberOfRows, int numberOfColumns, char borderCharacter, boolean isGridEnable) {
        this(numberOfRows, numberOfColumns, borderCharacter);
        this.isGridEnable = isGridEnable;
    }

    public static Window readSpecFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.canRead()) {
            return null;
        } else {
            Scanner scanner = new Scanner(file);

            Window window = Window.fromData(scanner.nextLine());

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                switch (line.charAt(0)) {
                    case 'C':
                        window.addShape(Circle.fromData(line));
                        break;
                    case 'L':
                        window.addShape(Line.fromData(line));
                        break;
                    case 'R':
                        window.addShape(Rectangle.fromData(line));
                        break;
                    case 'X':
                        window.addShape(Text.fromData(line));
                        break;
                    case 'T':
                        window.addShape(Triangle.fromData(line));
                        break;
                }
            }
            return window;
        }
    }

    private static List<Character> getCharList(char[] chars) {
        List<Character> characters = new ArrayList<>(chars.length);
        for (char aChar : chars) {
            characters.add(aChar);
        }
        return characters;
    }

    /**
     * Read the circle data from string.
     * The format is As below.
     * W,numberOfRows,numberOfColumns,borderCharacter,isGridEnable
     */
    public static Window fromData(String data) {
        String[] values = data.split(",");
        int numberOfRows = Integer.parseInt(values[1]);
        int numberOfColumns = Integer.parseInt(values[2]);
        char borderCharacter = values[3].charAt(0);
        boolean isGridEnabled = Boolean.parseBoolean(values[4]);
        return new Window(numberOfRows, numberOfColumns, borderCharacter, isGridEnabled);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    public void addGrid() {
        isGridEnable = true;
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void addShapes(Shape... shapes) {
        this.shapes.addAll(Arrays.asList(shapes));
    }

    public void removeShape(String id) {
        shapes.removeIf(shape -> shape.toString().equals(id));
    }

    public void display() {
        display(shapes.size() != 0);
    }

    private void display(boolean withShapes) {

        makeDrawBoarder();
        if (withShapes) {
            shapes.forEach(shape -> shape.draw(this));
        }
        printDrawBoard();
    }

    private void printDrawBoard() {
        for (List<Character> characters : drawBoard) {
            for (Character one : characters) {
                System.out.print(one);
            }
            System.out.println();
        }
    }

    public void putCharAt(char character, int row, int column) {
        drawBoard.get(row).set(column, character);
    }

    private void makeDrawBoarder() {
        drawBoard.clear();
        int indexY = 0;
        for (int i = 0; i <= numberOfRows + 1; i++) {
            List<Character> arrayList = new ArrayList<>();
            int columnLimit = numberOfColumns + 1;
            int indexX = 1;

            for (int j = 0; j <= columnLimit; j++) {
                if (i == 0 || i == numberOfRows + 1) {
                    if (!isGridEnable || j == 0 || j == columnLimit)
                        arrayList.add(borderCharacter);
                    else {
                        arrayList.add((char) ('0' + indexX));
                        indexX++;
                        if (indexX == 10) indexX = 0;
                    }
                } else if (j == 0 || j == columnLimit) {
                    if (!isGridEnable)
                        arrayList.add(borderCharacter);
                    else {

                        arrayList.add((char) ('0' + indexY));
                    }
                } else {
                    arrayList.add(' ');
                }
            }
            indexY++;
            if (indexY == 10) indexY = 0;
            drawBoard.add(arrayList);
        }
    }

    public String toData() {
        return String.format(
                "W,%d,%d,%s,%b",
                numberOfRows,
                numberOfColumns,
                borderCharacter,
                isGridEnable
        );
    }

    /**
     * The structure of the file is look like this.
     * Window Data
     * Shape1 data
     * Shape2 data
     * Shape3 data
     * Shape4 data
     * .
     * .
     * .
     */
    public void writeSpecToFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        PrintStream printer = new PrintStream(file);
        printer.println(this.toData());
        for (Shape shape : shapes) {
            printer.println(shape.toData());
        }
        printer.flush();
    }

    public void refreshImage() {
        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 1; j <= numberOfColumns; j++) {
                drawBoard.get(i).set(j, ' ');
            }
        }
    }


}
