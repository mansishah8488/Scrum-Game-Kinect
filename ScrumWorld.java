import java.util.*;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.geom.Point2D;

public class ScrumWorld extends KinectWorld
{
    //New for kinect
    public static World world;
    
    //New addition for consturctor
    private static final int THUMBNAIL_WIDTH = 80;
    private static final int THUMBNAIL_HEIGHT = 60;
    
    public static GreenfootSound backgroundMusic;
    public static int TOTAL_HOURS = 300;
    public static int TOTAL_DAYS = 10;
    public static Queue<GamePiece> IMPEDED_PLAYERS = new LinkedList<GamePiece>();
    private Queue<GamePiece> playerList = new LinkedList<GamePiece>();
    private GamePlay gamePlay;
    private DayTrack dayTrack;
    GameRulesMessage message;
    DiceSumMessage diceSumMessage;
    HoursMessage hoursMessage;

    
    GamePiece gp1;
    GamePiece gp2;
    GamePiece gp3;
    GamePiece gp4;
    
    //Graph Values for plotting the graph
    public static ArrayList<Integer> graph_Values = new ArrayList<Integer>();

    //Arrays for X & Y Coordinate of the positions of the players
    public static int[][] board_x = {
        {123,160,123,160},
        {182,217,182,217},
        {239,274,239,274},
        {296,331,296,331},
        {353,370,353,388},
        {488,545,488,545},
        {611,646,655,680},
        {655,670,693,703},
        {663,665,705,698},
        {647,640,682,668},
        {612,585,638,605},
        {562,528,572,528},
        {506,472,506,460},
        {446,422,435,402},
        {386,385,350,340},
        {373,373,333,333},
        {373,373,333,333},
        {390,423,355,380},
        {290,290,290,290},
        {240,240,240,240},
        {220,220,220,220},
        {250,250,250,250},
        {305,305,305,305},
        {345,345,345,345},
        {748,785,748,785},
    };
    
    
    public static int[][] board_y = {
        {533,533,569,569},
        {533,533,569,569},
        {533,533,569,569},
        {533,533,569,569},
        {533,544,569,569},
        {533,533,567,567},
        {501,455,501,469},
        {423,398,435,400},
        {368,338,368,325},
        {308,275,295,268},
        {265,240,238,218},
        {237,232,205,195},
        {232,240,200,208},
        {250,263,215,238},
        {270,310,250,290},
        {338,368,331,368},
        {400,428,400,435},
        {456,501,470,501},
        {292,292,292,292},
        {272,272,272,272},
        {222,222,222,222},
        {174,174,174,174},
        {172,172,172,172},
        {210,210,210,210},
        {533,533,569,569},
    };
    
   public static int[][] dayTrackHighlighter =
    {
        {845,183},
        {806,183},
        {767,184},
        {729,183},
        {689,183},
        {845,145},
        {806,145},
        {767,145},
        {728,145},
        {689,145},
        
    };
   
    
    //Getter Method for GamePlay
    public GamePlay getGamePlay()
    {
        return gamePlay;
    }
    
    public ScrumWorld() throws Exception
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       // super(923, 580, 1); 
       super(THUMBNAIL_WIDTH, THUMBNAIL_HEIGHT, 1.0, false);
       prepare();
       setWorld();
    }
    
    private void prepare() throws Exception
    {
       ExcelReader er = new ExcelReader();
       er.readFile();
       
       //Instantiate day track;
       DayTrack dayTrack = DayTrack.getDayTrackInstance();
       addObject(dayTrack,845,183);
        
       //Callout for message
       Callout callout = new Callout();
       addObject(callout,462,78);
       
       //Hour Counter
       HourCounter hourCounter = new HourCounter();
       addObject(hourCounter, 767,40);
       
       //Singleton hours message object 
       hoursMessage = HoursMessage.getMessageInstance();
       addObject(hoursMessage,778, 65);
       hoursMessage.setTextMessage("300");
       
       //Dice Sum Counter
       DiceSumCounter diceSumCounter = new DiceSumCounter();
       addObject(diceSumCounter, 120,40);
       
       //Singleton dice sum message object 
       diceSumMessage = DiceSumMessage.getMessageInstance();
       addObject(diceSumMessage,135, 65);
       diceSumMessage.setTextMessage("0");
       
       //Singleton message object 
       message = GameRulesMessage.getMessageInstance();
       addObject(message,458, 85);
       message.setTextMessage("  Welcome to Scrum Game! \n U have 2 play & 3 progress \n                 dice");
       
       backgroundMusic = new GreenfootSound("Welcome Game.mp3");
       backgroundMusic.play();
       
       
       //Front image of Cards
       BackCard backCard = new BackCard();
       backCard.getWorld(this);
       
       //Cards
       OpportunityCard opportunityCard= new OpportunityCard();
       addObject(opportunityCard,115,150);
       opportunityCard.getWorld(this);
       
       ToolCard toolCard= new ToolCard();
       addObject(toolCard,115,300);
       toolCard.getWorld(this);
       
       ImpedimentCard impedimentCard= new ImpedimentCard();
       addObject(impedimentCard,115,450);
       impedimentCard.getWorld(this);
       
       //Dices
       PlayDice playDice1 = new PlayDice();
       addObject(playDice1, 20, 553);
       
       PlayDice playDice2 = new PlayDice();
       addObject(playDice2, 20, 520);
       
       ProgressDice progressDice1 = new ProgressDice();
       progressDice1.getWorld(this);
       addObject(progressDice1, 20, 470);
       
       ProgressDice progressDice2 = new ProgressDice();
       addObject(progressDice2, 20, 435);
       
       ProgressDice progressDice3 = new ProgressDice();
       addObject(progressDice3, 20, 400);
       
      // Day track counter
      DayCounter dayCounter;
      
      dayCounter = new DayCounter();
      dayCounter.setImage("9.1.png");
      addObject(dayCounter,845,185);
      
      dayCounter = new DayCounter();
      dayCounter.setImage("8.1.png");
      addObject(dayCounter,806,185);
      
      dayCounter = new DayCounter();
      dayCounter.setImage("7.1.png");
      addObject(dayCounter,767,185);
      
      dayCounter = new DayCounter();
      dayCounter.setImage("6.1.png");
      addObject(dayCounter,729,185);
      
      dayCounter = new DayCounter();
      dayCounter.setImage("5.1.png");
      addObject(dayCounter,689,185);
      
      
      dayCounter = new DayCounter();
      dayCounter.setImage("4.1.png");
      addObject(dayCounter,845,145);
      
      dayCounter = new DayCounter();
      dayCounter.setImage("3.1.png");
      addObject(dayCounter,806,145);
      
      dayCounter = new DayCounter();
      dayCounter.setImage("2.1.png");
      addObject(dayCounter,767,145);
      
      dayCounter = new DayCounter();
      dayCounter.setImage("1.1.png");
      addObject(dayCounter,728,145);
      
      dayCounter = new DayCounter();
      dayCounter.setImage("0.1.png");
      addObject(dayCounter,691,145);
       
       //Player object positions at the beginning
       //Player 1
       gp1 = new GamePiece(1);
       gp1.setImage("gamePiece4.png");
       addObject(gp1, 60, 533);
        
       //Player 2
       gp2 = new GamePiece(2);
       gp2.setImage("yellowGamePiece.png");
       addObject(gp2, 100, 533);
       
       //Player 3
       gp3 = new GamePiece(3);
       gp3.setImage("blueGamePiece.png");
       addObject(gp3, 60, 569);
       
       //Player 4
       gp4 = new GamePiece(4);
       gp4.setImage("gamePiece1.png");
       addObject(gp4, 100, 569);
       
       playerList.add(gp1);
       playerList.add(gp2);
       playerList.add(gp3);
       playerList.add(gp4);
       
       gamePlay = new GamePlay(this.playerList);
       //GameInitiator gameInitiator = new GameInitiator(gamePlay);
       //addObject(gameInitiator,180,450);
    }
    
    public void act()
    {
        super.act();
        //System.out.println(isConnected());
        if (!isConnected())
        return;

        UserData[] us = getTrackedUsers();
        boolean anyRightHandUp = false;
        
        //System.out.println(us);
        for (UserData u: us)
        {
           anyRightHandUp = anyRightHandUp || (u.getJoint(Joint.RIGHT_HAND).getY() < u.getJoint(Joint.HEAD).getY());
        }
        
        if(anyRightHandUp)
        {
            System.out.println("Right hand is up!");
            gamePlay.diceRolled(gamePlay);
            Greenfoot.delay(100);
            
        }
        
    }
    
    public boolean isLeftHandUp()
    {
        super.act();
       
        UserData[] us = getTrackedUsers();
        boolean anyLeftHandUp = false;
        

        for (UserData u: us)
        {
           anyLeftHandUp = anyLeftHandUp || (u.getJoint(Joint.LEFT_HAND).getY() < u.getJoint(Joint.HEAD).getY());
        }
        
        if(anyLeftHandUp)
        {
            System.out.println("Left hand is up!");
            Greenfoot.delay(100);
        }
        
        return anyLeftHandUp;
    }
    
    public static World getWorld()
    {       
         return world;
    }
    
    public void setWorld()
    {
        this.world = this;
    }
    
    
}
