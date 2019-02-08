import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {
    public static void main(String[] args) throws Exception  {
       BufferedReader br=new BufferedReader(new java.io.FileReader("abc.txt"));
        String s=new FileReader().readFile(()-> {
           BufferedReader br1= new BufferedReader(new java.io.FileReader("abc.txt"));
           return  br1.readLine();
        });
        System.out.println(s);
    }

    String readFile(ReadFileFunction readFileFunction) throws IOException{
        return readFileFunction.readFile();
    }
}
