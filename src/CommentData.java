public class CommentData {
    private int commentNum;  //게시글번호
    private String comment;//게시글 내용?
    private User commetMaker;//만든사람이름
    private boolean changeName;//익명 여부
    private int postnum; //소속된곳

    public CommentData(int commentNum, String comment,User commetMaker, boolean changeName, int postnum) {
        super();
        this.commentNum = commentNum;
        this.comment = comment;
        //this.postMakeer = postMakeer;
        this.changeName = changeName;
        this.postnum = postnum;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public String getComment() {
        return comment;
    }

    public User getCommetMaker() {
        return commetMaker;
    }

    public boolean isChangeName() {
        return changeName;
    }

    @Override
    public String toString() {
        return  "댓글 번호='" + commentNum + '\'' +
                ", 댓글 내용='" + comment + '\'' +
                ", 댓글 작성자='" + commetMaker + '\'' +
                ", 익명여부=" + changeName +
                ", postnum='" + postnum + '\'' +
                '}'+'\n';
    }

    public int getPostnum() {
        return postnum;
    }
}
