package easy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BadgeTest {

    @Test
    @Tag("task:1")
    @DisplayName("Printing a badge for an employee")
    public void labelForEmployee() {
        Badge badge = new Badge();
        assertEquals("[17] - Ryder Herbert - MARKETING", badge.print(17, "Ryder Herbert", "Marketing"));
    }

    @Test
    @Tag("task:2")
    @DisplayName("Printing a badge for a new employee")
    public void labelForNewEmployee() {
        Badge badge = new Badge();
        assertEquals("Bogdan Rosario - MARKETING", badge.print(null, "Bogdan Rosario", "Marketing"));
    }

    @Test
    @Tag("task:3")
    @DisplayName("Printing a badge for the owner")
    public void labelForOwner() {
        Badge badge = new Badge();
        assertEquals("[59] - Julie Sokato - OWNER", badge.print(59, "Julie Sokato", null));
    }

    @Test
    @Tag("task:3")
    @DisplayName("Printing a badge for the owner who is a new employee")
    public void labelForNewOwner() {
        Badge badge = new Badge();
        assertEquals("Amare Osei - OWNER", badge.print(null, "Amare Osei", null));
    }

}
