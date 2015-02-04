
public class Tool implements ActionStrategy  
{
    GamePiece player;

    public Tool(GamePiece player){
        this.player = player;
    }

    public void performTask()
    {
        Cards card = new ToolCard();
        if(ToolCard.TOOL_CARDS.size() == 0)
            card.shuffleCard();
            
        player.addToolCard(card.drawCard());
    }
    
    public void performGraphicDrawCard()
    {
    }
   
}
