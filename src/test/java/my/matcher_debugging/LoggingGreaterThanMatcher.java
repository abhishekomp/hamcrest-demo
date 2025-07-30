package my.matcher_debugging;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class LoggingGreaterThanMatcher extends TypeSafeMatcher<Integer> {
    private final int threshold;

    public LoggingGreaterThanMatcher(int threshold) {
        this.threshold = threshold;
    }

    @Override
    protected boolean matchesSafely(Integer actual) {
        System.out.println("[LOG] matchesSafely called! actual=" + actual + ", threshold=" + threshold);
        return actual > threshold;
    }

/*    @Override
    public void describeTo(Description description) {
        description.appendText("a number greater than " + threshold);
    }*/

    @Override
    public void describeTo(Description description) {
        System.out.println("[LOG] describeTo called!");
        description.appendText("a number greater than " + threshold);
    }

    public static LoggingGreaterThanMatcher loggingGreaterThan(int threshold) {
        return new LoggingGreaterThanMatcher(threshold);
    }
}