package my.err_message_construction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestErrorMsgExample {
    public static void main(String[] args) {
        int value = 5;
        assertThat(value, is(greaterThan(10)));
    }
}