import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackCard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackCard extends Actor
{
    String taskDescription;
    private static World myworld;
    
    public BackCard()
    {
    }
    
    public static void getWorld(World world){
        myworld = world;
    }
    
    public BackCard(String taskDescription)
    {
        this.taskDescription = taskDescription;
    }
    
    public String getDescription()
    {
        return this.taskDescription;
    }
    
    public void addCardGraphically()
    {
        try
        {
            BackCard backCard = new BackCard();
            myworld.addObject(backCard,515,385);
            String editedTaskDescription = this.taskDescription;
            System.out.println("Task Description: "+editedTaskDescription);
            
            CardMessage card = CardMessage.getMessageInstance();
            card.setTextMessage(editedTaskDescription.replace("\\n", "\n"));
            myworld.addObject(card,520,390);
            
            Greenfoot.delay(200);
            myworld.removeObject(card);
            myworld.removeObject(backCard);
        }catch(Exception e)
        {
            System.out.println("Exception: "+e.getMessage());
        }
    }
    
    /**
     * Act - do whatever the FrontCard wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
