import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
public class ImpedimentCard extends Cards
{
    public static Queue<String> IMPEDIMENT_CARDS = new LinkedList<String>();
    public static Queue<String> DIS_IMPEDIMENT_CARDS = new LinkedList<String>();
    public Impediment impediment;
    GameRulesMessage message;
    private static ScrumWorld myworld;
    
    public String drawCard(){
        String cardMessage="";
        try{
            message = GameRulesMessage.getMessageInstance();
            message.setTextMessage("Pick an impediment card \n by clicking on deck \nof impediment cards \nusing left hand");
            ScrumWorld.backgroundMusic = new GreenfootSound("Pick Impediment.mp3");
            ScrumWorld.backgroundMusic.play();
            Greenfoot.delay(200);
            boolean checkLeftHand = false; 
            while(!checkLeftHand)
            {
                if(myworld.isLeftHandUp())
                {
                    System.out.println("Successfuly Drew Opportunity Card");
                    cardMessage = IMPEDIMENT_CARDS.peek();
                    showDrawnCard(cardMessage);
                    IMPEDIMENT_CARDS.remove();
                    checkLeftHand = true;
                }
            
            }
        }
        catch(Exception e)
        {
            System.out.println("Exception caught in drawcard() Impediment");
        }
        return cardMessage;
    }
    
    public static void getWorld(ScrumWorld world){
        myworld = world;
    }
    
    public void discardCard(String card){
       DIS_IMPEDIMENT_CARDS.add(card); 
    }

    public void shuffleCard(){
        for(int i=0;i<DIS_IMPEDIMENT_CARDS.size();i++)
        {
            IMPEDIMENT_CARDS.add(DIS_IMPEDIMENT_CARDS.peek());
            DIS_IMPEDIMENT_CARDS.remove();
        }
    }
    
    public void showDrawnCard(String cardMessage)
    {
        BackCard backCard = new BackCard(cardMessage);
        backCard.addCardGraphically();
    }
    
}
