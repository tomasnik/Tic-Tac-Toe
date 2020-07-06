package tictactoe;

public class Cell {
    private State state;

    public Cell() {
        this.state = State.EMPTY;
    }

    public Cell(State state) {
        this.state = state;
    }

    public void setX() {
        this.state = State.X;
    }

    public void setO() {
        this.state = State.O;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    @Override
    public String toString() {
        return state.toString();
    }
}
