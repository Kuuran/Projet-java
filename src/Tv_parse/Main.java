package Tv_parse;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

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

        for(Program program : tv.getProgram_list()){
            System.out.println(program.toString_long());
        }
    }
}
