package lab_3_src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Utils {
    public static Session[] sortTime(Session[] sessions)
    {
        Session [] sortSession = new Session[sessions.length];
        int iter = 0;
        int del_iter = 0;
        while (sessions.length != 1)
        {
            Session temp = sessions[0];
            for (int i = 0; i < sessions.length; i++)
            {
                if (sessions[i].getStart_f().getTime() < temp.getStart_f().getTime())
                {
                    temp = sessions[i];
                    del_iter = i;
                }
            }
            sortSession[iter] = temp;
            sessions = remove(sessions, del_iter);   // удаляем самый ранний сеанс
            iter += 1;
        }
        sortSession[sortSession.length - 1] = sessions[0];
        return sortSession;
    }
    //////////удаление элемента масива
    private static Session[] remove(Session [] sessions, int iter) {
        // Создаем пустой массив размером на один меньше чем исходный
        // так как мы удаляем один элемент
        Session [] result = new Session[sessions.length - 1];
        for (var i = 0; i < sessions.length; i++) {
            if (i != iter) { // Копируем все кроме index
                var newIndex = i < iter ? i : i - 1;  // Элементы стоящие дальше index смещаются влево
                result[newIndex] = sessions[i];
            }
        }
        return result;
    }
    public static Kinoteatr[] upLengthK(Kinoteatr[] kinoteatrs)
    {
        Kinoteatr [] clone = new Kinoteatr[kinoteatrs.length + 1];
        for (int i = 0; i < kinoteatrs.length; i++)
        {
            clone[i] = kinoteatrs[i];
        }
        return clone;
    }

    public static Cabinet[] upLengthC(Cabinet [] cabinets)
    {
        Cabinet [] clone = new Cabinet[cabinets.length + 1];
        for (int i = 0; i < cabinets.length; i++)
        {
            clone[i] = cabinets[i];
        }
        return clone;
    }

    public static Session[] upLengthS(Session [] sessions)
    {
        Session [] clone = new Session[sessions.length + 1];
        for (int i = 0; i < sessions.length; i++)
        {
            clone[i] = sessions[i];
        }
        return clone;
    }
    public static Date ReadDate()
    {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                String start = scanner.nextLine();
                return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(start);
            } catch (ParseException e) {
                System.out.println("Неправильный ввод данных");
                System.out.println("Правельный формат <yyyy-MM-dd HH:mm>");
            }
        }
    }

    public static void printKinoteatrs(Kinoteatr [] kinoteatrs)
    {
        for (int i = 0; i < kinoteatrs.length; i++)
        {
            System.out.println((i+1)+" :" + kinoteatrs[i].getName());
        }
    }
    public static void printCabinets(Kinoteatr kinoteatr)
    {
        for (int i = 0; i < kinoteatr.getCabinets().length; i++)
        {
            System.out.println("Зал №" + (kinoteatr.getCabinets()[i].getNumber()));
        }
    }
    public static void printSession(Session session)
    {
        System.out.println("Сеанс  -  " + session.getTitle());
        System.out.println("Кинотеатр  -  " + session.getKinoteatr().getName());
        System.out.println("Номер зала  -  " + session.getCabinet().getNumber());
        System.out.println("Начало : " + session.getStart_f().toString());
        System.out.println("Окончание : " + session.getEnd_f().toString());
        System.out.println("План зала");
        printSessionCabinets(session.getCabinet());
        System.out.println();
    }
    public static void printSessionCabinets(Cabinet cabinet)
    {
        System.out.println("Свободно - false  :  Занято - true");
        cabinet.printSeats();
    }

    public static int correctInputInt() {
        while (true) {
            try {
                Scanner scanner_first = new Scanner(System.in);
                return scanner_first.nextInt();
            } catch (Exception e) {
                System.out.println();
                System.out.println("Неприавльный ввод данных !");
                System.out.println("Ввод должен представлять собой номер строки !");
                System.out.println("Попробуйте еще раз!");
                System.out.println();
            }
        }
    }
    public static String correctInputString()
    {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                return scanner.nextLine();
            } catch (Exception e) {
                System.out.println();
                System.out.println("Неприавльный ввод данных !");
                System.out.println("Ввод должен представлять собой строку !");
                System.out.println("Попробуйте еще раз!");
            }
        }
    }

}

