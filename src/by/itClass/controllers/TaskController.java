package by.itClass.controllers;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.itClass.Section.SectionTask;
import by.itClass.constants.Constants;
import by.itClass.factory.TaskFactory;
import by.itClass.interfaces.ITaskDAO;
import by.itClass.model.beans.Task;
import by.itClass.model.beans.User;

@WebServlet("/task")
public class TaskController extends AbstractController {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    public void performTask(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(Constants.KEY_USER);
        String paramList = (String) session.getAttribute(Constants.KEY_PARAM_LIST);
        if (paramList == null) paramList = "today";
        ITaskDAO taskDAO = TaskFactory.getITaskDAO();
        SectionTask sectionTask = (SectionTask) TaskFactory.getKindSectionTask(paramList);
        try {
            ArrayList<Task> tasks = (ArrayList<Task>) taskDAO.getTasks(user, sectionTask);
            session.setAttribute(Constants.KEY_PARAM_LIST, tasks);
            jump(Constants.TASK_JSP, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
