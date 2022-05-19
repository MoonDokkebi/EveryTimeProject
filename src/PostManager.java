import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class PostManager {
    public static ArrayList<PostData> postData;
    Scanner in = new Scanner(System.in);
    int postNum = 0;

    public void addPost(int boardnum) {

        postNum++;

        System.out.println("게시글 제목을 입력하세요 : ");
        String posstTitle = in.next();
        //System.out.println("만든 사람 입력하세요 : ");
        //String boardMakeer = in.next();
        System.out.println("게시글 내용을 입력하세요");
        String post = in.next();
        boolean hide;
        boolean check = false;
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


        PostData PD = new PostData(postNum, posstTitle, post, hide, boardnum);
        postData.add(PD);
    }
}
