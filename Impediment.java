public class Impediment implements ActionStrategy  
{
    // instance variables - replace the example below with your own
    GamePiece player;
    
    public Impediment(GamePiece player){
        this.player = player;
    }
    
    public void performTask()
    {
        ImpedimentCard card = new ImpedimentCard();
        if(ImpedimentCard.IMPEDIMENT_CARDS.size() == 0)
           card.shuffleCard();
            
        player.setImpedimentCard(card.drawCard());
        ScrumWorld.IMPEDED_PLAYERS.add(player); 
    }    
    
    public void performGraphicDrawCard()
    {
    }
}
