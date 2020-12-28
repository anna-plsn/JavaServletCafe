package Admin;

public class AdminModel {
    Integer id;
    String name;

    public AdminModel(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public  AdminModel(){
    }

    public Integer getId() {return id;}
    public String getName(){
        return this.name;
    }


    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }

}
