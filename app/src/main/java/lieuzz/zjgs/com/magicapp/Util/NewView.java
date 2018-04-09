package lieuzz.zjgs.com.magicapp.Util;

/**
 * Created by Administrator on 2018/4/8.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import lieuzz.zjgs.com.magicapp.R;

public class NewView extends View{

    public NewView(Context context) {
        super(context);
    }
    public NewView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //方格长宽
    float width;
    float height;
    //选定的坐标
    int selectX;
    int selectY;
    int rank = 1;
    TextView title;

    MyGame mGame=new MyGame(this.getRank());

    //获得屏幕尺寸
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //每一个小格的长宽
        this.width=w/9f;
        this.height=h/9f;
    }


    //绘图函数
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画背景
        Paint bgPaint=new Paint();
        bgPaint.setColor(getResources().getColor(R.color.colorBackground));
        canvas.drawRect(0,0,getWidth(),getHeight(), bgPaint);
        //线条画笔
        Paint darkPaint =new Paint();
        darkPaint.setColor(getResources().getColor(R.color.colorDark));
        Paint hilitePaint =new Paint();
        hilitePaint.setColor(getResources().getColor(R.color.colorHilite));
        Paint lightPaint =new Paint();
        lightPaint.setColor(getResources().getColor(R.color.colorLight));
        //绘制线条
        for(int i=0;i<10;i++){
            canvas.drawLine(0, i*height,getWidth(),i*height,lightPaint);
            canvas.drawLine(0, i*height+1,getWidth(),i*height+1,hilitePaint);
            canvas.drawLine(i*width, 0,i*width,getWidth(),lightPaint);
            canvas.drawLine(i*width+1,0,i*width+1,getWidth(),hilitePaint);
            if(i%3==0){
                canvas.drawLine(0, (i+3)*height,getWidth(),(i+3)*height,darkPaint);
                canvas.drawLine(0, (i+3)*height+3,getWidth(),(i+3)*height+3,hilitePaint);
                canvas.drawLine(i*width, 0,i*width,getWidth(),darkPaint);
                canvas.drawLine(i*width+3, 0,i*width+3,getWidth(),hilitePaint);
            }
        }
        canvas.drawLine(0, getHeight(),getWidth(),getHeight(),darkPaint);
        //canvas.drawLine(0, (i+3)*height+3,getWidth(),(i+3)*height+3,hilitePaint);


        //绘制数字
        Paint numberPaint =new Paint();
        numberPaint.setColor(Color.BLACK);
        numberPaint.setStyle(Paint.Style.STROKE);
        numberPaint.setTextSize(height*0.75f);
        numberPaint.setTextAlign(Align.CENTER);

        //调节文字居中
        FontMetrics fMetrics=numberPaint.getFontMetrics();
        float x=width/2;
        float y=height/2-(fMetrics.ascent+fMetrics.descent)/2;
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                canvas.drawText(mGame.getNumber(i+1, j+1), i*width+x, y+j*height, numberPaint);
            }
        }

    }

    //触摸事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x=(int)(event.getX()/width);
        int y=(int)(event.getY()/height);
        if(x<=8 && y<=8){  //判断点击的是否是游戏界面
            int []t=mGame.getUsed(x, y);
            selectX=x;
            selectY=y;
            MyDialog mDialog=new MyDialog(getContext(), t, this); //调用自定义Dialog
            mDialog.show();
        }
        return super.onTouchEvent(event);
    }
    public void setTitle(int i){
        mGame.setTitle(i,selectX,selectY);
        invalidate();  //每次填写一个数 都要重新进行绘制
        mGame.youWin();
    }

    public void setRank(int rank){
        this.rank = rank;
        Log.d("rankkkkkk",String.valueOf(this.rank));
        mGame = new MyGame(this.rank);
    }
    private int getRank(){
        return rank;
    }


}