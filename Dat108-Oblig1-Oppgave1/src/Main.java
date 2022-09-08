import javax.swing.*;

public class Main {

    private static boolean running = true;
    public static void main(String[] args) {
        ThreadOutput threadOutput = new ThreadOutput();
        threadOutput.start();

        ThreadInputOutput threadInputOutput = new ThreadInputOutput();
        threadInputOutput.start();


    }

    public static class ThreadOutput extends Thread {
        public void run() {
            while (running) {
                System.out.println("Hello World");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (Thread.interrupted()) {
                    return;
                }
            }
        }
        public void stopRunning() {
            running = false;
        }
    }

    public static class ThreadInputOutput extends Thread {
        public void run() {
            running = true;
            while (running) {
                String message = JOptionPane.showInputDialog("Type your message, type quit to exit");
                System.out.println(message);
                if (message.equals("quit")) {
                    running = false;
                }
                if (Thread.interrupted()) {
                    return;
                }
            }
        }
    }
}
