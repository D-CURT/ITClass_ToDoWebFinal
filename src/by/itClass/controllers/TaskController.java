package by.itClass.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import by.itClass.constants.Constants;
import by.itClass.factory.TaskFactory;
import by.itClass.interfaces.ITaskDAO;
import by.itClass.model.beans.User;

@WebServlet("/task")
public class TaskController extends AbstractController {

    @Override
    public void performTask(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.KEY_USER);
        session.setAttribute(Constants.KEY_PARAM_LIST, request.getParameter(Constants.KEY_PARAM_LIST));
        String paramList = (String) session.getAttribute(Constants.KEY_PARAM_LIST);

        if (paramList == null) {
            paramList = Constants.PARAM_LIST_TODAY;
        }

        try {
            ITaskDAO taskDAO = TaskFactory.getITaskDAO();
            Enum<?> sectionTask = TaskFactory.getKindSectionTask(paramList);
            session.setAttribute(Constants.PARAM_LIST_TASK, taskDAO.getTasks(user, sectionTask));
            jump(Constants.TASK_JSP, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
