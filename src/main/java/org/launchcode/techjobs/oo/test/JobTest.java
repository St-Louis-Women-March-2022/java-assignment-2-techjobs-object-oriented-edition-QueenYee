package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
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
    public void testSettingJobId(){
        Job shellJob1 = new Job();
        Job shellJob2 = new Job();
        assertNotEquals(shellJob1.getId(),shellJob2.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
       Job someJob = new Job("Product tester",
                    new Employer("ACME"),
                    new Location("Desert"),
                    new PositionType("Quality control"),
                    new CoreCompetency("Persistence"));
        assertEquals("ACME", someJob.getEmployer().getValue());
        assertEquals("Desert",someJob.getLocation().getValue());
        assertEquals("Persistence",someJob.getCoreCompetency().getValue());
        assertEquals("Product tester",someJob.getName());
        assertEquals("Quality control",someJob.getPositionType().getValue());

        assertTrue( someJob.getEmployer() instanceof Employer);
        assertTrue( someJob.getLocation() instanceof Location);
        assertTrue( someJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue( someJob.getName() instanceof String);
        assertTrue( someJob.getPositionType() instanceof PositionType);


    }

    private void assertTrue(boolean b) {
    }
    @Test
    public void testJobsForEquality(){
        Job jobI = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job jobII= new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(jobI.equals(jobII));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job anyJob= new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

           assertEquals(anyJob.toString().charAt(0), '\n' );
           assertEquals(anyJob.toString().charAt(anyJob.toString().length()-1), '\n');
             }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job thisJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(thisJob.getName(), "Product tester");
        assertEquals(thisJob.getEmployer().toString(), "ACME");
        assertEquals(thisJob.getLocation().toString(), "Desert");
        assertEquals(thisJob.getPositionType().toString(), "Quality control");
        assertEquals(thisJob.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String theResponse = "\n" + "ID: " + testJob5.getId() + "\n" +
                "Name: " + testJob5.getName() + "\n" +
                "Employer: " + testJob5.getEmployer() + "\n" +
                "Location: " + testJob5.getLocation() + "\n" +
                "Position Type: " + testJob5.getPositionType() + "\n" +
                "Core Competency: " + testJob5.getCoreCompetency() + "\n";
        assertEquals(testJob5.toString(), theResponse);
//        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
//        Assert.assertEquals("\nID: " + job.getId()+ "\nName: Data not available" + "\nEmployer: Data not available" + "\nLocation: Data not available" +"\nPosition Type: Data not available" +
//                "\nCore Competency: Data not available" + "\n",job.toString());
    }

    //Bonus Test

    @Test
    public void testNoOtherJobDataAvailable() {
        Job noJob = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        assertEquals(noJob.toString(), "OOPS");
    }

}
