package by.itClass.controllers;

import by.itClass.constants.Constants;
import by.itClass.factory.UserFactory;
import by.itClass.interfaces.IUserDAO;
import by.itClass.model.beans.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/regist")
public class RegistrationController extends AbstractController {

    @Override
    public void performTask(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        String login = request.getParameter(Constants.KEY_LOGIN);
        String password = request.getParameter(Constants.KEY_PASSWORD);
        String firstName = request.getParameter(Constants.KEY_FIRST_NAME);
        String email = request.getParameter(Constants.KEY_EMAIL);
        if (login == null || password == null || firstName == null || email == null) {
            jumpError(Constants.INDEX_JSP, Constants.ERR_NULL, request, response);
            return;
        }
        if (Constants.KEY_EMPTY.equals(login) || Constants.KEY_EMPTY.equals(password)
                || Constants.KEY_EMPTY.equals(firstName) || Constants.KEY_EMPTY.equals(email)) {
            jumpError(Constants.INDEX_JSP, Constants.ERR_INPUT_EMPTY, request, response);
            return;
        }
        IUserDAO userDAO = UserFactory.getClassFromFactory();
        User user = new User(login, firstName, email);
        try {
            if (userDAO.addUser(user, password)) {
                HttpSession session = request.getSession();
                session.setAttribute(Constants.KEY_USER, user);
                jump(Constants.INDEX_JSP, request, response);
                return;
            }
        } catch (Exception e) {
            jumpError(Constants.INDEX_JSP, e.getMessage(), request, response);
            return;
        }
        jumpError(Constants.INDEX_JSP, Constants.ERR_REG_LOGIN, request, response);
    }
}
