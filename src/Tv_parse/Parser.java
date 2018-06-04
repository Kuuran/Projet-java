package Tv_parse;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
     * Stores the credits inside the program.
     * @param program The <b>Program</b> instance to fill with the information.
     * @throws XMLStreamException Cannot read the next entry (hasNext(), next()) or cannot read the content (getElementText()).
     */
    public void create_credits(Program program) throws XMLStreamException {
        int eventType = xmlsr.getEventType();
        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("//credits") == Boolean.FALSE)){
            eventType = xmlsr.next();

            if (eventType == XMLEvent.START_ELEMENT){
                program.getCredits().put(xmlsr.getElementText(), xmlsr.getLocalName()); //Name as key and role as stored data because there might have several people with the same role.
            }
        }
    }

    /**
     * Creates a new instance of <b>Program</b> and <b>Broadcast</b> classes and fill them with the information read from the XML file.
     * @throws XMLStreamException Cannot read the next entry (hasNext()).
     * @throws ParseException Date parsing is not working.
     */
    public void create_program() throws XMLStreamException, ParseException {
        int eventType = xmlsr.getEventType();

        //Cree un program et un broadcast + add start/stop/channelID a broadcast
        Program program = new Program();
        tv.addProgram(program);
        DateFormat dateFormat = new SimpleDateFormat("YYYYMMDDhhmmss yyyy");
        Broadcast broadcast = new Broadcast(xmlsr.getAttributeValue(3), dateFormat.parse(xmlsr.getAttributeValue(0)), dateFormat.parse(xmlsr.getAttributeValue(1)), program);

        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("//programme") == Boolean.FALSE)){
            eventType = xmlsr.next();

            if(eventType == XMLEvent.START_ELEMENT) switch (xmlsr.getLocalName()) {
                case "title":
                    //todo gerer le cas de titres multiples (avec argument de langue? pas oblgatoire)
                    program.setTitle(xmlsr.getElementText());
                    break;
                case "sub-title":
                    //todo idem title
                    program.setSub_title(xmlsr.getElementText());
                    break;
                case "desc":
                    //todo idem title?
                    program.setDescripion(xmlsr.getElementText());
                    break;
                case "credits":
                    create_credits(program);
                    break;
                case "date":
                    Date date = new Date();
                    date.setYear(Integer.parseInt(xmlsr.getElementText()));
                    program.setDate(date);
                    break;
                case "category":
                    program.setCategory(xmlsr.getElementText());
                    break;
                case "subtitles":
                    while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("//subtitles") == Boolean.FALSE)){
                        eventType = xmlsr.next();

                        if(eventType == XMLEvent.START_ELEMENT){
                            if (xmlsr.getLocalName() == "language"){
                                program.setSubtitles_language(xmlsr.getElementText());
                            }
                        }
                    }
                    break;
                case "length":
                    program.setLength(Integer.parseInt(xmlsr.getElementText()));
                    program.setTime_unit(xmlsr.getAttributeValue(0));
                    break;
                case "country":
                    program.setCountry(xmlsr.getElementText());
                    break;
                case "episode-num":
                    program.setEpisode_num(xmlsr.getElementText());
                    break;
                case "video":
                    while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("//video") == Boolean.FALSE)){
                        eventType = xmlsr.next();

                        if(eventType == XMLEvent.START_ELEMENT){
                            if (xmlsr.getLocalName() == "aspect"){
                                program.setVideo_format(xmlsr.getElementText());
                            }
                            if (xmlsr.getLocalName() == "quality"){
                                program.setVideo_quality(xmlsr.getElementText());
                            }
                        }
                    }
                    break;
            }

        }
    }

    /**
     * Creates a new instance of <b>Channel</b> class and fill it with the information read from the XML file.
     * @throws XMLStreamException Cannot read the next entry (hasNext() or getElementText()).
     */
    public void create_channel() throws XMLStreamException {
        int eventType = xmlsr.getEventType();
        //Creates a new Channel and stores its ID
        Channel channel = new Channel(xmlsr.getAttributeValue(0));
        tv.addChannel(channel);

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
     * @throws ParseException In case {@link #create_program()} throws an exception.
     */
    public void start_element() throws XMLStreamException, ParseException {
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
     * @param tv New <b>Tv</b> instance to fill with the parser.
     * @throws XMLStreamException Cannot read the next entry (hasNext()) or in case {@link #start_element()} throws an exception.
     * @throws ParseException In case {@link #start_element()} throws an exception.
     */
    public void run(Tv tv) throws XMLStreamException, ParseException {
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
