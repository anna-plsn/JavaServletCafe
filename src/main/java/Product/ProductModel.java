package Product;

public class ProductModel {
    int id;
    String name;
    String image;
    int price;

    public ProductModel(int id, String name, String image, int price) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public ProductModel() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getImage() {
        if (this.image == null) {
            return "null";
        }
        return image;
    }

    public int getPrice() {
        return price;
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

    public void setPrice(int price) {
        this.price = price;
    }
}
