import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class ProgressDice extends Dice
{
    private static World myworld;
    static int dice_count = 3;
    private static int y_loc = 400;
    ScrumWorld world;
    DiceSumMessage message;
    
    public ProgressDice(){
        // your code here.
    }
    
    public static void getWorld(World world){
        myworld = world;
    }
    
    public int[] roll(int val){
        int[] dice_values = new int[dice_count];
        for(int i = 0; i < dice_count; i++){
            dice_values[i] = getRandomValue();
        }
        return dice_values;
    }
        
    public int getDiceCount(){
        return dice_count;
    }
    
    public void increaseDice(){
        dice_count++;
        System.out.println("World : " + myworld);
        y_loc = y_loc - 35;
        myworld.addObject(new ProgressDice(), 20, y_loc);
    }
    
    public int getSum(int[] val){
        int sum = 0;
        int[] sortedArr;
        int count=0;
        
        sortedArr = sort(val);
        for(int i=0; i < val.length; i++){
            if(val[i] == 6){
                count++;
                val[i] = 0;
            } else {
                if(count > 0){
                    sum += val[i]*2;
                    count--;
                } else {
                    sum += val[i]; 
                }
            }
        }
        message = DiceSumMessage.getMessageInstance();
        message.setTextMessage(Integer.toString(sum));
        
        return sum;
    }
    
    private int[] sort(int[] val_arr){
        int swap;
        for (int i = 0; i < val_arr.length; i++) {
            for (int j = 0; j < val_arr.length - i-1; j++) {
                if (val_arr[j] < val_arr[j+1]) /* For descending order use < */
                {
                  swap         = val_arr[j];
                  val_arr[j]   = val_arr[j+1];
                  val_arr[j+1] = swap;
                }
            }
        }
        System.out.println("Dice Values : ");
        for(int c=0; c<val_arr.length; c++){
            System.out.print(val_arr[c] + "  ");
        }
        return val_arr;
    }
}
