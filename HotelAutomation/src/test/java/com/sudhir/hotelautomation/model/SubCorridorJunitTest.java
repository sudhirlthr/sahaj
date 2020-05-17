package com.sudhir.hotelautomation.model;

import com.sudhir.hotelautomation.interfaces.Instruments;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class SubCorridorJunitTest {

    private SubCorridorImpl subCorridor;

    @Before
    public void init(){
        subCorridor = new SubCorridorImpl(1);
    }

    @Test
    public void testSubCorridorId(){
        Assert.assertNotNull(subCorridor.getSubcorridorId());
    }
    @Test
    public void testSubCorriodrACDefaultStatus(){
        Assert.assertTrue(subCorridor.getAC_ON());
    }
    @Test
    public void testSubCorriodrLightStatus(){
        Assert.assertFalse(subCorridor.getLight_ON());
    }
    @Test
    public void testSubCorriodrACasInstrument(){
        Assert.assertTrue(subCorridor.getSubcorridor_ac().equals(Instruments.AC));
    }
    @Test
    public void testSubCorriodrLightInstrument(){
        Assert.assertTrue(subCorridor.getSubcorridor_light().equals(Instruments.LIGHT));
    }
    @Test
    public void testSubCorriodrHashCode(){
        Assert.assertFalse(subCorridor.hashCode() == new SubCorridorImpl(10).hashCode());
    }
    @Test
    public void testSubCorriodrEquality(){
        Assert.assertFalse(subCorridor.equals(new SubCorridorImpl(44)));
    }
    @Test
    public void testDifferentSubCorriodrLightInstrumentEquality(){
        SubCorridorImpl newSubCorridor = new SubCorridorImpl(55);
        Assert.assertTrue(newSubCorridor.getSubcorridor_light().equals(subCorridor.getSubcorridor_light()));
    }

    @Test
    public void testDifferentSubCorriodrACInstrumentEquality(){
        SubCorridorImpl newSubCorridor = new SubCorridorImpl(55);
        Assert.assertTrue(newSubCorridor.getSubcorridor_ac().equals(subCorridor.getSubcorridor_ac()));
    }
    @Test
    public void testDifferentSubCorriodrACDefaultStatus(){
        SubCorridorImpl newSubCorridor = new SubCorridorImpl(55);
        Assert.assertTrue(newSubCorridor.getAC_ON().equals(subCorridor.getAC_ON()));
    }
    @Test
    public void testDifferentSubCorriodrLightDefaultStatus(){
        SubCorridorImpl newSubCorridor = new SubCorridorImpl(55);
        Assert.assertTrue(newSubCorridor.getLight_ON().equals(subCorridor.getLight_ON()));
    }

}
