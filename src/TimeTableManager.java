
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TimeTableManager {
    private static ArrayList<TimeTableData> data;
    String[][] timeTableDataList = new String[30][5];
    Scanner in = new Scanner(System.in);
    public TimeTableManager(){data =new ArrayList<>();}//객체 생성

    public static void choose() {


    }
    public void addtable() {
        int pos1=0;
        System.out.println("교과번호를 입력하세요 : ");
        String classnum = in.next();
        System.out.println("분반을 입력하세요 : ");
        String classnum2 = in.next();
        for (int i = 0; i < data.size() ; i++){
            if(data.get(i).getClassnum().equals(classnum)){
                if (data.get(i).getClassnum2().equals(classnum2)) pos1 = i; //주소 찾기
            }
        }

        //data.get(pos1).getClasstime().contains

    }

    public void addtable_user() {
    }

    public int loadData() {
        String file = "F:\\상민\\대학교\\3학년1학기\\Java_Test\\EveryTimeProject\\timetable.csv";
        try {
            FileReader reader = new FileReader(file);
            BufferedReader buf = new BufferedReader(reader);
            String line;
            String str = null;
            while((line = buf.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line, ",");

                String grade = tokenizer.nextToken();
                String division = tokenizer.nextToken();
                String classnum = tokenizer.nextToken();
                String classname = tokenizer.nextToken();
                String classnum2 = tokenizer.nextToken();
                String credit = tokenizer.nextToken();
                String professor = tokenizer.nextToken();
                String classtime = tokenizer.nextToken();
                //String classtime2 = tokenizer.nextToken();
                String classroom = tokenizer.nextToken();




                TimeTableData timeTableData = new TimeTableData(grade,division,classnum,classname,classnum2,credit,professor,classtime,classroom);

                data.add(timeTableData);
            }
            buf.close();
        } catch (FileNotFoundException e) {
            System.out.println("File open error : "+file+"을 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }
    public void showAllData() {

        for(TimeTableData timeTableData : data) timeTableData.printInfo();
    }



    public void showNowTable() {
        for (int i = 0; i < timeTableDataList.length ; i++) {
            System.out.print( ((i*30+540)/60)+"시"+((i*30+540)%60)+"분 : ");
            System.out.println(Arrays.toString(timeTableDataList[i]));
            System.out.println();
        }

    }
}
