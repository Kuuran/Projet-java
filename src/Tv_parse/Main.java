package Tv_parse;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Main class
 */
public class Main {

    /**
     * Main loop of the application.
     * @param args Arguments given to the application (might be used to toggle the GUI).
     * @throws FileNotFoundException In case {@link Parser#Parser(String)} throws an exception.
     * @throws XMLStreamException In case {@link Parser#run(Tv)} throws an exception.
     * @throws ParseException In case {@link Parser#run(Tv)} throws an exception.
     */
    public static  void main(String[] args) throws FileNotFoundException, XMLStreamException, ParseException {
        Parser parser = new Parser("input/tvguide.xml");
        Tv tv = new Tv();
        parser.run(tv);

        tv.print_channel_list();

        tv.print_program_list();

        tv.print_program("Cosmos : une odyssée à travers l'univers");

        tv.print_channel_programmation("W9");

        tv.print_days_with_broadcast();

        Date date = new Date(2018, 5, 20, 6, 0);
        tv.print_broadcasts_at_hour(date);



    }
}
