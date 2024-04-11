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