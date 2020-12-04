package sample;

public class HallRoom {
    Student one, two;

    public HallRoom() {
        one = null;
        two = null;
    }

    public HallRoom(Student one, Student two) {
        this.one = one;
        this.two = two;
    }

    public Student getOne() {
        return one;
    }

    public void setOne(Student one) {
        this.one = one;
    }

    public Student getTwo() {
        return two;
    }

    public void setTwo(Student two) {
        this.two = two;
    }
}
