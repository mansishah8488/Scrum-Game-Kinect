import java.util.*;
import greenfoot.*;

public class EndDay implements ActionStrategy
{
    DayTrack dayTrack;
    ExcelReader er;
    private GameRulesMessage message;
    public EndDay(){
        // Your code here.
    }

    public void performTask(){
       message = GameRulesMessage.getMessageInstance();
       er = new ExcelReader();
       dayTrack = DayTrack.getDayTrackInstance();
       dayTrack.endOfDay();
       System.out.println("\n\nDays Left: " + ScrumWorld.TOTAL_DAYS);
        
       //Set the location of the day track depending on the days finished in the sprint.
       int index = 10 - ScrumWorld.TOTAL_DAYS - 1;
       dayTrack.setImage("redOutline.png");
       dayTrack.setLocation(ScrumWorld.dayTrackHighlighter[index][0],ScrumWorld.dayTrackHighlighter[index][1]);
       if(index == 9 && ScrumWorld.TOTAL_HOURS > 0){
           try{
               message.setTextMessage("Sprint of 10 days is over\n Team Lost.");
               ScrumWorld.backgroundMusic = new GreenfootSound("Lost Game.mp3");
               ScrumWorld.backgroundMusic.play();
               Greenfoot.delay(200);
               //er.writeToFile();
           } catch(Exception e){
               System.out.println("Error : " + e.getMessage());
           }
       }   
    }
    
    public void performGraphicDrawCard(){
        
    }
}
