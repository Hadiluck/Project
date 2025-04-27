package amit_barak_hadi_abu_aklin;

import amit_barak_hadi_abu_aklin.college.*;

import java.util.Scanner;

public class Main {
    private static final String[] MENU = {
            "Exit Program",
            "Add Lecturer",
            "Add Committee",
            "Add Department",
            "Add Lecturer to Committee",
            "Change Head of Committee",
            "Remove Lecturer from Committee",
            "Show Average Salary of All Lecturers",
            "Show Average Salary by Department",
            "Show All Lecturers",
            "Show All Committees",
            "Add Lecturer to Department"
    };
    private static Scanner s;
    private static College c1;

    private static void run() {
        System.out.println("Enter college name:");
        String cName = s.nextLine();
        c1 = new College(cName);

        int userChosen;
        do {
            userChosen = showMenu();
            switch (userChosen) {
                case 0 -> System.out.println("Goodbye!");
                case 1 -> addLecturerMain();
                case 2 -> addCommitteeMain();
                case 3 -> addDepartmentMain();
                case 4 -> lecturerToCommittee();
                case 5 -> changeCommitteeHead();
                case 6 -> removeFromCommittee();
                case 7 -> showAvgPayAll();
                case 8 -> showAvgPayDepartment();
                case 9 -> showAllLecturers();
                case 10 -> showAllCommittees();
                case 11 -> lecturerToDepartment();
                default -> System.out.println("Unexpected value, try again.");
            }
        } while (userChosen != 0);
    }

    private static int showMenu() {
        System.out.println("\n====== Menu =======");
        for (int i = 0; i < MENU.length; i++) {
            System.out.println(i + ". " + MENU[i]);
        }
        System.out.print("Please enter your choice: ");
        return s.nextInt();
    }

    private static void addLecturerMain() {
        s.nextLine();
        System.out.println("Enter Lecturer's name: ");
        String name = s.nextLine();
        System.out.println("Enter Lecturer's ID: ");
        String id = s.nextLine();
        System.out.println("Enter Lecturer's Degree (FIRST, SECOND, DOC, PROF): ");
        String degree = s.nextLine().toUpperCase();
        System.out.println("Enter Lecturer's Salary: ");
        double salary = s.nextDouble();
        s.nextLine();
        Lecturer newLecturer = new Lecturer(salary, null, degree, id, name);
        boolean success = c1.addLecturer(newLecturer);
        if (success) {
            System.out.println("Lecturer added successfully!");
        } else {
            System.out.println("Failed to add Lecturer (maybe already exists..?)");
        }
    }

    private static void addCommitteeMain() {
        s.nextLine();
        System.out.println("Enter Committee's name: ");
        String committeeName = s.nextLine();
        System.out.println("Enter Head Lecturer's name: ");
        String headName = s.nextLine();
        Lecturer head = null;
        for (int i = 0; i < c1.getAllLecturers().length; i++) {
            Lecturer l = c1.getAllLecturers()[i];
            if (l != null && l.getName().equals(headName)) {
                head = l;
                break;
            }
        } if (head == null) {
            System.out.println("Head Lecturer not found!");
            return;
        }
        Committee newCommittee = new Committee(committeeName, head);
        boolean success = c1.addCommittee(newCommittee);
        if (success) {
            System.out.println("Committee added successfully!");
        } else {
            System.out.println("Failed to add committee (maybe is already exists..?)");
        }
    }

    private static void addDepartmentMain() {
        s.nextLine();
        System.out.println("Enter Department's name: ");
        String name = s.nextLine();
        System.out.println("Enter number of students: ");
        int num = s.nextInt();
        s.nextLine();
        Department newDepartment = new Department(name, num);
        boolean success = c1.addDepartment(newDepartment);
        if (success) {
            System.out.println("Department added successfully!");
        } else {
            System.out.println("Failed to add Department (maybe already exists..?)");
        }
    }

    private static void lecturerToCommittee() {
        s.nextLine();
        System.out.println("Enter Lecturer's name: ");
        String nameL = s.nextLine();
        System.out.println("Enter Committee's name: ");
        String nameC = s.nextLine();
        Lecturer selectedLecturer = null;
        for (Lecturer l : c1.getAllLecturers()) {
            if (l != null && l.getName().equals(nameL)) {
                selectedLecturer = l;
                break;
            }
        }
        Committee selectedCommittee = null;
        for (Committee c : c1.getAllCommittees()) {
            if (c != null && c.getName().equals(nameC)) {
                selectedCommittee = c;
                break;
            }
        }
        if (selectedLecturer == null) {
            System.out.println("Lecturer not found!");
            return;
        }

        if (selectedCommittee == null) {
            System.out.println("Committee not found!");
            return;
        }
        selectedCommittee.addLecturerToCommittee(selectedLecturer);
        System.out.println("Lecturer added to committee successfully!");
    }

    private static void changeCommitteeHead() {
        s.nextLine();
        System.out.println("Enter Committee's name: ");
        String committeeName = s.nextLine();
        System.out.println("Enter new Head Lecturer's name: ");
        String lecturerName = s.nextLine();

        Committee selectedCommittee = null;
        for (Committee c : c1.getAllCommittees()) {
            if (c != null && c.getName().equals(committeeName)) {
                selectedCommittee = c;
                break;
            }
        }
        Lecturer selectedLecturer = null;
        for (Lecturer l : c1.getAllLecturers()) {
            if (l != null && l.getName().equals(lecturerName)) {
                selectedLecturer = l;
                break;
            }
        }
        if (selectedCommittee == null) {
            System.out.println("Committee not found!");
            return;
        }
        if (selectedLecturer == null) {
            System.out.println("Lecturer not found!");
            return;
        }
        boolean success = selectedCommittee.setHeadOf(selectedLecturer);
        if (success) {
            System.out.println("Head of committee updated successfully!");
        } else {
            System.out.println("Failed to update the head, lecturer must be DOC or PROF!!");
        }
    }

    private static void removeFromCommittee() {
        s.nextLine();
        System.out.println("Enter Lecturer's name: ");
        String lecturerName = s.nextLine();
        System.out.println("Enter Committee's name: ");
        String committeeName = s.nextLine();
        Lecturer selectedLecturer = null;
        for (Lecturer l : c1.getAllLecturers()) {
            if (l != null && l.getName().equals(lecturerName)) {
                selectedLecturer = l;
                break;
            }
        }
        Committee selectedCommittee = null;
        for (Committee c : c1.getAllCommittees()) {
            if (c != null && c.getName().equals(committeeName)) {
                selectedCommittee = c;
                break;
            }
        }
        if (selectedLecturer == null) {
            System.out.println("Lecturer not found!");
            return;
        }
        if (selectedCommittee == null) {
            System.out.println("Committee not found!");
            return;
        }
        selectedCommittee.removeLecturerFromCommittee(selectedLecturer);
        System.out.println("Lecturer removed from committee successfully!");
    }

    private static void showAvgPayAll() {
        double totalSalary = 0;
        int lecturerCount = 0;
        for (Lecturer l : c1.getAllLecturers()) {
            if (l != null) {
                totalSalary += l.getSalary();
                lecturerCount++;
            }
        }
        if (lecturerCount == 0) {
            System.out.println("No lecturers available to calculate average salary.");
        } else {
            double average = totalSalary / lecturerCount;
            System.out.println("Average Salary of All Lecturers: " + average);
        }
    }

    private static void showAvgPayDepartment() {
        s.nextLine();
        System.out.println("Enter Department's name: ");
        String departmentName = s.nextLine();
        Department selectedDepartment = null;
        for (Department d : c1.getAllDepartments()) {
            if (d != null && d.getName().equals(departmentName)) {
                selectedDepartment = d;
                break;
            }
        }
        if (selectedDepartment == null) {
            System.out.println("Department not found!");
            return;
        }
        double totalSalary = 0;
        int lecturerCount = 0;
        for (Lecturer l : selectedDepartment.getLecturers()) {
            if (l != null) {
                totalSalary += l.getSalary();
                lecturerCount++;
            }
        }
        if (lecturerCount == 0) {
            System.out.println("No lecturers available in this department.");
        } else {
            double average = totalSalary / lecturerCount;
            System.out.println("Average Salary in Department \"" + departmentName + "\": " + average);
        }
    }

    private static void showAllLecturers() {
        if (c1.getNumOfLecturers() == 0) {
            System.out.println("No lecturers available.");
            return;
        }

        System.out.println("List of all lecturers:");
        for (int i = 0; i < c1.getNumOfLecturers(); i++) {
            Lecturer l = c1.getAllLecturers()[i];
            if (l != null) {
                System.out.println("- " + l.getName());
            }
        }
    }

    private static void showAllCommittees() {
        if (c1.getNumOfCommittees() == 0) {
            System.out.println("No committees available.");
            return;
        }

        System.out.println("List of all committees:");
        for (int i = 0; i < c1.getNumOfCommittees(); i++) {
            Committee c = c1.getAllCommittees()[i];
            if (c != null) {
                System.out.println("- " + c.getName());
            }
        }
    }

    private static void lecturerToDepartment() {
        s.nextLine();
        System.out.println("Enter Lecturer's name: ");
        String lecturerName = s.nextLine();
        System.out.println("Enter Department's name: ");
        String departmentName = s.nextLine();
        Lecturer selectedLecturer = null;
        for (Lecturer l : c1.getAllLecturers()) {
            if (l != null && l.getName().equals(lecturerName)) {
                selectedLecturer = l;
                break;
            }
        }
        Department selectedDepartment = null;
        for (Department d : c1.getAllDepartments()) {
            if (d != null && d.getName().equals(departmentName)) {
                selectedDepartment = d;
                break;
            }
        }
        if (selectedLecturer == null) {
            System.out.println("Lecturer not found!");
            return;
        }
        if (selectedDepartment == null) {
            System.out.println("Department not found!");
            return;
        }
        boolean success = selectedDepartment.addLecturerToDepartment(selectedLecturer);
        if (success) {
            System.out.println("Lecturer assigned to department successfully!");
        } else {
            System.out.println("Failed to assign lecturer to department (maybe already assigned?).");
        }
    }

    public static void main(String[] args) {
        s = new Scanner(System.in);
        run();
        s.close();
    }
}