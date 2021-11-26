package code;


import java.io.Serializable;
import java.util.ArrayList;


public class Course implements Serializable {

    private String CName;
    private int CId;
    private String room;
    private String branch;
    private String startdate;
    private int days;
    private String enddate;
    private String statusOfCoruse;
    private double priceOfCourse;
    private String InstructorOfCourse;
    private String parentCourse;
    private double priceOfParentCourse;
    private int courseGrade;
    private int numberOfStudents;
 
    FileMangerBinary FManger = new FileMangerBinary();
    private final String CourseFileName = "Courses.bin";


    public static ArrayList<Course> Courses = new ArrayList<Course>();

    public Course() {
    }
   
    public Course(String Cname, int CId,String room, String branch, double priceOfCourse, 
            String startdate, int days, String enddate, String statusOfCourse , String InstructorOfCourse, 
            String parentCourse, double priceOfParentCourse, int courseGrade, int numberOfStudents) {
        
        this.CName = Cname;
        this.CId = CId;
        this.room = room;
        this.branch = branch;
        this.priceOfCourse = priceOfCourse;
        this.startdate = startdate;
        this.days = days;
        this.enddate = enddate;
        this.statusOfCoruse = statusOfCourse;
        this.InstructorOfCourse = InstructorOfCourse;
        this.parentCourse = parentCourse;
        this.priceOfParentCourse = priceOfParentCourse;
        this.courseGrade = courseGrade;
        this.numberOfStudents = numberOfStudents;
    }
    
    
    //getters and setters 
    
    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public int getCId() {
        return CId;
    }

    public void setCId(int CId) {
        this.CId = CId;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public String getEnddate() {
        return enddate;
    }

    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
    
    public String getStatusOfCoruse() {
        return statusOfCoruse;
    }

    public void setStatusOfCoruse(String statusOfCoruse) {
        this.statusOfCoruse = statusOfCoruse;
    }
    
    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getPriceOfCourse() {
        return priceOfCourse;
    }

    public void setPriceOfCourse(double priceOfCourse) {
        this.priceOfCourse = priceOfCourse;
    }

    public String getInstructorOfCourse() {
        return InstructorOfCourse;
    }

    public void setInstructorOfCourse(String InstructorOfCourse) {
        this.InstructorOfCourse = InstructorOfCourse;
    }

    public String getParentCourse() {
        return parentCourse;
    }

    public void setParentCourse(String parentCourse) {
        this.parentCourse = parentCourse;
    }

    public double getPriceOfParentCourse() {
        return priceOfParentCourse;
    }

    public void setPriceOfParentCourse(double priceOfParentCourse) {
        this.priceOfParentCourse = priceOfParentCourse;
    }

    public int getCourseGrade() {
        return courseGrade;
    }

    public void setCourseGrade(int courseGrade) {
        this.courseGrade = courseGrade;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public FileMangerBinary getFManger() {
        return FManger;
    }

    public void setFManger(FileMangerBinary FManger) {
        this.FManger = FManger;
    }

    public static ArrayList<Course> getCourses() {
        return Courses;
    }

    public static void setCourses(ArrayList<Course> Courses) {
        Course.Courses = Courses;
    }
    
    
    public boolean addCourse() {
        loadFromFile();
        Courses.add(this);
        return commitToFile();
    }
    

    // end of setters and getters
    
    
    public boolean commitToFile() {
        return FManger.write(CourseFileName, Courses);
    }
    

    public void loadFromFile() {
        Courses = (ArrayList<Course>) FManger.read(CourseFileName);
    }
    

    private int getCourseIndex(int id) {
        for (int i = 0; i < Courses.size(); i++) {
            if (Courses.get(i).getCId() == id) {
                return i;
            }
        }
        return -1;
    }
   
    
    public String displayAllCourses() {
        loadFromFile();
        String S = "\nAll Courses Data:\n";
        for (Course x : Courses) {
            S = S + x.toString();
        }
        return S;
    }

    public Course searchCourse(int id) {
        Course c = new Course();
        
        loadFromFile();
        int index = getCourseIndex(id);
        if (index != -1) {
            System.out.println("\nFound ...!"); 
            return Courses.get(index);
        } 
        else
        {
            System.out.println("\nNot Found ...!");
            return c;
        }
    }

    
    public boolean updateCourse(int oldID, Course x) {
        loadFromFile();
        int index = getCourseIndex(oldID);

        if (index != -1) {
            Courses.set(index, x);

            return commitToFile();
        }

        return false;
    }

    
    public boolean deleteCourse(int id) {
        loadFromFile();
        int index = getCourseIndex(id);

        if (index != -1) {
            Courses.remove(index);

            return commitToFile();
        }

        return false;
    }

    
    @Override
    public String toString() {
        return "\n   Course Name : " + CName + "\n" + "   Course ID : " + CId + "\n" + "   Course room : "
                + room + "\n   Course branch :" + "\n   Course price : " + priceOfCourse + " $" + 
                "\n   Startdate of this course : " + startdate + "\n   Days number : " + days + 
                "\n   Enddate of this course : " + enddate + "\n   Status Of Course: "+ statusOfCoruse + 
                "\n   Instructor Name : " + InstructorOfCourse +"\n   Parent Course :" + parentCourse+ 
                "\n   Price Of Parent Course" + " $"+priceOfParentCourse + "\n   Grade Of Course :" + courseGrade + 
                "\n   Number Of Students: " + numberOfStudents +"\n----------------------------------------------";                                                               
    }
}









