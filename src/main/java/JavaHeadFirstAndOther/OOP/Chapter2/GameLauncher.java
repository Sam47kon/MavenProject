package JavaHeadFirstAndOther.OOP.Chapter2;

public class GameLauncher {

    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        game.startGame();
    }
}

class Player {
    int number;

    void guess() {
        number = (int) (Math.random() * 10 + 1);
    }
}

class GuessGame {
    private Player p1;
    private Player p2;
    private Player p3;

    void startGame() {
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessp1;
        int guessp2;
        int guessp3;

        boolean p1isRight = false;
        boolean p2isRight = false;
        boolean p3isRight = false;

        int targetNumber = (int) (Math.random() * 10 + 1);
        System.out.println("Загадано число от 1 - 10");

        while (true) {
            System.out.println("Загаданное число: " + targetNumber);
            p1.guess();
            p2.guess();
            p3.guess();

            guessp1 = p1.number;
            System.out.println("Число 1 игрока: " + guessp1);

            guessp2 = p2.number;
            System.out.println("Число 2 игрока: " + guessp2);

            guessp3 = p3.number;
            System.out.println("Число 3 игрока: " + guessp3);

            if (guessp1 == targetNumber) {
                p1isRight = true;
            }

            if (guessp2 == targetNumber) {
                p2isRight = true;
            }

            if (guessp3 == targetNumber) {
                p3isRight = true;
            }

            if (p1isRight || p2isRight || p3isRight) {
                System.out.println("Есть победители!");
                System.out.println("1 игрок " + (p1isRight ? "угадал!" : "не угадал!"));
                System.out.println("2 игрок " + (p2isRight ? "угадал!" : "не угадал!"));
                System.out.println("3 игрок " + (p3isRight ? "угадал!" : "не угадал!"));
                System.out.println("Конец игры");
                break;
            }
            System.out.println("Никто не угадал. еще раз...");
        }
    }
}
