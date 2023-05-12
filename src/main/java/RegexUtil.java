import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtil {
    public static String getSubstringByPattern(String string, Pattern pattern) {
        Matcher matcher = pattern.matcher(string);
        String substring = "";
        if (matcher.matches()) {
            substring = matcher.group(1);
        }
        return substring;
    }
}
