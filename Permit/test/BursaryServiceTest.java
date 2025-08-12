/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import permit.BursaryService;

class BursaryServiceTest {

    private BursaryService svc;

    @BeforeEach
    void setUp() { svc = new BursaryService(); }

    // Decision table (year>=2? and avg>=80?)
    @ParameterizedTest
    @CsvSource({ "2,80", "3,95.5", "4,100" })
    void eligible_whenYearAndAvgMeetThreshold(int year, double avg) {
        assertTrue(svc.getsBursary(year, avg));
    }

    @ParameterizedTest
    @CsvSource({ "2,79.99", "5,60", "10,0" })
    void notEligible_whenAvgBelowThreshold(int year, double avg) {
        assertFalse(svc.getsBursary(year, avg));
    }

    @ParameterizedTest
    @CsvSource({ "1,100", "1,80", "1,79.99" })
    void notEligible_whenYearBelowThreshold(int year, double avg) {
        assertFalse(svc.getsBursary(year, avg));
    }

    // Boundaries
    @Test void boundary_exactThreshold_true() { assertTrue(svc.getsBursary(2, 80.0)); }
    @Test void boundary_justBelowAvg_false()  { assertFalse(svc.getsBursary(2, Math.nextDown(80.0))); }
    @Test void boundary_justBelowYear_false() { assertFalse(svc.getsBursary(1, 80.0)); }

    // Validation (keep if your method throws)
    @ParameterizedTest @CsvSource({ "0", "-1" })
    void throwsForInvalidYear(int badYear) {
        assertThrows(IllegalArgumentException.class, () -> svc.getsBursary(badYear, 75));
    }
    @ParameterizedTest @CsvSource({ "-0.01", "100.01" })
    void throwsForInvalidAverage(double badAvg) {
        assertThrows(IllegalArgumentException.class, () -> svc.getsBursary(2, badAvg));
    }
    @Test
    void throwsForNaN() { assertThrows(IllegalArgumentException.class, () -> svc.getsBursary(2, Double.NaN)); }
}

