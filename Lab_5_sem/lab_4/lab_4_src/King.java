package lab_4.lab_4_src;

public class King extends Figure{
    public King(String name, char color, int row, int col) {
        super(name, color, row, col);
    }

    @Override
    public boolean canMove(int row1, int col1, Figure[][] location) {
        boolean isrow;
        if (Math.abs(this.getRow() - row1) == 1 && this.getCol() == col1)
            isrow = true;
        else
            isrow = false;

        boolean iscol;
        if (this.getRow() == row1 && Math.abs(this.getCol() - col1) == 1)
            iscol = true;
        else
            iscol = false;

        boolean isdeagonal;
        if (Math.abs(this.getRow() - row1) == 1 && Math.abs(this.getCol() - col1) == 1)
            isdeagonal = true;
        else
            isdeagonal = false;

        if (isrow)
            return true;
        if (iscol)
            return true;
        if (isdeagonal)
            return true;
        return false;
    }
}
