import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BoardManager {
    public static ArrayList<BoardData> boardArraylist;
    public static int currentBoard;
    private static BoardManager boardManager = null;
    Scanner in = new Scanner(System.in);


    public BoardManager() {
        boardArraylist = new ArrayList<>();
    }

    public static BoardManager getInstance(String s) {
        if(boardManager == null)boardManager = new BoardManager();
        return boardManager;
    }

    public void boardList() {

        if (boardArraylist.isEmpty()) {
            System.out.println("게시판이 없습니다.");
        } else {
            System.out.println("          <<게시판>>");
            System.out.println("게시판 번호 |       제목       | 작성자 | 익명여부");
            System.out.println("----------------------------------------------");
            for (BoardData bo : boardArraylist) {
                System.out.printf(" %-8d | %-15s | %-5s | %-1s\n",
                        bo.getBoardNum(), bo.getBoardTitle(),
                        bo.getBoardMaker(), bo.isChangeName());
            }

        }
    }
    public void goboard() {
        int boardNum;
        System.out.println("들어갈 게시판번호를 입력하세요");
        boardList();

        System.out.println("이전 : 0");
        boardNum = in.nextInt();
        if (boardNum == 0) return;
        for (BoardData boardDatum : boardArraylist) {
            if (boardNum != boardDatum.getBoardNum()) {System.out.println("해당번호의 계시판이 없습니다.");}
            else if (boardNum == boardDatum.getBoardNum()) {
                currentBoard = boardNum;
                PostManager.goPostMenu(currentBoard);
            }

        }
    }


    public void addBoard(User boardMaker) {
        int maxboarnum = 1;
        for (BoardData boardDatum : boardArraylist) {
            if (maxboarnum <= boardDatum.getBoardNum()) {
                maxboarnum = boardDatum.getBoardNum();
                maxboarnum++;
            }
        }



        in.nextLine();
        System.out.println("게시판 이름을 입력하세요 : ");
        String boardTitle = in.nextLine();
        //System.out.println("만든 사람 입력하세요 : ");
        //String boardMakeer = in.next();
        boolean hide;
        boolean check;
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
        PostManager postManager = new PostManager();
        BoardData BD = new BoardData(maxboarnum, boardTitle, boardMaker.toString(), hide );
        boardArraylist.add(BD);
    }


    public void removeBoard() {
        int boardNum;
        int pos = 0;
        System.out.println("게시판 삭제");
        boardList();
        System.out.println("지울 게시판 번호를 입력하세요 : ");
        System.out.println("이전 : 0");
        boardNum = in.nextInt();
        if (boardNum == 0) return;
        for (int i = 0; i < boardArraylist.size(); i++) {
            if (boardArraylist.get(i).getBoardNum() == boardNum) pos = i;
        }
        boardArraylist.remove(pos);
    }




}
