package Task1;

public class TimerThread {
    private static int secondsPassed = 0;

    public static void main(String[] args) {
        Thread timeThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    secondsPassed++;
                    System.out.println("Пройшло " + secondsPassed + " секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread messageThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        timeThread.start();
        messageThread.start();
    }
}
