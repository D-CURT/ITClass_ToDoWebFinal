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
        String titleTask = request.getParameter(Constants.PARAM_TITLE_TASK);
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
                if (contentTask == null || dateTask == null)
                    jumpError(Constants.TASK_JSP, Constants.ERR_INPUT_EMPTY, request, response);
                else {
                    if (contentTask.equals(Constants.KEY_EMPTY) || dateTask.equals(Constants.KEY_EMPTY))
                        jumpError(Constants.TASK_JSP, Constants.ERR_INPUT_EMPTY, request, response);
                    else {
                        Task task = ValidationManager.getTask(titleTask, contentTask, dateTask);
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
                    }
                }
            } else {
                String[] arrayId;
                if (section == SectionEditTaskMenu.VIEW) {

                    String idTask = request.getParameter(Constants.PARAM_ID_TASK);
                    System.out.println("Edit: idTask = " + idTask);

                    session.setAttribute(Constants.KEY_TASK, taskDAO.getTask(idTask, section));
                    jump(Constants.TASK_EDIT_JSP, request, response);
                } else {
                    arrayId = request.getParameterValues(Constants.KEY_PARAM_EDIT_CHECK);
                    System.out.println("Edit: arrayID initialized;");
                    if (arrayId != null) {

                        taskDAO.doEditTask(arrayId, section);
                        System.out.println("Edit: task changed;");
                    } else jumpError(Constants.TASK_JSP, "Choose task and try again", request, response);
                }
            }
            jump(Constants.TASK_CONTROLLER, request, response);
            System.out.println("Edit: jump;");
        } catch (Exception e) {
            System.out.println("Edit: exception");
            jumpError(Constants.TASK_JSP, e.getMessage(), request, response);
        }
    }
}
