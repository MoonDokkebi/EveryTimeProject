import java.io.*;
import java.util.StringTokenizer;

public class FileLoad {

    public void readTxt() {
        try{
            FileReader reader = new FileReader(filename);
            BufferedReader buf = new BufferedReader(reader);

            String line;
            while ((line = buf.readLine()) != null){
                StringTokenizer token = new StringTokenizer(line, ",");
                String tittle = token.nextToken();
                String tittle = token.nextToken();
            }
            while (line = uf){
            int data =reader.read();
            if(data == -1)break;
            System.out.println((char)data);
        }
        reader.close();
        System.out.println("로딩 완료");
        } catch(){

        }catch (){

        }
    }

    public void writeTxt() throws Exception{
        Writer writer =new FileWriter("F:\\상민\\대학교\\3학년1학기\\Java_Test\\EveryTimeProject");
        while (true){
            int data =reader.read();
            if(data == -1)break;
            System.out.println((char)data);
        }
        reader.close();
        System.out.println("로딩 완료");
    }


}
