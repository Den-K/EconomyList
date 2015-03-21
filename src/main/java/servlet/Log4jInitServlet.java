package servlet;

import org.apache.log4j.PropertyConfigurator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Created by Den on 20.03.2015.
 */
@WebServlet(name="Log4jInit", urlPatterns = "", loadOnStartup = 1,
            initParams = {@WebInitParam(name = "log4j", value = "WEB-INF/log4j.properties")})
public class Log4jInitServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        String log4j = getInitParameter("log4j");
        String pref = getServletContext().getRealPath("/");
        PropertyConfigurator.configure(pref + log4j);
    }

}