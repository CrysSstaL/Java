package lab_4;

import java.util.Scanner;
public class lab_4Main {
    static lab_4Board board = new lab_4Board();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        board.setColorGaming('w');
        board.init();
        start();
    }
    public static void start() {
        if (board.getTakeBlack().size() == 15 && board.getTakeWhite().size() == 15) {
            System.out.println("Ничья!");
            end();
        }

        print_game(board);
        String inputLine = scanner.nextLine();
        if (inputLine.equals("exit")) {
            end();
        }

        int start_y, start_x, end_y, end_x;
        String[] coordinates = inputLine.split(" ");
        start_y = Integer.parseInt(coordinates[0]);
        start_x = Integer.parseInt(coordinates[1]);
        end_y = Integer.parseInt(coordinates[2]);
        end_x = Integer.parseInt(coordinates[3]);

        try {
            board.move_figure(start_y, start_x, end_y, end_x);
            if (board.getColorGaming() == 'w') {
                board.setColorGaming('b');
            } else if (board.getColorGaming() == 'b') {
                board.setColorGaming('w');
            }
        } catch (Error e) {
            System.out.println(e.getMessage());
            board.print_board();
            end();
        } finally {
            start();
        }
    }

    public static void print_game(lab_4Board board) {
        board.print_board();
        System.out.println();
        System.out.println("Команды: ");
        System.out.println("1) exit -  Выход из игры");
        System.out.println("2) y1 x1 y2 x2 - Ход фигуры из клетки x1, y1 в клекту x2, y2");
        System.out.println("Взятые Белые: " + board.getTakeWhite().toString());
        System.out.println("Взятые Черные: " + board.getTakeBlack().toString());
        if (board.getColorGaming() == 'w') {
            System.out.println("Ход Белых - ");
        } else if (board.getColorGaming() == 'b') {
            System.out.println("Ход Черных - ");
        }
    }

    public static void end() {
        System.out.println();
        System.out.println("Игра завeршена!");
    }
}
