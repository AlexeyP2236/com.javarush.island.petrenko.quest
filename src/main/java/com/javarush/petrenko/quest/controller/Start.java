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
    private DB questBD = new DB();
    public String name;
    public String title;
    public boolean fail, victory;
    public int number = 1;
    public int next = 0;

    public List<String> searchStringsQuestBD() {
        List<String> strings = new ArrayList<>();
        for (Quest quest:
                questBD.getQuestBD()) {
            if (quest.getTitle().equals(title)) {
                strings = quest.getStrings();
                break;
            }
        }
        return strings;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Quest q :
                questBD.getQuestBD()) {
            if (q.getTitle().equals(title)) {
                fail = q.isFail();
                victory = q.isVictory();
                break;
            }
        }
        req.setAttribute("text", searchStringsQuestBD());
        req.setAttribute("name", name);
        req.setAttribute("fail", fail);
        req.setAttribute("title", title);
        req.setAttribute("number", String.valueOf(number));
        req.setAttribute("next", String.valueOf(next));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/start.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
