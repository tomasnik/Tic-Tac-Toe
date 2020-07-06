package tictactoe;

class Checker {
    private Cell[][] cells;

    public Checker(Cell[][] cells) {
        this.cells = cells;
    }

    public String check() {
        if (isImpossible()) {
            return "Impossible";
        } else if (isDraw()) {
            return "Draw";
        } else if (doesXWin()) {
            return "X wins";
        } else if (doesOWin()) {
            return "O wins";
        } else if (!isFinished()) {
            return "Game not finished";
        } else {
            return "Impossible";
        }
    }

    public boolean doesXWin() {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0].getState() == State.X && cells[i][1].getState() == State.X && cells[i][2].getState() == State.X) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (cells[0][j].getState() == State.X && cells[1][j].getState() == State.X && cells[2][j].getState() == State.X) {
                return true;
            }
        }
        return (cells[0][0].getState() == State.X && cells[1][1].getState() == State.X && cells[2][2].getState() == State.X) || (cells[0][2].getState() == State.X && cells[1][1].getState() == State.X && cells[2][0].getState() == State.X);
    }

    public boolean doesOWin() {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0].getState() == State.O && cells[i][1].getState() == State.O && cells[i][2].getState() == State.O) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (cells[0][j].getState() == State.O && cells[1][j].getState() == State.O && cells[2][j].getState() == State.O) {
                return true;
            }
        }
        return (cells[0][0].getState() == State.O && cells[1][1].getState() == State.O && cells[2][2].getState() == State.O) || (cells[0][2].getState() == State.O && cells[1][1].getState() == State.O && cells[2][0].getState() == State.O);
    }

    public boolean isImpossible() {
        if (doesXWin() && doesOWin()) {
            return true;
        }
        int xCount = 0, oCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j].getState() == State.X) {
                    xCount++;
                } else if (cells[i][j].getState() == State.O) {
                    oCount++;
                }
            }
        }
        if (xCount - oCount > 1 || oCount - xCount > 1) {
            return true;
        }
        return false;
    }


    public boolean isFinished() {
        if (doesXWin() || doesOWin()) {
            return true;
        } else return !isAnyCellEmpty();
    }

    public boolean isAnyCellEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j].getState() == State.EMPTY) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isDraw() {
        return !doesOWin() && !doesXWin() && !isAnyCellEmpty();
    }

    public void setCells(Cell[][] cells) {
        this.cells = cells;
    }
}