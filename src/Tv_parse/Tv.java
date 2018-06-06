/**
 * Tv class,
 * used to store the channels and programs.
 */
package Tv_parse;

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


    public void print_channel_list(){
        for(Channel channel : channel_list.values()){
            System.out.println(channel.toString());
        }
    }

    public void print_program_list(){
        for(Program program : program_list.values()){
            System.out.println(program.toString_short());
        }
    }

    public  void print_program(String name){
        System.out.println(program_list.get(name).toString_long());
    }

    public void print_channel_programmation(String channel_id){
        for (Broadcast broadcast : channel_list.get(channel_id).getBroadcast_list()) {
            System.out.println(broadcast.toString());
        }
    }

    public void print_days_with_broadcast(){
        HashMap<String,String> day_list = new HashMap<>();
        String string;
        for(Broadcast broadcast : broadcast_list){
               string = String.valueOf(broadcast.getStart().getDay()) + " / " + String.valueOf(broadcast.getStart().getMonth()) + " / " + String.valueOf(broadcast.getStart().getYear());
               day_list.put(string, "");
        }
        for(String str : day_list.keySet()){
            System.out.println(str);
        }
    }

    public void print_broadcasts_at_date(Date date){
        for (Broadcast broadcast : broadcast_list){
            if(broadcast.getStart().getDay() == date.getDay() && broadcast.getStart().getMonth() == date.getMonth() && broadcast.getStart().getYear() == date.getYear()){
                System.out.println(broadcast.toString());            }
        }
    }

    public void print_broadcasts_at_hour(Date date){
        for (Broadcast broadcast : broadcast_list){
            if(broadcast.getStart().getDay() == date.getDay() && broadcast.getStart().getMonth() == date.getMonth() && broadcast.getStart().getYear() == date.getYear() && broadcast.getStart().getHours() == date.getHours()){
                System.out.println(broadcast.toString());            }
        }
    }

    public void print_broadcast(Broadcast broadcast){
        System.out.println(broadcast.toString());
    }

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

}
