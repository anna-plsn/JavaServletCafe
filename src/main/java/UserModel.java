public class UserModel {
    int id;
    String name;

    public UserModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public int getId() {
        return id;
    }
}

