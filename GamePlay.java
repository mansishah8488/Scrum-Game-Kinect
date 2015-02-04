import java.util.*;
import java.awt.Desktop;
import java.io.File;
import greenfoot.*;

public class GamePlay{
    BoardStates sprintPlanningState;
    BoardStates gameProgressState;
    BoardStates burndownState;
    BoardStates currentState;
    Queue<GamePiece> playerList; 
    GamePiece currentPlayer;
    GamePlay gameplay;
    ProgressDice progressDice;
    boolean isBurndownComplete = false;
    GameRulesMessage message;
    
    public GamePlay(Queue<GamePiece> playerList){
        this.playerList = playerList;        
        progressDice = new ProgressDice();
        sprintPlanningState = new SprintPlanningState();
        gameProgressState = new GameProgressState();
        burndownState = new BurndownState();
        currentState = sprintPlanningState;
    }
    
    public GamePiece turnAndGetPlayer(){
        GamePiece current_player = playerList.peek();
        playerList.remove();
        playerList.add(current_player);
        return current_player;
    }
    
    public void diceRolled(GamePlay gameplay){
        this.gameplay = gameplay;
        
        if(ScrumWorld.TOTAL_DAYS > 0 && ScrumWorld.TOTAL_HOURS > 0){
            
            if(currentState != burndownState){
                //Remove The card object here
                currentPlayer = turnAndGetPlayer();
                
                //Current player display - Display message
                System.out.println("currentPlayer = " + currentPlayer.getId() + ", currentPlayer State = " + currentPlayer.getPlayerState());
                message = GameRulesMessage.getMessageInstance();
                message.setTextMessage("Player: " + currentPlayer.getId() + " currently played!");
                
                if(currentPlayer.hasOpportunity() == true){
                    setState("BurndownState"); 
                } else {
                    if(currentPlayer.hasToolCards() && ScrumWorld.IMPEDED_PLAYERS.size() > 0){
                        // Remove impedment from player.
                        GamePiece impeded_player = ScrumWorld.IMPEDED_PLAYERS.peek();
                         // Remove impedment from player. - Display message
                        System.out.println("Player "+ impeded_player.getId() +" impeded, used tool card to remove impediment");
                        message = GameRulesMessage.getMessageInstance();
                        message.setTextMessage("Player "+ impeded_player.getId() +" impeded, used \n tool card to remove \n impediment!");
                        ScrumWorld.backgroundMusic = new GreenfootSound("Impeded Player.mp3");
                        ScrumWorld.backgroundMusic.play();
                        Greenfoot.delay(200);
                        impeded_player.removeImpediment();
                        ScrumWorld.IMPEDED_PLAYERS.remove();
                        return;
                    }
                }
            }
            currentPlayer.getPlayerState().diceRolled(currentPlayer, gameplay);
        } else {
            // Display Message of loosing game and show burndown chart. - Display message
            if(ScrumWorld.TOTAL_HOURS > 0){
                System.out.println("Sprint Over, Lost Game!");
                message = GameRulesMessage.getMessageInstance();
                message.setTextMessage("Sprint of 10 days is over\n Team Lost Game!");
                ScrumWorld.backgroundMusic = new GreenfootSound("Lost Game.mp3");
                ScrumWorld.backgroundMusic.play();
                Greenfoot.delay(200);
            } else {
                System.out.println("Sprint Over, You Won Game!");
                message = GameRulesMessage.getMessageInstance();
                message.setTextMessage("Sprint of 10 days is over\n Team Won Game!");
                ScrumWorld.backgroundMusic = new GreenfootSound("Won Game.mp3");
                ScrumWorld.backgroundMusic.play();
                Greenfoot.delay(200);
            }
            
            // Display Graph from execl file.
            //Desktop dt = Desktop.getDesktop();
            //dt.open(new File("Cards.xls"));
        }
    }
    
    public void setState(String state){
        if(state.equals("GameProgressState"))
            this.currentState = gameProgressState;
        else if(state.equals("BurndownState"))
            this.currentState = burndownState;
            
        currentPlayer.setPlayerState(this.currentState);
    }
    
    public int progressDiceCount(){
        return progressDice.getDiceCount();
    }
    
    public void setRotated(boolean isBurndownComplete){
        this.isBurndownComplete = isBurndownComplete;
    }
    
    public boolean burndownCompleted(){
        return isBurndownComplete;
    }
    
    public void graphicMove(){
        System.out.println("Move Player to location (x,y)");
        currentPlayer.setLocation(ScrumWorld.board_x[currentPlayer.getPosition()-1][currentPlayer.getId()-1], ScrumWorld.board_y[currentPlayer.getPosition()-1][currentPlayer.getId()-1]);
        /*if(ScrumWorld.TOTAL_HOURS>0 && ScrumWorld.TOTAL_DAYS>0)
        {
            ScrumWorld.backgroundMusic = new GreenfootSound("Roll Progress Dice.mp3");
            ScrumWorld.backgroundMusic.play();
        }*/
    }
    
    public void moveToSprint(){
        for(int i=0; i < playerList.size(); i++){
            currentPlayer = turnAndGetPlayer();
            currentPlayer.setLocation(ScrumWorld.board_x[24][currentPlayer.getId()-1], ScrumWorld.board_y[24][currentPlayer.getId()-1]);
        }
    }
}
