package code;



import java.io.File;
import java.util.Scanner;


public class Main {

    
    public static void main(String[] args) {
        
        String projectPath = System.getProperty("user.dir");
        System.out.println("Project Path: " + projectPath);
        File currentDir = new File(projectPath); // current directory				
	checkDirectoryContents(currentDir);
        
        Scanner input = new Scanner(System.in);

        Admin admin = new Admin("Admin@yahoo.com", "12345678", 1, "admin", "admin", 35);
        
        int ch = 1;
        String userName, Pass, Fname, Lname,Cname,room,branch,startdate,enddate, oldCID;
        double price;
        int id, oldID, age, level, maxGrade,days, Cid;
 
        System.out.print("\n\nWelecome Admin ... !\n\nUser Name : ");
        userName = input.next();
        System.out.print("Password  : ");
        Pass = input.next();
        int viewSelector = Person.login(userName, Pass);
        
        if (viewSelector == 1) {

            while (ch != 0) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("\n\t ________________________________\n\t"
                        + "| Enter 1: Add New Student.         |\n\t| Enter 2: Add New TA.          |\n\t| Enter 3: Add New Course.      |"
                        + "\n\t| Enter 4: Display All Students.|\n\t| Enter 5: Display All Teachers.|\n\t| Enter 6: Display Course.     |"
                        + "\n\t| Enter 7: Search Student.     |\n\t| Enter 8: Search TA.          |\n\t| Enter 9: Search Course.      |"
                        + "\n\t| Enter 10: Update Student.     |\n\t| Enter 11: Update TA.          |\n\t| Enter 12: Update Course.      |"
                        + "\n\t| Enter 13: Delete Student.     |\n\t| Enter 14: Delete TA.          |\n\t| Enter 15: Delete Course.      |"
                        + "\n\t -------------------------------\n\t");
                ch = input.nextInt();

                switch (ch) {
                    case 1:
                        System.out.println("Enter Student Info ... ");
                        System.out.print("Student First Name : ");
                        Fname = input.next();
                        System.out.print("Student Last Name : ");
                        Lname = input.next();
                        System.out.print("Student ID : ");
                        id = input.nextInt();
                        System.out.print("Student Age : ");
                        age = input.nextInt();
                        System.out.print("Student Level : ");
                        level = input.nextInt();
                        System.out.print("Username : ");
                        userName = input.next();
                        System.out.print("Password : ");
                        Pass = input.next();
                        admin.addNewStudent(userName, Pass, id, Fname, Lname, age, level);
                        break;
                    case 2:
                        System.out.println("Enter Instructor Info ... ");
                        System.out.print("Instructor First Name : ");
                        Fname = input.next();
                        System.out.print("Instructor Last Name : ");
                        Lname = input.next();
                        System.out.print("Instructor ID : ");
                        id = input.nextInt();
                        System.out.print("Instructor Age : ");
                        age = input.nextInt();
                        System.out.print("Username : ");
                        userName = input.next();
                        System.out.print("Password : ");
                        Pass = input.next();
                        admin.addNewInstructor(userName, Pass, id, Fname, Lname, age);
                        break;
                    case 3:
                        System.out.println("Enter Course Info ... ");
                        System.out.print("Course Name : ");
                        Cname = input.next();
                        System.out.print("Course Code : ");
                        Cid = input.nextInt();
                        System.out.print("Course Room Char : ");
                        room = input.next();
                        System.out.print("Course branch : ");
                        branch = input.next();
                        System.out.print("Course Price : ");
                        price = input.nextDouble();
                        System.out.print("Course Startdate : ");
                        startdate = input.next();
                        System.out.print("Number Course Days : ");
                        days = input.nextInt();
                        System.out.print("Course Enddate : ");
                        enddate = input.next();
////                    admin.addNewCourse(Cname, Cid,room,branch,price,startdate,days,enddate);
                        break;
                    case 4:
                        admin.displayStudents();
                        break;
                    case 5:
                        admin.displayInstructors();
                        break;
                    case 6:
                        admin.displayCourses();
                        break;
                    case 7:
                        System.out.print("\nSearch for Student ...!\nEnter Student ID : ");
                        id = input.nextInt();
                        admin.searchForStudent(id);
                        break;
                    case 8:
                        System.out.print("\nSearch for TA ...!\nEnter TA ID : ");
                        id = input.nextInt();
                        admin.searchForInstructor(id);
                        break;
                    case 9:
                        System.out.print("\nSearch for Course ...!\nEnter Course ID : ");
                        Cid = input.nextInt();
                        admin.searchForCourse(Cid);
                        break;
                    case 10:
                        System.out.print("\nUpdate Student info ...!\nEnter Student OldID : ");
                        oldID = input.nextInt();
                        System.out.println("\nEnter Student New Info ... ");
                        System.out.print("Student First Name : ");
                        Fname = input.next();
                        System.out.print("Student Last Name : ");
                        Lname = input.next();
                        System.out.print("Student ID : ");
                        id = input.nextInt();
                        System.out.print("Student Age : ");
                        age = input.nextInt();
                        System.out.print("Student Level : ");
                        level = input.nextInt();
                        System.out.print("Username : ");
                        userName = input.next();
                        System.out.print("Password : ");
                        Pass = input.next();
                        Student x = new Student(userName, Pass, id, Fname, Lname, age, level);
                        admin.updateStudent(oldID, x);
                        break;
                    case 11:
                        System.out.print("\nUpdate Instructor info ...!\nEnter TA OldID : ");
                        oldID = input.nextInt();
                        System.out.println("Enter Teaching Assistant Info ... ");
                        System.out.print("TA First Name : ");
                        Fname = input.next();
                        System.out.print("TA Last Name : ");
                        Lname = input.next();
                        System.out.print("TA ID : ");
                        id = input.nextInt();
                        System.out.print("TA Age : ");
                        age = input.nextInt();
                        System.out.print("Username : ");
                        userName = input.next();
                        System.out.print("Password : ");
                        Pass = input.next();
                        Instructor z = new Instructor(userName, Pass, id, Fname, Lname, age);
                        admin.updateInstructor(oldID, z);
                        break;
                    case 12:
                        System.out.print("\nUpdate Course info ...!\nEnter Course OldID : ");
                        oldCID = input.next();
                        System.out.println("Enter Course Info ... ");
                        System.out.print("Course Name : ");
                        Cname = input.next();
                        System.out.print("Course Code : ");
                        Cid = input.nextInt();
                        System.out.print("Course Room Char : ");
                        room = input.next();
                        System.out.print("Course branch : ");
                        branch = input.next();
                        System.out.print("Course Price : ");
                        price = input.nextDouble();
                        System.out.print("Course Startdate : ");
                        startdate = input.next();
                        System.out.print("Number Course Days : ");
                        days = input.nextInt();
                        System.out.print("Course Enddate : ");
                        enddate = input.next();
////                    Course c = new Course(Cname, Cid,room,branch,price,startdate,days,enddate);
////                    admin.updateCourse(oldCID, c);
                        break;
                    case 13:
                        System.out.print("\nDelete Student info ...!\nEnter Student ID : ");
                        id = input.nextInt();
                        admin.deleteStudent(id);
                        break;
                    case 14:
                        System.out.print("\nDelete Instructor info ...!\nEnter TA ID : ");
                        id = input.nextInt();
                        admin.deleteInstructor(id);
                        break;                   
                    case 15:
                        System.out.print("\nDelete Course info ...!\nEnter Course ID : ");
                        Cid = input.nextInt();
                        admin.deleteCourse(Cid);
                        break;
                    default:
                        System.out.println("Enter vaild Option :(");
                }
            }
        }
    }

    public static void checkDirectoryContents(File dir){
        File[] files = dir.listFiles();
        boolean studentFile = true;
        boolean InstructorFile = true;
        boolean courseFile = true;

        for (File file : files) {

            if (file.getName().contains("Students.bin")) {
                studentFile = false;
            } else if (file.getName().contains("Instructors.bin")) {
                InstructorFile = false;
            } else if (file.getName().contains("Courses.bin")) {
                courseFile = false;
            }
            
        }
        
        if (studentFile) {
            Student x = new Student();
            x.commitToFile();
        } 
        
        
        if (InstructorFile) {
            Instructor x = new Instructor();
            x.commitToFile();
        } 
        
        
        if (courseFile) {
            Course x = new Course();
            x.commitToFile();
        }
    }

}

