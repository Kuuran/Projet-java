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
import java.util.Objects;

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
        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("credits") == Boolean.FALSE)){
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
        Program program = new Program();
        DateFormat dateFormat = new SimpleDateFormat("YYYYMMDDhhmmss");
        Broadcast broadcast = new Broadcast((tv.getChannel_list().get(xmlsr.getAttributeValue(3)).getDisplay_name()), dateFormat.parse(xmlsr.getAttributeValue(0)), dateFormat.parse(xmlsr.getAttributeValue(1)), program);

        Boolean previously_shown = Boolean.FALSE;

        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("programme") == Boolean.FALSE)){
            eventType = xmlsr.next();

            if(eventType == XMLEvent.START_ELEMENT) {
                switch (xmlsr.getLocalName()) {
                    case "title":
                        program.setTitle(xmlsr.getElementText());
                        break;
                    case "sub-title":
                        program.setSub_title(xmlsr.getElementText());
                        break;
                    case "desc":
                        program.setDescripion(xmlsr.getElementText());
                        break;
                    case "credits":
                        create_credits(program);
                        break;
                    case "date":
                        program.setDate(xmlsr.getElementText());
                        break;
                    case "category":
                        program.setCategory(xmlsr.getElementText());
                        break;
                    case "subtitles":
                        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("subtitles") == Boolean.FALSE)){
                            eventType = xmlsr.next();

                            if(eventType == XMLEvent.START_ELEMENT){
                                if (Objects.equals(xmlsr.getLocalName(), "language")){
                                    program.setSubtitles_language(xmlsr.getElementText());
                                }
                            }
                        }
                        break;
                    case "length":
                        program.setTime_unit(xmlsr.getAttributeValue(0));
                        program.setLength(xmlsr.getElementText());
                        break;
                    case "country":
                        program.setCountry(xmlsr.getElementText());
                        break;
                    case "episode-num":
                        program.setEpisode_num(xmlsr.getElementText());
                        break;
                    case "video":
                        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("video") == Boolean.FALSE)){
                            eventType = xmlsr.next();

                            if(eventType == XMLEvent.START_ELEMENT){
                                if (Objects.equals(xmlsr.getLocalName(), "aspect")){
                                    program.setVideo_format(xmlsr.getElementText());
                                }
                                if (Objects.equals(xmlsr.getLocalName(), "quality")){
                                    program.setVideo_quality(xmlsr.getElementText());
                                }
                            }
                        }
                        break;
                    case "audio":
                        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("audio") == Boolean.FALSE)){
                            eventType = xmlsr.next();

                            if(eventType == XMLEvent.START_ELEMENT){
                                if (Objects.equals(xmlsr.getLocalName(), "stereo")){
                                    program.setAudio_format(xmlsr.getElementText());
                                }
                            }
                        }
                        break;
                    case "prevoiusly-shown":
                        previously_shown = Boolean.TRUE;
                        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("programme") == Boolean.FALSE)) { //skip to the end of the program definition, there is no need to create it since it already exists
                            eventType = xmlsr.next();
                        }
                        break;
                    case "rating":
                        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("rating") == Boolean.FALSE)){
                            eventType = xmlsr.next();

                            if(eventType == XMLEvent.START_ELEMENT){
                                if (Objects.equals(xmlsr.getLocalName(), "value")){
                                    program.setRating(xmlsr.getElementText());
                                }
                            }
                        }
                        break;
                    case "star-rating":
                        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("star-rating") == Boolean.FALSE)){
                            eventType = xmlsr.next();

                            if(eventType == XMLEvent.START_ELEMENT){
                                if (Objects.equals(xmlsr.getLocalName(), "value")){
                                    program.setStar_rating(xmlsr.getElementText());
                                }
                            }
                        }
                    break;
                    default:
                        break;
                }
            }
        }
        if(!previously_shown) tv.addProgram(program);
        tv.addBroadcast(broadcast);

        System.out.println(broadcast.getChannel_id());

        //tv.getChannel_list().get(broadcast.getChannel_id()).addBroadcast(broadcast);

        /*
        if(tv.getChannel_list().containsKey(broadcast.getChannel_id())){
            tv.getChannel_list().get(broadcast.getChannel_id()).addBroadcast(broadcast);
            tv.getChannel_list().
        }*/

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

        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("channel") == Boolean.FALSE)){
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
        if(xmlsr.getLocalName().equals("channel")) {
            create_channel();
        }
        else if(xmlsr.getLocalName().equals("programme")) {
            create_program();
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
        this.tv = tv;
        while(xmlsr.hasNext()){
            eventType = xmlsr.next();
            if (eventType == XMLEvent.START_ELEMENT){
                start_element();
            }
        }
    }
}
