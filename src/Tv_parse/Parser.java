package Tv_parse;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Parser class,
 * used to process the XML file and create the objects that will be used by the application.
 */
public class Parser {

    private XMLInputFactory xmlif;
    private XMLStreamReader xmlsr;
    private FileReader xmlfr;
    private Tv tv;

    /**
     * Constructor of Parser class.
     * @param filename XML file to process.
     * @throws FileNotFoundException File not existing.
     * @throws XMLStreamException Cannot create the StreamReader.
     */
    public Parser(String filename) throws FileNotFoundException, XMLStreamException {
        xmlif = XMLInputFactory.newInstance();
        xmlfr = new FileReader(filename);
        xmlsr = xmlif.createXMLStreamReader(xmlfr);
    }

    /**
     * Creates a new instance of program and broadcast classes and fill them with the information read from the XML file.
     * @throws XMLStreamException Cannot read the next entry (hasNext()).
     */
    public void create_program() throws XMLStreamException {
        int eventType = xmlsr.getEventType();

        //todo cree un program et un broadcast + add start/stop/channelID a broadcast

        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("//programme") == Boolean.FALSE)){
            eventType = xmlsr.next();

            if(eventType == XMLEvent.START_ELEMENT){
                switch (xmlsr.getLocalName()){
                    case "title":
                        //todo
                        break;
                    case "sub-title" :
                        //todo
                        break;
                    case "desc":
                        //todo
                        break;
                    case "credits":
                        //todo (handle les credits)
                        break;
                    case "date":
                        //todo
                        break;

                }
            }

        }
    }

    /**
     * Creates a new instance of channel class and fill it with the information read from the XML file.
     * @throws XMLStreamException Cannot read the next entry (hasNext() or getElementText()).
     */
    public void create_channel() throws XMLStreamException {
        int eventType = xmlsr.getEventType();
        //Creates a new Channel and stores its ID
        Channel channel = new Channel(xmlsr.getAttributeValue(0));
        tv.getChannel_list().add(channel);

        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("//channel") == Boolean.FALSE)){
            eventType = xmlsr.next();

            //Sets the display_name of the Channel
            if(eventType == XMLEvent.START_ELEMENT && xmlsr.getLocalName().equals("display-name")){
                if (channel.getDisplay_name().equals("")) {
                    channel.setDisplay_name(xmlsr.getElementText());
                } else {
                    channel.addDisplay_name(xmlsr.getElementText());
                }
            }
        }
    }


    /**
     * Handles the XML event START_ELEMENT.
     * @throws XMLStreamException In case {@link #create_channel()} or {@link #create_program()} throws an exception.
     */
    public void start_element() throws XMLStreamException {
        switch(xmlsr.getLocalName()){
            case "channel":
                create_channel();
                break;
            case "programme":
                create_program();
                break;
            default:
                break;
        }
    }

    /**
     * Main loop of the Parser class.
     * @param tv New Tv instance to fill with the parser.
     * @throws XMLStreamException Cannot read the next entry (hasNext()) or in case {@link #start_element()} throws an exception.
     */
    public void run(Tv tv) throws XMLStreamException {
        int eventType;
        int loop = 0;
        this.tv = tv;
        //todo remove loop var (used for debug)
        while(xmlsr.hasNext() && loop < 1000){
            eventType = xmlsr.next();
            loop++;
            if (eventType == XMLEvent.START_ELEMENT){
                start_element();
            }
        }
    }

}
