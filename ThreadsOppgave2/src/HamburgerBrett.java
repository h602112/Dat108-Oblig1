import java.util.LinkedList;

public class HamburgerBrett {
    private LinkedList<Hamburger> hamburgerBrett;
    private int kapasitet;
    private int antall;
    private int hamburgerNummer;
    public HamburgerBrett(int kapasitet) {
        hamburgerBrett = new LinkedList<>();
        int antall = 0;
        this.kapasitet = kapasitet;
        hamburgerNummer = 1;
    }

    public int getAntall() {
        return antall;
    }

    public synchronized void add(Hamburger hamburger) {
        if (antall < kapasitet) {
            hamburgerBrett.add(hamburger);
            antall++;
            hamburgerNummer++;
        }
    }

    public synchronized Hamburger remove() {
        antall--;
        return hamburgerBrett.remove();
    }

    public boolean erTom() {
        return antall==0;
    }

    public int getHamburgerNummer() {
        return hamburgerNummer;
    }
    public boolean erFull() {
        return antall==kapasitet;
    }
}
