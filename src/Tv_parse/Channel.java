package Tv_parse;

import java.util.ArrayList;

/**
 * Channel class,
 * stores a channel and its information.
 */
public class Channel {

    private String id;
    private String display_name;
    private ArrayList <Broadcast> broadcast_list;

    /**
     * Default constructor of Channel class.
     */
    public Channel(){
        id = "";
        display_name = "";
        broadcast_list = new ArrayList<>();
    }

    /**
     * Secondary constructor of Channel class.
     * @param id ID of the channel.
     */
    public Channel(String id){
        this();
        this.id = id;
    }

    @Override
    public String toString(){
        return display_name;
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
