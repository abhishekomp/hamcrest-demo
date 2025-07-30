package my.err_message_construction;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class EnglishDivisibleByMatcher extends TypeSafeMatcher<Integer> {
    private final int divisor;

    public EnglishDivisibleByMatcher(int divisor) { this.divisor = divisor; }

    @Override
    public void describeTo(Description description) {
        description.appendText("a number divisible by ").appendValue(divisor);
    }

    @Override
    protected boolean matchesSafely(Integer actual) {
        return actual % divisor == 0;
    }

    @Override
    protected void describeMismatchSafely(Integer actual, Description mismatchDescription) {
        mismatchDescription.appendText("was ").appendValue(actual).appendText(", which is not divisible by ").appendValue(divisor);
    }

    public static EnglishDivisibleByMatcher divisibleBy(int divisor) {
        return new EnglishDivisibleByMatcher(divisor);
    }
}