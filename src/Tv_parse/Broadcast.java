package Tv_parse;

import java.util.Date;

public class Broadcast {

    private String channel_id;
    private Date start;
    private Date stop;
    private Program program;


    public Broadcast(String channel_id, Date start, Date stop, Program program) {
        this.channel_id = channel_id;
        this.start = start;
        this.stop = stop;
        this.program = program;
    }

    public Date getStop() {
        return stop;
    }

    public void setStop(Date stop) {
        this.stop = stop;
    }

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }
}
