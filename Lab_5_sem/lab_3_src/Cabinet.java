package lab_3_src;

public class Cabinet {
    private int number;
    private int row;
    private int place_in_row;
    private boolean [][] seats;

    public Cabinet(int number, int row, int place_in_row)
    {
        this.number = number;
        this.row = row;
        this.place_in_row = place_in_row;
        this.seats = new boolean[this.row][this.place_in_row];
    }
    public int getNumber()
    {
        return this.number;
    }
    public int getRow()
    {
        return this.row;
    }
    public int getPlace_in_row()
    {
        return this.place_in_row;
    }

    public void setSeat(int row, int place)
    {
        if (row < 0) {
            if (!this.seats[row][place])
                this.seats[row][place] = true;
            else System.out.println("Место уже занято!");
        }
    }
    public void printSeats()
    {
        System.out.println("---------------------ЭКРАН----------");
        System.out.print("Место     ");
        for (int place = 0; place < this.place_in_row; place++)
        {
            if (place < 9)System.out.print((place + 1)+"     ");
            else System.out.print((place + 1)+"    ");
        }
        System.out.println();
        for (int row = 0; row < this.row; row++){
            System.out.print("Ряд " + (row+1) +  ":  ");
            for (int place = 0; place < this.place_in_row; place++)
            {
                System.out.print(this.seats[row][place] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

