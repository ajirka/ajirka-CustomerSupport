import org.junit.jupiter.api.Test;
import org.example.ajirkacustomersupport.Attachment;
import static org.junit.jupiter.api.Assertions.*;



public class AttachmentTest {
    @Test
    void getsNameOfImage() {
        var attachment = new Attachment("vase");

        assertEquals("vase", attachment.getName());
    }
}
