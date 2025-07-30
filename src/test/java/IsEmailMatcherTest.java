import org.hamcrest.StringDescription;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static my.matchers._01_IsEmailMatcher.isEmail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsEmailMatcherTest {

    @Test
    void shouldMatchValidEmail() {
        assertThat("my.address@email.com", isEmail());
    }

    @Test
    void shouldFailInvalidEmail() {
        org.junit.jupiter.api.Assertions.assertThrows(AssertionError.class, () ->
            assertThat("not-an-email", isEmail())
        );
    }

    @Test
    void shouldDescribeToProperly() {
        StringDescription description = new StringDescription();
        isEmail().describeTo(description);
        assertEquals("a valid email address", description.toString());
    }

}