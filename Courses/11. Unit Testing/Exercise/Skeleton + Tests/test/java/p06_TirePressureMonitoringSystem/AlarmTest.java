package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;


public class AlarmTest {

    @Test
    public void alarmShouldBeOnIfOutOfRange() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm = new Alarm();

        Field reflectedSensor = Alarm.class.getDeclaredField("sensor");
        reflectedSensor.setAccessible(true);

        Sensor mockSensor = Mockito.mock(Sensor.class);
        Mockito.when(mockSensor.popNextPressurePsiValue()).thenReturn(12.0);

        reflectedSensor.set(alarm,mockSensor);
        alarm.check();
        Assert.assertTrue(alarm.getAlarmOn());
    }

}