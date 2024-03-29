import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

import java.util.Random;
import java.util.function.Function;

import java.io.IOException;

public class Jhava {

    public static void main(String[] args) {
        System.out.println(Hero.makeProclamation());

        System.out.println("Spells:");
        Spellbook spellbook = new Spellbook();
        for (String spell : spellbook.spells) {
            System.out.println(spell);

        }

        System.out.println("Max spell count: " + Spellbook.MAX_SPELL_COUNT);
        Spellbook.getSpellbookGreeting();

        Function1<String, Unit> translator = Hero.getTranslator();

        translator.invoke("TRUCE");


    }

    private int hitPoints = 52489112;
    private String greeting = "BLARGH";
    @NotNull
    public String utterGreeting() {
        return greeting;
    }






    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
    @Nullable
    public String determineFriendshipLevel() {
        return null;
    }

    public int getHitPoints() {
        return hitPoints;
    }
    public void offerFood() {
        Hero.handOverFood("mm");
    }

    public void extendHandInFriendship() throws Exception {
        throw new Exception();
    }
    public void apologize() {
        try {
            Hero.acceptApology();
        } catch (IOException e) {
            System.out.println("Caught!");
        }
    }

}
