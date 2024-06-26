﻿# AttackerDefenceGameJava
#Problem Statement
Design a Magical Arena. Every Player is defined by a “health” attribute, “strength” attribute and an “attack” attribute - all positive integers. The player dies if his health attribute touches 0. 
#OverView 
1) Player.java : Defines the behaviour of a player
2) Game.java : Defines the main logic of a game between attacker and defender
3) GAmeTest.java : Consists testcases to test the Game logic

#Getting Started
1)Clone or download the project repository to your local machine.
2)Open project in your preferred Java IDE.
3)Remember it is a maven project.

#Running the application
1) Follow the main.java class and run main() function.

#Explanation 
Player.java : It contains characterstic of Player i.e. health , attack and strength. Getter and Setter are created to access their characterstic.
```
package org.example.entities;


public class Player {
    private int health;
    private int strength;
    private int attack;

    public int getHealth(){
        return health;
    }
    public int getStrength(){
        return strength;
    }

    public int getAttack(){
        return attack;
    }
    public  void setHealth(int health){
        this.health = health;
    }
    public void setStrength(int strength){
        this.strength = strength;
    }
    public void setAttack(int attack){
        this.attack = attack;
    }
    public Player(int health , int strength , int attack){
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }
}

```

Game.java: It contains the main logic of a Game .
1) Any two player can fight a match in the arena. Players attack in turns.
2) Attacking player rolls the attacking dice and the defending player rolls the defending dice. The “attack”  value multiplied by the outcome of the  attacking dice roll is the damage created by the attacker.
3) The defender “strength” value, multiplied by the outcome of the defending dice is the damage defended by the defender.
4) Whatever damage created by attacker which is in excess of the damage defended by the defender will reduce the “health” of the defender.
5) Game ends when any players health reaches 0.
6) Player with lower health attacks first at the start of a match.

```
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


```
Main.java : It serves as a entry point of this game. It initiates player with given behaviour and calls a fight function to start a game.

```
package org.example;

import org.example.entities.Player;

public class Main {
    public static void main(String[] args) {
            Player playerA = new Player(50 , 5, 10);
            Player playerB = new Player(100,10,5);

            Game game = new Game(playerA , playerB);
            game.attackingDefendingFight();

            if(playerA.getHealth() <= 0 && playerB.getHealth()>0){
                System.out.println("PlayerB wins.");
            }
            else{
                System.out.println("PlayerA wins.");
            }

    }
}
```

GameTest.java : It consists test cases for Game.java classes.

```
import org.example.Game;
import org.example.entities.Player;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void attackingDefendingFight1(){
        Player playerA = new Player(50 , 5, 10);
        Player playerB = new Player(100,10,5);

        Game game = new Game(playerA , playerB);
        game.attackingDefendingFight();

        if(playerA.getHealth()<=0){
            assertEquals(true , playerB.getHealth()>0);
        }
        else{
            assertEquals(true,playerA.getHealth()>0);
        }

    }

    @Test
    public void attackingDefendingFight2(){
        Player playerA = new Player(500 , 15, 10);
        Player playerB = new Player(100,10,5);

        Game game = new Game(playerA , playerB);
        game.attackingDefendingFight();

        if(playerA.getHealth()<=0){
            assertEquals(true , playerB.getHealth()>0);
        }
        else{
            assertEquals(true,playerA.getHealth()>0);
        }

    }
}
```
