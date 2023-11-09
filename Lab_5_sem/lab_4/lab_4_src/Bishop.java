package lab_4.lab_4_src;

public class Bishop extends Figure{
    public Bishop(String name, char color, int row, int col) {
        super(name, color, row, col);
    }

    @Override
    public boolean canMove(int row1, int col1, Figure[][] location) {
        if (Math.abs(this.getRow() - row1) == Math.abs(this.getCol()-col1)){
            int row_dir = this.getRow() < row1 ? 1 : -1;
            int col_dir = this.getCol() < col1 ? 1 : -1;
            int i = this.getRow() + row_dir;
            int j = this.getCol() + col_dir;
            while (Math.abs(row1 - i) > 0 || Math.abs(col1 - j) > 0) {
                if (location[i][j] != null)
                    return false;
                i += row_dir;
                j += col_dir;
            }
            return true;
        }
        return false;
    }
}