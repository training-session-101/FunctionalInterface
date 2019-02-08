import javax.xml.soap.SOAPPart;
import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface ReadFileFunction {
    String readFile() throws IOException;
    default void show(){
        System.out.printf("Data");
    }
}
