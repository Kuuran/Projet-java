package project;

import java.util.ArrayList;

public class Tv {

    private ArrayList <Channel> channel_list;
    private ArrayList <Program> program_list;

    public Tv(){
        channel_list = new ArrayList<>();
        program_list = new ArrayList<>();
    }


    public ArrayList<Program> getProgram_list() {
        return program_list;
    }

    public ArrayList<Channel> getChannel_list() {
        return channel_list;
    }

}
