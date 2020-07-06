package tictactoe;

import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private Field field;
    private Checker checker;

    public Game() {
        this.scanner = new Scanner(System.in);
        this.field = new Field();
        this.checker = new Checker(field.getCells());
    }

    public void start() {
        while (true) {
            field.draw();
            getCoordinates();
            checker.setCells(field.getCells());
            if (checker.isFinished()) {
                field.draw();
                System.out.println(checker.check());
                return;
            }
        }
    }

    private void getFromInput() {
        System.out.print("Enter cells: ");
        String input = scanner.nextLine();
        Field field = new Field(input);
        field.draw();
    }

    private void getCoordinates() {
        String input;
        while (true) {
            System.out.print("Enter the coordinates: ");
            input = scanner.nextLine();
            String[] coordinates = input.split(" ");
            try {
                int x = Math.abs(Integer.parseInt(coordinates[0]));
                int y = Math.abs(Integer.parseInt(coordinates[1]));
                if (x > 0 && y > 0 && x <= 3 && y <= 3) {
                    x = Math.abs(x - 1);
                    y = Math.abs(y - 3);
                    if (field.isMoveLegal(x, y)) {
                        field.addMove(x, y);
                        break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                } else {
                    System.out.println("Coordinates should be from 1 to 3!");
                }
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
            }
        }
    }
}
