package com.javarush.petrenko.quest.db;

import com.javarush.petrenko.quest.entity.Quest;
import com.javarush.petrenko.quest.text.Text;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DB {
    private final List<Quest> questBD;
    public DB() {
    questBD = Stream.of(
            new Quest(Text.BEGINNING, Stream.of(" потерял память", "Принять вызов НЛО?", "Принять вызов", "Отклонить вызов").collect(Collectors.toList())),
            new Quest(Text.BAD_BEGINNING, Stream.of(" отклонил вызов", "Поражение").collect(Collectors.toList()), true),
            new Quest(Text.CAPTAIN_BRIDGE, Stream.of(" принял вызов", "Поднимаешься на мостик к капитану?", "Подняться на мостик", "Отказаться подняться на мостик").collect(Collectors.toList())),
            new Quest(Text.BAD_CAPTAIN_BRIDGE, Stream.of(" не пошел на переговоры", "Поражение").collect(Collectors.toList()), true),
            new Quest(Text.FIND_NAME, Stream.of(" поднялся на мостик", "Ты кто?", "Рассказать правду о себе", "Солгать о себе").collect(Collectors.toList())),
            new Quest(Text.BAD_FIND_NAME, Stream.of(" ложь разоблачили", "Поражение").collect(Collectors.toList()), true),
            new Quest(Text.GOOD_END, Stream.of(" вернули домой", "Победа").collect(Collectors.toList()), false, true)
            ).collect(Collectors.toList());
    }

    public List<Quest> getQuestBD() {
        return questBD;
    }
}
