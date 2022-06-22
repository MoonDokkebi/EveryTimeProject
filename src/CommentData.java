public class CommentData {
    private int commentNum;  //게시글번호
    private String comment;//게시글 내용?
    private String commetMaker;//만든사람이름
    private boolean changeName;//익명 여부
    private int postnum; //소속된곳

    public CommentData(int commentNum, String comment,String commetMaker, boolean changeName, int postnum) {
        super();
        this.commentNum = commentNum;
        this.comment = comment;
        this.commetMaker = commetMaker;
        this.changeName = changeName;
        this.postnum = postnum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public String getComment() {
        return comment;
    }

    public String getCommetMaker() {
        return commetMaker;
    }

    public boolean isChangeName() {
        return changeName;
    }


    public int getPostnum() {
        return postnum;
    }
}
