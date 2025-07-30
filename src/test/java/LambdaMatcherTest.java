import my.matchers._03_LambdaMatcher;
import org.junit.jupiter.api.Test;

import static my.matchers._03_LambdaMatcher.lambda;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LambdaMatcherTest {

    @Test
    void testLambda() {
        // Example usage of LambdaMatcher
        var matcher = _03_LambdaMatcher.<Integer>lambda(
                i -> i > 10,
                "should be greater than 10"
        );

        assertTrue(matcher.matches(15), "Expected 15 to match the condition");
        assertFalse(matcher.matches(5), "Expected 5 not to match the condition");

        // Description check
        var description = new org.hamcrest.StringDescription();
        matcher.describeTo(description);
        assertEquals("should be greater than 10", description.toString());
    }

    @Test
    void testLambda2() {
        // Even integer matcher, written in a test as a lambda
        assertThat(14, lambda(x -> x % 2 == 0, "an even integer"));

        // List size matcher
        assertThat(java.util.Arrays.asList(1, 2, 3), lambda(
                list -> list.size() == 3, "a list of size 3"));

        // "Starts with hello"
        assertThat("hello world", lambda(
                x -> x.startsWith("hello"), "starts with 'hello'"));
    }

/*    @Test
    void lambdaWithNull() {
        // Example usage of LambdaMatcher with null
        var matcher = LambdaMatcher.<String>lambda(
                s -> s == null || s.isEmpty(),
                "should be null or empty"
        );

        assertTrue(matcher.matches(null), "Expected null to match the condition");
        assertTrue(matcher.matches(""), "Expected empty string to match the condition");
        assertFalse(matcher.matches("not empty"), "Expected non-empty string not to match the condition");

        // Description check
        var description = new org.hamcrest.StringDescription();
        matcher.describeTo(description);
        assertEquals("should be null or empty", description.toString());
    }*/
}