package com.javarush.petrenko.quest.controller;

import com.javarush.petrenko.quest.service.QuestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "start", value = "/start")
public class Start extends HttpServlet {

    private final QuestService questService = new QuestService();

    public String name;
    public String title;
    public int number = 1;
    public int next = 0;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("text", questService.searchStringsQuest(title));
        req.setAttribute("name", name);
        req.setAttribute("fail", questService.searchFailQuest(title));
        req.setAttribute("victory", questService.searchVictoryQuest(title));
        req.setAttribute("title", title);
        req.setAttribute("number", String.valueOf(number));
        req.setAttribute("next", String.valueOf(next));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/start.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("name");
        title = req.getParameter("title");
        Optional<String> optionalNumber = Optional.ofNullable(req.getParameter("number"));
        optionalNumber.ifPresent(string -> number = Integer.parseInt(string) + 1);
        Optional<String> optionalNext = Optional.ofNullable(req.getParameter("next"));
        optionalNext.ifPresent(string -> next = Integer.parseInt(string) + 1);
        resp.sendRedirect("/start");
    }
}
