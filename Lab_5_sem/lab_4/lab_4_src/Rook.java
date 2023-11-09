package lab_4.lab_4_src;

public class Rook extends Figure{
    public Rook(String name, char color, int row, int col) {
        super(name, color, row, col);
    }

    @Override
    public boolean canMove(int row1, int col1, Figure[][] location) {
        if (this.getRow() == row1 || this.getCol() == col1){
            int dir = 0;
            if (Math.abs(this.getRow() - row1) != 0) {
                if (this.getRow() < row1)
                    dir = 1;
                else
                    dir = -1;
                if (!checkEmptyFields(this.getRow(), row1, dir, this.getCol(), location))
                    return false;
            }
            if (Math.abs(this.getCol() - col1) != 0) {
                if (this.getCol() < col1)
                    dir = 1;
                else
                    dir = -1;
                if (!checkEmptyFields(this.getCol(), col1, dir, this.getRow(), location))
                    return false;
            }
            return true;
        }
        return false;
    }

    private boolean checkEmptyFields(int start, int end, int step, int index, Figure[][] location) {
        for (int i = start + step; Math.abs(end - i) > 0; i = i + step) {
            if (location[index][i] != null)
                return false;
        }
        return true;
    }
}