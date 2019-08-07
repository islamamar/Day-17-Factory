
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

 class XMLFileParser implements FileParser {
    @Override
    public void ParseFile() {
        try {
            File inputFile = new File("SI2.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("note");
            System.out.println("----------------------------");
            FileWriter fw = new FileWriter("result.txt") ;
            fw.write("Type: Note\n" +
                    "------------------\n");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);


                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("TO: "
                            + eElement
                            .getElementsByTagName("to")
                            .item(0)
                            .getTextContent());
                    fw.write("TO: " + eElement.getElementsByTagName("to").item(0).getTextContent()+"\n");
                    System.out.println("From : "
                            + eElement
                            .getElementsByTagName("from")
                            .item(0)
                            .getTextContent());
                    fw.write("From: " + eElement.getElementsByTagName("from").item(0).getTextContent()+"\n");
                    System.out.println("heading "
                            + eElement
                            .getElementsByTagName("heading")
                            .item(0)
                            .getTextContent());
                    fw.write("heading: " + eElement.getElementsByTagName("heading").item(0).getTextContent()+"\n");
                    System.out.println("Body : "
                            + eElement
                            .getElementsByTagName("body")
                            .item(0)
                            .getTextContent());
                    fw.write("Body: " + eElement.getElementsByTagName("body").item(0).getTextContent()+"\n");
                }
            }
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
