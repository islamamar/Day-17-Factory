import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

//        XMLFileParser m = new XMLFileParser() ;
//        m.ParseFile();
//        JSONFileParser n = new JSONFileParser();
//       n.ParseFile();

        System.out.println("  which File do you want to parse ?");
        System.out.println("1-jsonFile ");
        System.out.println("2-XMLFile");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number from MainMenu");
         String selctor= input.next();
         FactoryClass file = new FactoryClass();
            file.getFile(selctor) ;
        FileParser p = file.getFile(selctor);
        p.ParseFile();


    }



    }
