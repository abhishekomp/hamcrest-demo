import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class InBuiltHamcrestMatchersTest {
    @Test
    public void testStringEquality() {
        String actual = "hello world";
        assertThat(actual, is("hello world"));
    }

    @Test
    public void testListHasItem() {
        java.util.List<Integer> numbers = java.util.Arrays.asList(1, 2, 3, 4, 5);
        assertThat(numbers, hasItem(3));
    }

    @Test
    public void testNumberComparison() {
        int value = 10;
        assertThat(value, greaterThan(5));
    }

    @Test
    public void testStringContains() {
        String phrase = "The quick brown fox";
        assertThat(phrase, containsString("quick"));
    }

    @Test
    public void testListDoesNotHaveItem() {
        java.util.List<String> fruits = java.util.Arrays.asList("apple", "banana", "cherry");
        assertThat(fruits, not(hasItem("orange")));
    }

    @Test
    public void testStringNotEqual() {
        String greeting = "hello";
        assertThat(greeting, not("hi"));
    }

    @Test
    public void testNumberNotGreaterThan() {
        int value = 3;
        assertThat(value, not(greaterThan(10)));
    }

    @Test
    public void testThrowsException() {
        // It is possible to use Hamcrest matchers to assert that a specific exception is thrown.
        // However, this is typically done in conjunction with JUnit's assertThrows method.
        // Here is an example of how to do this:
        /*org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> { throw new IllegalArgumentException("Invalid argument"); }
        );*/
        // The above code will pass if the IllegalArgumentException is thrown,
        // and fail if it is not thrown or if a different exception is thrown.
        // To check the message of the exception, you can use Hamcrest's `hasMessage` matcher.

        Exception exception = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class,
            () -> { throw new IllegalArgumentException("Invalid argument"); }
        );
        assertThat(exception.getMessage(), containsString("Invalid"));
    }

    @Test
    public void testAllItemsInListMatchCondition() {
        java.util.List<String> words = java.util.Arrays.asList("apple", "apricot", "avocado");
        assertThat(words, everyItem(startsWith("a")));
    }

    @Test
    public void testMultipleConditionsOnString() {
        String result = "Hamcrest is powerful";
        assertThat(result, allOf(containsString("Hamcrest"), endsWith("powerful")));
    }

    @Test
    public void testAnyOfMatcher() {
        int number = 42;
        assertThat(number, anyOf(equalTo(42), equalTo(7)));
    }

    @Test
    public void testMapHasEntry() {
        java.util.Map<String, Integer> map = new java.util.HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        assertThat(map, hasEntry("one", 1));
    }

    /**
     * Example: Assert that a list of strings contains at least one element that matches a complex condition.
     * Here, we check that at least one string both starts with 'b' and ends with 'y'.
     */
    @Test
    public void testListHasComplexCondition() {
        java.util.List<String> animals = java.util.Arrays.asList("cat", "bat", "bunny", "dog");
        assertThat(animals, hasItem(allOf(startsWith("b"), endsWith("y"))));
    }

    /**
     * Example: Assert that a double value is close to a given value within a tolerance (delta).
     */
    @Test
    public void testDoubleCloseTo() {
        double actual = 3.14159;
        assertThat(actual, closeTo(3.14, 0.01)); // Passes if actual is within 0.01 of 3.14
    }

    /**
     * Example: Assert that a string is not blank and matches a regex pattern.
     */
    @Test
    public void testStringNotBlankAndMatchesPattern() {
        String email = "user@example.com";
        assertThat(email, allOf(not(blankOrNullString()), matchesPattern(".+@.+\\..+")));
    }

    /**
     * Example: Assert that a map contains a key and the value for that key matches a condition.
     */
    @Test
    public void testMapKeyValueCondition() {
        java.util.Map<String, Integer> scores = new java.util.HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 82);
        assertThat(scores, hasEntry(equalTo("Alice"), greaterThan(90)));
    }

    /**
     * Example: Assert that a thrown exception is of a specific type and its message matches a regex.
     */
    @Test
    public void testExceptionTypeAndMessagePattern() {
        Exception ex = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalStateException.class,
            () -> { throw new IllegalStateException("Error: code 1234"); }
        );
        assertThat(ex.getMessage(), matchesPattern("Error: code \\d+"));
    }

    /**
     * Example: Assert that a list of numbers contains only even numbers using a custom matcher.
     */
    @Test
    public void testAllNumbersAreEven() {
        java.util.List<Integer> evens = java.util.Arrays.asList(2, 4, 6, 8);
        // everyItem allows us to check a condition for all elements
        assertThat(evens, everyItem(is(evenNumber())));
    }

    // Custom matcher for even numbers
    private static org.hamcrest.Matcher<Integer> evenNumber() {
        return new org.hamcrest.TypeSafeMatcher<Integer>() {
            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("an even number");
            }
            @Override
            protected boolean matchesSafely(Integer item) {
                return item % 2 == 0;
            }
        };
    }

    /**
     * Example: Assert that a string is both not null and not empty, and also has a specific length.
     */
    @Test
    public void testStringNotNullNotEmptyAndLength() {
        String code = "abc123";
        assertThat(code, allOf(notNullValue(), not(isEmptyString()), hasLength(6)));
    }

    // Custom matcher for string length
    private static org.hamcrest.Matcher<String> hasLength(int length) {
        return new org.hamcrest.TypeSafeMatcher<String>() {
            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("a string with length ").appendValue(length);
            }
            @Override
            protected boolean matchesSafely(String item) {
                return item != null && item.length() == length;
            }
        };
    }

    /**
     * Example: Assert that a list contains elements in a specific order.
     */
    @Test
    public void testListContainsInOrder() {
        java.util.List<String> colors = java.util.Arrays.asList("red", "green", "blue");
        // contains checks for order and exact match
        assertThat(colors, contains("red", "green", "blue"));
    }

    /**
     * Example: Assert that a map contains only the specified keys, regardless of order.
     */
    @Test
    public void testMapContainsOnlyKeys() {
        java.util.Map<String, Integer> map = new java.util.HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        // hasKey and containsInAnyOrder can be combined for key sets
        assertThat(map.keySet(), containsInAnyOrder("A", "B"));
    }

    /**
     * Example: Assert that a string is equal to another string, ignoring case and whitespace.
     */
    @Test
    public void testStringEqualsIgnoreCaseAndWhitespace() {
        String s1 = "  Hello World  ";
        String s2 = "hello world";
        // Custom matcher for trimmed, case-insensitive equality
        assertThat(s1, trimmedAndEqualsIgnoreCase(s2));
    }

    // Custom matcher for trimmed, case-insensitive string equality
    private static org.hamcrest.Matcher<String> trimmedAndEqualsIgnoreCase(String expected) {
        return new org.hamcrest.TypeSafeMatcher<String>() {
            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("a string equal to ")
                        .appendValue(expected)
                        .appendText(" ignoring case and whitespace");
            }
            @Override
            protected boolean matchesSafely(String item) {
                return item != null && item.trim().equalsIgnoreCase(expected.trim());
            }
        };
    }

    /**
     * Domain-specific example: Assert that a list of email addresses contains only valid emails.
     * Uses a custom Hamcrest matcher for email validation.
     */
    @Test
    public void testAllEmailsAreValid() {
        java.util.List<String> emails = java.util.Arrays.asList(
            "alice@example.com",
            "bob.smith@company.org",
            "user123@domain.co.uk"
        );
        // everyItem with a custom matcher for email validation
        assertThat(emails, everyItem(is(validEmail())));
    }

    // Custom matcher for email validation (simple regex for demonstration)
    private static org.hamcrest.Matcher<String> validEmail() {
        return new org.hamcrest.TypeSafeMatcher<String>() {
            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("a valid email address");
            }
            @Override
            protected boolean matchesSafely(String item) {
                return item != null && item.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
            }
        };
    }

    /**
     * Domain-specific example: Assert that a map of product SKUs to prices contains only positive prices
     * and that all SKUs match a specific pattern (e.g., start with 'SKU-' and followed by digits).
     */
    @Test
    public void testProductSkuAndPriceMap() {
        java.util.Map<String, Double> products = new java.util.HashMap<>();
        products.put("SKU-1001", 19.99);
        products.put("SKU-2002", 5.49);
        products.put("SKU-3003", 0.99);
        // Assert all SKUs are valid
        assertThat(products.keySet(), everyItem(matchesPattern("SKU-\\d+")));
        // Assert all prices are positive
        assertThat(products.values(), everyItem(greaterThan(0.0)));
    }

    /**
     * Domain-specific example: Assert that a list of user objects contains at least one admin user.
     */
    @Test
    public void testUserListContainsAdmin() {
        java.util.List<User> users = java.util.Arrays.asList(
            new User("alice", false),
            new User("bob", true),
            new User("carol", false)
        );
        // hasItem with a custom matcher for admin
        assertThat(users, hasItem(is(adminUser())));
    }

    // Simple User class for demonstration
    static class User {
        String username;
        boolean isAdmin;
        User(String username, boolean isAdmin) {
            this.username = username;
            this.isAdmin = isAdmin;
        }
    }

    // Custom matcher for admin user
    private static org.hamcrest.Matcher<User> adminUser() {
        return new org.hamcrest.TypeSafeMatcher<User>() {
            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("an admin user");
            }
            @Override
            protected boolean matchesSafely(User user) {
                return user != null && user.isAdmin;
            }
        };
    }

    /**
     * Advanced custom matcher: Assert that a list of strings contains at least one palindrome.
     * A palindrome is a string that reads the same forwards and backwards.
     */
    @Test
    public void testListContainsPalindrome() {
        java.util.List<String> words = java.util.Arrays.asList("apple", "level", "banana");
        // hasItem with a custom palindrome matcher
        assertThat(words, hasItem(is(palindrome())));
    }

    // Custom matcher for palindrome strings
    private static org.hamcrest.Matcher<String> palindrome() {
        return new org.hamcrest.TypeSafeMatcher<String>() {
            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("a palindrome string");
            }
            @Override
            protected boolean matchesSafely(String item) {
                if (item == null) return false;
                String reversed = new StringBuilder(item).reverse().toString();
                return item.equals(reversed);
            }
        };
    }

    /**
     * Advanced custom matcher: Assert that a list of numbers contains only prime numbers.
     */
    @Test
    public void testAllNumbersArePrime() {
        java.util.List<Integer> primes = java.util.Arrays.asList(2, 3, 5, 7, 11);
        assertThat(primes, everyItem(is(primeNumber())));
    }

    // Custom matcher for prime numbers
    private static org.hamcrest.Matcher<Integer> primeNumber() {
        return new org.hamcrest.TypeSafeMatcher<Integer>() {
            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("a prime number");
            }
            @Override
            protected boolean matchesSafely(Integer item) {
                if (item == null || item < 2) return false;
                for (int i = 2; i <= Math.sqrt(item); i++) {
                    if (item % i == 0) return false;
                }
                return true;
            }
        };
    }

    /**
     * Advanced custom matcher: Assert that a string contains only uppercase letters.
     */
    @Test
    public void testStringIsAllUppercase() {
        String code = "HELLOWORLD";
        assertThat(code, is(allUppercase()));
    }

    // Custom matcher for all-uppercase strings
    private static org.hamcrest.Matcher<String> allUppercase() {
        return new org.hamcrest.TypeSafeMatcher<String>() {
            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("a string with all uppercase letters");
            }
            @Override
            protected boolean matchesSafely(String item) {
                return item != null && item.matches("[A-Z]+");
            }
        };
    }

    /**
     * Advanced custom matcher: Assert that a list of users contains only users with unique usernames.
     */
    @Test
    public void testAllUsersHaveUniqueUsernames() {
        java.util.List<User> users = java.util.Arrays.asList(
            new User("alice", false),
            new User("bob", true),
            new User("carol", false)
        );
        assertThat(users, uniqueUsernames());
    }

    // Custom matcher for unique usernames in a list of User objects
    private static org.hamcrest.Matcher<java.util.List<User>> uniqueUsernames() {
        return new org.hamcrest.TypeSafeMatcher<java.util.List<User>>() {
            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("all users have unique usernames");
            }
            @Override
            protected boolean matchesSafely(java.util.List<User> users) {
                java.util.Set<String> seen = new java.util.HashSet<>();
                for (User user : users) {
                    if (!seen.add(user.username)) {
                        return false;
                    }
                }
                return true;
            }
        };
    }
}
