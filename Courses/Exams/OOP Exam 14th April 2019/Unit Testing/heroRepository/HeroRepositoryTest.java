package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    private HeroRepository heroRepository;
    private Item item;
    private Hero hero;
    private Item secondItem;

    @Before
    public void initializeRepository() {
        heroRepository = new HeroRepository();
        this.item = new Item(10, 10, 10);
        this.hero = new Hero("Ivan", 20, this.item);
        this.secondItem = new Item(11,11,11);
    }

    @Test
    public void getCountShouldWork(){
        heroRepository.add(hero);
        hero = new Hero("sds",12,item);
        heroRepository.add(hero);

        Assert.assertEquals(heroRepository.getCount(),2);
    }

    @Test
    public void constructorShouldWork() {
        Assert.assertNotNull(heroRepository);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addShouldThrowExceptionIfDuplicateHeroAdded() {
        heroRepository.add(hero);
        heroRepository.add(hero);
    }

    @Test
    public void addShouldAddHero() {
        heroRepository.add(hero);

        Assert.assertEquals(1, heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void removeShouldThrowExceptionWhenHeroIsNotFound() {
        heroRepository.add(hero);
        heroRepository.remove("asd");
    }

    @Test
    public void removeShouldRemoveHero() {
        heroRepository.add(hero);
        Hero removeHero = new Hero("Gosho", 20, secondItem);
        heroRepository.add(removeHero);
        int initialSize = heroRepository.getCount();
        heroRepository.remove("Gosho");

        int reducedSize = heroRepository.getCount();

        Assert.assertTrue(reducedSize < initialSize);
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityShouldThrowExceptionIfNoHeroes(){
        heroRepository.getHeroWithHighestAgility();
    }

    @Test
    public void getHeroWithHighestAgilityShouldWork(){
        heroRepository.add(hero);
        Hero secondHero = new Hero("Gosho",20,secondItem);
        heroRepository.add(secondHero);

        Assert.assertEquals(heroRepository.getHeroWithHighestAgility(),secondHero);
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceShouldThrowExceptionIfNoHeroes(){
        heroRepository.getHeroWithHighestIntelligence();
    }

    @Test
    public void getHeroWithHighestIntelligenceShouldWork(){
        heroRepository.add(hero);
        Hero secondHero = new Hero("Gosho",20,secondItem);
        heroRepository.add(secondHero);

        Assert.assertEquals(heroRepository.getHeroWithHighestIntelligence(),secondHero);
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthShouldThrowExceptionIfNoHeroes(){
        heroRepository.getHeroWithHighestStrength();
    }

    @Test
    public void getHeroWithHighestStrengthShouldWork(){
        heroRepository.add(hero);
        Hero secondHero = new Hero("Gosho",20,secondItem);
        heroRepository.add(secondHero);

        Assert.assertEquals(heroRepository.getHeroWithHighestStrength(),secondHero);
    }

    @Test
    public void toStringShouldWork(){  // TODO: needs work
        Hero secondHero = new Hero ("Gosho", 20, secondItem);
        heroRepository.add(secondHero);

        Assert.assertTrue(heroRepository.toString().contains("Gosho"));
    }




}