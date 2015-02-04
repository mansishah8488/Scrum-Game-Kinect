import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class DayTrack extends Actor
{
    private static DayTrack dayTrackInstance = new DayTrack( );
    public static ArrayList<Integer> graph_Values = new ArrayList<Integer>();
    public DayTrack(){
        // Your code here...
    }
    
    public static DayTrack getDayTrackInstance(){    
         return dayTrackInstance;
    }
    
    public void endOfDay(){
        ScrumWorld.graph_Values.add(ScrumWorld.TOTAL_HOURS);
        ScrumWorld.TOTAL_DAYS--;
        System.out.println("Graph Plot Values for BurnDown Chart :");
        for(int i = 0; i < graph_Values.size(); i++)
            System.out.println("Day : " + i + ", Hours Remaining : " + graph_Values.get(i));
    }
}
