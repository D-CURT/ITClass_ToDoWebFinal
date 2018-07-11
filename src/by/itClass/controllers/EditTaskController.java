package by.itClass.controllers;

import by.itClass.constants.Constants;
import by.itClass.factory.TaskFactory;
import by.itClass.interfaces.ITaskDAO;
import by.itClass.model.beans.Task;
import by.itClass.model.beans.User;
import by.itClass.section.SectionEditTaskMenu;
import by.itClass.valid.ValidationManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/edit")
public class EditTaskController extends AbstractController {

    @Override
    public void performTask(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.KEY_USER);
        String paramEdit = request.getParameter(Constants.KEY_PARAM_EDIT);
        try {
            Enum<?> section = TaskFactory.getKindSectionEditTask(paramEdit);
            ITaskDAO taskDAO = TaskFactory.getITaskDAO();
            if (section == SectionEditTaskMenu.ADD) {
                String contentTask = request.getParameter(Constants.PARAM_CONTENT_TASK);
                String dateTask = request.getParameter(Constants.PARAN_TASK_DATE);

                Task task = ValidationManager.getTask(contentTask, dateTask);
                if (task == null) {
                    jumpError(Constants.TASK_ADD_JSP, Constants.ERR_MESS_ADD_TASK, request, response);
                }

                taskDAO.addTask(user, task, section);
            }
        } catch (Exception e) {
            jumpError(Constants.TASK_JSP, e.getMessage(), request, response);
        }
    }
}
