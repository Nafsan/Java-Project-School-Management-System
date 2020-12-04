package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;

public class StudentLoader {
    public static ObservableList<Student> getStudents() throws IOException {
        ObservableList<Student> studentList = FXCollections.observableArrayList();

        File file = new File("studentList.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String string;
        Student student;
        int line = 0;

        while((string = bufferedReader.readLine()) != null) {
            student = new Student();
            student.setName(string);
            student.setFatherName(bufferedReader.readLine());
            student.setMotherName(bufferedReader.readLine());
            student.setGuardianMobileNo(bufferedReader.readLine());

            String str = bufferedReader.readLine();
            int cl = 0, pos = 0;
            while(pos < str.length() && str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
                cl = cl * 10 + str.charAt(pos) - '0';
                pos++;
            }
            student.setClassNo(cl);

            str = bufferedReader.readLine();
            pos = 0;
            cl = 0;
            while(pos < str.length() && str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
                cl = cl * 10 + str.charAt(pos) - '0';
                pos++;
            }

            student.setClassRoll(cl);
            student.setRes(new Hall(bufferedReader.readLine()));
            student.setAddress(bufferedReader.readLine());
            student.setBirth(new Date(bufferedReader.readLine()));
            student.setSerialNo(++line);
            studentList.add(student);
        }
        bufferedReader.close();
        return studentList;
    }
}
