package my.matchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

import java.util.regex.Pattern;

public class _02_RegexMatcher extends BaseMatcher<String> {

    private final Pattern pattern;
    private String actualValue;

    public _02_RegexMatcher(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public boolean matches(Object item) {
        if (item == null) {
            this.actualValue = null;
            return false;
        }
        this.actualValue = item.toString();
        return pattern.matcher(this.actualValue).matches();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("a string matching regex: " + pattern.pattern());
        if (actualValue != null) {
            description.appendText(", but was: '" + actualValue + "'");
        }
    }

    // Optional helper for fluency in your tests
    public static Matcher<String> matchesRegex(String regex) {
        return new _02_RegexMatcher(regex);
    }

}
