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

}
