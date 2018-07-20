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
        System.out.println("\nIn EditTaskController;");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.KEY_USER);
        String paramEdit = request.getParameter(Constants.KEY_PARAM_EDIT);

        String title = request.getParameter(Constants.PARAM_TITLE_TASK);
        String contentTask = request.getParameter(Constants.PARAM_CONTENT_TASK);
        String dateTask = request.getParameter(Constants.PARAM_DATE_TASK);
        System.out.println("Edit: variables initialized;");

        try {
            System.out.println("Edit: in try block;");

            ITaskDAO taskDAO = TaskFactory.getITaskDAO();
            System.out.println("Edit: DAO initialized;");

            Enum<?> section = TaskFactory.getKindSectionEditTask(paramEdit);
            System.out.println("Edit: section initialized as - " + paramEdit.toUpperCase());

            if (section == SectionEditTaskMenu.ADD || section == SectionEditTaskMenu.EDIT) {
                System.out.println("Edit: in add/edit block;");

                Task task = ValidationManager.getTask(title, contentTask, dateTask);
                System.out.println("Edit: task initialized;");

                if (section == SectionEditTaskMenu.EDIT) {
                    System.out.println("Edit: in add/edit: in edit block;");

                    String id = request.getParameter(Constants.PARAM_ID_TASK);
                    System.out.println("Edit: id parameter is taken;");

                    task.setId(id);
                    System.out.println("Edit: id for task is set;");
                }
                taskDAO.addTask(user,task,section);
                System.out.println("Edit: task added;");
            } else {
                String[] arrayId = request.getParameterValues(Constants.KEY_PARAM_EDIT_CHECK);
                System.out.println("Edit: arrayID initialized;");
                if (arrayId != null) {

                    taskDAO.doEditTask(arrayId, section);
                    System.out.println("Edit: task changed;");
                } else jump(Constants.TASK_JSP, request, response);
            }
            jump(Constants.TASK_CONTROLLER, request, response);
            System.out.println("Edit: jump;");
        } catch (Exception e) {
            System.out.println("Edit: exception");
            jumpError(Constants.TASK_JSP, e.getMessage(), request, response);
        }
    }
}
