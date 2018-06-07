package Tv_parse;

import java.util.Date;

/**
 * Broadcast class,
 * stores a broadcast and its information.
 */
public class Broadcast {

    private String channel_id;
    private String channel_name;
    private Date start;
    private Date stop;
    private Program program;

    /**
     * Default constructor of Broadcast class.
     * @param channel_name ID of the <b>Channel</b> where the program will be broadcasted.
     * @param start <i>Date</i> and hour when the <b>Broadcast</b> starts.
     * @param stop <i>Date</i> and hour when the <b>Broadcast</b> ends.
     * @param program <b>Program</b> that will be broadcasted.
     */
    public Broadcast(String channel_id, String channel_name, Date start, Date stop, Program program) {
        this.channel_name = channel_name;
        this.start = start;
        this.stop = stop;
        this.program = program;
        this.channel_id = channel_id;
    }

    /**
     * Used to print a Broadcast and its information.
     * @return String to print.
     */
    @Override
    public String toString(){
        return program.toString_short() + "\nChaine : " + channel_name + "\nHorraires : " + start.toString() + "  " + stop.toString();
    }

    public Date getStop() {
        return stop;
    }

    public void setStop(Date stop) {
        this.stop = stop;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
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

    public String getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(String channel_id) {
        this.channel_id = channel_id;
    }
}
