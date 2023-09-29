package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job3.getName() instanceof String);
        assertEquals("Product tester", job3.getName());
        assertTrue(job3.getEmployer() instanceof Employer);
        assertEquals("ACME", job3.getEmployer().getValue());
        assertTrue(job3.getLocation() instanceof Location);
        assertEquals("Desert", job3.getLocation().getValue());
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job4.getId() == job5.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String line = System.lineSeparator();
        String expected = line;
        String actual = String.valueOf(job6.toString().charAt(0));
        assertEquals(expected, actual);

        int stringEnd = job6.toString().length();
        String actualTwo = String.valueOf(job6.toString().charAt(stringEnd-1));
        assertEquals(expected, actualTwo);

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String line = System.lineSeparator();
        String expected = line + "ID: " + job7.getId() + line + "Name: " + "Product tester" + line + "Employer: " + "ACME" + line + "Location: " + "Desert" + line + "Position Type: " + "Quality control" + line + "Core Competency: " + "Persistence" + line;
        String actual = job7.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job8 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String line = System.lineSeparator();
        String expected = line + "ID: " + job8.getId() + line + "Name: " + "Data not available" + line + "Employer: " + "Data not available" + line + "Location: " + "Data not available" + line + "Position Type: " + "Data not available" + line + "Core Competency: " + "Data not available" + line;
        String actual = job8.toString();
        assertEquals(expected, actual);

    }
}
