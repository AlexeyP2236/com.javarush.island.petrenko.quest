import com.javarush.petrenko.quest.db.DB;
import com.javarush.petrenko.quest.entity.Quest;
import com.javarush.petrenko.quest.text.Text;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BDTest {
    DB db = new DB();

    @Test
    public void testGetQuestBD() {
        Quest quest = db.getQuestBD().get(0);
        assertEquals(Text.BEGINNING, quest.getTitle());
    }
}
