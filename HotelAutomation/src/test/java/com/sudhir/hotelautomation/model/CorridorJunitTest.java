package com.sudhir.hotelautomation.model;

import com.sudhir.hotelautomation.interfaces.Instruments;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class CorridorJunitTest {

        private CorridorImpl corridor;

        @Before
        public void init(){
        corridor = new CorridorImpl(1, Instruments.AC, Instruments.LIGHT);
    }

        @Test
        public void testCorridorId(){
        Assert.assertNotNull(corridor.getCorridorId());
    }
        @Test
        public void testCorriodrACDefaultStatus(){
        Assert.assertTrue(corridor.getAC_ON());
    }
        @Test
        public void testSubCorriodrLightStatus(){
        Assert.assertFalse(corridor.getLight_ON());
    }
        @Test
        public void testCorriodrACasInstrument(){
        Assert.assertTrue(corridor.getCorridor_ac().equals(Instruments.AC));
    }
        @Test
        public void testCorriodrLightInstrument(){
        Assert.assertTrue(corridor.getCorridor_light().equals(Instruments.LIGHT));
    }
        @Test
        public void testCorriodrHashCode(){
        Assert.assertFalse(corridor.hashCode() == new CorridorImpl(new Random().nextInt(), Instruments.AC, Instruments.LIGHT).hashCode());
    }
        @Test
        public void testSubCorriodrEquality(){
        Assert.assertFalse(corridor.equals(new CorridorImpl(new Random().nextInt(), Instruments.AC, Instruments.LIGHT)));
    }
        @Test
        public void testDifferentSubCorriodrLightInstrumentEquality(){
        CorridorImpl newCorridor = new CorridorImpl(new Random().nextInt(), Instruments.AC, Instruments.LIGHT);
        Assert.assertTrue(newCorridor.getCorridor_light().equals(corridor.getCorridor_light()));
    }

        @Test
        public void testDifferentSubCorriodrACInstrumentEquality(){
        CorridorImpl newCorridor = new CorridorImpl(new Random().nextInt(), Instruments.AC, Instruments.LIGHT);
        Assert.assertTrue(newCorridor.getCorridor_ac().equals(corridor.getCorridor_ac()));
    }
        @Test
        public void testDifferentSubCorriodrACDefaultStatus(){
        CorridorImpl newCorridor = new CorridorImpl(new Random().nextInt(), Instruments.AC, Instruments.LIGHT);
        Assert.assertTrue(newCorridor.getAC_ON().equals(corridor.getAC_ON()));
    }
        @Test
        public void testDifferentSubCorriodrLightDefaultStatus(){
        CorridorImpl newCorridor = new CorridorImpl(new Random().nextInt(), Instruments.AC, Instruments.LIGHT);
        Assert.assertTrue(newCorridor.getLight_ON().equals(corridor.getLight_ON()));
    }
    @Test
    public void testCorridorIdEquality(){
        CorridorImpl another_corridor = new CorridorImpl(new Random().nextInt(), Instruments.AC, Instruments.LIGHT);
        Assert.assertFalse(another_corridor.getCorridorId().equals(corridor.getCorridorId()));
    }
}
