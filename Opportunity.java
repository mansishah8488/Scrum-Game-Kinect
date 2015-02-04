public class Opportunity implements ActionStrategy  
{
    GamePiece player;
    GamePlay gameplay;
    EndDay endDay;

    public Opportunity(GamePiece player, GamePlay gameplay){
        this.player = player;
        this.gameplay = gameplay;
    }

    public void performTask()
    {
        ProgressDice p_dice = new ProgressDice();
        OpportunityCard card = new OpportunityCard();
        String card_Val = card.drawCard();
        
        // Display Message of opportunity card
        
        if(card_Val.toLowerCase().contains("Go to the scrum".toLowerCase())){
            // Move player to daily scrum.
            player.setPosition(15);
            player.setOpportunity(true);
            player.setPlayerState(new BurndownState());
        } else {
            // Move to End of day.
            player.setPosition(6);
            endDay = new EndDay();
            endDay.performTask();
        }
        
        if(p_dice.getDiceCount() < 10){
            p_dice.increaseDice();
        }
        
        // Graphical move code here.
        gameplay.graphicMove();
    }
    
    public void performGraphicDrawCard()
    {
    }
}
