package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job testJob = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob, testJob2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job instanceof Job);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().toString());
        assertEquals("Desert", job.getLocation().toString());
        assertEquals("Quality control", job.getPositionType().toString());
        assertEquals("Persistence", job.getCoreCompetency().toString());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
        assertFalse(job2.equals(job1));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', job4.toString().charAt(0));
        assertEquals('\n', job4.toString().charAt(job4.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        assertTrue(job5.toString().contains("Name: Product Tester"));
        assertTrue(job5.toString().contains("Employer: ACME"));
        assertTrue(job5.toString().contains("Location: Desert"));
        assertTrue(job5.toString().contains("Position Type: Quality control"));
        assertTrue(job5.toString().contains("Core Competency: Persistence"));
        assertEquals(4, job5.getId());
        assertEquals("Product tester", job5.getName());
        assertEquals("ACME", job5.getEmployer().toString());
        assertEquals("Desert", job5.getLocation().toString());
        assertEquals("Quality control", job5.getPositionType().toString());
        assertEquals("Persistence", job5.getCoreCompetency().toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job5 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals("\nID: 3\nName: Data not available\nEmployer: Data not available\nLocation: Data not available\nPosition Type: Data not available\nCore Competency: Data not available\n",job5.toString());
    }

}

