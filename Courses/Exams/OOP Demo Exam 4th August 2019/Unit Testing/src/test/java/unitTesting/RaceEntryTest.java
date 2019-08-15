package unitTesting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RaceEntryTest {
    private RaceEntry raceEntry;
    private UnitRider firstRider;
    private UnitMotorcycle firstMotorcycle;

    @Before
    public void initializeRaceEntry(){
        this.raceEntry = new RaceEntry();
        this.firstMotorcycle = new UnitMotorcycle("model",69,69);
        this.firstRider = new UnitRider("Ghost", firstMotorcycle);
    }

    @Test
    public void constructorShouldWork(){
        Assert.assertNotNull(raceEntry);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getRidersShouldThrowExceptionIfAttemptToModify(){
        this.raceEntry.getRiders().clear();
    }

    @Test(expected = NullPointerException.class)
    public void addRiderShouldThrowExceptionIfRiderIsNull(){
        firstRider = null;
        raceEntry.addRider(firstRider);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRiderShouldThrowExceptionIfRiderAlreadyAdded(){
        this.raceEntry.addRider(firstRider);
        this.raceEntry.addRider(firstRider);
    }

    @Test
    public void addRiderShouldAddRiderToRaceEntry(){
        this.raceEntry.addRider(firstRider);
        Assert.assertTrue(raceEntry.getRiders().contains(firstRider));
    }

    @Test
    public void addRiderShouldReturnString(){
        Assert.assertEquals("Rider Ghost added in race.",this.raceEntry.addRider(firstRider));
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateAvgHPShouldThrowExceptionIfLessThanMIN_PARTICIPANTS(){
        this.raceEntry.addRider(firstRider);
        this.raceEntry.calculateAverageHorsePower();
    }

    @Test
    public void calculateAvgHPShouldReturnAvgHP(){
        this.raceEntry.addRider(firstRider);
        UnitRider rider = new UnitRider("Shit",firstMotorcycle);
        this.raceEntry.addRider(rider);

        Assert.assertEquals(this.raceEntry.calculateAverageHorsePower(),firstMotorcycle.getHorsePower(),0.001);
    }

    @Test
    public void motorcycleGetModelShouldWork(){
        Assert.assertEquals(firstMotorcycle.getModel(),"model");
    }

    @Test
    public void motorcycleGetCubicCentimetersShouldWork(){
        Assert.assertEquals(firstMotorcycle.getCubicCentimeters(),69,0.001);
    }

}
