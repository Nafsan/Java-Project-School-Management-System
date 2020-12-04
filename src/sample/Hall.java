package sample;

import java.util.Vector;

public class Hall {
    String name;
    HallRoom rooms[] = new HallRoom[30];
    Vector<Stuff> stuff;
    Vector<Teacher> houseTutor;
    Vector<Student> student;
    int numberOfStudents = 0;

    public Hall() {
        name = "";
        for(int i = 0; i < 30; i++)
            rooms[i] = new HallRoom();
    }

    public Hall(String name) {
        this.name = name;
        for(int i = 0; i < 30; i++)
            rooms[i] = new HallRoom();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HallRoom[] getRooms() {
        return rooms;
    }

    public void setRooms(HallRoom[] rooms) {
        this.rooms = rooms;
    }

    public void addStudent(Student s) {
        student.addElement(s);

        for(int i = 0; i < 30; i++) {
            if(rooms[i].one == null)
                rooms[i].one = s;
            else if(rooms[i].two == null)
                rooms[i].two = s;
        }
    }

    public void addTeacher(Teacher t) {
        houseTutor.addElement(t);
    }

    public void addStuff(Stuff f) {
        stuff.addElement(f);
    }

    public int getNumberOfStudents() {
        return student.size();
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public String toString() {
        return name;
    }
}
