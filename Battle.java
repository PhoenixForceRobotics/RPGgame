package RPGgame;

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Battle {
    private static Scanner input = new Scanner(System.in);
    private static Random randy = new Random();
    private static int playerHealth = 50;
    private static int enemyHealth = 50;
    public static void main(String[] args) throws InterruptedException {
        System.out.println("An Enemy has appeared!\n(ง｀Д´)ง");
        TimeUnit.SECONDS.sleep(1);
        while ((playerHealth) > 0  && (enemyHealth > 0))
        {
            int playerAttack = PlayerAttack();
            int enemyAttack = EnemyAttack();
            BattleActions(playerAttack, enemyAttack);
            if (playerHealth < 0) {
                playerHealth = 0;
            }
            if (enemyHealth < 0) {
                enemyHealth = 0;
            }
            System.out.println("Player HP: " + playerHealth);
            System.out.println("Enemy HP: " + enemyHealth);
            System.out.println("(ง｀Д´)ง");
            TimeUnit.SECONDS.sleep(1);
        }

        if (enemyHealth > 0) {
            System.out.println("You lost!");
        } else if (playerHealth > 0) {
            System.out.println("You won!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    private static int PlayerAttack() {
        System.out.println("Your move.");
        System.out.print("1: Melee Attack\n2: Ranged Attack\n3: Counter\n4: Defend \n5: Help \n");

        int playerAction = 0;
        String playerChoice = input.nextLine();

            if (playerChoice.equals("1")) {
                System.out.println("You chose to do a Melee Attack!");
                playerAction = 1;
            } else if (playerChoice.equals("2")) {
                System.out.println("You chose to do a Ranged Attack!");
                playerAction = 2;
            } else if (playerChoice.equals("3")) {
                System.out.println("You chose to Counter!");
                playerAction = 3;
            } else if (playerChoice.equals("4")) {
                System.out.println("You chose to Defend!");
                playerAction = 4;
            } else if (playerChoice.equals("5")) {
                playerAction = Help();
            } else {
                System.out.println("That isn't a valid option!");
                playerAction = PlayerAttack();
            }

        return playerAction;
    }

    private static int Help() {   
        System.out.println("What would you like to learn more about? \n1: Melee Attack\n2: Ranged Attack\n3: Counter\n4: Defend\n5: Back");
        String helpselect = input.nextLine();

        if (helpselect.equals("1")) {
            System.out.println("Melee Attack:\nDeals 8-10 Damage.\nOnly half as effective if enemy does the same or Counters.\nDoes no damage if Opponent Defends.");
            return Help();
        } else if (helpselect.equals("2")) {
            System.out.println("Ranged Attack:\nDeals 4-6 Damage. \nOnly half as effective if openent Defends or Melee Attacks. \nTake no Conuter damage.");
            return Help();
        } else if (helpselect.equals("3")) {
            System.out.println("Counter: \nDeals 2-4 Damage if Oppenent Defends or Melee Attacks\nDoes nothing if Oppenent uses Ranged Attack or Counters.");
            return Help();
        } else if (helpselect.equals("4")) {
            System.out.println("Defend: \nDeals no damage.\nStops damage against Melee Attacks.\nStops half of the damage from Ranged Attacks\nDoes nothing if Oppenent Counters or Defends.");
            return Help();
        } else if (helpselect.equals("5")) {
            return PlayerAttack();
        } else {
            System.out.println("That isn't a valid option!");
            return Help();
        }

    }

    private static int EnemyAttack() {
        int enemyChoice = randy.nextInt(4);
        if (enemyChoice == 0) {
            System.out.println("The Enemy chose to do a Melee Attack!");
            return 1;
        } else if (enemyChoice == 1) {
            System.out.println("The Enemy chose to do a Ranged Attack!");
            return 2;
        } else if (enemyChoice == 2) {
            System.out.println("The Enemy chose to Counter!");
            return 3;
        } else if (enemyChoice == 3) {
            System.out.println("The Enemy chose to Defend!");
            return 4;
        } else {
            return 0;
        }
    }

    private static void BattleActions(int player, int enemy) throws InterruptedException {
        if (player == 1) {
            PlayerMelee(enemy);
        } else if (player == 2) {
            PlayerRanged(enemy);
        } else if (player == 3) {
            PlayerCounter(enemy);
        } else if (player == 4) {
            PlayerDefend(enemy);
        }
        
    }

    private static void PlayerMelee(int enemy) throws InterruptedException {
        int enemyDmg = 0;
        int playerDmg = 0;

        enemyDmg = randy.nextInt(3) + 8;

        if (enemy == 1) {
            //Enemy Melee Attacks too
            enemyDmg /= 2;

            playerDmg = randy.nextInt(3) + 8;
            playerDmg /= 2;
           
            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("(ง •̀ _•́)ง ผ(•̀ _•́ ผ)");
            
        } else if (enemy == 2) {
            //Enemy Range Attacks
            playerDmg = randy.nextInt(3) + 4;
            playerDmg /= 2;

            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("¤=[]::(゜Д゜;)::>");

        } else if (enemy == 3) {
            //Enemy Counters
            enemyDmg /= 2;
            playerDmg = randy.nextInt(3) + 2;

            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("(ง •̀ _•́)ง ผ(•̀ _•́ ผ)");

        } else if (enemy == 4) {
            //Enemy Defends
            enemyDmg = 0;
            playerDmg = 0;

            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("(ง •̀_•́)ง ผ(o.Oผ)");

        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println("You lost " + playerDmg + " HP!");
        enemyHealth -= enemyDmg;
        playerHealth -= playerDmg;
        TimeUnit.SECONDS.sleep(1);
    }

    private static void PlayerRanged(int enemy) throws InterruptedException {
        int enemyDmg = 0;
        int playerDmg = 0;

        enemyDmg = randy.nextInt(3) + 4;

        if (enemy == 1) {
            //Enemy Melee Attacks
            enemyDmg /= 2;
            playerDmg = randy.nextInt(3) + 8;
           
            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("Σ>―(´･ω･`)→");
            
        } else if (enemy == 2) {
            //Enemy Range Attacks
            playerDmg = randy.nextInt(3) + 4;

            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("⤜(XᗩX)⤏");

        } else if (enemy == 3) {
            //Enemy Counters
            playerDmg = 0;

            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("⤜(XᗩX)⤏");

        } else if (enemy == 4) {
            //Enemy Defends
            enemyDmg /= 2;
            playerDmg = 0;

            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("Σ>―(´･ω･`)→");
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println("You lost " + playerDmg + " HP!");
        enemyHealth -= enemyDmg;
        playerHealth -= playerDmg;
        TimeUnit.SECONDS.sleep(1);
    }

    private static void PlayerCounter(int enemy) throws InterruptedException {
        int enemyDmg = 0;
        int playerDmg = 0;

        enemyDmg = randy.nextInt(3) + 2;

        if (enemy == 1) {
            //Enemy Melee Attacks
            playerDmg = randy.nextInt(3) + 8;
            playerDmg /= 2;

            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("!!( ･_･)r鹵~<巛巛巛(ﾟoﾟ;");
            
        } else if (enemy == 2) {
            //Enemy Range Attacks
            enemyDmg = 0;
            playerDmg = randy.nextInt(3) + 4;

            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("（*￣□￣*；");

        } else if (enemy == 3) {
            //Enemy Counters
            enemyDmg = 0;
            playerDmg = 0;
            
            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("（*￣□￣*；");

        } else if (enemy == 4) {
            //Enemy Defends
            playerDmg = 0;

            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("!!( ･_･)r鹵~<巛巛巛(ﾟoﾟ;");
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println("You lost " + playerDmg + " HP!");
        enemyHealth -= enemyDmg;
        playerHealth -= playerDmg;
        TimeUnit.SECONDS.sleep(1);
    }

    private static void PlayerDefend(int enemy) throws InterruptedException {
        int enemyDmg = 0;
        int playerDmg = 0;
        if (enemy == 1) {
            //Enemy Melee Attacks
            enemyDmg = 0;
            playerDmg = 0;
        
            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("(ʘ言ʘ╬)");
            
        } else if (enemy == 2) {
            //Enemy Range Attacks
            enemyDmg = 0;
            playerDmg = randy.nextInt(3) + 4;
            playerDmg /= 2;

            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("Σ(‐△‐●)");

        } else if (enemy == 3) {
            //Enemy Counters
            enemyDmg = 0;
            playerDmg = randy.nextInt(3) + 2;
            
            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("(´ｖ｀)");

        } else if (enemy == 4) {
            //Enemy Defends
            enemyDmg = 0;
            playerDmg = 0;

            System.out.println("The Enemy lost " + enemyDmg + " HP!");
            System.out.println("┐(´д｀)┌");
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println("You lost " + playerDmg + " HP!");
        enemyHealth -= enemyDmg;
        playerHealth -= playerDmg;
        TimeUnit.SECONDS.sleep(1);
    }
}