public class Main {
    public static void main(String[] args) {
        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};

        HamburgerBrett hamburgerBrett = new HamburgerBrett();

        for (String navn: kokker) {
            new Thread(new Kokk(hamburgerBrett, navn)).start();
        }
        for (String navn: servitorer) {
            new Thread(new Servitor(hamburgerBrett, navn)).start();
        }
    }
}
