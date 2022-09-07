public class Main {
    public static void main(String[] args) {
        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;

        HamburgerBrett hamburgerBrett = new HamburgerBrett(KAPASITET);

        while (true) {
            for (String navn : kokker) {
                new Kokker(hamburgerBrett, navn).start();
            }
            for (String navn : servitorer) {
                new Servitor(hamburgerBrett, navn).start();
            }
        }
    }
}
