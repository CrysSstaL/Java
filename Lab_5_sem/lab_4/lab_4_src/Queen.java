package lab_4.lab_4_src;

public class Queen extends Figure{
    public Queen(String name, char color, int row, int col) {
        super(name, color, row, col);
    }

    @Override
    public boolean canMove(int row1, int col1, Figure[][] location) {
        if (this.getRow() == row1 && this.getCol() != col1 ||
                this.getRow() != row1 && this.getCol() == col1 ||
                Math.abs(this.getRow() - row1) == Math.abs(this.getCol() - col1)) {
            int rowDir = Integer.compare(row1, this.getRow());
            int colDir = Integer.compare(col1, this.getCol());
            int i = this.getRow() + rowDir;
            int j = this.getCol() + colDir;
            while (Math.abs(col1 - i) > 0 || Math.abs( col1 - j) > 0) {
                if (location[i][j] != null) {
                    return false;
                }
                i += rowDir;
                j += colDir;
            }
            return true;
        }
        return false;
    }
}
