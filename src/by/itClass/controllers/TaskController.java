package by.itClass.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

import by.itClass.constants.Constants;
import by.itClass.factory.TaskFactory;
import by.itClass.interfaces.ITaskDAO;
import by.itClass.model.beans.OldTaskManager;
import by.itClass.model.beans.User;
import by.itClass.section.SectionTask;
import by.itClass.valid.ValidationManager;

@WebServlet("/task")
public class TaskController extends AbstractController {

    @Override
    public void performTask(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("\nIn TaskController;");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.KEY_USER);
        session.setAttribute(Constants.KEY_PARAM_LIST, request.getParameter(Constants.KEY_PARAM_LIST));
        String paramList = (String) session.getAttribute(Constants.KEY_PARAM_LIST);
        String dateTask = request.getParameter(Constants.PARAM_DATE_TASK);
        System.out.println(dateTask);
        //Date dateOldTask;
        System.out.println("Task: variables initialized;");

        if (paramList == null) {
            paramList = Constants.PARAM_LIST_TODAY;
        }

        try {
            System.out.println("Task: in try block;");

            ITaskDAO taskDAO = TaskFactory.getITaskDAO();
            System.out.println("Task: DAO initialized;");

            taskDAO.moveOldTaskToTrash(user);

            /*OldTaskManager manager = OldTaskManager.getInstance(user, taskDAO);
            System.out.println("Task: oldTaskManager initialized as:\n" + manager);*/

            Enum<?> sectionTask = TaskFactory.getKindSectionTask(paramList);
            System.out.println("Task: section initialized as - " + paramList.toUpperCase());

            if (sectionTask == SectionTask.CHOSEN) {
                session.setAttribute(Constants.PARAM_LIST_TASK,
                        taskDAO.getTasks(user, ValidationManager.getValidDate(dateTask), sectionTask));
            } else {
                if (paramList.equals("fixed")) session.setAttribute("fixMark", "1");
                else session.setAttribute("fixMark", null);
                if (paramList.equals("recycle")) session.setAttribute("recycleMark", "1");
                else session.setAttribute("recycleMark", null);
                session.setAttribute(Constants.PARAM_LIST_TASK, taskDAO.getTasks(user, sectionTask));
            }
            System.out.println("Task: session attribute set;");

            jump(Constants.TASK_JSP, request, response);
            System.out.println("Task: jump;");

        } catch (Exception e) {
            System.out.println("Task: exception;");
            e.printStackTrace();
        }
    }
}
