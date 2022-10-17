package utilities;

import java.io.BufferedReader;
import java.io.FileReader;

public class TXTReader {

    public static String readFile(String filepath)
    {
        String returnFileContent="";
        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            String st;
            while ((st = br.readLine()) != null){
                returnFileContent = returnFileContent +st +"\n";
                System.out.println(st);
            }
        } catch(Exception e){

        }

        return returnFileContent;
    }
}
