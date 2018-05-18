package project;

import java.util.ArrayList;

public class Channel {

    private String id;
    private String display_name;
    private ArrayList <Broadcast> broadcastt_list;

    public Channel(){
        id = "";
        display_name = "";
        broadcastt_list = new ArrayList<>();
    }

    public Channel(String n_id){

        id = n_id;

    }

}
