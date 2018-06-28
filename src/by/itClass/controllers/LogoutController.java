package by.itClass.controllers;

import by.itClass.constants.Constants;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutController extends AbstractController {

    @Override
    public void performTask(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        System.out.println();

        response.sendRedirect(Constants.LOGOUT_INDEX_JSP);
    }
}
