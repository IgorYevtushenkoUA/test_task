import org.junit.jupiter.api.*;

public class ValidatorTest {

    MessagePlaceholder messagePlaceholder;

    @BeforeEach
    public void init(){
        messagePlaceholder = new MessagePlaceholder();
    }

    @Test
    void when_message_has_more_placeholders_then_messagePlaceholder_is_not_valid(){
        String message = "Text {lol}, {lo1}";
        String[] placeholders = new String[]{"lol"};
        messagePlaceholder.setMessage(message);
        messagePlaceholder.setPlaceholders(placeholders);
        Assertions.assertFalse(MessagePlaceholderValidator.isValidMessagePlaceholder(messagePlaceholder));

    }

    @Test
    void when_message_has_less_placeholders_then_messagePlaceholder_is_not_valid() {
        String message = "Text {lol}";
        String[] placeholders = new String[]{"lol", "lol1"};
        messagePlaceholder.setMessage(message);
        messagePlaceholder.setPlaceholders(placeholders);
        Assertions.assertFalse(MessagePlaceholderValidator.isValidMessagePlaceholder(messagePlaceholder));
    }

    @Test
    void when_message_has_more_placeholders_but_they_duplicate_then_messagePlaceholder_is_valid() {
        String message = "test {lol}, {lol} hello {mem}";
        String[] placeholders = new String[]{"lol", "mem"};
        messagePlaceholder.setMessage(message);
        messagePlaceholder.setPlaceholders(placeholders);
        Assertions.assertTrue(MessagePlaceholderValidator.isValidMessagePlaceholder(messagePlaceholder));
    }

    @Test
    void when_message_has_same_placeholders_then_messagePlaceholder_is_valid() {
        String message = "test {lol}, hello {mem}";
        String[] placeholders = new String[]{"lol", "mem"};
        messagePlaceholder.setMessage(message);
        messagePlaceholder.setPlaceholders(placeholders);
        Assertions.assertTrue(MessagePlaceholderValidator.isValidMessagePlaceholder(messagePlaceholder));
    }

    @Test
    void when_message_has_same_placeholders_and_not_in_the_same_positions_then_messagePlaceholder_is_valid() {
        String message = "test hello {mem} {lol}";
        String[] placeholders = new String[]{"lol", "mem"};
        messagePlaceholder.setMessage(message);
        messagePlaceholder.setPlaceholders(placeholders);
        Assertions.assertTrue(MessagePlaceholderValidator.isValidMessagePlaceholder(messagePlaceholder));
    }
}


