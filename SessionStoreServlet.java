import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionStoreServlet")
public class SessionStoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);


        String action = request.getParameter("store");

        if (action.equals("login")) {


            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String password = request.getParameter("password");

            User user = new User(fname, lname);

            if (password.equals("admin")) { //Gets value
                out.print("Welcome, " + user.getFname() + " " + user.getLname());
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
            } else {
                out.print("Sorry, username or password error!");
                request.getRequestDispatcher("login.html").include(request, response);
            }
            out.close();

        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        request.getRequestDispatcher("logout.html").include(request, response);

        String action = request.getParameter("store");
        String url = "/store.jsp";


        if (action.equals("goToStore")){
            HttpSession session=request.getSession(false); // SETS FALSE TO PREVENT NEW SESSION FROM BEING CREATED
            if(session!=null){
                User user=(User)session.getAttribute("user");

                getServletContext().getRequestDispatcher(url).forward(request, response);
            }
            else{
                out.print("Please login first to Access Store");
                request.getRequestDispatcher("login.html").include(request, response);
            }
            out.close();
        }
        else if (action.equals("logout")){

            HttpSession session=request.getSession();
            session.invalidate();

            out.print("You are successfully logged out!");

            out.close();
        }

        }


}
