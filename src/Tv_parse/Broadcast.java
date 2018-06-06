package Tv_parse;

import java.util.Date;

/**
 * Broadcast class,
 * stores a broadcast and its information.
 */
public class Broadcast {

    private String channel_name;
    private Date start;
    private Date stop;
    private Program program;

    /**
     * Default constructor of Broadcast class.
     * @param channel_id ID of the <b>Channel</b> where the program will be broadcasted.
     * @param start <i>Date</i> and hour when the <b>Broadcast</b> starts.
     * @param stop <i>Date</i> and hour when the <b>Broadcast</b> ends.
     * @param program <b>Program</b> that will be broadcasted.
     */
    public Broadcast(String channel_name, Date start, Date stop, Program program) {
        this.channel_name = channel_name;
        this.start = start;
        this.stop = stop;
        this.program = program;
    }

    /**
     * Used to print a Broadcast and its information.
     * @return String to print.
     */
    @Override
    public String toString(){
        String string = "";
        string = program.toString_short() + "\nChaine : " + channel_name + "\nHorraires : " + start.getTime() + "  " + stop.getTime();
        return string;
    }

    public Date getStop() {
        return stop;
    }

    public void setStop(Date stop) {
        this.stop = stop;
    }

    public String getChannel_id() {
        return channel_name;
    }

    public void setChannel_id(String channel_name) {
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
}
