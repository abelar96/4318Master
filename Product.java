import java.io.Serializable;

public class Product implements Serializable {

    private String productID;
    private String prodName;
    private String prodDesc;
    private double prodPrice;
    private int prodQuant;
    private String prodPicLocation;


    public Product() {
    }

    public Product(String productID, String prodName, String prodDesc, double prodPrice, int prodQuant, String prodPicLocation) {
        this.productID = productID;
        this.prodName = prodName;
        this.prodDesc = prodDesc;
        this.prodPrice = prodPrice;
        this.prodQuant = prodQuant;
        this.prodPicLocation = prodPicLocation;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public double getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(double prodPrice) {
        this.prodPrice = prodPrice;
    }

    public int getProdQuant() {
        return prodQuant;
    }

    public void setProdQuant(int prodQuant) {
        this.prodQuant = prodQuant;
    }

    public String getProdPicLocation() {
        return prodPicLocation;
    }

    public void setProdPicLocation(String prodPicLocation) {
        this.prodPicLocation = prodPicLocation;
    }
}
