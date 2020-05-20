package au.dilini19559052.assigement.board;

import au.dilini19559052.assigement.shape.Shape;

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

    public static Window readSpecFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.canRead()) {
            return null;
        } else {
            Scanner scanner = new Scanner(file);

            Window window = new Window();

            while (scanner.hasNext()) {
                window.drawBoard.add(getCharList(scanner.nextLine().toCharArray()));
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
        display(System.out, shapes.size() != 0);
    }

    private void display(PrintStream printStream, boolean withShapes) {
        if (withShapes) {
            if(!isAlreadyCreated())
                makeDrawBoarder();
            shapes.forEach(shape -> shape.draw(this));
        }
        printDrawBoard(printStream);
    }

    private void printDrawBoard(PrintStream printStream) {
        for (List<Character> characters : drawBoard) {
            for (Character one : characters) {
                printStream.print(one);
            }
            printStream.println();
        }
    }

    public void putCharAt(char character, int row, int column) {
        drawBoard.get(row).set(column, character);
    }

    private void makeDrawBoarder() {
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

    public void writeSpecToFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        PrintStream printer = new PrintStream(file);
        display(printer, true);
    }

    public void refreshImage() {
        if (isAlreadyCreated()) {
            for (int i = 1; i <= numberOfRows; i++) {
                for (int j = 1; j <= numberOfColumns; j++) {
                    drawBoard.get(i).set(j, ' ');
                }
            }
        }
    }

    private boolean isAlreadyCreated() {
        return drawBoard.size() > numberOfRows
            && drawBoard.get(0).size() > numberOfColumns;
    }
}
