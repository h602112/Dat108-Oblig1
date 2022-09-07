import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class HamburgerBrett {
    private BlockingQueue<Hamburger> hamburgerBrett;
    private int hamburgerId;

    public HamburgerBrett() {
        hamburgerBrett = new LinkedBlockingDeque<>(4);
        hamburgerId = 1;
    }

    public void addHamburger(Hamburger hamburger) throws InterruptedException {
        hamburgerBrett.put(hamburger);
    }

    public Hamburger takeHamburger() throws InterruptedException {
        return hamburgerBrett.take();
    }

    public int antallHamburgere() {
        return hamburgerBrett.size();
    }

    public int getHamburgerId() {
        return hamburgerId;
    }

    public void incrementHamburgerId() {
        hamburgerId++;
    }


}
