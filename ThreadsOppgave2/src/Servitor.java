import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Servitor extends Thread {
    private String navn;
    private final HamburgerBrett hamburgerBrett;

    public Servitor(HamburgerBrett hamburgerBrett, String navn) {
        this.hamburgerBrett = hamburgerBrett;
        this.navn = navn;
    }

    @Override
    public void run() {
        synchronized (hamburgerBrett) {
            if (!(hamburgerBrett.erTom())) {
                try {
                    int boundedRandomValue = ThreadLocalRandom.current().nextInt(2000, 6000);
                    sleep(boundedRandomValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Hamburger hamburger = hamburgerBrett.remove();
                System.out.println(navn + "(servitør) tar av hamburger <" + hamburger.getHamburgerNummer() + "" +
                        ">. Brett: [" + hamburgerBrett.getAntall() + "]");
                hamburgerBrett.notifyAll();
            }

            if (hamburgerBrett.erTom()) {
                System.out.println(navn + "(Servitør) ønsker å ta hamburger, men brett er tomt. Venter!");
                try {
                    hamburgerBrett.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
