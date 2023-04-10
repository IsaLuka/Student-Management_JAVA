package classes;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
 * Demonstration of  Error handling and class implementation.
 * This version has five catch block, concrete class extending our abstract class undergraduate,that is implementing our interface class.
 *We have 4 methods, 3 are  implementation for the extended undergraduate class and 1 login method.
 */

public class Courses extends underGraduate {
 
String courses=null;
String store[] = new String[21], title[] = new String[21];
    int total, unit[] = new int[21];
    String Id,pword,Coursereg;
     
     @Override
    public void registercourses() {
               System.out.println("________COURSE REGISTRATION___________ ");
        if(status==true) {
        /**here is our first catch, it handles InputMismatchException andArrayIndexOutOfBoundsException errors.*/
            try(Scanner sc = new Scanner(System.in)) {
                System.out.println("ENTER THE TOTAL NUMBER OF COURSES TO REGISTER should exceed 15");
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
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e + ": you have entered more number of courses than required..");
            }

        } 

    }

   @Override
   public void dispalyCourses() {
       displayStudentinfo();
       System.out.println("\n\n________COURSES DISPLAY___________\n "); 
       if(courses != null){System.out.println("\nRegistered ocurses are:\n"
                + "SN | Course code  |    unit    | Course Title");
            for (int i = 1; i <= total; i++) {

                System.out.println(i + ".   " + store[i] + "            \t\t" + unit[i] + "         " + title[i]);

            }
         }else {
            System.out.println("\n\n   *REGISTER USER BEFORE COURSES*          \n");
            System.out.println("STATUS : Not yet register,\nDo you want to  register: y or n");
            //Second catch block catches InputMismatchException error
            try(Scanner sc=new Scanner(System.in)){
                    Coursereg=sc.next().toLowerCase();
                    }catch(InputMismatchException e){
                      System.out.println(e+"inCorrect selection ");
                    }
            if(Coursereg.equals("y") || Coursereg.equals("yes")){
              registercourses();
            }else{
              login();
            }
        }
   }
   @Override
    public void login(){
    //3rd catch block handles InputMismatchException other error
      try(Scanner sc = new Scanner(System.in)){
        System.out.println("Enter Your id Number");
        Id=sc.next().toUpperCase();
        System.out.println("Enter Your Password");
        pword=sc.next().toUpperCase();
        if(status==false){System.out.println("Id not registered..");}
       if(super.getpassword().equals(pword) && super.getid().equals(Id)){
            dispalyCourses();
        }else{
          System.out.println("The Id or Password You've Entered is Incorrect");}
        } catch(InputMismatchException e){
          System.out.println(e + ": You have an input error");
        } catch(Exception e) {
         //here we don't want to print the error we just catch it
        }
    }
    
   
    @Override 
   public void menu(){
   
    System.out.print("\n\n\n\t\t\tLoading");
                  int i=1;                         
                while(i<4){
                    System.out.print(".");
                    //4th catch block handle InterruptedException for time 
                   try{
                    TimeUnit.MILLISECONDS.sleep(1000);
                    }catch(InterruptedException e){
                      System.out.println(e);
                    }
                     i++;  }
                 System.out.println("\n\n");
                 
        char c = 0;

        do {
        //last catch block also handle InputMismatchException errors
            try(Scanner sc = new Scanner(System.in)) {
                System.out.println("_________WELCOME TO STUDENT MANAGEMENT SYSTEM____________");
                
                System.out.println("\t\t\t\t      _________MAIN MENU____________");
                System.out.println("\t\t\t1. REGISTER A NEW ACCOUNT");
                System.out.println("\t\t\t2. LOG INTO YOUR ACCOUNT");
                System.out.println("\t\t\t3. TO EXIT");

                int ch = sc.nextInt();

                switch (ch) {
                    case 1:
                        registerStudent();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        System.exit(0);
                }

                System.out.println("press any key to go back to Menu ,else press 3 to exit");

                c = sc.next().charAt(0);
                
            } catch (InputMismatchException e) {
                System.out.println(e);
            }
        } while (c != '3');
     }
   }


