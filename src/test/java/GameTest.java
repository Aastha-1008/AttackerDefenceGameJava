import org.example.Game;
import org.example.entities.Player;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void attackingDefendingFight(){
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
}
