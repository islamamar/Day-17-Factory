import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;

public class JSONFileParser implements FileParser {


    @Override
    public void ParseFile() throws IOException {
        File file = new File("SI1.json");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;
        String jsonString= " " ;
        while ((st = br.readLine()) != null)
            jsonString = jsonString+st;
        JSONObject obj = new JSONObject(jsonString);
        String pageName = obj.getJSONObject("note").toString();
        System.out.println("-------------");
        FileWriter fw = new FileWriter("result.txt");
        fw.write("Type: Note\n" +
                "------------------\n");

        String[] arrOfStr = pageName.split(",");
        for(int i = 0; i<arrOfStr.length;i++)
        {
            for(int j=0 ;j<arrOfStr[i].length();j++)
            {
                String name = arrOfStr[i];
                if(name.charAt(j)!= '\"' && name.charAt(j)!='{'&& name.charAt(j)!= '}')
                {
                    System.out.print(name.charAt(j));
                    fw.write(name.charAt(j));
                }
            }
            fw.write("\n");
            System.out.println();
        }
        fw.close();
    }
}
