public class TimeTableData {
    private String grade;  //학년
    private String division;//이수구분
    private String classnum;//교과번호
    private String classname;//과목이름
    private String classnum2;//분반
    private String credit;//학점
    private String professor;//담당교수
    private String classtime; //강의시간
    private String classtime2; //강의시간
    private String classroom;//강의장소

    public void printInfo() {//toString으로 대체함
        System.out.printf("학년 : %-4s, 이수구분 : %5s 교과번호 : %6s, 과목이름 : %-15s, 분반 : %2s, 학점 : %1s, 담당교수 : %-4s, 강의시간 : %-30s, 강의장소 : %-30s%n",
                grade,division,classnum,classname,classnum2,credit,professor,classtime,classroom);

    }

    public TimeTableData(String grade, String division, String classnum, String classname, String classnum2, String credit, String professor, String classtime, String classtime2, String classroom) {
        super();
        this.grade = grade;
        this.division = division;
        this.classnum = classnum;
        this.classname = classname;
        this.classnum2 = classnum2;
        this.credit = credit;
        this.professor = professor;
        this.classtime = classtime;
        this.classtime2 = classtime2;
        this.classroom = classroom;
    }


    public String getGrade() {
        return grade;
    }

    public String getDivision() {
        return division;
    }

    public String getCredit() {
        return credit;
    }

    public String getClassroom() {
        return classroom;
    }

    public String getClassnum() {
        return classnum;
    }

    public String getClassname() {
        return classname;
    }

    public String getClassnum2() {
        return classnum2;
    }

    public String getProfessor() {
        return professor;
    }

    public String getClasstime() {
        return classtime;
    }

    public String getClasstime2() {
        return classtime2;
    }





}
