import java.util.Scanner;

public class MainPage {
    private static Scanner in = new Scanner(System.in);

    private static void bfLoginMenu() {
        System.out.println("[[[[ 로그인전 ]]]]");
        System.out.println(" 1. 회원가입");
        System.out.println(" 2. 로그인");
        System.out.println(" 0. 종료");
    }
    private static void afLoginMenu() {
        System.out.println("[[[[ 로그인후 ]]]]");
        System.out.println(" 1. 게시판 목록");
        System.out.println(" 2. 게시판 생성");
        System.out.println(" 3. 게시판 삭제");
        System.out.println(" 4. 시간표");
        System.out.println(" 5. 저장 및 종료");
    }
    public static void main(String[] args) {

        UserManager userManager = new UserManager();
        BoardManager boardManager =new BoardManager();
        new PostManager();
        new CommentManager();
        TimeTableManager timeTableManager = new TimeTableManager();


        FileLoad.readTxt();
        boolean check = true;
        while(check) {
            bfLoginMenu();
            int bfloginmenu = in.nextInt();
            if (bfloginmenu == 0) {
                System.out.println("프로그램 종료 및 저장");
                FileLoad.writeTxt();
                break;
            }
            System.out.println();
            switch (bfloginmenu) {
                case 1 -> userManager.register();
                case 2 ->check = userManager.login();

            }
        }

        while(!check) {
            afLoginMenu();
            int afloginmenu = in.nextInt();
            if (afloginmenu == 5) {
                System.out.println("종료및 저장");
                FileLoad.writeTxt();
                return;
            }

            switch (afloginmenu) {
                case 1 -> boardManager.goboard();
                case 2 -> boardManager.addBoard(UserManager.currentUser);
                case 3 -> boardManager.removeBoard();
                case 4 -> timeTableManager.showTimeTableMenu();
            }
        }

    }
}
