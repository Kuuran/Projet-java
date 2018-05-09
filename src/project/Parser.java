package project;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Parser {

    private XMLInputFactory xmlif;
    private XMLStreamReader xmlsr;
    private FileReader xmlfr;

    public Parser(String name){
        xmlif = XMLInputFactory.newInstance();

        try {
            xmlfr = new FileReader(name);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            xmlsr = xmlif.createXMLStreamReader(xmlfr);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    /*
    fonction programme
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
                    //todo (gere les credits)
                    break;
                case "date":
                    //todo
                    break;
     */




    private void create_channel() throws XMLStreamException {
        int eventType = xmlsr.getEventType();

        //todo cree un channel et stock son id

        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("//channel") == Boolean.FALSE)){
            eventType = xmlsr.next();

            if(eventType == XMLEvent.START_ELEMENT && xmlsr.getLocalName().equals("display-name")){
                //todo
            }
        }
    }



    private void start_element() throws XMLStreamException {
        switch(xmlsr.getLocalName()){
            case "channel":
                create_channel();
                break;
            case "programme":
                //todo (cree emission + programme)
                break;
            default:
                break;
        }
    }


    public void run() throws XMLStreamException {
        int eventType = 0;
        int loop = 0;

        while(xmlsr.hasNext() && loop < 1000){
            eventType = xmlsr.next();
            loop++;
            switch (eventType){

                case XMLEvent.START_ELEMENT:
                    start_element();
                    break;
                    default:
                        break;

            }


        }
    }

}
