public class TimeTableData {
    private String grade;  //학년
    private String division;//이수구분
    private String classnum;//교과번호
    private String classname;//과목이름
    private String classnum2;//분반
    private String credit;//학점
    private String professor;//담당교수
    private String classtime; //강의시간
    private String classroom;//강의장소

    public void printInfo() {
        System.out.printf("학년 : %-4s, 이수구분 : %5s 교과번호 : %6s, 과목이름 : %-15s, 분반 : %2s, 학점 : %1s, 담당교수 : %-4s, 강의시간 : %-30s, 강의장소 : %-30s%n",
                grade,division,classnum,classname,classnum2,credit,professor,classtime,classroom);

        //System.out.println("학년 : "+ grade + ", 이수구분 : " + division +", 교과번호 : "+ classnum +", 과목이름 : "+ classname
        //        +", 분반 : "+ division2+", 학점 : "+ credit+", 담당교수 : "+ professor+", 강의시간 : "+ classtime+", 강의장소 : "+ classroom);
    }

    public TimeTableData(String grade, String division, String classnum, String classname, String classnum2, String credit, String professor, String classtime, String classroom) {
        super();
        this.grade = grade;
        this.division = division;
        this.classnum = classnum;
        this.classname = classname;
        this.classnum2 = classnum2;
        this.credit = credit;
        this.professor = professor;
        this.classtime = classtime;
        this.classroom = classroom;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getClassnum() {
        return classnum;
    }

    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getClassnum2() {
        return classnum2;
    }

    public void setClassnum2(String classnum2) {
        this.classnum2 = classnum2;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getClasstime() {
        return classtime;
    }

    public void setClasstime(String classtime) {
        this.classtime = classtime;
    }


    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }





}