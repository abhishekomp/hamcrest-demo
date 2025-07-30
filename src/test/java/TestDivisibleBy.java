import my.err_message_construction.EnglishDivisibleByMatcher;

import static my.err_message_construction.EnglishDivisibleByMatcher.divisibleBy;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;

public class TestDivisibleBy {
    public static void main(String[] args) {

        //assertThat(7, divisibleBy(3));
        assertThat(6, not(divisibleBy(3)));

    }
}