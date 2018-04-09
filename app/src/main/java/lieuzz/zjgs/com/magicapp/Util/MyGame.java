package lieuzz.zjgs.com.magicapp.Util;

/**
 * Created by Administrator on 2018/4/8.
 */
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


public class MyGame {

    Context context;
    private int rank = 1;
    String data1="200680507" +
            "900000012" +
            "748000060" +
            "387490000" +
            "451872639" +
            "029351478" +
            "194200300" +
            "870534196" +
            "506000024";
    String data2="080060000" +
            "953412678" +
            "160809504" +
            "010000062" +
            "849600000" +
            "326170000" +
            "001000009" +
            "070950000" +
            "600000801";
    String data3="800006905" +
            "925108000" +
            "001000003" +
            "002901387" +
            "370402000" +
            "006700000" +
            "000000654" +
            "684370200" +
            "000000008";
    String data4="000509710" +
            "800000006" +
            "500308900" +
            "014207000" +
            "000000081" +
            "000006070" +
            "000152030" +
            "000800000" +
            "009000420";
    String data5="021087005" +
            "067000000" +
            "530420076" +
            "200000004" +
            "000010008" +
            "010006200" +
            "800740000" +
            "000000600" +
            "000003700";
    int numbers[][] =new int[9][9];
    public MyGame(int rank){
        //初始化data
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
            {
                switch (rank)
                {
                    case 1:
                        numbers[i][j]=data1.charAt(i+j*9)-'0'; //字符转化为整形
                        break;
                    case 2:
                        numbers[i][j]=data2.charAt(i+j*9)-'0'; //字符转化为整形
                        break;
                    case 3:
                        numbers[i][j]=data3.charAt(i+j*9)-'0'; //字符转化为整形
                        break;
                    case 4:
                        numbers[i][j]=data4.charAt(i+j*9)-'0'; //字符转化为整形
                        break;
                    case 5:
                        numbers[i][j]=data5.charAt(i+j*9)-'0'; //字符转化为整形
                        break;
                }


            }
    }

    //得到值
    public String getNumber(int x,int y){
        if(numbers[x-1][y-1]==0)
            return "";
        else
            return ""+numbers[x-1][y-1];
    }
    //算出已经被用的数字
    public int[] getUsed(int x,int y){
        int c[]=new int[9];
        //x列
        for(int i=0;i<9;i++)
        {
            if(numbers[x][i]!=0)
            {
                c[numbers[x][i]-1]=numbers[x][i];
            }
        }
        //y排
        for(int i=0;i<9;i++)
        {
            if(numbers[i][y]!=0)
            {
                c[numbers[i][y]-1]=numbers[i][y];
            }
        }
        //小九宫格
        x=(x/3)*3;
        y=(y/3)*3;
        for(int i=0;i<9;i++)
        {
            if(numbers[x+i%3][y+i/3]!=0)
            {
                c[numbers[x+i%3][y+i/3]-1]=numbers[x+i%3][y+i/3];
            }
        }
        return c;
    }
    //设置选定的数字
    public void setTitle(int i,int x,int y){
        numbers[x][y]=i;
    }
    //判断游戏结束
    public void youWin(){
        int t=0;
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (numbers[i][j]!=0){
                    t++;
                }
            }
        }
        if (t==81){
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            builder.setTitle("Tips")
                    .setMessage("You Win !")
                    .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            System.exit(0);
                        }
                    }).show();
        }
    }
}
