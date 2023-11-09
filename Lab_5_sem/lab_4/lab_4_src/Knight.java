package lab_4.lab_4_src;

public class Knight extends Figure{
    public Knight(String name, char color, int row, int col) {
        super(name, color, row, col);
    }

    @Override
    public boolean canMove(int row1, int col1, Figure[][] location) {
        int rowDiff = Math.abs(this.getRow() - row1);
        int colDiff = Math.abs(this.getCol() - col1);
        if (rowDiff == 1)
            if (colDiff == 2)
                return true;
        if (rowDiff == 2)
            if (colDiff == 1)
                return true;
        return false;
    }
}