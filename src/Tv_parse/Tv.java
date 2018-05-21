/**
 * Tv class,
 * used to store the channels and programs.
 */
package Tv_parse;

import java.util.ArrayList;
import java.util.HashMap;

public class Tv {

    private HashMap<String, Channel> channel_list; //Use of a Hashmap in order to prevent having duplicate Channels.
    private ArrayList<Broadcast> broadcast_list;
    //fixme besoin de garder la liste de program sachant qu'ils sont stockés dans les broadcast qui sont dans les channel?
    private ArrayList <Program> program_list;

    /**
     * Default constructor of Tv class
     */
    public Tv(){
        channel_list = new HashMap<>();
        broadcast_list = new ArrayList<>();
        program_list = new ArrayList<>();
    }

    public ArrayList<Program> getProgram_list() {
        return program_list;
    }

    public HashMap<String, Channel> getChannel_list() {
        return channel_list;
    }

    public void addChannel(Channel channel){
        channel_list.put(channel.getId(), channel);
    }

    public void addProgram(Program program){
        program_list.add(program);
    }

    public ArrayList<Broadcast> getBroadcast_list() {
        return broadcast_list;
    }

    public void addBroadcast(Broadcast broadcast) {
        broadcast_list.add(broadcast);
    }
}
