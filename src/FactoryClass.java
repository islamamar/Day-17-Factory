public class FactoryClass {

    public FileParser getFile(String FileParser){
        if(FileParser == null){
            return null;
        }
        if(FileParser.equalsIgnoreCase("1")) {
            return new JSONFileParser();
        }
        else if(FileParser.equalsIgnoreCase("2")){
            return new XMLFileParser();
        }


        return null;
    }


}
