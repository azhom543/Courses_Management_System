package code;



import java.io.Serializable;


public abstract class Person implements Serializable {

    protected int id;
    protected String userName;
    protected String pass;
    protected String fname;
    protected String lname;
    protected int age;

    FileMangerBinary FManger = new FileMangerBinary();

    public Person() {
    }

    public Person(String user, String pass, int id, String fname, String lname, int age) {
             
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.userName = user;
        this.pass = pass;
        
    }

    @Override
    public abstract String toString();

    //setter
    public void setID(int id) {
        this.id = id;
    }

    public void setFName(String fname) {
        this.fname = fname;
    }

    public void setLName(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    //getter
    public String getuserName() {
        return this.userName;
    }

    public String getPass() {
        return this.pass;
    }

    public int getID() {
        return this.id;
    }

    public String getFName() {
        return this.fname;
    }

    public String getLName() {
        return this.lname;
    }

    public int getAge() {
        return this.age;
    }
    
    public static int login(String userName, String Pass){
        
   
        if( userName.equals("Admin@yahoo.com") && Pass.equals("12345678") ) return 1;
        
     
        Student st=new Student();
        Instructor ins = new Instructor();   
        st.loadFromFile();
        ins.loadFromFile();
        
        
        
        for(Instructor x : Instructor.instructors){
            if(x.getuserName().equals(userName) && x.getPass().equals(Pass)) return 2;
        }
        
        for(Student x : Student.Students){
            if(x.getuserName().equals(userName) && x.getPass().equals(Pass)) return 3;
        }
             return 0;
    }
}
