import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class MessagePlaceholderValidator {

    private static final String PLACEHOLDER_REGEX = "\\{\\w*}";

    public static boolean isValidMessagePlaceholder(MessagePlaceholder messagePlaceholder) {

        String[] messagePlaceholders = generateMessagePlaceholders(messagePlaceholder.getMessage());

        if (messagePlaceholders.length != messagePlaceholder.getPlaceholders().length)
            return false;

        Set<String> messagePlaceholdersSet = new HashSet(List.of(messagePlaceholders));
        for (String str : messagePlaceholder.getPlaceholders())
            if (!messagePlaceholdersSet.contains(str))
                return false;
        return true;
    }

    private static String[] generateMessagePlaceholders(String message) {
        return Pattern.compile(PLACEHOLDER_REGEX)
                .matcher(message)
                .results()
                .map(MatchResult::group)
                .map(str -> str.substring(1, str.length() - 1))
                // if we have few duplicate string, like: "{lol} , {lol}"
                .distinct()
                .toArray(String[]::new);
    }

}
