import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyMassIndexTest {

    @Test
    public void calculateScore() {
        BodyMassIndex bmi = new BodyMassIndex(73, 210);
        assertEquals(27.70313379620942,bmi.calculateScore(73,210));
    }

    @Test
    public void determineCategory() {
        BodyMassIndex bmi1 = new BodyMassIndex(73,210);
        assertEquals("Overweight", bmi1.determineCategory(27.7));

        BodyMassIndex bmi2 = new BodyMassIndex(60,200);
        assertEquals("Obesity", bmi2.determineCategory(39.1));

        BodyMassIndex bmi3 = new BodyMassIndex(73,180);
        assertEquals("Normal", bmi3.determineCategory(23.7));

        BodyMassIndex bmi4 = new BodyMassIndex(73,135);
        assertEquals("Underweight", bmi4.determineCategory(17.8));
    }
}