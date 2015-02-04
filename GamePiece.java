import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GamePiece extends Actor
{
    private int currentPosition;
    private BoardStates currentPlayerState;
    private boolean over = false;
    private int id;
    private ActionStrategy currentAction;
    private String impedimentCard;
    //private OpportunityCard opportunityCard;
    private String[] toolCards = new String[20];
    private boolean isImpeded = false;
    private boolean dailyScrum = false;
    public int loc_x, loc_y;
    
    
    public GamePiece(int id)
    {
        loc_x = 0;//Starting position
        loc_y = 0;//-------|
        this.id = id;
        currentPlayerState = new SprintPlanningState();
        currentPosition = 0;
    }
    
    public void act() 
    {
        // Add your action code here.
    }
    
    
    public void setPlayerState(BoardStates currentPlayerState)
    {
        this.currentPlayerState = currentPlayerState;
    }
    
    public BoardStates getPlayerState()
    {
        return currentPlayerState;
    }
    
    public void setPosition(int currentPosition)
    {
        this.currentPosition = currentPosition;
    }
    
    public int getPosition()
    {
        return currentPosition;
    }   
    
    public void firstOver()
    {
        over = true;
    }
    
    
    public boolean isFirstOver()
    {
        return over;
    }
    
    public String getPlayerName()
    {
        return "Player " + id;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setCurrentAction(ActionStrategy currentAction)
    {
        this.currentAction = currentAction;
    }
    
    public ActionStrategy getCurrentAction()
    {
        return currentAction;
    }
    
    public void setImpedimentCard(String impedimentCard)
    {
        this.impedimentCard = impedimentCard;
        isImpeded = true;
    }
    
    public String getImpediment()
    {
        return impedimentCard;
    }
    
    public void removeImpediment()
    {
        impedimentCard = "No impediments";
        isImpeded = false;
    }
    
    public boolean ifImpeded()
    {
        return isImpeded;
    }
    
    public void addToolCard(String toolCard)
    {
        for(int i=0;i<20;i++)
        {
            if(toolCards[i] == null)
            {
                toolCards[i] = toolCard;
            }
        }
    }
    
    public String[] getToolCards()
    {
        return toolCards;
    }
    
    public void useToolCard(int index)
    {
        toolCards[index] = null;
    }
    
    public void setOpportunity(boolean val){
        dailyScrum = val;
    }
    
    public boolean hasOpportunity(){
        return dailyScrum;
    }
    
    public boolean hasToolCards(){
        return true;
    }
}
