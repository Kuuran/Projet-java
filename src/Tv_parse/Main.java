package Tv_parse;

import javax.xml.stream.XMLStreamException;

public class Main {

    public static  void main(String[] args){
        Parser p = new Parser("input/tvguide.xml");
        Tv tv = new Tv();
        try {
            p.run(tv);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

}
