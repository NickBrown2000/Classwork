//Clock class using calenderdate class
import java.util.*;


public class Clock{

    private int hour,
            min,
            sec;

    public Clock(){
        hour=0;
        min=0;
        sec=0;
    }

    public Clock(int hrSet, int minSet, int secSet){
        hour=hrSet;
        min=minSet;
        sec=secSet;
    }

    public void reset(){
        hour=0;
        min=0;
        sec=0;
    }

    public void reset(int hrSet, int minSet, int secSet){
        hour=hrSet;
        min=minSet;
        sec=secSet;
    }

    public void advance(){
        sec++;

        if(sec==60){
            sec=0;
            min++;
        }

        if(min==60){
            min=0;
            hour++;
        }

        if(hour==24){
            hour=0;
            reset();
        }

    }

    public String toString(){
        String time = ("");
        if (hour<10){
            time+="0";
        }
        time+=(hour+":");

        if (min<10){
            time+="0";
        }
        time+=(min+":");

        if (sec<10){
            time+="0";
        }
        time+=(sec);

        return time;
    }
}
