import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PostManager {
    public static ArrayList<PostData> postData;
    public static int currentPost;
    static Scanner in = new Scanner(System.in);


    public PostManager() {
        postData = new ArrayList<>();
    }

    private static void menu() {
        System.out.println("[[[[ 게시글 ]]]]");
        System.out.println(" 1. 게시글 목록");
        System.out.println(" 2. 게시글 생성");
        System.out.println(" 3. 게시글 삭제");
        System.out.println(" 4. 게시글 수정");
        System.out.println(" 0. 이전");
    }

    public static void goPostMenu(int currentBoard) {

        while(true) {
            menu();
            int menu = in.nextInt();
            if (menu == 0) return;
            System.out.println();
            switch (menu) {
                case 1 -> postList(currentBoard);
                case 2 -> addPost(currentBoard);
                case 3 -> removePost();
                case 4 -> upatePost(currentBoard);



            }
        }
    }
    private static int findLocation(int postNum){
        int pos=0;
        for (int i = 0; i < postData.size() ; i++)
            if(postData.get(i).getPostdNum()==postNum) pos=i;
        return pos;
    }
    private static void upatePost(int currentBoard) {
        System.out.println("수정할 게시글 번호를입력하세요");
        int postNum = in.nextInt();
        int pos = findLocation(postNum);
        if(pos!=-1) {
            System.out.println("제목 : ");
            String posttitle = in.nextLine();
            System.out.println("내용 : ");
            String post = in.nextLine();
            System.out.println("익명여부 : ");
            String yn = in.next();
            boolean chabgeName = false;
            if(Objects.equals(yn, "Y"))chabgeName=true;
            else if (Objects.equals(yn, "N"))chabgeName=false;


            postData.set(pos, new PostData(pos,posttitle, post, chabgeName, currentBoard));//pos 위치에 새로운 book 객체를 저장하는 메소드
        }
    }

    private static void removePost() {
        System.out.println("게시글 삭제");
        System.out.println(postData);
        System.out.println("지울 게시글 번호를 입력하세요 : ");
        int postNum = in.nextInt();
        int pos = findLocation(postNum);
        if(pos!=-1) postData.remove(pos);
        else System.out.println("해당하는 게시글이 없습니다.");

    }

    public static void postList(int currentBoard) {
        boolean checkboard= false;
        for (PostData postDatum : postData) {
            if (postDatum.getBoardnum() == currentBoard) {
                checkboard = true;
                break;
            }
        }

        if (!checkboard){
            System.out.println("게시글이 없습니다.");
            return;
        } else{
            System.out.println("게시글 리스트");
            for (PostData postDatum : postData) {
                if (postDatum.getBoardnum() == currentBoard) {
                    System.out.println(postDatum);
                }
            }
        }

        System.out.println("들어갈 게시글번호를 입력하세요");
        System.out.println("이전 : 0");
        int postNum = in.nextInt();
        if (postNum==0) return;
        for (PostData postDatum : postData) {
            if (postNum != postDatum.getPostdNum()) {
                System.out.println("해당번호의 계시판이 없습니다.");
            } else if (postNum == postDatum.getPostdNum()) {
                currentPost = postNum;
                CommentManager.goCommentMenu(currentPost);

            }
        }
    }


    public static void addPost(int currentBoard) {
        int maxpostnum = 0;
        for (PostData postDatum : postData) {
            if (maxpostnum < postDatum.getPostdNum()) {
                maxpostnum = postDatum.getPostdNum();
            }
        }
        maxpostnum++;


        System.out.println("게시글 제목을 입력하세요 : ");
        String postTitle = in.nextLine();
        System.out.println("게시글 내용을 입력하세요");
        String post = in.nextLine();
        boolean hide;
        boolean check ;
        do {
            System.out.println("익명 여부를 입력하세요(Y/N) : ");
            String bool = in.next();
            hide = true;
            if (Objects.equals(bool, "Y")) {
                hide = true;
                check = false;
            } else if (Objects.equals(bool, "N")) {
                hide = false;
                check = false;
            } else {
                System.out.println("Y/N을 입력하세요");
                check = true;
            }
        } while (check);

        PostData PD = new PostData(maxpostnum, postTitle, post, hide, currentBoard);
        postData.add(PD);
    }
}
