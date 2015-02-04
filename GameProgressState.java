import greenfoot.*;

public class GameProgressState implements BoardStates {
   private GamePlay gameplay;
   private PlayDice playDice = new PlayDice();
   private int[] dice_value = new int[2];
   private GamePiece currentPlayer;
   private ActionStrategy actionStrategy;
   private GameRulesMessage message;
   private int sum = 0;
   
   public void diceRolled(GamePiece currentPlayer, GamePlay gameplay){
       this.currentPlayer = currentPlayer;
       this.gameplay = gameplay;
       message = GameRulesMessage.getMessageInstance();
       dice_value = playDice.roll(currentPlayer.getPosition());
       sum = playDice.getSum(dice_value);
       System.out.println("Play Sum: "+sum);
       
       if(!this.currentPlayer.ifImpeded()){
           movePlayer(dice_value);
       } else {
           if(dice_value[0]!= 6 || dice_value[1]!= 6){ //Scrum check if impeded
               System.out.println("Player impeded, no scrum");
               return;
           } else if(dice_value[0] == 6){
               //Display message
               System.out.println("Got scrumed, Impediment removed");
               message.setTextMessage("Got scrumed, \nImpediment removed");
               ScrumWorld.backgroundMusic = new GreenfootSound("Scrum Ed Imp Removed.mp3");
               ScrumWorld.backgroundMusic.play();
               Greenfoot.delay(200);
               dice_value[0] = 0;
           } else if(dice_value[1] == 6){
               //Display message
               System.out.println("Got scrumed, Impediment removed");
               message.setTextMessage("Got scrumed, \nImpediment removed");
               ScrumWorld.backgroundMusic = new GreenfootSound("Scrum Ed Imp Removed.mp3");
               ScrumWorld.backgroundMusic.play();
               Greenfoot.delay(200);
               dice_value[1] = 0;
           } else {
               //Display message
               System.out.println("Got scrumed, Impediment removed");
               message.setTextMessage("Got scrumed, \nImpediment removed");
               ScrumWorld.backgroundMusic = new GreenfootSound("Scrum Ed Imp Removed.mp3");
               ScrumWorld.backgroundMusic.play();
               Greenfoot.delay(200);
               currentPlayer.removeImpediment();
               return;
           }
           movePlayer(dice_value);
       }
   }
    
   public void movePlayer(int[] dice_value){
       System.out.println("current player position = " + currentPlayer.getPosition() + " dice values =  " + dice_value[0] + ", " + dice_value[1]);
       int new_location = currentPlayer.getPosition() + sum;
       System.out.println("So new location = " + new_location); 
       if(currentPlayer.getPosition() == 24){
           new_location = new_location - 9;
           System.out.println("if 24, then negate 9 ");
       } else {
           new_location = new_location;
       }
       
       if(new_location == 15){
           gameplay.setState("BurndownState");
           System.out.println("its 15, going to BurnDownState");
       } else if(new_location > 18) {
           new_location = new_location - 18 + 5;
           System.out.println("new location greater than 18, so -18+5+new location");
       }
       currentPlayer.setPosition(new_location);
       System.out.println("current Poition = " + currentPlayer.getPosition());
       
       //Grqphics movement
       gameplay.graphicMove();
       
       ActionMapper actionMapper = new ActionMapper();
       actionStrategy = actionMapper.getAction(currentPlayer, 1, gameplay);
       System.out.println("Action Strategy " +actionStrategy); 
       actionStrategy.performTask();
   }
}