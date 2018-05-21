package Tv_parse;

import java.util.ArrayList;

public class Channel {

    private String id;
    private String display_name;
    private ArrayList <Broadcast> broadcast_list;

    public Channel(){
        id = "";
        display_name = "";
        broadcast_list = new ArrayList<>();
    }

    public Channel(String n_id){

        this();
        id = n_id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public ArrayList<Broadcast> getBroadcast_list() {
        return broadcast_list;
    }

    public void addBroadcast(Broadcast broadcast){
        broadcast_list.add(broadcast);
    }

    public void addDisplay_name(String display_name){
        this.display_name = this.display_name + " // " + display_name;
    }
}
