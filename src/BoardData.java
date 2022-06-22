public class BoardData {

    private int boardNum;  //게시판번호
    private String boardTitle;//제목
    private String boardMaker;//만든사람이름
    private boolean changeName;//익명여부

    public BoardData(int boardNum, String boardTitle, String boardMaker, boolean changeName ) {
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

    public String getBoardMaker() {
        return boardMaker;
    }

    public boolean isChangeName() {
        return changeName;
    }




}
