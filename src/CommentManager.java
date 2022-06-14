import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CommentManager {
    public static ArrayList<CommentData> commentArrayList;
    static Scanner in = new Scanner(System.in);
    static int commentNum = 0;

    public CommentManager(){commentArrayList =new ArrayList<>();}
    private static void commentmenu() {
        System.out.println("[[[[ 댓글 ]]]]");
        System.out.println(" 1. 댓글 목록");
        System.out.println(" 2. 댓글 생성");
        System.out.println(" 3. 댓글 삭제");
        System.out.println(" 4. 댓글 수정");
        System.out.println(" 0. 이전");
    }

    public static void goCommentMenu(int currentPost) {
        while(true) {
            commentmenu();
            int commentmenu = in.nextInt();
            if (commentmenu == 0) return;
            System.out.println();
            switch (commentmenu) {
                case 1 -> commentList(currentPost);
                case 2 -> addcomment(currentPost,UserManager.currentUser);
                case 3 -> removecomment();
                case 4 -> upateComment(currentPost,UserManager.currentUser);
            }
        }
    }
    private static void upateComment(int currentPost,User commentMaker) {

        int pos = findLocation(commentNum);
        if(pos!=-1) {
            System.out.println("내용 : ");
            String post = in.nextLine();
            System.out.println("익명여부 : ");
            String yn = in.next();
            boolean chabgeName = false;
            if(Objects.equals(yn, "Y"))chabgeName=true;
            else if (Objects.equals(yn, "N"))chabgeName=false;


            commentArrayList.set(pos, new CommentData(pos, post,commentMaker, chabgeName, currentPost));//pos 위치에 새로운 book 객체를 저장하는 메소드
        }
    }
    private static void removecomment() {
        System.out.println("댓글 삭제");
        System.out.println(commentArrayList);
        System.out.println("지울 댓글 번호를 입력하세요 : ");
        int commentNum = in.nextInt();
        int pos = findLocation(commentNum);
        if(pos!=-1) commentArrayList.remove(pos);
        else System.out.println("해당하는 댓글이 없습니다.");
    }

    private static void addcomment(int currentPost,User commentMaker) {
        int commentNum = 0;
        for (CommentData commentDatum : commentArrayList) {
            if (commentNum < commentDatum.getCommentNum()) {
                commentNum = commentDatum.getCommentNum();
            }
        }
        commentNum++;



        //System.out.println("만든 사람 입력하세요 : ");
        //String boardMakeer = in.next();
        System.out.println("게시글 내용을 입력하세요");
        String comment = in.next();
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

        CommentData CD = new CommentData(commentNum, comment, commentMaker, hide, currentPost);
        commentArrayList.add(CD);
    }


    private static void commentList(int currentPost) {
        boolean checkpost= false;
        for (CommentData commentDatum : commentArrayList) {
            if (commentDatum.getPostnum() == currentPost) {
                checkpost = true;
                break;
            }
        }

        if (!checkpost){
            System.out.println("댓글이 없습니다.");
            return;
        } else{
            System.out.println("                       <<댓글 리스트>>");
            System.out.println(" 댓글 번호 |     댓글내용     | 작성자 | 익명여부");
            System.out.println("----------------------------------------------");
            for (CommentData co : commentArrayList) {
                System.out.printf(" %-8d | %-15s | %-5s | %-1s\n",
                        co.getPostnum() , co.getComment(),
                        co.getCommetMaker(), co.isChangeName());
            }
        }


    }


    private static int findLocation(int currentPost){
        int pos=0;
        for (int i = 0; i < commentArrayList.size() ; i++)
            if(commentArrayList.get(i).getCommentNum()==currentPost) pos=i;
        return pos;
    }



}
