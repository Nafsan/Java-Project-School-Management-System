package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TeacherLoader {
    public static ObservableList<Teacher> getTeachers() throws IOException {
        ObservableList<Teacher> teacherList = FXCollections.observableArrayList();

        Teacher teacher;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("TeachersList.txt"));
        String str;

        int cnt = 0;

        while((str = bufferedReader.readLine()) != null) {
            teacher = new Teacher();

            teacher.setName(str);
            teacher.setDesignation(bufferedReader.readLine());
            teacher.setEducation(bufferedReader.readLine());
            teacher.setContactNo(bufferedReader.readLine());
            teacher.setEmail(bufferedReader.readLine());
            teacher.setTutor(new Hall(bufferedReader.readLine()));
            teacher.setJoiningDate(new Date(bufferedReader.readLine()));
            teacher.setSerialNo(++cnt);

            String loc = "t";
            if(cnt < 10)
                loc += "0" + cnt + ".jpg";
            else
                loc += cnt + ".jpg";

            teacher.setPic(new ImageView(new Image(loc)));
            teacherList.add(teacher);
        }

        return teacherList;
    }
}
