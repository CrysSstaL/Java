import java.util.Scanner;
import static java.lang.Integer.MAX_VALUE;

public class lab_1 {
    public static void main(String[] args) {
//        point_1();
//        point_2();
//        point_3();
//        point_4();
//        point_5();
    }
    public static void point_1() // #1 Сиракузская последовательность
    {
        Scanner scanner = new Scanner(System.in); // инициализируем сканер
        System.out.print("Введите натуральное число: ");
        int number = scanner.nextInt();  // вводим число
        ///////// блок проверок
        if (number > 0)
        {
            int step = 0;
            if (number == 1) // обработаем особый случай ввода 1
            {
                step = 3; // 1->4->2->1
            }
            while (number != 1) // остальные случаи
            {
                if (number % 2 == 0)
                {
                    number /= 2;
                }
                else
                {
                    number = 3 * number + 1;
                }
                step++;
            }
            System.out.println("Необходимо " + step + " шага(ов)");
        }
        else
        {
            System.out.println("Неправильный ввод");
        }
        ////////
    }
    public static void point_2() // #2 Сумма Ряда
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите натуральное число: ");
        int number = scanner.nextInt();
        if (number > 0)
        {
            int[] mas_of_numbers = new int[number];
            for (int i = 0; i < number; i++)
            {
                mas_of_numbers[i] = scanner.nextInt();
            }
            double result = 0;
            for (int i = 0; i < number; i++)
            {
                result += mas_of_numbers[i] * Math.pow(-1, i);  // задаем очередность + и -
            }
            System.out.println(result);
        }
        else
        {
            System.out.println("Неправильный ввод");
        }
    }
    public static void point_3()  // #3 Ищем клад
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите координаты клада: ");
        int pos_X = scanner.nextInt();
        int pos_Y = scanner.nextInt();
        int step;
        int x = 0, y = 0;
        int number_step = 0;
        boolean play = true;
        boolean found = false;
        String str = "";
        while (play)    // если игра идет то принимаем шаги
        {
            str = scanner.next();
            if (str.equals("стоп") && found){
                play = false;   // окончание игры
                continue;
            }
            step = scanner.nextInt();
            if (str.equals("север") && !found)
            {
                y+=step;
                number_step++;
            }
            if (str.equals("юг") && !found)
            {
                y-=step;
                number_step++;
            }
            if (str.equals("запад") && !found)
            {
                x-=step;
                number_step++;
            }
            if (str.equals("восток") && !found)
            {
                x+=step;
                number_step++;
            }
            if (x == pos_X && y == pos_Y && !found)
            {
                found = true;   // клад найден, останавливаем увеличение шагов
            }
        }
        System.out.println(number_step);
    }

    public static void point_4()  // #4 Логистический максимин
    {
        Scanner scanner = new Scanner(System.in);
        int road_number = scanner.nextInt();
        int tunnel_number;
        int local_tunnel;
        int local_road = 0;
        int result = 0;
        int[] tunnel_min = new int[road_number];
        for (int i = 0; i < road_number; i++)  // перебор дорог
        {
            int min = MAX_VALUE;
            tunnel_number = scanner.nextInt();
            for (int j = 0; j < tunnel_number; j++)  // перебор тунелей
            {
                local_tunnel = scanner.nextInt();
                if (local_tunnel < min)
                {
                    min = local_tunnel;
                }
            }
            tunnel_min[i] = min;
        }
        for (int i = 0; i < road_number; i++)  // итоговый перебор
        {
            if (tunnel_min[i] > result)
            {
                result = tunnel_min[i];
                local_road = i + 1;
            }
        }
        System.out.println(local_road + " " + result);
    }
    public static void point_5()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите трехзначное число");
        int N = scanner.nextInt();
        int a = N % 10;  // единицы
        int b = N % 100 / 10; // десятки
        int c = N / 100;  // сотни
        if ((a*b*c % 2 == 0) && ((a+b+c) % 2 == 0))
        {
            System.out.println("Является дваджы четным");
        }
        else System.out.println("Не является дваджы четным");
    }
}
