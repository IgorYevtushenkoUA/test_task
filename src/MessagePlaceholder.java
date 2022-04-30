import java.util.*;

public class MessagePlaceholder {

    private String message;
    private String[] placeholders;

    MessagePlaceholder() {
        this.message = null;
        this.placeholders = null;
    }

    MessagePlaceholder(String message, String[] placeholders) {
        setMessage(message);
        setPlaceholders(placeholders);

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getPlaceholders() {
        return placeholders;
    }

    public void setPlaceholders(String[] placeholders) {
        this.placeholders = placeholders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessagePlaceholder that = (MessagePlaceholder) o;
        return message.equals(that.message) && Arrays.equals(placeholders, that.placeholders);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(message);
        result = 31 * result + Arrays.hashCode(placeholders);
        return result;
    }

}
