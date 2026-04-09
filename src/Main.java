import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    private List<Student> list = new ArrayList<>();
    private String id;
    private String name;
    private float mark;

    public void create() {
        System.out.print("Number of students you want to enter: ");
        int amount = sc.nextInt();
        sc.nextLine();

        System.out.println("");

        for (int i = 1; i <= amount; i++) {
            Student student = new Student();

            while (true) {
                System.out.print("ID: ");
                id = sc.nextLine();

                if (id.trim().isEmpty()) {
                    System.out.println("ID cannot be empty. Enter again.");
                } else if (isDuplicateId(id)) {
                    System.out.println("ID already exists. Enter another ID.");
                } else {
                    student.setId(id);
                    break;
                }
            }

            while (true) {
                System.out.print("Name student " + i + ": ");
                name = sc.nextLine();

                if (!isValidName(name)) {
                    System.out.println("Invalid name. Name must contain letters only.");
                } else {
                    student.setName(name);
                    break;
                }
            }

            while (true) {
                System.out.print("Mark: ");
                String input = sc.nextLine();

                if (input.trim().isEmpty()) {
                    System.out.println("Mark cannot be empty.");
                    continue;
                }

                try {
                    mark = Float.parseFloat(input);

                    if (mark >= 0 && mark <= 10) {
                        student.setMarks(mark);
                        break;
                    } else {
                        System.out.println("Invalid mark! Enter again (0-10).");
                    }

                } catch (Exception e) {
                    System.out.println("Invalid input! Enter a number.");
                }
            }
            list.add(student);
        }

        System.out.println("Add student success!!!");
    }

    //    Improve function
    public boolean isDuplicateId(String id) {
        for (Student st : list) {
            if (st.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    public void deleteStudentById() {
        System.out.print("Enter student ID to delete: ");
        sc.nextLine();
        String deleteId = sc.nextLine().trim();

        if (deleteId.isEmpty()) {
            System.out.println("ID cannot be empty.");
            return;
        }
        boolean found = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equalsIgnoreCase(deleteId)) {
                list.remove(i);
                found = true;
                System.out.println("Delete student success!!!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void updateStudentById() {
        System.out.print("Enter student ID to update: ");
        sc.nextLine();
        String updateId = sc.nextLine().trim();

        if (updateId.isEmpty()) {
            System.out.println("ID cannot be empty.");
            return;
        }

        boolean found = false;

        for (Student st : list) {
            if (st.getId().equalsIgnoreCase(updateId)) {
                found = true;

                System.out.println("Student found. Enter new information:");

                System.out.print("New name: ");
                String newName = sc.nextLine();
                st.setName(newName);

                System.out.print("New mark: ");
                float newMark = sc.nextFloat();
                st.setMarks(newMark);

                list.sort((a, b) -> a.getId().compareToIgnoreCase(b.getId()));

                System.out.println("Update student success!!!");
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void print(Student st) {
        System.out.println("Student id: " + st.getId());
        System.out.println("Student name: " + st.getName());
        System.out.println("Student mark: " + st.getMarks());
        System.out.println("Student academic ability: " + st.getAcademicAbility());
        System.out.println("");
    }

    public void printOut() {
        System.out.println("List student: ");
        for (Student st: list) {
            print(st);
        }
    }
    public void listMenu() {
        System.out.println("\t\t\t\t\t|------------------------------Menu-------------------------------|");
        System.out.println("\t\t\t\t\t| 1. Enter a list of students                                     |");
        System.out.println("\t\t\t\t\t| 2. Print out list of students                                   |");
        System.out.println("\t\t\t\t\t| 3. Find student by ID entered from the keyboard. (Linear Search)|");
        System.out.println("\t\t\t\t\t| 4. Find student by ID entered from the keyboard. (Binary Search)|");
        System.out.println("\t\t\t\t\t| 5. Delete student by ID                                         |");
        System.out.println("\t\t\t\t\t| 6. Update student by ID                                         |");
        System.out.println("\t\t\t\t\t| 7. Sort student by mark. (Bubble Sort)                          |");
        System.out.println("\t\t\t\t\t| 8. Sort student by mark. (Insertion Sort)                       |");
        System.out.println("\t\t\t\t\t| 9. Sort student by mark. (Quick Sort)                           |");
        System.out.println("\t\t\t\t\t| 10. Sort student by mark. (Merge Sort)                          |");
        System.out.println("\t\t\t\t\t| 11. Sort student by mark. (Heap Sort)                           |");
        System.out.println("\t\t\t\t\t| 12. Filter students by academic ability                         |");
        System.out.println("\t\t\t\t\t| 0. Exit                                                         |");
        System.out.println("\t\t\t\t\t|-----------------------------------------------------------------|");
    }

    public boolean repeatFunction() {
         do {
           int option = 0;
             System.out.print("Press 1 to continue with function or 0 to Menu: ");
             option = sc.nextInt();
             if (option == 0) {
                 menu();
             }
             if (option == 1) {
                 return true;
             }
        } while (true);
    }


    public void menu() {
        int option = 0;
        int function;
        do {
            listMenu();
            try {
                do {
                    System.out.println("Enter the program you want to choose ");
                    function = sc.nextInt();
                    System.out.println("");
                    switch (function) {
                        case 1:
                            do {
                                create();
                            }while (repeatFunction());
                            break;
                        case 2:
                            do {
                                printOut();
                            }while (repeatFunction());
                            break;
                        case 3:
                            do {
                                linearSearchById();
                            } while (repeatFunction());
                            break;
                        case 4:
                            do {
                                binarySearchById();
                            } while (repeatFunction());
                            break;
                        case 5:
                            do {
                                deleteStudentById();
                            } while (repeatFunction());
                            break;
                        case 6:
                            do {
                                updateStudentById();
                            } while (repeatFunction());
                            break;
                        case 7:
                            do {
                               sortMarkBubble();
                            } while (repeatFunction());
                            break;
                        case 8:
                            do {
                                sortMarkInsertionSort();
                            }while (repeatFunction());
                            break;
                        case 9:
                            do {
                                sortMarkQuickSort();
                            }while (repeatFunction());
                            break;
                        case 10:
                            do {
                                sortMarkMergeSort();
                            } while (repeatFunction());
                            break;
                        case 11:
                            do {
                                sortMarkHeapSort();
                            } while (repeatFunction());
                            break;
                        case 12:
                            do {
                                filterStudentsByAcademicAbility();
                            } while (repeatFunction());
                            break;
                        case 0:
                            System.out.println("Exited");
                            System.exit(0);
                        default:
                            System.out.println("    !!Wrong option!! ");
                    }
                }while (true);
            }catch (Exception ex) {
                System.out.println("Invalid input! Please enter a number.");
                sc.nextLine();
//                System.out.println(" ");
//                System.out.println(ex.getMessage());
            }
        }while (option == 1 || option > 2);
    }

    public void sortMarkBubble() {
        while (true) {
            System.out.print("Ascending (1) or Descending (2): ");
            int chose = sc.nextInt();
            if (chose == 1 || chose == 2){
                Sort.bubbleSort(list, chose);
                break;
            }
        }
        System.out.println("List student after Sort: ");
        printOut();
    }
    public void sortMarkInsertionSort() {
        while (true) {
            System.out.print("Ascending (1) or Descending (2): ");
            int chose = sc.nextInt();
            if (chose == 1 || chose == 2){
                Sort.insertionSort(list, chose);
                break;
            }
        }
        System.out.println("List student after Sort: ");
        printOut();
    }
    public void sortMarkQuickSort() {
        while (true) {
            System.out.print("Ascending (1) or Descending (2): ");
            int chose = sc.nextInt();
            if (chose == 1 || chose == 2){
                Sort.quickSort(list, chose);
                break;
            }
        }
        System.out.println("List student after Sort: ");
        printOut();
    }
    public void sortMarkMergeSort() {
        while (true) {
            System.out.print("Ascending (1) or Descending (2): ");
            int chose = sc.nextInt();
            if (chose == 1 || chose == 2){
                Sort.mergeSort(list, chose);
                break;
            }
        }
        System.out.println("List student after Sort: ");
        printOut();
    }

    public void sortMarkHeapSort() {
        while (true) {
            System.out.print("Ascending (1) or Descending (2): ");
            int chose = sc.nextInt();
            if (chose == 1 || chose == 2) {
                Sort.heapSort(list, chose);
                break;
            }
        }
        System.out.println("List student after Sort: ");
        printOut();
    }

    public void linearSearchById() {
        System.out.print("Enter student ID to search: ");
        sc.nextLine();
        String searchId = sc.nextLine().trim();

        boolean found = false;

        for (Student st : list) {
            if (st.getId().equalsIgnoreCase(searchId)) {
                System.out.println("Student found:");
                print(st);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public void binarySearchById() {
        System.out.print("Enter student ID to search: ");
        sc.nextLine();
        String searchId = sc.nextLine().trim();

        if (searchId.isEmpty()) {
            System.out.println("ID cannot be empty.");
            return;
        }

        list.sort((a, b) -> a.getId().compareToIgnoreCase(b.getId()));

        int low = 0;
        int high = list.size() - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            Student midStudent = list.get(mid);
            int compare = midStudent.getId().compareToIgnoreCase(searchId);

            if (compare == 0) {
                System.out.println("Student found:");
                print(midStudent);
                found = true;
                break;
            } else if (compare > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
// Bonus new function
public void filterStudentsByAcademicAbility() {
    if (list.isEmpty()) {
        System.out.println("List is empty.");
        return;
    }

    while (true) {
        System.out.println("Choose academic ability to filter:");
        System.out.println("1. Weak");
        System.out.println("2. Medium");
        System.out.println("3. Good");
        System.out.println("4. Very Good");
        System.out.println("5. Excellent");
        System.out.print("Your choice: ");

        int choice = sc.nextInt();
        String ability = "";

        switch (choice) {
            case 1: ability = "Weak"; break;
            case 2: ability = "Medium"; break;
            case 3: ability = "Good"; break;
            case 4: ability = "Very Good"; break;
            case 5: ability = "Excellent"; break;
            default:
                System.out.println("Invalid choice.");
                continue;
        }

        List<Student> filteredList = new ArrayList<>();

        for (Student st : list) {
            if (st.getAcademicAbility().equalsIgnoreCase(ability)) {
                filteredList.add(st);
            }
        }

        if (filteredList.isEmpty()) {
            System.out.println("No students found. Choose again.");
            continue;
        }

        int sortChoice;
        while (true) {
            System.out.print("Sort Ascending (1) or Descending (2): ");
            sortChoice = sc.nextInt();

            if (sortChoice == 1 || sortChoice == 2) {
                break;
            } else {
                System.out.println("Invalid sort choice.");
            }
        }

        Sort.quickSort(filteredList, sortChoice);

        System.out.println("Students with academic ability: " + ability);
        for (Student st : filteredList) {
            print(st);
        }

        break;
    }
}

    public static void main(String[] args) {
        Main menu = new Main();
        menu.menu();
    }
}