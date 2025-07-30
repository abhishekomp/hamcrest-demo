package my.matchers;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import java.util.function.Predicate;

public class _03_LambdaMatcher<T> extends TypeSafeMatcher<T> {
    private final Predicate<T> predicate;
    private final String description;

    public _03_LambdaMatcher(Predicate<T> predicate, String description) {
        this.predicate = predicate;
        this.description = description;
    }

    @Override
    protected boolean matchesSafely(T item) {
        return predicate.test(item);
    }

    @Override
    public void describeTo(Description desc) {
        desc.appendText(description);
    }

    public static <T> Matcher<T> lambda(Predicate<T> pred, String description) {
        return new _03_LambdaMatcher<>(pred, description);
    }
}