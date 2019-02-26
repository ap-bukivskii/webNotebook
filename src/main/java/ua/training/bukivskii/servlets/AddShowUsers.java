package ua.training.bukivskii.servlets;

import ua.training.bukivskii.controller.RegexpsToWeb;
import ua.training.bukivskii.model.LoginAlreadyExistsException;
import ua.training.bukivskii.model.Notebook;
import ua.training.bukivskii.view.webView;
import ua.training.bukivskii.controller.webController;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

public class AddShowUsers extends HttpServlet {

    private Notebook notebook;

    private String errorHandling;
    private CopyOnWriteArrayList<String> notes;
    private final static String index = "/users.jsp";

    @Override
    public void init()throws ServletException {
        notebook = new Notebook();
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
            throws ServletException,IOException {

        notes = webView.notebookToWebList(notebook);
        httpServletRequest.setAttribute("notes", notes);
        httpServletRequest.setAttribute("errorHandling", errorHandling);
        httpServletRequest.setAttribute("regexps", new RegexpsToWeb()); //TODO is it bad?
        httpServletRequest.getRequestDispatcher(index).forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF8");

//        if (!webController.requestIsValid(req).equals("goodData")) {
//            errorHandling = String.format("Sorry! Field %s have errors!", webController.requestIsValid(req));
//            doGet(req, resp);
//            return;
//        }

        try {
            notebook.addAbonent(webController.createAbonent(req));
            errorHandling = "Note successfully added!";
        }
        catch (LoginAlreadyExistsException loginBad){
            errorHandling = "Sorry! Login already exists!";
            doGet(req, resp); //TODO handle exception
            return;
        }

        doGet(req, resp);
    }



}
