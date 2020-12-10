public class ProductModel {
    int id;
    String name;
    String image;

    public ProductModel(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public ProductModel() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        if (this.image==null){
            return "null";
        }
        return image;
    }
}
