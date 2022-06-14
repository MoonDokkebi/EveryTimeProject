public class BoardData {

    private int boardNum;  //게시판번호
    private String boardTitle;//제목
    //private String    ;//보드 설명?
    private User boardMaker;//만든사람이름
    private boolean changeName;//익명여부

    public BoardData(int boardNum, String boardTitle, User boardMaker, boolean changeName, PostManager postManager) {
        this.boardNum = boardNum;
        this.boardTitle = boardTitle;
        this.boardMaker = boardMaker;
        this.changeName = changeName;
    }

    public int getBoardNum() {
        return boardNum;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public User getBoardMaker() {
        return boardMaker;
    }

    public boolean isChangeName() {
        return changeName;
    }

    @Override
    public String toString() {
        return  String.format(" %-7d | %-15s | %5s | %-1s\n",
                boardNum, boardTitle, boardMaker, changeName);
    }

}
