package User;

public class UserModel {
    int id;
    String name;
    String surname;
    String email;
    String password;
    String image;

    public UserModel(int id, String name, String surname, String email, String password, String image) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.image = image;
    }

    public  UserModel(){

    }
    public int getId() { return this.id; }
    public String getName(){
        return this.name;
    }
    public String getSurname(){
        return this.surname;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public String getImage() {
        if (this.image==null){
            return "null";
        }
        return image;
    }


    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setSurname(String surname) { this.surname = surname; }

    public void setEmail(String email) { this.email = email; }

    public void setPassword(String password) { this.password = password; }

    public void setImage(String image) {

        this.image = image;
    }
}

