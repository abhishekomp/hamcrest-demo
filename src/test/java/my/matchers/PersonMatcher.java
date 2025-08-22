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
}