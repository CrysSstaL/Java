package lab_4.lab_4_src;

// 1(w) - White 2(b) - Black;

public abstract class Figure {
    public char getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(char color) {
        this.color = color;
    }

    private String name;

    public String getName() {
        return name;
    }

    private char color;
    private int row;
    private int col;

    public Figure(String name, char color, int row, int col) {
        this.name = name;
        this.color = color;
        this.col = col;
        this.row = row;
    }

    public int getRow(){
        return this.row;
    }

    public int getCol(){
        return this.col;
    }
    public void setRow(int row){
        this.row = row;
    }
    public void setCol(int col){
        this.col = col;
    }

    public boolean canMove(int row1, int col1, Figure[][] location){
        boolean VR;
        if ((this.row >= 0 && this.row < 8) && (row1 >= 0 && row1 < 8))
            VR = true;
        else
            VR = false;

        boolean VC;
        if ((this.col >= 0 && this.col < 8) && (col1 >= 0 && col1 < 8))
            VC = true;
        else
            VC = false;

        boolean DiffR;
        if (this.row != row1)
            DiffR = true;
        else
            DiffR = false;

        boolean DiffC;
        if (this.col != col1)
            DiffC = true;
        else
            DiffC = false;

        if (VR)
            if (VC)
                if (DiffR)
                    if (DiffC)
                        return true;
        return false;
    }
    public boolean canAttack(int row1, int col1, Figure nextField){
        if (nextField.getColor() != this.getColor())
            return true;
        else
            return false;
    }
}
