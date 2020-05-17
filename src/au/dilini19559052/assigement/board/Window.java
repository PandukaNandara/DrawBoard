package au.dilini19559052.assigement.board;

import au.dilini19559052.assigement.shape.Shape;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author dilini
 * Date: 2020-05-09
 * Time: 3:46 PM
 */
public class Window {
    private final int numberOfRows;
    private final int numberOfColumns;
    private final char borderCharacter;

    private final List<List<Character>> drawBoard = new ArrayList<>();

    private final List<Shape> shapes = new ArrayList<>();

    public Window(int numberOfRows, int numberOfColumns, char borderCharacter) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.borderCharacter = borderCharacter;


    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public void removeShape(String id){
        shapes.removeIf(shape -> shape.toString().equals(id));
    }

    public void display(){
        makeDrawBoarder();
        shapes.forEach(shape -> shape.draw(this));
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

    public void putCharAt(char character, int row, int column){
        drawBoard.get(row).set(column , character);
    }

    private void makeDrawBoarder(){

        for (int i = 0; i <= numberOfRows + 1; i++) {
            List<Character> arrayList = new ArrayList<>();
            for (int j = 0; j <= numberOfColumns + 1; j++) {
                if(i == 0 || i == numberOfRows + 1) {
                    arrayList.add(borderCharacter);
                } else if(j == 0 || j == numberOfColumns + 1){
                    arrayList.add(borderCharacter);
                }else{
                    arrayList.add(' ');
                }
            }
            drawBoard.add(arrayList);
        }
    }
}
