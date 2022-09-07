import java.util.concurrent.ThreadLocalRandom;

public class Servitor implements Runnable{
    private HamburgerBrett hamburgerBrett;
    private String navn;

    public Servitor(HamburgerBrett hamburgerBrett, String navn) {
        this.hamburgerBrett = hamburgerBrett;
        this.navn = navn;
    }


    @Override
    public void run() {
        while (true) {
            try {
                int boundedRandomValue = ThreadLocalRandom.current().nextInt(2000, 6000);
                Thread.sleep(boundedRandomValue);
                Hamburger hamburger = hamburgerBrett.takeHamburger();
                System.out.println(navn + "(servitør) tar av hamburger <" + hamburger.getId() + ">. Brett: [" +
                        hamburgerBrett.antallHamburgere() + "]");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
