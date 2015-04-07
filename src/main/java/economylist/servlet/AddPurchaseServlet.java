package economylist.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="AddPurchase", urlPatterns = "/AddPurchase")
public class AddPurchaseServlet extends HttpServlet{

    private static Logger LOG = Logger.getLogger(AddPurchaseServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String s = request.getParameter("sel1ID");
        request.setAttribute("email", email);
        request.setAttribute("selectedID", s);
        request.getRequestDispatcher("addPurchase.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addPurchase.jsp").forward(request, response);
    }
}
