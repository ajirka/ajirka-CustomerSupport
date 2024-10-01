import org.junit.jupiter.api.Test;
import org.example.ajirkacustomersupport.Ticket;
import org.example.ajirkacustomersupport.Attachment;
import static org.junit.jupiter.api.Assertions.*;

public class TicketTest {
    @Test
    void getsNameOnTheTicket(){
        var attachment = new Attachment("picture");
        var ticket = new Ticket("Amy","Mold","There is mold in the bathroom",attachment);
        assertEquals("Amy", ticket.getName());
    }

    @Test
    void getsSubjectOnTheTicket(){
        var attachment = new Attachment("picture");
        var ticket = new Ticket("Amy","Mold","There is mold in the bathroom",attachment);
        assertEquals("Mold", ticket.getSubject());
    }

    @Test
    void getsSummaryOnTheTicket(){
        var attachment = new Attachment("picture");
        var ticket = new Ticket("Amy","Mold","There is mold in the bathroom",attachment);
        assertEquals("There is mold in the bathroom", ticket.getTicketSummary());
    }
}
