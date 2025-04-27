package amit_barak_hadi_abu_aklin.college;

import java.util.Arrays;

public class College {
    private String name;
    private int numOfLecturers;
    private int numOfDepartments;
    private int numOfCommittees;
    private Lecturer[] allLecturers;
    private Department[] allDepartments;
    private Committee[] allCommittees;

    public College(String name) {
        this.name = name;
        this.allLecturers = new Lecturer[0];
        this.allDepartments = new Department[0];
        this.allCommittees = new Committee[0];
    }

    private boolean isLecturerExist(String name) {
        for (int i = 0; i < numOfLecturers; i++) {
            if (allLecturers[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private boolean isDepartmentExist(String name) {
        for (int i = 0; i < numOfDepartments; i++) {
            if (allDepartments[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCommitteeExist(String name) {
        for (int i = 0; i < numOfCommittees; i++) {
            if (allCommittees[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean addDepartment(Department department) {
        if (isDepartmentExist(department.getName())) {
            return false;
        }
        if (numOfDepartments == allDepartments.length) {
            allDepartments = Arrays.copyOf(allDepartments, allDepartments.length == 0 ? 2 : allDepartments.length * 2);
        }
        allDepartments[numOfDepartments++] = department;
        return true;
    }

    public boolean addLecturer(Lecturer lecturer) {
        if (isLecturerExist(lecturer.getName())) {
            return false;
        }
        if (numOfLecturers == allLecturers.length) {
            allLecturers = Arrays.copyOf(allLecturers, allLecturers.length == 0 ? 2 : allLecturers.length * 2);
        }
        allLecturers[numOfLecturers++] = lecturer;
        return true;
    }

    public boolean addCommittee(Committee committee) {
        if (isCommitteeExist(committee.getName())) {
            return false;
        }
        if (numOfCommittees == allCommittees.length) {
            allCommittees = Arrays.copyOf(allCommittees, allCommittees.length == 0 ? 2 : allCommittees.length * 2);
        }
        allCommittees[numOfCommittees++] = committee;
        return true;
    }

//    public void removeLecturer(Lecturer lecturer) {
//        int j = 0;
//        for (int i = 0; i < numOfLecturers; i++) {
//            if (!allLecturers[i].equals(lecturer)) {
//                allLecturers[j++] = allLecturers[i];
//            }
//        }
//        numOfLecturers = j;
//    }
//
//    public void removeDepartment(Department department) {
//        int j = 0;
//        for (int i = 0; i < numOfDepartments; i++) {
//            if (!allDepartments[i].equals(department)) {
//                allDepartments[j++] = allDepartments[i];
//            }
//        }
//        numOfDepartments = j;
//    }
//
//    public void removeCommittee(Committee committee) {
//        int j = 0;
//        for (int i = 0; i < numOfCommittees; i++) {
//            if (!allCommittees[i].equals(committee)) {
//                allCommittees[j++] = allCommittees[i];
//            }
//        }
//        numOfCommittees = j;
//    }
//
//    public void showAllLecturers() {
//        System.out.print("[ ");
//        for (int i = 0; i < numOfLecturers; i++) {
//            System.out.print(allLecturers[i].getName());
//            if (i != numOfLecturers - 1) {
//                System.out.print(", ");
//            }
//        }
//        System.out.println(" ]");
//    }
//
//    public void showAllDepartments() {
//        System.out.print("[ ");
//        for (int i = 0; i < numOfDepartments; i++) {
//            System.out.print(allDepartments[i].getName());
//            if (i != numOfDepartments - 1) {
//                System.out.print(", ");
//            }
//        }
//        System.out.println(" ]");
//    }
//
//    public void showAllCommittees() {
//        System.out.print("[ ");
//        for (int i = 0; i < numOfCommittees; i++) {
//            System.out.print(allCommittees[i].getName());
//            if (i != numOfCommittees - 1) {
//                System.out.print(", ");
//            }
//        }
//        System.out.println(" ]");
//    }

    @Override
    public String toString() {
        return "College Name: " + name + "\n" +
                "Number of Lecturers: " + numOfLecturers + "\n" +
                "Number of Departments: " + numOfDepartments + "\n" +
                "Number of Committees: " + numOfCommittees;
    }

    public Lecturer[] getAllLecturers() {
        return allLecturers;
    }

    public Department[] getAllDepartments() {
        return allDepartments;
    }

    public Committee[] getAllCommittees() {
        return allCommittees;
    }

    public int getNumOfLecturers() {
        return numOfLecturers;
    }

//    public int getNumOfDepartments() {
//        return numOfDepartments;
//    }

    public int getNumOfCommittees() {
        return numOfCommittees;
    }
}