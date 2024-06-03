package com.javarush.petrenko.quest.controller;

import com.javarush.petrenko.quest.db.DB;
import com.javarush.petrenko.quest.entity.Quest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "start", value = "/start")
public class Start extends HttpServlet {
    String name;
    String title;
    boolean fail, victory;
    int number = 1;
    int next = 0;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DB questBD = new DB();
        List<String> str = new ArrayList<>();
        for (Quest q :
                questBD.getQuestBD()) {
            if (q.getTitle().equals(title)) {
                str = q.getStrings();
                fail = q.isFail();
                victory = q.isVictory();
                break;
            }
        }
        req.setAttribute("text", str);
        req.setAttribute("name", name);
        req.setAttribute("fail", fail);
        req.setAttribute("title", title);
        req.setAttribute("number", String.valueOf(number));
        req.setAttribute("next", String.valueOf(next));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/start.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        name = req.getParameter("name");
        //вот это перенести в индекс
        //if (name.isEmpty()) name = "Ноунэйм";
        title = req.getParameter("title");
        Optional<String> optionalNumber = Optional.ofNullable(req.getParameter("number"));
        optionalNumber.ifPresent(string -> number = Integer.parseInt(string) + 1);
        Optional<String> optionalNext = Optional.ofNullable(req.getParameter("next"));
        optionalNext.ifPresent(string -> next = Integer.parseInt(string) + 1);
        resp.sendRedirect("/start");

    }
}
