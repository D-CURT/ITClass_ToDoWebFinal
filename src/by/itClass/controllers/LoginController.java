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

@WebServlet("/login")
public class LoginController extends AbstractController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void jump(String url, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.jump(url, request, response);
    }

    @Override
    public void jumpError(String url, String message, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.jumpError(url, message, request, response);
    }

    @Override
    public void performTask(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String login = request.getParameter(Constants.KEY_LOGIN);
        String password = request.getParameter(Constants.KEY_PASSWORD);
        if (login == null || password == null) {
            jumpError(Constants.INDEX_JSP, Constants.ERR_NULL, request, response);
            return;
        }
        if (Constants.KEY_EMPTY.equals(login) || Constants.KEY_EMPTY.equals(password)) {
            jumpError(Constants.INDEX_JSP, Constants.ERR_EMPTY, request, response);
            return;
        }
        login = login.trim();
        IUserDAO userDAO = UserFactory.getClassFromFactory();
        User user = new User(login);
        try {
            if (userDAO.isFoundUser(user, password)) {
                HttpSession session = request.getSession();
                session.setAttribute(Constants.KEY_USER, user);
                jump(Constants.INDEX_JSP, request, response);
                return;
            }
        } catch (Exception e) {
            jumpError(Constants.INDEX_JSP, e.getMessage(), request, response);
        }
        jumpError(Constants.INDEX_JSP, Constants.ERR_LOGIN, request, response);
    }
}
