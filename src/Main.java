import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void writeToFile(String path, List<Student> studentList){
        try{
            OutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path){
        List<Student> studentList = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(is);
            studentList = (List<Student>) ois.readObject();
            is.close();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentList;
    }

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"Vu kieu anh","Ha noi"));
        studentList.add(new Student(2,"Nguyen Minh Quan","Ha noi"));
        studentList.add(new Student(2,"Dang huy hoa","Ha noi"));

        writeToFile("ListOfStudent.txt",studentList);
        List<Student> studentDataFromFile = readDataFromFile("ListOfStudent.txt");
        for (Student student :
                studentDataFromFile) {
            System.out.println(student);
        }

    }

}
