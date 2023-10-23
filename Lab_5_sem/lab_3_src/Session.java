package lab_3_src;

import java.util.Date;

public class Session {
    private Kinoteatr kinoteatr;
    private String Title;
    private Cabinet cabinet;
    private Date start_f;
    private Date end_f;

    public Session(Kinoteatr kinoteatr, String Title, Cabinet cabinet, Date start_f, Date end_f)
    {
        this.kinoteatr = kinoteatr;
        this.Title = Title;
        this.cabinet = new Cabinet(cabinet.getNumber(), cabinet.getRow(), cabinet.getPlace_in_row());
        this.start_f = start_f;
        this.end_f = end_f;
    }

    public Kinoteatr getKinoteatr()
    {
        return this.kinoteatr;
    }

    public String getTitle()
    {
        return this.Title;
    }

    public Cabinet getCabinet()
    {
        return this.cabinet;
    }

    public Date getStart_f()
    {
        return this.start_f;
    }
    public Date getEnd_f()
    {
        return this.end_f;
    }
}
