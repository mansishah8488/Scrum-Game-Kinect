
public class TakeDice implements ActionStrategy  
{
    public TakeDice(){
        
    }

    public void performTask(){
        ProgressDice pd = new ProgressDice();
        pd.increaseDice();
        //Add extra dice to the World
    }
    
    public void performGraphicDrawCard()
    {
    }
}
