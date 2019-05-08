import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String url = "/index.jsp";
        String action = request.getParameter("action");

        if (action.equals("addToCart")) {

            String productCode = request.getParameter("productCode");
            String quantityString = request.getParameter("quantity");


            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");

            int quantity;

            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0) {
                    quantity = 1;
                }
            } catch (NumberFormatException nfe) {

                quantity = 1;
            }


            if (cart == null) {
                cart = new Cart();
            }

            Product product = ProductDB.selectProduct(productCode);

            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);
            lineItem.setTotal();

            if (quantity > 0) {

                cart.addItem(lineItem);
            }
            else if (quantity ==0){
                cart.removeItem(lineItem);
            }


            session.setAttribute("cart", cart);
            url = "/cart.jsp";


        }


        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
