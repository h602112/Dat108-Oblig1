import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Kokker extends Thread {
    private String navn;
    private final HamburgerBrett hamburgerBrett;

    public Kokker(HamburgerBrett hamburgerBrett, String navn) {
        this.hamburgerBrett = hamburgerBrett;
        this.navn = navn;
    }

    @Override
    public void run() {
        synchronized (hamburgerBrett) {
            if (!(hamburgerBrett.erFull())) {
                try {
                    int boundedRandomValue = ThreadLocalRandom.current().nextInt(2000, 6000);
                    sleep(boundedRandomValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Hamburger hamburger = new Hamburger(hamburgerBrett.getHamburgerNummer());
                hamburgerBrett.add(hamburger);
                System.out.println(navn + "(kokk) legger på hamburger <" + hamburger.getHamburgerNummer() +
                        ">. Brett: [" + hamburgerBrett.getAntall() + "]");
                hamburgerBrett.notifyAll();
            }
            if (hamburgerBrett.erFull()) {
                System.out.println(navn + "(kokk) har hamburger klar, men brettet er fullt, venter");
                try {
                    hamburgerBrett.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
