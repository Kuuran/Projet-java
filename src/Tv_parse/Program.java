package Tv_parse;

import java.util.Date;

public class Program {

    private String title;
    private String sub_title;
    private String descripion;
    private String[] credits;
    private Date date;


    public Program(String title, String sub_title, String descripion, String[] credits, Date date) {
        this.title = title;
        this.sub_title = sub_title;
        this.descripion = descripion;
        this.credits = credits;
        this.date = date;
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

    public String[] getCredits() {
        return credits;
    }

    public void setCredits(String[] credits) {
        this.credits = credits;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
