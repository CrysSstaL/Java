package lab_3_src;

public abstract class Net
{
    protected String name;
    protected Cabinet[] cabinets;
    public Net(String name, Cabinet[] cabinets)
    {
        this.name = name;
        this.cabinets = cabinets;
    }
}

