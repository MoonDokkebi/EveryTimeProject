public class User {
    private String ussername;  //학년
    private String id;//이수구분
    private String password;//교과번호
    private String studentcode;//과목이름

    public User(String username, String id, String password, String studentcode) {
        super();
        this.ussername = username;
        this.id = id;
        this.password = password;
        this.studentcode = studentcode;
    }

    public String getUsername() {
        return ussername;
    }

    public String getId() {
        return id;
    }


    public String getPassword() {
        return password;
    }


    public String getStudentcode() {
        return studentcode;
    }





}
