package sample;

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
    private static final long serialVersionUID = 1015854638037386371l;
    public static final int TIMEOUT = 5 * 60; // seconds

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
        if ("/logout".equals(req.getServletPath())) {
            req.getSession().invalidate();
        } else {
            String name = req.getParameter("name").replaceAll("[^\\w]", "");
            if (name.length() > 0) {
                HttpSession session = req.getSession();
                session.setAttribute("name", name);
                /* Automatical "logout". */
                session.setMaxInactiveInterval(TIMEOUT);
            }
        }
        res.sendRedirect("count.jsp");
    }
}
