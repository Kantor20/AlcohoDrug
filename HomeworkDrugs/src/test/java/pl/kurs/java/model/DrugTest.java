package pl.kurs.java.model;

import org.junit.Assert;
import org.junit.Test;
import pl.kurs.java.zadanie02.exceptions.NameIsNullExceptions;
import pl.kurs.java.zadanie02.exceptions.NotEnoughIngrediensInDrugException;
import pl.kurs.java.zadanie02.exceptions.PriceIsLessThanZeroException;
import pl.kurs.java.zadanie02.model.Cocaine;
import pl.kurs.java.zadanie02.model.Ingredients;
import pl.kurs.java.zadanie02.model.Lsd;
import pl.kurs.java.zadanie02.model.Mdma;

import java.util.List;

public class DrugTest {

    @Test(expected = BadDrugQualityException.class)
    public void shouldThrowBadDrugQualityException() {
        Lsd lsdWithBadQuality = new Lsd("LSD", 15.0, List.of(Ingredients.ACID, Ingredients.ACID,  Ingredients.ACID), 5);
        lsdWithBadQuality.checkDrug();
    }
    @Test
    public void shouldNotThrowBadDrugQualityException(){
        Lsd lsdWithBadQuality = new Lsd("LSD", 15.0, List.of(Ingredients.GLASS, Ingredients.GLASS,  Ingredients.ACID), 5);
        lsdWithBadQuality.checkDrug();
    }
    
    @Test(expected = NotEnoughIngrediensInDrugException.class)
    public void shouldThrowNotEnoughIngrediensInDrugException() {
        Lsd lsd = new Lsd("LSD", 34.12, List.of(Ingredients.ACID, Ingredients.FLOUR), 5);
    }

    @Test(expected = PriceIsLessThanZeroException.class)
    public void shouldThrowPriceIsLessThanZeroException() {
        Lsd lsd = new Lsd("LSD", -34.12, List.of(Ingredients.FLOUR, Ingredients.ACID, Ingredients.FLOUR), 5);

    }

    @Test(expected = NameIsNullExceptions.class)
    public void shouldThrowNameIsNullExceptions() {
        Lsd lsd = new Lsd(null, -34.12, List.of(Ingredients.FLOUR, Ingredients.ACID, Ingredients.FLOUR), 5);

    }

    @Test
    public void shouldCountMdmaPriceCorrect() {
        Mdma mdma = new Mdma("mdma", 10.0, List.of(Ingredients.FLOUR, Ingredients.ACID, Ingredients.FLOUR));
        mdma.dlugoscFazy = 10;
        double expectedPrice = 103.0;
        Assert.assertEquals(expectedPrice, mdma.countPrice(), 0.01);
    }

    @Test
    public void shouldCountLsdPriceCorrect() {
        Lsd lsd = new Lsd("lsd", 5.5, List.of(Ingredients.FLOUR, Ingredients.ACID, Ingredients.FLOUR), 2);
        double expectedPrice = 55.0;
        Assert.assertEquals(expectedPrice, lsd.countPrice(), 0.01);
    }

    @Test
    public void shouldCountCocainePriceCorrect() {
        Cocaine lsd = new Cocaine("cocaine", 51.7, List.of(Ingredients.FLOUR, Ingredients.ACID, Ingredients.FLOUR));
        double expectedPrice = 77.55;
        Assert.assertEquals(expectedPrice, lsd.countPrice(), 0.01);
    }
}
