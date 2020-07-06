package tictactoe;

public class Field {
    private Cell[][] cells;

    public Field(String input) {
        this.cells = convertToTwoDimArray(input);
    }

    public Field() {
        this.cells = convertToTwoDimArray();
    }

    public void draw() {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public void addMove(int x, int y) {
        cells[y][x].setState(whoShouldMove());
    }

    public State whoShouldMove() {
        int countX = 0;
        int countO = 0;
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if (cell.getState() == State.X) {
                    countX++;
                } else if (cell.getState() == State.O) {
                    countO++;
                }
            }
        }
        if (countX > countO) {
            return State.O;
        } else {
            return State.X;
        }
    }

    public boolean isMoveLegal(int x, int y) {
        return cells[y][x].getState() == State.EMPTY;
    }

    public Cell[][] convertToTwoDimArray(String input) {
        Cell[][] cells = new Cell[3][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (input.charAt(index) == 'X') {
                    cells[i][j] = new Cell(State.X);
                } else if (input.charAt(index) == 'O') {
                    cells[i][j] = new Cell(State.O);
                } else {
                    cells[i][j] = new Cell();
                }
                index++;
            }
        }
        return cells;
    }

    public Cell[][] convertToTwoDimArray() {
        Cell[][] cells = new Cell[3][3];
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell();
                index++;
            }
        }
        return cells;
    }

    public Cell[][] getCells() {
        return cells;
    }
}
