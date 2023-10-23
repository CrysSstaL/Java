import lab_3_src.Cabinet;
import lab_3_src.Kinoteatr;
import lab_3_src.Session;
import lab_3_src.Utils;

import java.util. *;

public class lab_3 {
    public static void main(String[] args) {
        System.out.println("Приветствую вас в нашей сети кинотеатров 'Shishkin'!");
        // Cоздание кинотеатров в ручную!
        Cabinet[] cabinets = new Cabinet[2];
        Cabinet cabinet1 = new Cabinet(1,3, 5);
        Cabinet cabinet2 = new Cabinet(2,3, 5);
        cabinets[0] = cabinet1;
        cabinets[1] = cabinet2;


        Kinoteatr[] kinoteatrs = new Kinoteatr[2];
        Kinoteatr ki = new Kinoteatr("q", cabinets);
        Kinoteatr kin = new Kinoteatr("w", cabinets);
        kinoteatrs[0] = ki;
        kinoteatrs[1] = kin;

        Session[] sessions = new Session[1];
        Session session1 = new Session(kinoteatrs[0], "Test_film", kinoteatrs[0].getCabinets()[0], new Date(), new Date());
        sessions[0] = session1;



        boolean run = true;
        boolean admin = false;
        boolean user = false;
        while (run) {
            System.out.println("Представтесь!)");
            System.out.println("1 - Admin");
            System.out.println("2 - User");
            System.out.println("3 - Выйти!");
            int step_1 = Utils.correctInputInt();
            if (step_1 == 1) // Создание кинотеатра
            {
                admin = true;
            }
            if (step_1 == 2) // Добавление кинозала к выбранному кинотеатру
            {
                user = true;
            }
            if (step_1 == 3) // полная информация о кинотеатре
            {
                run = false;
            }
            if ((step_1 < 1) && (step_1 > 3))
            {
                System.out.println("Выбранной команды не существует!");
            }
            while (admin) {
                System.out.println("Что вы хотите сделать?)");
                System.out.println("1 - Создать кинотетатр");
                System.out.println("2 - Добавить кинозал к выбранному кинотеатру");
                System.out.println("3 - Вывести полную информацию о кинотеатрах");
                System.out.println("4 - Добавить сеанс ");
                System.out.println("5 - Все сеансы ");
                System.out.println("6 - К выбору роли!");
                System.out.println("-----------------");
                Scanner scanner_second = new Scanner(System.in);
                int step_2 = Utils.correctInputInt();
                if (step_2 == 1) // Создание кинотеатра
                {
                    kinoteatrs = point_1(kinoteatrs);
                }
                if (step_2 == 2) // Добавление кинозала к выбранному кинотеатру
                {
                    kinoteatrs = point_2(kinoteatrs);
                }
                if (step_2 == 3) // полная информация о кинотеатре
                {
                    point_3(kinoteatrs);
                }
                if (step_2 == 4) // добавить сеанс
                {
                    sessions = point_4(kinoteatrs, sessions);
                }
                if (step_2 == 5) {
                    point_5(sessions);
                }
                if (step_2 == 6) // Выход
                {
                    admin = point_6(admin);
                }
                if ((step_2 < 1) && (step_2 > 6))
                {
                    System.out.println("Выбранной команды не существует!");
                }
            }
            while (user)
            {
                System.out.println("Что вы хотите сделать?)");
                System.out.println("1 - Узнать ближайший сеанс");
                System.out.println("2 - Список сеансов");
                System.out.println("3 - Купить билет");
                System.out.println("4 - К выбору роли!");
                Scanner scanner_second = new Scanner(System.in);
                int step_2 = Utils.correctInputInt();
                if (step_2 == 1)
                {
                    Utils.printSession(sessions[0]);
                }
                if (step_2 == 2)
                {
                    System.out.println("И так, что мне удлось найти");
                    for (Session session:sessions)
                    {
                        Utils.printSession(session);
                    }
                }
                if (step_2 == 3)
                {
                    sessions = BuyTicket(sessions);
                }
                if (step_2 == 4)
                {
                    user = point_6(user);
                }
                if ((step_2 < 1) && (step_2 > 4))
                {
                    System.out.println("Выбранной команды не существует!");
                }
            }
        }
    }

    public static Kinoteatr[] point_1(Kinoteatr [] kinoteatrs)
    {
        System.out.println("Создаем кинотеатр");
        kinoteatrs = Utils.upLengthK(kinoteatrs);
        Kinoteatr kino = Create_kinoteatr();
        kinoteatrs[kinoteatrs.length - 1] = kino;
        System.out.println("Кинотеатр " + kino.getName() + " создан!");
        System.out.println("-----------------");
        return kinoteatrs;
    }

    public static Kinoteatr[] point_2(Kinoteatr [] kinoteatrs)
    {
        System.out.println("Выберите кинотеатр : ");
        Utils.printKinoteatrs(kinoteatrs);
        Scanner scanner_second = new Scanner(System.in);
        int step_2 = Utils.correctInputInt();
        Kinoteatr kinoteatr = kinoteatrs[step_2-1];
        kinoteatr.setCabinets(Utils.upLengthC(kinoteatr.getCabinets()));
        Utils.printCabinets(kinoteatr);
        System.out.println("В Кинотеатре " + kinoteatr.getName() + " добавлен новый кинозал!");
        System.out.println("-----------------");
        return kinoteatrs;
    }

    public static void point_3(Kinoteatr [] kinoteatrs)
    {
        System.out.println("И так, что мне удалось найти :");
        for (Kinoteatr kinoteatr : kinoteatrs) {
            kinoteatr.getInfo();
        }
        System.out.println("-----------------");
    }

    public static Session[] point_4(Kinoteatr [] kinoteatrs, Session [] sessions)
    {
        Scanner scanner = new Scanner(System.in);
        sessions = Utils.upLengthS(sessions);

        System.out.println("Выберите кинотеатр:");
        Utils.printKinoteatrs(kinoteatrs);
        int id_kinoteatr = Utils.correctInputInt();
        id_kinoteatr -= 1;
        System.out.println(kinoteatrs[id_kinoteatr].getName());

        System.out.println("Выберите зал:");
        Utils.printCabinets(kinoteatrs[id_kinoteatr]);
        int id_cabinet = Utils.correctInputInt();
        id_cabinet -= 1;
        System.out.println(kinoteatrs[id_kinoteatr].getName());

        System.out.println("Введите название фильма");
        String title = Utils.correctInputString();

        System.out.println("Введите время начала фильма (<yyyy-mm-dd hh:mm:ss>)");
        Date start_f = Utils.ReadDate();

        System.out.println("Введите время окончания фильма(<yyyy-mm-dd hh:mm:ss>)");
        Date end_f = Utils.ReadDate();


        Session session = new Session(kinoteatrs[id_kinoteatr],
                title,
                kinoteatrs[id_kinoteatr].getCabinets()[id_cabinet],
                start_f,
                end_f);
        sessions[sessions.length - 1] = session;
        sessions = Utils.sortTime(sessions);
        return sessions;
    }

    public static void point_5(Session [] sessions)
    {
        System.out.println("Что мне удалось найти");
        for (Session session : sessions)
        {
            Utils.printSession(session);
        }
    }

    public static boolean point_6(boolean run)
    {
        System.out.println("До скорых встреч!");
        run = false;
        return run;
    }
    public static Session[] BuyTicket(Session [] sessions) {
        boolean flag = true;
        int id_row = 0;
        int id_place = 0;
        System.out.println("//////////");
        System.out.println("Выберите номер сеанса");
        System.out.println("//////////");
        for (int id_session = 0; id_session < sessions.length; id_session++) {
            System.out.println("СЕАНС №" + (id_session + 1));
            Utils.printSession(sessions[id_session]);
        }
        int id_session = Utils.correctInputInt();
        id_session -= 1;
        if ((id_session > sessions.length - 1 || id_session < 0) && flag)
        {
            flag = false;
            System.out.println("Выбранного сеанса не существует");
        }
        else {
            System.out.println("Отлично!");
            System.out.println("Выберите ряд!");
            id_row = Utils.correctInputInt();
            if ((id_row > sessions[id_session].getCabinet().getRow() - 1 || id_row - 1 < 0) && flag) {
                flag = false;
                System.out.println("Выбранного ряда не существует");
            }
            else {
                System.out.println("Выберите место!");
                id_place = Utils.correctInputInt();
                if ((id_place > sessions[id_session].getCabinet().getPlace_in_row() - 1 || id_place - 1 < 0) && flag) {
                    flag = false;
                    System.out.println("Выбранного места не существует");
                }
            }
        }

        if (flag)
        {
            sessions[id_session].getCabinet().setSeat(id_row - 1, id_place - 1);
            System.out.println("Вы приобрели билет на сеанс - " + sessions[id_session].getTitle());
            System.out.println("Начало сеанса - " + sessions[id_session].getStart_f());
            System.out.println("Кинотеатр - " + sessions[id_session].getKinoteatr().getName());
            System.out.println("Зал - №" + sessions[id_session].getCabinet().getNumber());
            System.out.println("Ваше место:)");
            System.out.println("////////");
            System.out.println("Ряд - " + id_row);
            System.out.println("Место - " + id_place);
            System.out.println("/////////");
            System.out.println("Приятного просмотра!");
            System.out.println();
        }
        else
        {
            System.out.println();
            System.out.println("Неправильный ввод данных");
            System.out.println("Попробуйте еще раз!");
            System.out.println();
        }
        return sessions;
    }

    public static Kinoteatr Create_kinoteatr() {
        System.out.println("Введите название кинотетатра");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Введите количество залов : ");
        int number_of_cabinets = Utils.correctInputInt();
        Cabinet [] cabinets = new Cabinet[number_of_cabinets];
        for (int i = 0; i < number_of_cabinets; i++) {
            System.out.println("Зал № " + (i + 1));
            System.out.println("Введите количество рядов в зале");
            int rows = Utils.correctInputInt();
            System.out.println("Введите количество мест в ряде");
            int numbers_chair = Utils.correctInputInt();
            Cabinet cabinet = new Cabinet((i+1), rows, numbers_chair);
            cabinets[i] = cabinet;
        }
        Kinoteatr kinoteatr = new Kinoteatr(name, cabinets);
        return kinoteatr;
    }
}

// 2002-09-23 22:45:00
// 2002-09-24 01:15:00
