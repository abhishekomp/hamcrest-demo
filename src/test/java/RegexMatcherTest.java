import org.junit.jupiter.api.Test;

import static my.matchers._02_RegexMatcher.matchesRegex;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RegexMatcherTest {
    @Test
    void shouldMatchSimplePattern() {
        assertThat("hello", matchesRegex("^[a-z]+$")); // Passes
    }

    @Test
    void shouldFailOnNonMatchingString() {
        assertThrows(AssertionError.class, () ->
                assertThat("Hello123", matchesRegex("^[a-z]+$"))
        );
    }
}
