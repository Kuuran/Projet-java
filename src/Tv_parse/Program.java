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
    private String audio_format;
    private String rating;
    private String star_rating;

    /**
     * Default constructor of <b>Program</b> class.
     */
    public Program() {
        this.title = "";
        this.sub_title = "";
        this.descripion = "";
        this.credits = new HashMap<>();

    }

    public String toString_short(){
        if(star_rating == null){
            return title;
        }
        else {
            return title + " " + star_rating;
        }
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

    public String getAudio_format() {
        return audio_format;
    }

    public void setAudio_format(String audio_format) {
        this.audio_format = audio_format;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(String star_rating) {
        this.star_rating = star_rating;
    }
}
