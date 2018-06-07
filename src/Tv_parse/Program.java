package Tv_parse;

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
    private String date;
    private String category;
    private String subtitles_language;
    private String length;
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
        this.credits = new HashMap<>();

    }

    /**
     * Used to print a program.
     * @return String to print.
     */
    public String toString_short(){
        return title;
    }

    /**
     * Used to print a program with all its components.
     * @return String to print.
     */
    public String toString_long(){
        String string = "";
        string = string + title;

        if(episode_num != null){
            string = string + " " + episode_num;
        }
        if(sub_title != null){
            string = string + "\n" + sub_title;
        }
        if(category != null){
            string = string + "\nCategorie : " + category;
        }
        if(star_rating != null){
            string = string + "\nNote : " + star_rating;
        }
        if(descripion != null){
            string = string + "\nDescription : " + descripion;
        }
        if(length != null){
            string = string + "\nDuree : " + length + " " + time_unit;
        }
        if(date != null){
            string = string + "\nDate de sortie : " + date;
        }
        if(country != null){
            string = string + "\nPays d'origine : " + country;
        }
        if(subtitles_language != null){
            string = string + "\nSous titres disponibles : " + subtitles_language;
        }
        if(rating != null){
            string = string + "/n" + rating;
        }
        string = string + "\nCredits :";
        for (String key : credits.keySet()) {
            string = string + "\n   " + credits.get(key) + " : " + key;
        }
        if(video_format != null && video_quality != null){
            string = string + "\nVideo : " + video_quality + " " + video_format;
        }
        else if (video_quality != null){
            string = string + "\nVideo : " + video_quality;
        }
        if(audio_format != null){
            string = string + "\nAudio : " + audio_format;
        }
        return string;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
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
