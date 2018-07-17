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
        try {
            ITaskDAO taskDAO = TaskFactory.getITaskDAO();
            Enum<?> section = TaskFactory.getKindSectionEditTask(paramEdit);
            System.out.println("EditCon: " + paramEdit.toUpperCase());
            System.out.println(section.name());

            if (section == SectionEditTaskMenu.ADD) {
                String title = request.getParameter(Constants.PARAM_TITLE_TASK);
                String contentTask = request.getParameter(Constants.PARAM_CONTENT_TASK);
                String dateTask = request.getParameter(Constants.PARAM_DATE_TASK);
                Task task = ValidationManager.getTask(title ,contentTask, dateTask);
                taskDAO.addTask(user, task, section);
            } else {
                String[] arrayId = request.getParameterValues(Constants.KEY_PARAM_EDIT_CHECK);
                if (arrayId != null) {
                    taskDAO.doEditTask(arrayId, section);
                }
                    /*if (section == SectionEditTaskMenu.EDIT) {
                    taskDAO.doEditTask(request.getParameterValues(Constants.PARAM_CHECKBOX),
                            new TaskDBImplementation().getTasks(user, dateTask, section), section);*/
            }
            jump(Constants.TASK_CONTROLLER, request, response);
            /*if (task == null) {
                jumpError(Constants.TASK_ADD_JSP, Constants.ERR_MESS_ADD_TASK, request, response);
            } else {*/

         /*   }*/
        } catch (Exception e) {
            System.out.println(3);
            jumpError(Constants.TASK_JSP, e.getMessage(), request, response);
        }
    }
}
