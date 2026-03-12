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
        System.out.println("");
        for (int i = 1; i <= amount; i++) {
            Student student = new Student();
            System.out.print("ID: ");
            sc.nextLine();
            id = sc.nextLine();
            student.setId(id);
            System.out.print("Name student " + i + ": ");
            name = sc.nextLine();
            student.setName(name);
            System.out.print("Mark: ");
            mark = sc.nextFloat();
            student.setMarks(mark);
            list.add(student);
        }
        System.out.println("Add student success!!!");
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
        System.out.println("\t\t\t\t\t| 6. Sort student by mark. (Bubble Sort)                          |");
        System.out.println("\t\t\t\t\t| 7. Sort student by mark. (Insertion Sort)                       |");
        System.out.println("\t\t\t\t\t| 8. Sort student by mark. (Quick Sort)                           |");
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
                    System.out.println(" ");
                }
            }
        }
    }





    public static void main(String[] args) {
        Main menu = new Main();
    }
}