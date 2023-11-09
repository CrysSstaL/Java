package lab_4.lab_4_src;

public class Pawn extends Figure {

    private boolean isFirstStep = true;

    public Pawn(String name, char color, int row, int col) {
        super(name, color, row, col);
    }

    @Override
    public boolean canMove(int row1, int col1, Figure[][] location) {
        if (Math.abs(this.getRow() - row1) == 2 ||
                Math.abs(this.getRow() - row1) == 1) {
            if (this.getCol() == col1) {
                if (this.isFirstStep) {
                    this.isFirstStep = false;
                }
                return true;
            }
        } else if (Math.abs(this.getRow() - row1) == 1) {
            if (this.getCol() == col1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canAttack(int row1, int col1, Figure nextField) {
        if (Math.abs(this.getRow() - row1) == 1 && Math.abs(this.getCol() - col1) == 1) {
            if (nextField.getColor() != this.getColor())
                return true;
            else
                return false;
        }
        return false;
    }
}
