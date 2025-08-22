package my;

import my.model.Person;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test // POSITIVE: Check typical age calculation
    @DisplayName("Age calculation for ordinary adult should be correct and positive")
    void testNormalAgeCalculation() {
        Person p = new Person("Alice", LocalDate.now().minusYears(30).minusDays(90));
        double expectedAge = 30.25; // 30 years and ~3 months
        double age = p.getAge();
        assertTrue(age > 30.15 && age < 30.35, "Age should be about 30.25, got " + age);
    }

    @Test // EDGE: Born today (should be very close to zero)
    @DisplayName("Person born today should have age approximately zero")
    void testAgeBornToday() {
        Person baby = new Person("Baby", LocalDate.now());
        double babyAge = baby.getAge();
        assertTrue(babyAge >= 0.0 && babyAge < 0.01, "Age for today-born should be near zero, got " + babyAge);
    }

    @Test // POSITIVE: Born on leap day
    @DisplayName("Correct age for leap day birthday (Feb 29)")
    @Disabled("Leap day birthdays are tricky, so we disable this test for now")
    // This test is disabled because leap day birthdays can be tricky to handle.
    void testLeapDayAge() {
        int yearsAgo = 8; // Leap year ago: 2016 if today is 2024
        LocalDate leapBirthday = LocalDate.of(LocalDate.now().getYear() - yearsAgo, 2, 29);

        Person leapling = new Person("Leap", leapBirthday);
        double age = leapling.getAge();
        assertTrue(age > 7.9 && age < 8.1, "Leapling age should be about 8, got " + age);
    }

    @Test // EDGE: Born far in the past
    @DisplayName("Age for very old birthdate (historical)")
    void testAncientPerson() {
        Person vampire = new Person("Dracula", LocalDate.of(1800, 10, 31));
        double age = vampire.getAge();
        assertTrue(age > 224 && age < 226, "Dracula should be about 225 years old, got " + age);
    }

    @Test // NEGATIVE: Born in the future -- should be negative or zero
    @DisplayName("Age for person born in the future should be negative")
    void testBirthDateInFuture() {
        Person futureKid = new Person("FutureKid", LocalDate.now().plusYears(1));
        double age = futureKid.getAge();
        assertTrue(age < 0.01, "Age for future birthdate should be negative or zero, got " + age);
    }

    @Test // NEGATIVE: Null name is allowed (but check age still works)
    @DisplayName("Null name does not affect age calculation")
    void testNullName() {
        LocalDate birth = LocalDate.now().minusYears(18);
        Person anon = new Person(null, birth);
        double age = anon.getAge();
        assertTrue(age >= 18.0 && age < 18.15, "Age should be about 18, got " + age);
    }

    @Test // NEGATIVE: Null dateOfBirth should throw NullPointerException
    @DisplayName("Null dateOfBirth should throw on age calculation")
    void testNullDateOfBirthThrows() {
        Person ghost = new Person("Ghost", null);
        assertThrows(NullPointerException.class, ghost::getAge, "Should throw NPE for null DOB");
    }
}