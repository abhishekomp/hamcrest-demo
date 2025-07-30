package my.matchers;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class _01_IsEmailMatcher extends BaseMatcher<String> {

    public _01_IsEmailMatcher() {
        System.out.println("[LOG] Constructor: _01_IsEmailMatcher()");
    }

    @Override
    public boolean matches(Object item) {
        System.out.println("[LOG] matches() called with: " + item);
        if (item == null) return false;
        String str = item.toString();
        // Super simple, just for demo (real regex would be stricter)
        boolean result = str.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        System.out.println("[LOG] matches() result: " + result);
        return result;
    }

    @Override
    public void describeTo(Description description) {
        //System.out.println("[LOG] describeTo() called");
        System.out.println("[LOG] describeTo() called with description: '" + description + "'");
        description.appendText("a valid email address");
    }

    // Optional helper for fluency in your tests
    public static Matcher<String> isEmail() {

        System.out.println("[LOG] isEmail() factory called");
        return new _01_IsEmailMatcher();
    }
}