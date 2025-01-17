package pl.kurs.java.zadanie02.model;

import lombok.Getter;
import pl.kurs.java.zadanie02.interfaces.DrugControler;

import java.util.ArrayList;
import java.util.List;


@Getter
public abstract class Drug {
    private final String name;

    private final double pricePerGram;
    private int quality = 100;
    private final List<Ingredients> ingredients;

    private DrugControler drugControler;

    public List<DrugDealer> drugs = new ArrayList<>();

    public Drug(String name, double pricePerGram, List<Ingredients> ingredients) {
        Check.listSizeNotBelow3(ingredients);
        Check.nameNotNull(name);
        Check.pricePerGramNotNegative(pricePerGram);
        this.name = name;
        this.pricePerGram = pricePerGram;
        this.ingredients = ingredients;
    }


    public void checkQuality() {
        List<Ingredients> schowek = new ArrayList<>(ingredients);

        for(Ingredients element : schowek) {
            int value = element.getQuality();
            quality -= value;
        }
        drugControler.checkDrug(quality > 70);
    }
    public abstract double countPrice();


    @Override
    public String toString() {
        return "Drug{" +
                "name='" + name + '\'' +
                ", pricePerGram=" + pricePerGram +
                ", ingredients=" + ingredients +
                '}';
    }

}