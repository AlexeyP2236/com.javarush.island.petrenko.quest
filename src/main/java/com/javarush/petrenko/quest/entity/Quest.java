package com.javarush.petrenko.quest.entity;

import java.util.List;

public class Quest {
    private final String title;
    private final List<String> strings;
    private boolean fail;
    private boolean victory;

    public Quest(String title, List<String> strings) {
        this.title = title;
        this.strings = strings;
        fail = false;
        victory = false;
    }

    public Quest(String title, List<String> strings, boolean fail) {
        this(title, strings);
        this.fail = fail;
    }

    public Quest(String title, List<String> strings, boolean fail, boolean victory) {
        this(title, strings, fail);
        this.victory = victory;
    }

    public String  getTitle() {
        return title;
    }

    public List<String> getStrings() {
        return strings;
    }

    public boolean isFail() {
        return fail;
    }

    public boolean isVictory() {
        return victory;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "title=" + title +
                ", strings=" + strings +
                '}';
    }
}
