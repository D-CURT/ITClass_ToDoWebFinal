package by.itClass.controllers;

import by.itClass.constants.Constants;
import by.itClass.factory.TaskFactory;
import by.itClass.impl.TaskDBImplementation;
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

        String title = request.getParameter(Constants.PARAM_TITLE_TASK);
        String contentTask = request.getParameter(Constants.PARAM_CONTENT_TASK);
        String dateTask = request.getParameter(Constants.PARAM_DATE_TASK);

        try {
            ITaskDAO taskDAO = TaskFactory.getITaskDAO();
            Enum<?> section = TaskFactory.getKindSectionEditTask(paramEdit);
            System.out.println("EditCon: " + paramEdit.toUpperCase());
            System.out.println(section.name());
            if (isNullRequestParameters(title, contentTask, dateTask)) {
                if (section == SectionEditTaskMenu.ADD)
                    jumpError(Constants.TASK_ADD_JSP, Constants.ERR_INPUT_EMPTY, request, response);
                else jumpError(Constants.TASK_JSP, Constants.ERR_INPUT_EMPTY, request, response);
            }
            if (section == SectionEditTaskMenu.ADD) {
                taskDAO.addTask(user,ValidationManager.getTask(title, contentTask, dateTask),section);
            } else {
                String[] arrayId = request.getParameterValues(Constants.KEY_PARAM_EDIT_CHECK);
                if (arrayId != null) {
                    if (section == SectionEditTaskMenu.EDIT) {

                    }
                    taskDAO.doEditTask(arrayId, section);
                } else jump(Constants.TASK_JSP, request, response);
                    /*if (section == SectionEditTaskMenu.EDIT) {
                    taskDAO.doEditTask(request.getParameterValues(Constants.PARAM_CHECKBOX),
                            new TaskDBImplementation().getTasks(user, dateTask, section), section);*/
            }
            jump(Constants.TASK_CONTROLLER, request, response);
        } catch (Exception e) {
            System.out.println(3);
            jumpError(Constants.TASK_JSP, e.getMessage(), request, response);
        }
    }

    private boolean isNullRequestParameters(String title, String contentTask, String dateTask) {
        if (title == null || contentTask == null || dateTask == null)
            return true;
        return false;
    }
}
