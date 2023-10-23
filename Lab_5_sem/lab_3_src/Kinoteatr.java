package lab_3_src;

import java.util.Scanner;

public class Kinoteatr extends Net {

    public Kinoteatr(String name, Cabinet[] cabinets)
    {
        super(name, cabinets);

    }

    public String getName()
    {
        return this.name;
    }

    public Cabinet[] getCabinets()
    {
        return this.cabinets;
    }

    public void setCabinets(Cabinet [] cabinets)
    {
        System.out.println("Введите кол-во рядов в новом кинозале");
        int row = Utils.correctInputInt();
        System.out.println("Введите кол-во мест в ряду");
        int place_in_row = Utils.correctInputInt();
        cabinets[cabinets.length - 1] = new Cabinet(cabinets.length, row, place_in_row);
        this.cabinets = cabinets;
    }

    public void getInfo()
    {
        System.out.println("Кинотеатр - " + this.name);
        System.out.println("Кол-во залов - " + this.cabinets.length);
        for (int i = 0; i < this.cabinets.length; i++)
        {
            System.out.println("Зал № " + (i + 1));
            this.cabinets[i].printSeats();
        }
    }
}

