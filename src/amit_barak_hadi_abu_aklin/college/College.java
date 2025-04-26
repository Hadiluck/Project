package amit_barak_hadi_abu_aklin.college;

public class College {
    private String name;
    private static int numOfLecturers;
    private static int numOfCommittees;
    private static int numOfDepartments;
    private Lecturer[] allLecturers ;
    private Department[] allDepartments ;
    private Committees[] allCommittees ;

    public College(String name) {
        this.name = name;
        this.allLecturers = new Lecturer[0];
        this.allDepartments = new Department[0];
        this.allCommittees = new Committees[0];
    }


    public static boolean isExist(String name,String[] arr, int numOf) {
        for (int i = 0; i < numOf; i++) {
            if (arr[i].equals(name)){
                return true;
            }
        }
        return false;
    }

    private static String[] copy(String[] array, int size) {
        String[] temp = new String[size];
        for (int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }
        return temp;
    }


//    private static void showLecturersAll() {
//        System.out.print("[ ");
//        for (int i = 0; i < numOfLecturers; i++) {
//            if (i == numOfLecturers - 1){
//                System.out.print(lecturers[i]);
//            } else{
//                System.out.print(lecturers[i] + ", ");
//            }
//        }
//        System.out.println("]");
//    }
//
//    private static void showCommitteesAll() {
//        System.out.print("[ ");
//        for (int i = 0; i < numOfCommittees; i++) {
//            if (i == numOfCommittees - 1){
//                System.out.print(committees[i]);
//            } else{
//                System.out.print(committees[i] + ", ");
//            }
//        }
//        System.out.println("]");
//    }

}
