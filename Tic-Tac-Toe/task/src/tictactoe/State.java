package tictactoe;

public enum State {
    EMPTY,
    X,
    O;

    @Override
    public String toString() {
        switch (this) {
            case EMPTY:
                return " ";
            case X:
                return "X";
            case O:
                return "O";
            default:
                throw new IllegalStateException();
        }
    }
}
