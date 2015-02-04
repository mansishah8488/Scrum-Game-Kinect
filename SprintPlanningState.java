/**
 * Write a description of class SprintPlanningState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;

public class SprintPlanningState implements BoardStates {
    private GamePlay gameplay;
    private PlayDice playDice = new PlayDice();
    private int[] dice_value = new int[2];
    private GamePiece currentPlayer;
    private ActionStrategy actionStrategy;
    private GameRulesMessage message;
    private int sum =0;
    
    public void diceRolled(GamePiece currentPlayer, GamePlay gameplay){
        this.currentPlayer = currentPlayer;
        this.gameplay = gameplay;
        this.dice_value = playDice.roll(currentPlayer.getPosition());
        sum = playDice.getSum(this.dice_value);
        movePlayer(dice_value);
    }
    
    public void movePlayer(int[] dice_value){
        //Code to check if already on 15
        System.out.println("current player position = " + currentPlayer.getPosition() + " dice values =  " + dice_value[0] + ", " + dice_value[1]);

        int new_location = currentPlayer.getPosition() + sum;
        System.out.println("So new location = " + new_location);
        if((new_location == 6) && !currentPlayer.isFirstOver()){
            //Got scrumed - Display Messgae
            System.out.println("Player: "+currentPlayer.getId()+" got scrumed cannot move!");
            message = GameRulesMessage.getMessageInstance();
            message.setTextMessage("Player: "+currentPlayer.getId()+" got scrumed cannot \nmove!");
            ScrumWorld.backgroundMusic = new GreenfootSound("Got Scrumed.mp3");
            ScrumWorld.backgroundMusic.play();
            Greenfoot.delay(200);

        } else {
            if(new_location >= 6 && currentPlayer.isFirstOver()){
                System.out.println("Going to GameProgressState");
                if(new_location == 15)
                    gameplay.setState("BurndownState");
                else
                    gameplay.setState("GameProgressState");
            } else {
                System.out.println("Its less than 6");
                // no state change
            }
            currentPlayer.setPosition(new_location);
            
            //Grqphics movement
            gameplay.graphicMove();
            
             // Perform associate task
            ActionMapper actionMapper = new ActionMapper();
            actionStrategy = actionMapper.getAction(currentPlayer, 1, gameplay);
            actionStrategy.performTask();
            System.out.println("\n Total Hours = " + ScrumWorld.TOTAL_HOURS);
        }
        currentPlayer.firstOver();
    }
}
