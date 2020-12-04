package sample;

public class FindUser {
    public boolean find(String id, String pass) {
        System.out.println(id + "x" + pass + "x");
        if(id.equals("pial") && pass.equals("pial"))
            return true;
        return false;
    }
}
