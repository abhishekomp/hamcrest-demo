package my.matchers;

import my.model.Person;
import org.hamcrest.FeatureMatcher;
import org.hamcrest.Matcher;

/**
 * FeatureMatcher that logs all calls for demo purposes.
 */
public class PersonMatcher {
    public static Matcher<Person> hasName(Matcher<? super String> nameMatcher) {
        /* What is the purpose of the 2nd and 3rd parameters?
         * They are used in the error message when the matcher fails.
         * The 2nd parameter is a description of the feature being matched,
         * and the 3rd parameter is the name of the feature.
         * When the matcher fails, it will provide a detailed message
         * indicating what feature was expected and what was actually found.
         * Example error message:
         * Expected: a person with name is "Jane"
                but: name was "John"
         */
        // The 2nd parameter is a description of the feature being matched,
        // and the 3rd parameter is the name of the feature.
        // In this case, the feature is the name of the Person object.
        return new FeatureMatcher<Person, String>(nameMatcher, "a person with name", "name") {
            @Override
            protected String featureValueOf(Person person) {
                System.out.println("[FeatureMatcher] Calling featureValueOf for: " + person);
                String res = person.getName();
                System.out.println("[FeatureMatcher] Extracted feature (name): " + res);
                return res;
            }

/*            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("a person with name ").appendDescriptionOf(featureMatcher);
            }

            @Override
            protected void describeMismatchSafely(Person person, org.hamcrest.Description mismatchDescription) {
                String feature = featureValueOf(person);
                mismatchDescription.appendText("name was ").appendValue(feature);
            }*/
        };
    }

    // You can add more matchers for other features of the Person class
    // For example, if you want to match by age, you could create a matcher like
    // hasAge(Matcher<? super Integer> ageMatcher) {
    //     return new FeatureMatcher<Person, Integer>(ageMatcher, "a person with age", "age") {
    //         @Override
    //         protected Integer featureValueOf(Person person) {
    //             return person.getAge(); // Assuming Person has a getAge() method
    //         }
    //     };
    // }
    // This would allow you to write tests that check the age of a Person object
    // using a similar pattern to hasName.

    // You can also create matchers for other features like address, phone number, etc.

    /**
     * Matcher for a person with a specific age.
     * This matcher will log all calls to featureValueOf for demonstration purposes.
     *
     * @param nameMatcher the matcher for the age feature
     * @return a FeatureMatcher that matches a Person's age
     */
    // The way to remember this is that the FeatureMatcher takes the Person object, extracts the feature (age in this case), and then applies the provided matcher (nameMatcher) to that feature.
    // If the feature matches, the matcher succeeds; otherwise, it fails.
    // The FeatureMatcher is useful for creating custom matchers that operate on specific features of an object, allowing for more readable and maintainable tests.
    // The FeatureMatcher is a powerful tool for creating custom matchers that operate on specific features
    // of an object, allowing for more readable and maintainable tests.
    public static Matcher<Person> isYouth(Matcher<? super Double> nameMatcher) {
        return new FeatureMatcher<Person, Double>(nameMatcher, "a person with age", "age") {
            @Override
            protected Double featureValueOf(Person person) {
                System.out.println("[FeatureMatcher] Calling featureValueOf for: " + person);
                Double res = person.getAge();
                System.out.println("[FeatureMatcher] Extracted feature (age): " + res);
                return res;
            }
        };
    }
}