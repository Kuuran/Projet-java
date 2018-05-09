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

    /**
     * @brief Constructor of Parser class.
     * @param filename
     */
    public Parser(String filename){
        xmlif = XMLInputFactory.newInstance();

        try {
            xmlfr = new FileReader(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            xmlsr = xmlif.createXMLStreamReader(xmlfr);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    /**
     * @brief Creates a new instance of program and broadcast classes and fill them with the informations read from the XML file.
     * @throws XMLStreamException
     */
    private void create_program() throws XMLStreamException {
        int eventType = xmlsr.getEventType();

        //todo cree un programm et un broadcast + ajoute start/stop/channelID a broadcast

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
                        //todo (gere les credits)
                        break;
                    case "date":
                        //todo
                        break;

                }
            }

        }
    }

    /**
     * @brief Creates a new instance of channel classe and fill it with the informations read from the XML file.
     * @throws XMLStreamException
     */
    private void create_channel() throws XMLStreamException {
        int eventType = xmlsr.getEventType();

        //todo cree un channel et stock son id

        while (xmlsr.hasNext() && (eventType != XMLEvent.END_ELEMENT || xmlsr.getLocalName().equals("//channel") == Boolean.FALSE)){
            eventType = xmlsr.next();

            if(eventType == XMLEvent.START_ELEMENT && xmlsr.getLocalName().equals("display-name")){
                //todo modifie le display name du channel créé au dessus
            }
        }
    }


    /**
     * @brief Handles the XML event START_ELEMENT.
     * @throws XMLStreamException
     */
    private void start_element() throws XMLStreamException {
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
     * @brief Main loop of the Parser class.
     * @throws XMLStreamException
     */
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
