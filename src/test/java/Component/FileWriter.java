package Component;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;



public class FileWriter {

    public static void fileWrite(String str) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("itemInfo.txt", "UTF-8");
        writer.println(str);
        writer.close();

    }
}
