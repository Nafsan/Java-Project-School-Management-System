package sample;

public class Stuff {

    String name;
    String type;
    Hall work;
    String contactNo;
    Date joiningDate;

    public Stuff() {}

    public Stuff(String name, String type, Hall work, String contactNo, Date joiningDate) {
        this.name = name;
        this.type = type;
        this.work = work;
        this.contactNo = contactNo;
        this.joiningDate = joiningDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Hall getWork() {
        return work;
    }

    public void setWork(Hall work) {
        this.work = work;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String toString() {
        return name + ", " + type + ", " + work + ". Contact: " + contactNo;
    }
}
