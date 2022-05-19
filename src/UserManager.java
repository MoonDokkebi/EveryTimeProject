import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
    public static ArrayList<User> userdata;
    public static User currentUser;

    Scanner in = new Scanner(System.in);

    public UserManager(){userdata =new ArrayList<>();}

    public void register() { //회원가입
        System.out.println("회원가입");
        System.out.println("이름을 입력하세요");
        String Username = in.next();
        System.out.println("ID를 입력하세요");
        String ID = in.next();
        if (!checkId(ID)) // 아이디가 중복되었으면
        {
            System.out.println("이미 사용중인 아이디 입니다. \n");
            return;
        }
        System.out.println("비밀번호를 입력하세요");
        String Password = in.next();
        System.out.println("학번을 입력하세요");
        String StudentCode = in.next();
        if (!checkScode(StudentCode)) // 아이디가 중복되었으면
        {
            System.out.println("이미 가입된 학생입니다. \n");
            return;
        }
        userdata.add(new User(Username,ID,Password,StudentCode));
    }
    private boolean checkId(String id){ // 아이디의 중복 여부를 리턴
        boolean check = true;
        if(userdata.isEmpty()) return true;
        for (User userdatum : userdata) {
            if (!userdatum.getId().equals(id)) return true;
            if (userdatum.getId().equals(id)) return false;
        }
        return true;
    }




    private boolean checkScode(String studentCode){ // 학번의 중복 여부를 리턴
        if(userdata.isEmpty()) return true;
        for (User userdatum : userdata) {
            if (!userdatum.getStudentcode().equals(studentCode)) return true;
            if (userdatum.getStudentcode().equals(studentCode)) return false;
        }
        return true;
    }
    public boolean login() {
        System.out.println("로그인");
        System.out.println("ID를 입력하세요");
        String ID = in.next();
        System.out.println("비밀번호를 입력하세요");
        String Password = in.next();
        boolean check = true;
        for (User tempCurrentUser : userdata) {
            if (tempCurrentUser.getId().equals(ID)//등록된 데이터가 있을때
                    && tempCurrentUser.getPassword().equals(Password)) {
                System.out.println("로그인에 성공하였습니다. \n");
                check = false;
                currentUser = tempCurrentUser;
                break;
            } else if (!tempCurrentUser.getId().equals(ID)) {
                System.out.println("존재하지 않는 아이디입니다. \n");
                return true;
            } else if (tempCurrentUser.getId().equals(ID) && !tempCurrentUser.getPassword().equals(Password)) {
                System.out.println("암호가 잘못되었습니다. \n");
                return true;
            }
        }

        return check;
    }
}
