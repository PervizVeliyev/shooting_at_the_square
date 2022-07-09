import java.util.Random;
import java.util.Scanner;

public class ShootingAtTheSquare {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int target2;
        int target3;
        int targetsDefeated = 0;
        int horizontalOrVertical = random.nextInt(2);
        int random1 = random.nextInt(1, 6);
        int random2 = random.nextInt(1, 6);

        char[][] square = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k < 5; k++) {
                square[i][k] = '-';
            }
        }

        if(horizontalOrVertical == 0) {
            if(random2 - 1 != 0 && random2 + 1 != 6){
                target2 = random2 - 1;
                target3 = random2 + 1;
            }
            else if(random2 - 1 == 0) {
                target2 = random2 + 1;
                target3 = target2 + 1;
            }
            else {
                target2 = random2 - 1;
                target3 = target2 - 1;
            }
        }
        else {
            if(random1 - 1 != 0 && random1 + 1 != 6){
                target2 = random1 - 1;
                target3 = random1 + 1;
            }
            else if(random2 - 1 == 0) {
                target2 = random1 + 1;
                target3 = target2 + 1;
            }
            else {
                target2 = random1 - 1;
                target3 = target2 - 1;
            }
        }

        System.out.println("All set. Get ready to rumble!\nYou have 5x5 square game field to shoot.");
        while (true) {
            int line;
            int bar;
            try {
                System.out.print("Enter a line for fire:");
                line = scanner.nextInt();
                if (line > 5 || line < 1) {
                    System.out.println("Please, enter a number in range of 1-5!");
                    continue;
                }
                System.out.print("Enter a shooting bar:");
                bar = scanner.nextInt();
                if (bar > 5 || bar < 1) {
                    System.out.println("Please, enter a number in range of 1-5!");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Please, enter a number in range of 1-5!");
                scanner.nextLine();
                continue;
            }

            if (line == random1 && bar == random2) square[line - 1][bar - 1] = 'x';
            else square[line - 1][bar - 1] = '*';

            if(horizontalOrVertical == 0){
                if(line == random1 && (bar == target2 || bar == target3)) square[line - 1][bar - 1] = 'x';
            }
            if (horizontalOrVertical == 1){
                if(bar == random2 && (line == target2 || line == target3)) square[line - 1][bar - 1] = 'x';
            }

            System.out.println("Game field:\n0 | 1 | 2 | 3 | 4 | 5 |");

            for (int i = 1; i < 6; i++) {
                System.out.print(i + " | ");
                int k;

                for (k = 0; k < 5; k++) {
                    System.out.print(square[i - 1][k] + " | ");
                    if (k == 4) System.out.println();
                }
            }

            if(line == random1 && bar == random2) targetsDefeated++;
            if(horizontalOrVertical == 0 && ((line == random1 && bar == target2) || (line == random1 && bar == target3))) targetsDefeated++;
            if(horizontalOrVertical == 1 && ((line == target2 && bar == random2) || (line == target3 && bar == random2))) targetsDefeated++;

            if (targetsDefeated == 3) {
                System.out.println("You have won!");
                break;
            }
        }
    }
}
