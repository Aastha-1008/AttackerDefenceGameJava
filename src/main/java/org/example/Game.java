package org.example;

import org.example.entities.Player;

import java.util.Random;

public class Game {
    private Player attacker;
    private Player defender;

    // Random for generating random values of a dice
    private Random random;

    //Constructor
    public Game(Player attacker , Player defender ){
        this.attacker = attacker ;
        this.defender = defender;
        this.random = new Random();
    }

    public void attackingDefendingFight(){
        while(attacker.getHealth()>0 && defender.getHealth()>0) {

            int attackingDiceValue = random.nextInt(6) + 1;
            int defendingDiceValue = random.nextInt(6) + 1;

            int netDecreaseInDefenderHealth = Math.max(0, attacker.getAttack() * attackingDiceValue - defender.getStrength() * defendingDiceValue);
            defender.setHealth(defender.getHealth() - netDecreaseInDefenderHealth);


            //switch attacker and defender
            Player temp = attacker;
            attacker = defender;
            defender = temp;
        }
    }
}
