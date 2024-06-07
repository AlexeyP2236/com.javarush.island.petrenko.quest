import com.javarush.petrenko.quest.controller.Start;
import com.javarush.petrenko.quest.text.Text;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartTest {

    @Test
    public void doPost() throws ServletException, IOException {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        HttpServletResponse response = Mockito.mock(HttpServletResponse.class);

        when(request.getParameter("name")).thenReturn("Alex");
        when(request.getParameter("title")).thenReturn(Text.BEGINNING);

        Start start = new Start();
        start.doPost(request, response);
        String name = start.name;
        String title = start.title;

       assertEquals("Alex", name);
       assertEquals(Text.BEGINNING, title);
    }
}
