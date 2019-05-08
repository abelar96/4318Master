import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

public class ProductDB implements Serializable {

    public static ArrayList<Product> selectProducts() {

        Connection conc;
        PreparedStatement ps = null;
        String selectAll = "select * from products";
        ResultSet rs = null;
        ArrayList<Product> products = new ArrayList();
        {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "mysql");
                ps = conc.prepareStatement(selectAll);
                rs = ps.executeQuery();

                while (rs.next()){

                    Product product = new Product();

                    product.setProdName(rs.getString("ProdName"));
                    product.setProdDesc(rs.getString("ProdDesc"));
                    product.setProdPrice(rs.getDouble("ProdPrice"));
                    product.setProdPicLocation(rs.getString("ProdPictLocation"));
                    product.setProdQuant(rs.getInt("ProdQuant"));
                    product.setProductID(rs.getString("ProdID"));

                    products.add(product);
                }

                return products ;
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }finally {
                DBUtil.closePrepareStatement(ps);
            }
        }

    }

    public static Product selectProduct(String id){
        Connection conc;
        PreparedStatement ps = null;
        String selectUser = "select * from products where ProdID =?";
        ResultSet rs = null;
        {
            try {

                Class.forName("com.mysql.jdbc.Driver");
                conc = DriverManager.getConnection("jdbc:mysql://localhost:3306/store", "root", "mysql");
                ps = conc.prepareStatement(selectUser);
                ps.setString(1,id);
                rs = ps.executeQuery();


                Product product = new Product();

                if (rs.next()){
                    product.setProdName(rs.getString("ProdName"));
                    product.setProdDesc(rs.getString("ProdDesc"));
                    product.setProdPrice(rs.getDouble("ProdPrice"));
                    product.setProdPicLocation(rs.getString("ProdPictLocation"));
                    product.setProdQuant(rs.getInt("ProdQuant"));
                    product.setProductID(rs.getString("ProdID"));
                }

                return product;

            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }finally {
                DBUtil.closePrepareStatement(ps);
            }
        }

    }
}
