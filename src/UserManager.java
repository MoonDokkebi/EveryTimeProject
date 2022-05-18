import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
    public static ArrayList<User> userdata;

    Scanner in = new Scanner(System.in);

    String Username;
    String ID;
    String Password;
    String StudentCode;

    public UserManager(){userdata =new ArrayList<>();}

    public void register() {
        System.out.println("회원가입");
        System.out.println("이름을 입력하세요");
        Username = in.next();
        System.out.println("ID를 입력하세요");
        ID = in.next();
        System.out.println("비밀번호를 입력하세요");
        Password = in.next();
        System.out.println("학번을 입력하세요");
        StudentCode = in.next();
        userdata.add(new User(Username,ID,Password,StudentCode));
    }
    public boolean login() {
        System.out.println("로그인");
        System.out.println("ID를 입력하세요");
        ID = in.next();
        System.out.println("비밀번호를 입력하세요");
        Password = in.next();
        for (int i = 0; i < userdata.size() ; i++) {
            boolean check;
            if (userdata.get(i).getId().equals(ID)//등록된 데이터가 있을때
                    && userdata.get(i).getPassword().equals(Password)) {

                return true;
            } else {
                return false;
            }
        }//for
        return false;
    }
}
