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
    private String category;
    private String subtitles_language;
    private double length;
    private String time_unit;
    private String country;
    private String episode_num;
    private String video_format;
    private String video_quality;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubtitles_language() {
        return subtitles_language;
    }

    public void setSubtitles_language(String subtitles_language) {
        this.subtitles_language = subtitles_language;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getTime_unit() {
        return time_unit;
    }

    public void setTime_unit(String time_unit) {
        this.time_unit = time_unit;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEpisode_num() {
        return episode_num;
    }

    public void setEpisode_num(String episode_num) {
        this.episode_num = episode_num;
    }

    public String getVideo_format() {
        return video_format;
    }

    public void setVideo_format(String video_format) {
        this.video_format = video_format;
    }

    public String getVideo_quality() {
        return video_quality;
    }

    public void setVideo_quality(String video_quality) {
        this.video_quality = video_quality;
    }
}
