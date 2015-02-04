import greenfoot.*;

public class BurndownState implements BoardStates{
    private GameRulesMessage message;
    private ExcelReader er;
    private int[] dice_value;
    private int dice_count;
    private GamePiece currentPlayer;
    private ProgressDice progressDice = new ProgressDice();
    private GamePlay gameplay;
    private ActionStrategy actionStrategy;
    private int dice_sum = 0;

    public void diceRolled(GamePiece currentPlayer, GamePlay gameplay){
        this.currentPlayer = currentPlayer;
        this.gameplay = gameplay;
        //dice_count = gameplay.progressDiceCount;
        dice_value = progressDice.roll(1);
        movePlayer(dice_value);        
    }
    
    public void movePlayer(int[] dice_value){
        try
        {
            message = GameRulesMessage.getMessageInstance();
            er = new ExcelReader();
            dice_sum = progressDice.getSum(dice_value);
            System.out.println("Dice Sum = " + dice_sum);
            ActionMapper actionMapper = new ActionMapper();
            actionStrategy = actionMapper.getAction(currentPlayer, dice_sum, gameplay);
            actionStrategy.performTask();
            System.out.println("current Poition = " + currentPlayer.getPosition());            
            
            if(currentPlayer.getPosition() == 15){
                System.out.println("if on 15, set position 19");
                currentPlayer.setPosition(19);
            } else if(currentPlayer.getPosition() == 23) {
                gameplay.setRotated(true);
                currentPlayer.setPosition(24);
                gameplay.setState("GameProgressState");
                if(currentPlayer.hasOpportunity() == true)
                    currentPlayer.setOpportunity(false);
                System.out.println("if got onto 24, its rotated, hence state = GameProgressState");
            } else {
                System.out.println("if neither 15 nor 24, just increase position by 1");
                currentPlayer.setPosition(currentPlayer.getPosition() + 1);
            }

            //Grqphics movement
            gameplay.graphicMove();         
            dice_sum = 0;
            try{
                if(ScrumWorld.TOTAL_HOURS <= 0){
                    System.out.println("game won");
                    ScrumWorld.TOTAL_HOURS = 0;
                    gameplay.moveToSprint();
                    message.setTextMessage("Congratulations!! \nYour Team Won!!");
                    ScrumWorld.backgroundMusic = new GreenfootSound("Won Game.mp3");
                    ScrumWorld.backgroundMusic.play();
                    Greenfoot.delay(200);
                    //er.writeToFile();
                }
            } catch(Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Message : " + e.getMessage());
        }
    }
}
