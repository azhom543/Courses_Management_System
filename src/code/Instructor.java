package code;


import java.io.Serializable;
import java.util.ArrayList;


public class Instructor extends Person implements Serializable {

    
    private final String INSTRFileName = "Instructors.bin";

    public static ArrayList<Instructor> instructors = new ArrayList<Instructor>();
    
    
    
    

    public Instructor() {
    }

    public Instructor(String user, String pass, int id, String fname, String lname, int age) {
        super(user, pass, id, fname, lname, age);
    }

    public boolean addInstructor() {
        loadFromFile();
        instructors.add(this);
        return commitToFile();
    }

    public boolean commitToFile() {
        return FManger.write(INSTRFileName, instructors);
    }

    public void loadFromFile() {
        instructors = (ArrayList<Instructor>) FManger.read(INSTRFileName);
    }

    private int getInstructorIndex(int id) {
        for (int i = 0; i < instructors.size(); i++) {
            if (instructors.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

    public String displayAllInstructors() {
        loadFromFile();
        String S = "\n   All Instructors Data:\n";
        for (Instructor x : instructors) {
            S = S + x.toString();
        }
        return S;
    }

    public Instructor searchInstructor(int id) {
        Instructor ins = new Instructor();
        loadFromFile();
        int index = getInstructorIndex(id);
        if (index != -1) {
            System.out.println( "\nFound ...!") ; 
                    return instructors.get(index);
        } else {
            System.out.println("\nNot Found ...!");
            return ins;
        }
    }

    public boolean updateInstructor(int oldID, Instructor x) {
        loadFromFile();
        int index = getInstructorIndex(oldID);

        if (index != -1) {
            instructors.set(index, x);

            return commitToFile();
        }

        return false;
    }

    public boolean deleteInstructor(int id) {
        loadFromFile();
        int index = getInstructorIndex(id);

        if (index != -1) {
            instructors.remove(index);
            return commitToFile();
        }

        return false;
    }
    
    
    
    public boolean addGradeToStudent(int studentID,  int courseID, double grade){
        Student x = new Student();
        return  x.addGrade(studentID, courseID, grade);
    }
    
    public boolean publishToStudents(String pub){
        Student  x = new Student();
        return x.publish(pub);
    }
    
    
    
    @Override
    public String toString() {
        return "\n   Instructor Name : " + fname + " " + lname + "\n" + "   ID : " + id + "\n" + "   Age : " + age + "\n"  + "   UserName: " + userName +"\n" +"   Password: " + pass + "\n"
                + "--------------------------------------------------";
    }
    
    
    
    
    
    
    
}
