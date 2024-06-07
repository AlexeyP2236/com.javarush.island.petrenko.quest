package com.javarush.petrenko.quest.service;

import com.javarush.petrenko.quest.db.DB;
import com.javarush.petrenko.quest.entity.Quest;

import java.util.ArrayList;
import java.util.List;

public class QuestService {

    private final DB questBD = new DB();

    public List<String> searchStringsQuest(String title) {
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

    public boolean searchFailQuest(String title){
        boolean fail = false;
        for (Quest quest:
                questBD.getQuestBD()) {
            if (quest.getTitle().equals(title)) {
                fail = quest.isFail();
                break;
            }
        }
        return fail;
    }

    public boolean searchVictoryQuest(String title){
        boolean victory = false;
        for (Quest quest:
                questBD.getQuestBD()) {
            if (quest.getTitle().equals(title)) {
                victory = quest.isVictory();
                break;
            }
        }
        return victory;
    }
}
