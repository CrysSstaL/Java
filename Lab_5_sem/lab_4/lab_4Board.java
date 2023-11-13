package lab_4;
import lab_4.lab_4_src.Bishop;
import lab_4.lab_4_src.Figure;
import lab_4.lab_4_src.King;
import lab_4.lab_4_src.Knight;
import lab_4.lab_4_src.Pawn;
import lab_4.lab_4_src.Queen;
import lab_4.lab_4_src.Rook;

import java.util.ArrayList;
import java.util.Objects;

public class lab_4Board {
    private final Figure[][] location = new Figure[8][8];   // final - можно менять состояние обьекта но не ссылку на него
    private final ArrayList<String> takeWhite = new ArrayList<>(16);
    private final ArrayList<String> takeBlack = new ArrayList<>(16);

    public char getColorGaming() {
        return colorGaming;
    }
    public void setColorGaming(char colorGaming) {
        this.colorGaming = colorGaming;
    }

    private char colorGaming;

    public void init(){
        this.location[0] = new Figure[]{
                new Rook("R", 'w', 0, 0), new Knight("N", 'w', 0, 1),
                new Bishop("B", 'w', 0, 2), new Queen("Q", 'w',0,3),
                new King("K", 'w', 0,4), new Bishop("B", 'w',0, 5),
                new Knight("N", 'w', 0, 6),new Rook("R", 'w',0, 7)
        };
        this.location[1] = new Figure[]{
                new Pawn("P", 'w',1, 0),    new Pawn("P", 'w',1,1),
                new Pawn("P", 'w',1,2),    new Pawn("P", 'w',1,3),
                new Pawn("P", 'w',1, 4),    new Pawn("P", 'w',1,5),
                new Pawn("P", 'w',1,6),    new Pawn("P", 'w',1,7),
        };
        this.location[7] = new Figure[]{
                new Rook("R", 'b',7, 0), new Knight("N", 'b',7, 1),
                new Bishop("B", 'b',7, 2), new Queen("Q", 'b',7, 3),
                new King("K", 'b',7,4), new Bishop("B", 'b',7,5),
                new Knight("N", 'b',7,6),new Rook("R", 'b',7, 7)
        };
        this.location[6] = new Figure[]{
                new Pawn("P", 'b',6, 0),    new Pawn("P", 'b',6,1),
                new Pawn("P", 'b',6,2),    new Pawn("P", 'b',6,3),
                new Pawn("P", 'b',6,4),    new Pawn("P", 'b',6, 5),
                new Pawn("P", 'b',6, 6),    new Pawn("P", 'b',6, 7),
        };
    }

    public String getCell(int row, int col){
        Figure figure = this.location[row][col];
        if (figure == null){
            return "    ";
        }
        return " "+figure.getColor()+figure.getName()+" ";
    }
    public ArrayList<String> getTakeWhite() {
        return takeWhite;
    }

    public ArrayList<String> getTakeBlack() {
        return takeBlack;
    }

    public void move_figure(int row1, int col1, int row2, int col2) throws Error {
        Figure figure = getFigureAtPosition(row1, col1);
        if (figure.getClass().getSimpleName().equals("Pawn")) {
            movePawn(row2, col2, figure);
        } else {
            moveOtherFigure(row2, col2, figure);
        }
    }
    private Figure getFigureAtPosition(int row, int col) throws Error {
        try {
            return this.location[row][col];
        } catch (Exception e) {
            throw new Error("На выбранном вами поле нет фигуры");
        }
    }
    private void movePawn(int row2, int col2, Figure figure) throws Error {
        Figure nextField = getFigureAtPosition(row2, col2);
        int coord_y = figure.getRow();
        int coord_x = figure.getCol();
        if (nextField != null && figure.canAttack(row2, col2, nextField)) {
            FigureAttack(coord_y, coord_x, row2, col2, figure);
            return;
        } else if (figure.canMove(row2, col2, location)) {
            System.out.println("move");
            this.location[row2][col2] = figure;
            this.location[coord_y][coord_x] = null;
            figure.setRow(coord_y);
            figure.setCol(coord_x);
        }
    }
    private void moveOtherFigure(int row2, int col2, Figure figure) throws Error {
        int coord_y = figure.getRow();
        int coord_x = figure.getCol();
        if (figure.canMove(row2, col2, this.location)) {
            Figure nextField = this.location[row2][col2];
            if (nextField != null) {
                if (figure.canAttack(row2, col2, nextField)) {
                    FigureAttack(coord_y, coord_x, row2, col2, figure);
                    Figure figure1 = this.location[row2][col2];
                    checkMate(figure1);
                    return;
                }
            }
            System.out.println("move");
            this.location[row2][col2] = figure;
            figure.setCol(col2);
            figure.setRow(row2);
            this.location[coord_y][coord_x] = null;
            checkMate(figure);
        }
    }
    private void checkMate(Figure figure){
        char KingColor = this.getColorGaming() == 'w' ? 'b' : 'w';
        Figure KingFigure = this.FindKingPos(KingColor);
        if (this.isCheck(KingFigure.getRow(), KingFigure.getCol(), KingColor)) {
            System.out.println("Шах королю!");
            if (this.isMate(figure, KingFigure, KingColor)) {
                System.out.println("Mат!");
                System.out.println("Игра закончена!");
            }
        }
    }
    public boolean isMate(Figure figure, Figure King, char kingColor) {
        if (!Escape_King(King, kingColor)) {
            return false;
        }
        if (!Protected_King(figure, kingColor)) {
            return false;
        }
        return true;
    }
    private boolean Escape_King(Figure King, char kingColor) {
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (King.getRow() + i >= 8 || King.getRow() + i < 0 ||
                        King.getCol() + j >= 8 || King.getCol() + j < 0)
                    continue;
                if (i == 0 && j == 0)
                    continue;
                if (this.location[King.getRow() + i][King.getCol() + j] == null
                        && !(this.isCheck(King.getRow() + i, King.getCol() + j, kingColor))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean Protected_King(Figure figure, char kingColor) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Figure figure1 = this.location[i][j];
                if (figure == null || figure.getColor() != kingColor) {
                    continue;
                }
                if (figure.getClass().getSimpleName().equals("King") &&
                        this.isCheck(figure.getRow(), figure.getCol(), kingColor)) {
                    continue;
                }
                if (figure.getClass().getSimpleName().equals("Pawn") &&
                        figure.canAttack(figure.getRow(), figure.getCol(), this.location[figure.getRow()][figure.getCol()])) {
                    return true;
                }
                if (figure.canMove(figure.getRow(), figure.getCol(), this.location) &&
                        figure.canAttack(figure.getRow(), figure.getCol(), this.location[figure.getRow()][figure.getCol()])) {
                    return true;
                }
            }
        }

        return false;
    }
    public boolean isCheck(int kingRow, int kingCol, char kingColor) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Figure figure = this.location[i][j];
                if (figure == null || figure.getColor() == kingColor) {
                    continue;
                }
                if (figure.getClass().getSimpleName().equals("Pawn") &&
                        (Math.abs(i - kingRow) == 1 && Math.abs(j - kingCol) == 1)) {
                    return true;
                }
                if (figure.canMove(kingRow, kingCol, location)) {
                    return true;
                }
            }
        }
        return false;
    }
    public void FigureAttack(int row1, int col1, int row2, int col2, Figure figure) {
        System.out.println("attack");
        if (this.location[row2][col2].getColor() == 'w') {
            this.takeWhite.add(this.location[row2][col2].getColor() + this.location[row2][col2].getName());
        }
        if (this.location[row2][col2].getColor() == 'b'){
            this.takeBlack.add(this.location[row2][col2].getColor() + this.location[row2][col2].getName());
        }
        this.location[row2][col2] = figure;
        figure.setRow(row2);
        figure.setCol(col2);
        this.location[row1][col1] = null;
    }
    public Figure FindKingPos(char color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Figure figure = this.location[i][j];
                if (Objects.equals(figure.getName(), "K") && figure.getColor() == color) {
                    return figure;
                }
            }
        }
        return null;
    }

    public void print_board(){
        System.out.println(" +----+----+----+----+----+----+----+----+");
        for(int row = 7; row > -1; row--){
            System.out.print(row);
            for(int col = 0; col< 8; col++){
                System.out.print("|"+getCell(row, col));
             }
            System.out.println("|");
            System.out.println(" +----+----+----+----+----+----+----+----+");
        }

        for(int col = 0; col < 8; col++){
            System.out.print("    "+col);
        }
    }
}
