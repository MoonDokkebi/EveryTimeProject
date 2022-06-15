import java.io.*;
import java.util.StringTokenizer;

public class FileLoad {
    public static void readTxt() {
        try {
            FileReader boardfile_reader = new FileReader("F:\\상민\\대학교\\3학년1학기\\Java_Test\\EveryTimeProject\\boardfile.txt");
            FileReader postfile_reader = new FileReader("F:\\상민\\대학교\\3학년1학기\\Java_Test\\EveryTimeProject\\postfile.txt");
            FileReader commentfile_reader = new FileReader("F:\\상민\\대학교\\3학년1학기\\Java_Test\\EveryTimeProject\\commentfile.txt");
            FileReader userfile_reader = new FileReader("F:\\상민\\대학교\\3학년1학기\\Java_Test\\EveryTimeProject\\userfile.txt");


            BufferedReader boardfile_buf = new BufferedReader(boardfile_reader);
            BufferedReader postfile_buf = new BufferedReader(postfile_reader);
            BufferedReader commentfile_buf = new BufferedReader(commentfile_reader);
            BufferedReader userfile_buf = new BufferedReader(userfile_reader);

            String line;
            //보드
            while ((line = boardfile_buf.readLine()) != null) {
                StringTokenizer tokenb = new StringTokenizer(line, ",");
                int boardNum = Integer.parseInt(tokenb.nextToken());
                String boardTittle = tokenb.nextToken();
                String boardMaker = tokenb.nextToken();
                boolean changename = Boolean.parseBoolean(tokenb.nextToken());

                BoardManager.boardArraylist.add(new BoardData(boardNum, boardTittle, boardMaker, changename));
            }
            boardfile_buf.close();
            boardfile_reader.close();
            System.out.println("board 파일 로딩 완료");


            //포스트
            while ((line = postfile_buf.readLine()) != null) {
                StringTokenizer tokenp = new StringTokenizer(line, ",");
                int postNum = Integer.parseInt(tokenp.nextToken());
                String postTittle = tokenp.nextToken();
                String post = tokenp.nextToken();
                String postMaker = tokenp.nextToken();
                boolean post_changename = Boolean.parseBoolean(tokenp.nextToken());
                int linkboard = Integer.parseInt(tokenp.nextToken());
                PostManager.postArrayList.add(new PostData(postNum, postTittle, post, postMaker, post_changename, linkboard));
            }
            postfile_buf.close();
            postfile_reader.close();
            System.out.println("post 파일 로딩 완료");


            //코멘트
            while ((line = commentfile_buf.readLine()) != null) {
                StringTokenizer tokenc = new StringTokenizer(line, ",");
                int commentNum = Integer.parseInt(tokenc.nextToken());
                String commnet = tokenc.nextToken();
                String commentMaker = tokenc.nextToken();
                boolean comment_changename = Boolean.parseBoolean(tokenc.nextToken());
                int linkpost = Integer.parseInt(tokenc.nextToken());

                CommentManager.commentArrayList.add(new CommentData(commentNum, commnet, commentMaker, comment_changename, linkpost));
            }
            commentfile_buf.close();
            commentfile_reader.close();
            System.out.println("comment 파일 로딩 완료");

            //유저
            while ((line = userfile_buf.readLine()) != null) {
                StringTokenizer tokenu = new StringTokenizer(line, ",");
                String username = tokenu.nextToken();
                String id = tokenu.nextToken();
                String password = tokenu.nextToken();
                String studentcode = tokenu.nextToken();

                UserManager.userArrayList.add(new User(username, id, password, studentcode));
            }
            userfile_buf.close();
            userfile_reader.close();
            System.out.println("user 파일 로딩 완료");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static void writeTxt()  {
        try{
            FileWriter boardfile_writer = new FileWriter("F:\\상민\\대학교\\3학년1학기\\Java_Test\\EveryTimeProject\\boardfile.txt");
            FileWriter postfile_writer = new FileWriter("F:\\상민\\대학교\\3학년1학기\\Java_Test\\EveryTimeProject\\postfile.txt");
            FileWriter commentfile_writer = new FileWriter("F:\\상민\\대학교\\3학년1학기\\Java_Test\\EveryTimeProject\\commentfile.txt");
            FileWriter userfile_writer = new FileWriter("F:\\상민\\대학교\\3학년1학기\\Java_Test\\EveryTimeProject\\userfile.txt");

            BufferedWriter boardfile_buf = new BufferedWriter(boardfile_writer);
            BufferedWriter postfile_buf = new BufferedWriter(postfile_writer);
            BufferedWriter commentfile_buf = new BufferedWriter(commentfile_writer);
            BufferedWriter userfile_buf = new BufferedWriter(userfile_writer);

            for(BoardData boardData : BoardManager.boardArraylist){
                boardfile_buf.write(boardData.getBoardNum() +",");
                boardfile_buf.write(boardData.getBoardTitle() +",");
                boardfile_buf.write(boardData.getBoardMaker() +",");
                boardfile_buf.write(boardData.isChangeName() +",");
                boardfile_buf.newLine();
            }
            boardfile_buf.close();
            boardfile_writer.close();

            for(PostData postData : PostManager.postArrayList){
                postfile_buf.write(postData.getPostdNum() +",");
                postfile_buf.write(postData.getPostTitle() +",");
                postfile_buf.write(postData.getPost() +",");
                postfile_buf.write(postData.getPostMakeer() +",");
                postfile_buf.write(postData.isChangeName() +",");
                postfile_buf.write(postData.getBoardnum() +",");
                postfile_buf.newLine();
            }
            postfile_buf.close();
            postfile_writer.close();

            for(CommentData commentData : CommentManager.commentArrayList){
                commentfile_buf.write(commentData.getCommentNum() +",");
                commentfile_buf.write(commentData.getComment() +",");
                commentfile_buf.write(commentData.getCommetMaker() +",");
                commentfile_buf.write(commentData.isChangeName() +",");
                commentfile_buf.write(commentData.getPostnum() +",");
                commentfile_buf.newLine();
            }
            commentfile_buf.close();
            commentfile_writer.close();

            for(User user : UserManager.userArrayList){
                userfile_buf.write(user.getUsername() +",");
                userfile_buf.write(user.getId() +",");
                userfile_buf.write(user.getPassword() +",");
                userfile_buf.write(user.getStudentcode() +",");
                userfile_buf.newLine();
            }
            userfile_buf.close();
            userfile_writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}
