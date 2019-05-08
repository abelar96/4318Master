import java.io.Serializable;

public class LineItem implements Serializable {

    private  Product product;
    private int quantity;
    private double total;


    public LineItem(){

    }

    public double getTotal() {
        return total;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTotal(){
        this.total = product.getProdPrice()*quantity;
    }

}
