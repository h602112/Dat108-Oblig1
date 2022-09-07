import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Kokk implements Runnable {
    private HamburgerBrett hamburgerBrett;
    private String navn;


    public Kokk(HamburgerBrett hamburgerBrett, String navn) {
        this.hamburgerBrett = hamburgerBrett;
        this.navn = navn;
    }


    @Override
    public void run() {
        while (true) {
            try {
                int boundedRandomValue = ThreadLocalRandom.current().nextInt(2000, 6000);
                Thread.sleep(boundedRandomValue);
                lagHamburger();
                System.out.println(navn + "(kokk) legger på hamburger <" + hamburgerBrett.getHamburgerId() + ">. Brett: [" +
                        hamburgerBrett.antallHamburgere() + "]");
                hamburgerBrett.incrementHamburgerId();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void lagHamburger() throws InterruptedException {
        Hamburger hamburger = new Hamburger(hamburgerBrett.getHamburgerId());
        hamburgerBrett.addHamburger(hamburger);
    }
}
