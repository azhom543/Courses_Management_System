package code;



import java.io.Serializable;
import java.util.ArrayList;


public class Student extends Person implements Serializable {

    
    private int level;
    private String survey;
    private String publish;
    public int[] studentCourses = new int[10];
    public double [] studentGrades = new double[10];
    
    private final String studentFileName = "Students.bin";

    public static ArrayList<Student> Students = new ArrayList<Student>();

    public Student() {

    }

    public Student(String user, String pass, int id, String fname, String lname, int age, int level) {
        super(user, pass, id, fname, lname, age);
        this.level = level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    public void setSurvey(String survey){
        this.survey = survey;
    }
    
    public void setPublish(String publish){
        this.publish = publish;
    }
    
    
    public int getLevel() {
        return this.level;
    }
    
    public String getSurvey(){
        return survey;
    }
    
    public String getPublish(){
        return publish;
    }
    
    
    public boolean addStudent() {
        loadFromFile();
        Students.add(this);
        return commitToFile();
    }

    public boolean commitToFile() {
        return FManger.write(studentFileName, Students);
    }

    public void loadFromFile() {
        Students = (ArrayList<Student>) FManger.read(studentFileName);
    }

    private int getStudentIndex(int id) {
        for (int i = 0; i < Students.size(); i++) {
            if (Students.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

    public String displayAllStudents() {
        loadFromFile();
        String S = "\n   All Student Data:\n";
        for (Student x : Students) {
            S = S + x.toString();
        }
        return S;
    }

    public Student searchStudent(int id) {
        Student s = new Student();
        loadFromFile();
        int index = getStudentIndex(id);
        if (index != -1) {
            System.out.println("\nFound ...!" + Students.get(index).toString());
            return Students.get(index);
        } else {
            System.out.println( "\nNot Found ...!");
            return s;
        }
    }

    public boolean updateStudent(int oldID, Student x) {
        loadFromFile();
        int index = getStudentIndex(oldID);

        if (index != -1) {
            Students.set(index, x);
            return commitToFile();
        }

        return false;
    }

    public boolean deleteStudent(int id) {
        loadFromFile();
        int index = getStudentIndex(id);

        if (index != -1) {
            Students.remove(index);

            return commitToFile();
        }

        return false;
    }
    
  
   /*public  void TextFromInstracror(String text)
   {
       System.out.print(text);
   }*/
   
    @Override
    public String toString() {
        return "\n   Student Name : " + fname + " " + lname + "\n" + "   ID : " + id + "\n" + "   Age : " + age + "\n"
                + "   Level : " + level + "\n" +"   UserName: " + userName + "\n" + "   Password: " + pass + "\n" + "-------------------------------------------\n";
    }
    
    
   public boolean studentAddCourse(int courseID, int studentID){
       
       loadFromFile();
       int index = getStudentIndex(studentID);
       if (index == -1) return false;
       
       Admin manager = new Admin();
       Course C = manager.searchForCourse(courseID);
       if(C.getCId() != courseID) return false;
       
       for(int i = 0 ; i < 10 ; ++i){
            if( Students.get(index).studentCourses[i] == 0 ){
                 Students.get(index).studentCourses[i] = courseID;
                 Students.get(index).studentGrades[i] = -1;
                 return commitToFile();
            }      
       }   
       return false;
   }
   
   
   public boolean studentDeleteCourse(int courseID, int studentID){
       
       loadFromFile();
       int index = getStudentIndex(studentID);
       if(index == -1) return true;
       
       for(int i = 0 ; i < 10 ; ++i){
           if(Students.get(index).studentCourses[i] == courseID){
               Students.get(index).studentCourses[i] = 0;
               Students.get(index).studentGrades[i] = -1;
               commitToFile();
               return true;
           }
       }
       return true;
   }
    
   public double showStudentGrades(int courseID, int studentID){
               loadFromFile();
               int index = getStudentIndex(studentID);            
               if(index == -1) return index;
       
               for(int i = 0 ; i < 10 ; ++i){
                   if(Students.get(index).studentCourses[i]  == courseID) return Students.get(index).studentGrades[i];
               }
               
               return -1;
   }
   
   
   
   public boolean addGrade(int studentID,  int courseID, double grade)
    {
        
        loadFromFile();
        int index = getStudentIndex(studentID);            
        if(index == -1) return false;
        
       
        for( int i = 0 ; i < 10 ; ++i ){
            if( Students.get(index).studentCourses[i] == courseID ){
                Students.get(index).studentGrades[i] = grade;
                return commitToFile();
            }  
        }
        
        return false;
    }
   
   
   
   
   public boolean publish(String pub){
               loadFromFile();
               for(Student x : Students)    x.setPublish(pub);
               return commitToFile();
   }
   
   
   
   public boolean  updatesurvey(String s, int studentID){
       loadFromFile();
       int index = getStudentIndex(studentID);
       if(index == -1) return false;
       Students.get(index).setSurvey(s);
       return commitToFile();
   }
   
   public String showSurvey(){
       loadFromFile();
       String s = "<<All Students Opinions>>\n";
       for(Student x : Students) s += x.getSurvey() + "\n----------------\n";
       return s;
   }
   
   
   public String ShowIstructorPublishedNote(){
       loadFromFile();
       return Students.get(0).getPublish();
   }
   
   
   
   
   
   
   
   
   
   
   
     
}
