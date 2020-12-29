package Cart;

public class CartModel {
    int id_product;
    String name;
    int price;
    int quantity;

    public CartModel(int id_product, String name, int price, int quantity){
        this.id_product = id_product;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public  CartModel(){

    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
