package student2;
/**
 * Demonstration of  Error handling and class implementation.
 * This class has five catch block, concrete class extending our abstract class undergraduate,that is implementing our interface class.
 *We have 4 methods, 3 are  implementation for the extended undergraduate class and 1 login method.
 */

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Courses extends underGraduate {
     String courses;
     String store[] = new String[21];
     String title[] = new String[21];
     int total;
     int unit[] = new int[21];

    @Override
    public void registercourses() {
               System.out.println("________COURSE REGISTRATION___________ ");
        if (status == true) {
            try {
                System.out.println("ENTER THE TOTAL NUMBER OF COURSES TO REGISTER should exceed 15");

                Scanner sc = new Scanner(System.in);
                total = sc.nextInt();
                int i;
                int allunit = 0;
                for (i = 1; i <= total; i++) {

                    System.out.println(i + " Enter the course code");
                    courses = sc.next().toUpperCase();
                    store[i] = courses;
                    // System.out.println(i+" Enter the tile");

                    title[i] = getInput(i + " Enter the tile").toUpperCase();

                    System.out.println(i + " Enter the UNIT");
                    unit[i] = sc.nextInt();

                }
                for (i = 1; i <= total; i++) {
                    allunit += unit[i];
                }
                dispalyCourses();
                System.out.println("\tTOtal unit:     " + allunit);
            } catch (InputMismatchException e) {
                System.out.println(e + ": Enter an interger value number of array");
            } catch (Exception e) {
                System.out.println(e + ": you have entered more number of courses than required..");
            }

        } else {
            System.out.println("   *REGISTER USER BEFORE COURSES*          \n");
            System.out.println("STATUS : Not yet register, Go back to the MAIN MENU to register:\n");
        }

    }

    @Override
    public void dispalyCourses() {

        System.out.println("________COURSES DISPLAY___________\n ");
        displayStudentinfo();
        System.out.println("""
                           Registered ocurses are:
                           SN | Course code  |    unit    | Course Title""");
        if (status == true) {
            for (int i = 1; i <= total; i++) {

                System.out.println(i + ".   " + store[i] + " \t\t" + unit[i] + "         " + title[i]);

            }

        }

    }
    public void menu(){
         char c = 0;

        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("_________WELCOME TO STUDENT MANAGEMENT SYSTEM____________");
                try {
                   TimeUnit.SECONDS.sleep(1);
                
                System.out.println("_________MAIN MENU____________");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("1. REGISTER A NEW ACCOUNT");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("2. DISPLAY YOUR INFORMATION");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("3. REGISTER FOR COURSES");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("4. DISPLAY COURSES REGISTERED");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("5. TO EXIT");
                 } catch (InterruptedException ex) {
                 System.out.print(ex);
                }
                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        registerStudent();
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        displayStudentinfo();
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        registercourses();
                        break;
                    case 4:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        dispalyCourses();
                        break;

                    case 5:
                        System.exit(0);
                }

                System.out.println("press any key to go back to Menu ,else press 5 to exit");

                c = sc.next().charAt(0);
                
            } catch (InputMismatchException e) {
                System.out.println(e);
            }
        } while (c != '5');

    }

}
