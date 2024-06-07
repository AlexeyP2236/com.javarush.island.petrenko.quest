import com.javarush.petrenko.quest.db.DB;
import com.javarush.petrenko.quest.entity.Quest;
import com.javarush.petrenko.quest.service.QuestService;
import com.javarush.petrenko.quest.text.Text;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceQuestTest {
    private final DB dbQuest = new DB();
    private final QuestService questService = new QuestService();
    private final List<String> text = new ArrayList<>(List.of(Text.BEGINNING, Text.BAD_BEGINNING, Text.CAPTAIN_BRIDGE, Text.BAD_CAPTAIN_BRIDGE, Text.FIND_NAME, Text.BAD_FIND_NAME, Text.GOOD_END));

    @Test
    public void searchStringsQuestTest() {
        for (int i = 0; i < text.size(); i++) {
            assertEquals(dbQuest.getQuestBD().get(i).getStrings(), questService.searchStringsQuest(text.get(i)));
        }
    }

    @Test
    public void searchFailQuestTest() {
        for (int i = 0; i < text.size(); i++) {
            assertEquals(dbQuest.getQuestBD().get(i).isFail(), questService.searchFailQuest(text.get(i)));
        }
    }

    @Test
    public void searchVictoryQuestTest() {
        for (int i = 0; i < text.size(); i++) {
            assertEquals(dbQuest.getQuestBD().get(i).isVictory(), questService.searchVictoryQuest(text.get(i)));
        }
    }
}
