import my.matcher_debugging.LoggingGreaterThanMatcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class LoggingMatcherHamcrestTest {

    @Test
    void demo_without_is() {
        // The LOG line in matchesSafely should output here
        assertThat(20, LoggingGreaterThanMatcher.loggingGreaterThan(10));
    }

    @Test
    void demo_with_is() {
        // The LOG line in matchesSafely should output here too (just as above)
        assertThat(20, Matchers.is(LoggingGreaterThanMatcher.loggingGreaterThan(10)));
    }
}