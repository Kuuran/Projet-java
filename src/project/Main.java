package project;

import javax.xml.stream.XMLStreamException;

public class Main {

    public static  void main(String[] args){
        Parser p = new Parser("input/tvguide.xml");
        try {
            p.run();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

}
