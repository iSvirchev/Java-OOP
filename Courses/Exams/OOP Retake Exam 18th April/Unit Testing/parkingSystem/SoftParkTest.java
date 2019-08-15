package parkingSystem;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;


public class SoftParkTest {

    private SoftPark softPark;

    @Before
    public void initializeParking() {
        this.softPark = new SoftPark();
    }

    @Test
    public void testValidConstructor(){
        int actualPartCount = softPark.getParking().size();

        Assert.assertEquals(12,actualPartCount);
    }

    @Test
    public void testCar(){
        this.softPark = new SoftPark();
        Car car = new Car("someCar","6969");

        Assert.assertTrue(car.getMake().getClass().getSimpleName().equalsIgnoreCase("string"));
    }

    @Test(expected =  UnsupportedOperationException.class)
    public void getParkingShouldReturnUnmodifiableMap(){
        Map<String, Car> parking = softPark.getParking();
        parking.clear();
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionIfParkingSpotDoesNotExist(){
        Car car = new Car("someCar","6969");
        softPark.parkCar("D1",car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void parkCarShouldThrowExceptionIfParkingSpotNotNull(){
        Car car = new Car("someCar","6969");
        softPark.parkCar("A1",car);
        softPark.parkCar("A1",car);
    }

    @Test(expected = IllegalStateException.class)
    public void parkCarShouldThrowExceptionIfThereIsAParkedCar(){
        Car car = new Car("someCar","6969");
        Car car2 = new Car("otherCar","9696");
        softPark.parkCar("A1",car);
        softPark.parkCar("A2",car2);
    }

    @Test
    public void parkCarShouldReturnString(){
        Car car = new Car("someCar","6969");

        Assert.assertTrue(softPark.parkCar("A1", car).getClass().getSimpleName().equalsIgnoreCase("string"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionIfParkingSpotDoesNotExist(){
        Car car = new Car("someCar","6969");
        softPark.removeCar("D1",car);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeCarShouldThrowExceptionIfNoCarOnParkingSpot(){
        Car car = new Car("someCar","6969");
        softPark.parkCar("A1",car);
        softPark.removeCar("A2",car);
    }

    @Test
    public void removeCarShouldSetMapValueToNull(){
        Car car = new Car("someCar","6969");
        softPark.parkCar("A1",car);
        softPark.removeCar("A1",car);

        Assert.assertNull(softPark.getParking().get("A1"));
    }

    @Test
    public void removeCarShouldReturnString(){
        Car car = new Car("someCar","6969");
        softPark.parkCar("A1", car);

        Assert.assertTrue(softPark.removeCar("A1",car).getClass().getSimpleName().equalsIgnoreCase("string"));
    }

}