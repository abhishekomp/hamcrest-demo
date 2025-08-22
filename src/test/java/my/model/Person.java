package my.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * A Person with a name and date of birth (as LocalDate).
 * Calculates the current age as a double (years, with fractional part).
 */
public class Person {
    private final String name;
    private final LocalDate dateOfBirth;

    public Person(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() { return name; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }

    /**
     * Calculates the age in years as a double (including fractional years, e.g., 25.5).
     * Uses the current date as "now".
     */
    public double getAge() {
        LocalDate now = LocalDate.now();
        // Total days between DOB and now
        long days = ChronoUnit.DAYS.between(dateOfBirth, now);
        // Approximate as years
        double years = days / 365.2425; // account for leap years!
        return years;
    }
}