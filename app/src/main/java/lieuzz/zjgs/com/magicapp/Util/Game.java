package lieuzz.zjgs.com.magicapp.Util;

/**
 * Created by Administrator on 2018/4/9.
 */

public class Game {
    private int gameid;
    private int time;
    private int timelong;

    private int easy;
    private int normal;
    private int hard;
    private int spe;
    private int hell;

    public int getId(){
        return gameid;
    }

    public void setId(int id){
        this.gameid = id;
    }

    public int getTime(){
        return time;
    }

    public void setTime(int time){
        this.time = time;
    }

    public int getTimelong(){
        return timelong;
    }

    public void setTimelong(int timelong){
        this.timelong =timelong;
    }

    public int getEasy(){
        return easy;
    }

    public void setEasy(int easy){
        this.easy = easy;
    }

    public int getNormal(){
        return normal;
    }

    public void setNormal(int normal){
        this.normal = normal;
    }

    public int getHard(){
        return hard;
    }

    public void setHard(int hard){
        this.hard = hard;
    }

    public int getSpe(){
        return spe;
    }

    public void setSpe(int spe){
        this.spe = spe;
    }

    public int getHell(){
        return hell;
    }

    public void setHell(int hell){
        this.hell = hell;
    }

}
