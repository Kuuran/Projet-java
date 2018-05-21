package Tv_parse;

import java.util.Date;
import java.util.HashMap;

/**
 * Program class,
 * stores a program and its informations.
 */
public class Program {

    private String title;
    private String sub_title;
    private String descripion;
    private HashMap<String, String> credits;
    private Date date;

    /**
     * Default constructor of <b>Program</b> class.
     */
    public Program() {
        this.title = "";
        this.sub_title = "";
        this.descripion = "";
        this.credits = new HashMap<>();

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public HashMap<String, String> getCredits() {
        return credits;
    }

    public void setCredits(HashMap<String, String> credits) {
        this.credits = credits;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
