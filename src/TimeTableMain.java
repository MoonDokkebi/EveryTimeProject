import java.util.Scanner;

public class TimeTableMain {
    private static Scanner in = new Scanner(System.in);

    private static void timetablemenu() {
        System.out.println("[[[[ 시간표 ]]]]");
        System.out.println(" 1. 현재 시간표");
        System.out.println(" 2. 시간표 추가");
        System.out.println(" 3. 시간표 추가 (사용자 정의)");
        System.out.println(" 4. 시간표 삭제");
        System.out.println(" 5. ");
        System.out.println(" 0. 종료");
    }

    public static void main(String[] args) {
        TimeTableManager manager = new TimeTableManager();

        if(manager.loadData() == -1) return;
        manager.showAllData();
        while(true) {
            timetablemenu();
            int timetablemenu = in.nextInt();
            switch (timetablemenu) {
                case 1 -> manager.showNowTable();
                case 2 -> manager.addtable_user();
                case 3 -> manager.addtable();
            }
    }
}
}
