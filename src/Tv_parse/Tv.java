/**
 * Tv class,
 * used to store the channels and programs.
 */
package Tv_parse;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Tv {

    private HashMap<String, Channel> channel_list; //Use of a Hashmap in order to prevent having duplicate Channels.
    private ArrayList<Broadcast> broadcast_list;
    private HashMap <String, Program> program_list;

    /**
     * Default constructor of Tv class
     */
    public Tv(){
        channel_list = new HashMap<>();
        broadcast_list = new ArrayList<>();
        program_list = new HashMap<>();
    }

    public HashMap <String, Program> getProgram_list() {
        return program_list;
    }

    public HashMap<String, Channel> getChannel_list() {
        return channel_list;
    }

    public void addChannel(Channel channel){
        channel_list.put(channel.getId(), channel);
    }

    public void addProgram(Program program){
        program_list.put(program.getTitle(), program);
    }

    public ArrayList<Broadcast> getBroadcast_list() {
        return broadcast_list;
    }

    public void addBroadcast(Broadcast broadcast) {
        broadcast_list.add(broadcast);
    }


    /**
     * Prints a list of all channels.
     */
    public void print_channel_list(){
        for(Channel channel : channel_list.values()){
            System.out.println(channel.toString());
        }
    }

    /**
     * Prints a list of all programs.
     */
    public void print_program_list(){
        for(Program program : program_list.values()){
            System.out.println(program.toString_short());
        }
    }

    /**
     * Prints the information of a program.
     * @param name name of the program to print. Sensitive at the case.
     */
    public  void print_program(String name){
        System.out.println(program_list.get(name).toString_long());
    }

    /**
     * Prints the list of broadcasts of a channel.
     * @param channel_id ID of the channel.
     */
    public void print_channel_programmation(String channel_id){
        for (Broadcast broadcast : channel_list.get(channel_id).getBroadcast_list()) {
            System.out.println(broadcast.toString() + "\n");
        }
    }

    /**
     * Prints all days with programmed broadcasts.
     */
    public void print_days_with_broadcast(){
        HashMap<String,String> day_list = new HashMap<>();
        String string;
        DateFormat df = new SimpleDateFormat("dd / MM / yyyy");

        for(Broadcast broadcast : broadcast_list){
               string = df.format(broadcast.getStart());
               day_list.put(string, "");
        }
        for(String str : day_list.keySet()){
            System.out.println(str);
        }
    }

    /**
     * Prints broadcasts of the specified day.
     * @param date Day wanted.
     */
    public void print_broadcasts_at_date(Date date){
        for (Broadcast broadcast : broadcast_list){
            if(broadcast.getStart().getDay() == date.getDay() && broadcast.getStart().getMonth() == date.getMonth() && broadcast.getStart().getYear() == date.getYear()){
                System.out.println(broadcast.toString());            }
        }
    }

    /**
     * Prints broadcasts of the specified day and hour.
     * @param date Day and hour wanted.
     */
    public void print_broadcasts_at_hour(Date date){
        for (Broadcast broadcast : broadcast_list){
            if(broadcast.getStart().getDay() == date.getDay() && broadcast.getStart().getMonth() == date.getMonth() && broadcast.getStart().getYear() == date.getYear() && broadcast.getStart().getHours() == date.getHours()){
                System.out.println(broadcast.toString());            }
        }
    }

    /**
     * Prints the information of a broadcast.
     * @param broadcast Broadcast to print.
     */
    public void print_broadcast(Broadcast broadcast){
        System.out.println(broadcast.toString());
    }

    /**
     * Prints all films in which the specified person participated (not only actors).
     * @param name Person wanted.
     */
    public void print_films_from_actor(String name){
        ArrayList<String> result = new ArrayList<>();

        System.out.println("Liste des films associés à " + name + " :\n");

        for (Program program : program_list.values()) {
            for(String n : program.getCredits().keySet()){
                if (n.equals(name)) result.add(program.toString_short());
            }
        }
        for (String string : result){
            System.out.println(string);
        }
    }

    /**
     * Prints the number of Broadcasts for each CSA rating for each channel.
     */
    public void print_CSA_per_channel(){
        String string = "";
        HashMap<String, Integer> count = new HashMap<>();
        for (Channel channel : channel_list.values()) {
            string = string + "\n" + channel.toString() + " : \n";
            for (Broadcast broadcast: channel.getBroadcast_list()) {
                if(count.containsKey(broadcast.getProgram().getRating())){
                    count.put(broadcast.getProgram().getRating(), count.get(broadcast.getProgram().getRating()) + 1);
                }else {
                    count.put(broadcast.getProgram().getRating(), 1);
                }
            }
            for (String str : count.keySet()) {
                string = string + str + " : " + count.get(str) + "\n";
            }
            count.clear();
        }
        System.out.println(string);
    }

    /**
     * Prints all actors and their number of appearance in films (Not sorted).
     */
    public void print_actors(){
        HashMap<String, Integer> count = new HashMap<>();
        String sub = "";
        for(Program program : program_list.values()){
            for(String key : program.getCredits().keySet()){
                if(program.getCredits().get(key).equals("actor")){
                    if(key.contains("(")) {
                        sub = key.substring(0, key.indexOf("("));
                    } else{
                        sub = key;
                    }
                    if (count.containsKey(sub)){
                        count.put(sub, count.get(sub) + 1);
                    }
                    else{
                        count.put(sub, 1);
                    }
                }
            }
        }
        String res = "";
        for (String string : count.keySet()){
            res = res + string + ": " + count.get(string) + "\n";
        }
        System.out.println(res);
    }

}
