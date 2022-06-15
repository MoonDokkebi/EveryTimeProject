public class PostData {
    private int postNum;  //게시글번호
    private String postTitle;//게시글제목
    private String   post;//게시글 내용?
    private String postMakeer;//만든사람이름
    private boolean changeName;//익명 여부
    private int boardnum; //소속된곳

    public PostData(int postNum, String postTitle, String post,String postMakeer, boolean changeName, int boardnum) {
        super();
        this.postNum = postNum;
        this.postTitle = postTitle;
        this.post = post;
        this.postMakeer = postMakeer;
        this.changeName = changeName;
        this.boardnum = boardnum;
    }

    public int getPostdNum() {return postNum;}

    public String getPostTitle() {
        return postTitle;
    }

    public String getPost() {
        return post;
    }

    public String getPostMakeer() {
        return postMakeer;
    }
    public boolean isChangeName() {
        return changeName;
    }
    public int getBoardnum() {
        return boardnum;
    }






    @Override
    public String toString() {
        return "{" +
                "게시글번호='" + postNum + '\'' +
                ", 게시글 제목='" + postTitle + '\'' +
                ", 게시글 내용='" + post + '\'' +
                ", 제작자='" + postMakeer + '\'' +
                ", 익명여부=" + changeName +
                ", 게시판 번호='" + boardnum + '\'' +
                '}'+'\n';
    }



}
