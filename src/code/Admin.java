package code;


public class Admin extends Person {

    public Admin() {

    }

    public Admin(String user, String pass, int id, String fname, String lname, int age) {
        super(user, pass, id, fname, lname, age);
    }

    public void addNewStudent(String user, String pass, int id, String fname, String lname, int age, int level) {
        Student x = new Student(user, pass, id, fname, lname, age, level);
        if (x.addStudent()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public String displayStudents() {
        Student x = new Student();
        return x.displayAllStudents();
    }

    public Student searchForStudent(int id) {
        Student x = new Student();
        return x.searchStudent(id);
    }

    public void updateStudent(int oldID, Student newStudentValues) {
        Student x = new Student();
        if (x.updateStudent(oldID, newStudentValues)) {
            System.out.println(newStudentValues.toString() + "Updated Successfully ... !");
        } else {
            System.out.println("Failed to Updated ... !");
        }
    }

    public void deleteStudent(int Id) {
        Student x = new Student();
        if (x.deleteStudent(Id)) {
           System.out.println("Student: "+ Id + " Deleted Successfully ... !");
        } else {
            System.out.println("Failed to Deleted ... !");
        }
    }

  
    public void addNewInstructor(String user, String pass, int id, String fname, String lname, int age) {
        Instructor x = new Instructor(user, pass, id, fname, lname, age);
        if (x.addInstructor()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } else {
            System.out.println("Failed to insert ... !");
        }
    }

    public String displayInstructors() {
        Instructor x = new Instructor();
        return  x.displayAllInstructors();
    }

    public Instructor searchForInstructor(int id) {
        Instructor x = new Instructor();
        return x.searchInstructor(id);
    }

    public void updateInstructor(int oldID, Instructor newTAValues) {
        Instructor x = new Instructor();
        if (x.updateInstructor(oldID, newTAValues)) {
            System.out.println(newTAValues.toString() + "Updated Successfully ... !");
        } else {
            System.out.println("Failed to Updated ... !");
        }

    }

    public void deleteInstructor(int Id) {
        Instructor x = new Instructor();
        if (x.deleteInstructor(Id)) {
            System.out.println("TA: "+ Id + " Deleted Successfully ... !");
        } else {
            System.out.println("Failed to Deleted ... !");
        }
    }

    public void addNewCourse(String Cname, int CId,String room, String branch, double priceOfCourse, 
            String startdate, int days, String enddate, String statusOfCourse , String InstructorOfCourse, 
            String parentCourse, double priceOfParentCourse, int courseGrade, int numberOfStudents) {
        
        
        Course x = new Course(Cname, CId, room ,branch, priceOfCourse, startdate, days, enddate, 
                statusOfCourse , InstructorOfCourse, parentCourse, priceOfParentCourse, courseGrade, 
                numberOfStudents);
        
        if (x.addCourse()) {
            System.out.println(x.toString() + "Added Successfully ... !");
        } 
        else{
            System.out.println("Failed to insert ... !");
        }
    }

    public String displayCourses() {
        Course x = new Course();
        return x.displayAllCourses();
    }

    public Course searchForCourse(int id) {
        Course x = new Course();
        return x.searchCourse(id);
    }

    public void updateCourse(int oldID, Course newCourseValues) {
        Course x = new Course();
        if (x.updateCourse(oldID, newCourseValues)) {
            System.out.println(newCourseValues.toString() + "Updated Successfully ... !");
        } else {
            System.out.println("Failed to Updated ... !");
        }

    }

    public void deleteCourse(int Id) {
        Course x = new Course();
        if (x.deleteCourse(Id)) {
            System.out.println("Course: "+ Id + " Deleted Successfully ... !");
        } else {
            System.out.println("Failed to Deleted ... !");
        }
    }

    @Override
    public String toString() {
        return "I'm Manager : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age +  "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }
    
    
    public String showStudentsSurvey(){
        Student st = new Student();
        return st.showSurvey();
    }
    
    

}
