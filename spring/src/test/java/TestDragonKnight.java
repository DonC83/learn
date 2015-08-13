import com.donc.dragon.DragonKnight;
import com.donc.dragon.Quest;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by donovan on 15/05/22.
 */
public class TestDragonKnight {

    @Test
    public void testDragonQuest() throws Exception {
        Quest quest = mock(Quest.class);
        DragonKnight dk = new DragonKnight(quest);
        dk.startQuest();
        verify(quest, times(1)).embark();
    }
}
