package lieuzz.zjgs.com.magicapp.Util;

/**
 * Created by Administrator on 2018/4/8.
 */

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import lieuzz.zjgs.com.magicapp.R;

public class MyDialog extends Dialog{

    NewView mView;
    View keys[]=new View[9];
    int []used=new int[9];

    //传入已经使用过的数字
    public MyDialog(Context context, int[] useed, NewView m) {
        super(context);
        this.mView=m;
        this.used=useed;

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置标题
        setTitle("可选数字");
        //设置布局文件
        setContentView(R.layout.table);
        int id[]=new int[]{R.id.bt1,R.id.bt2,R.id.bt3,R.id.bt4,
                R.id.bt5,R.id.bt6,R.id.bt7,R.id.bt8,R.id.bt9};
        for(int i=0;i<9;i++)
        {
            final int t=i+1;
            keys[i]=findViewById(id[i]);
            keys[i].setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    mView.setTitle(t);
                    dismiss(); //取消对话框
                }
            });
        }
        for(int i=0;i<9;i++)
        {
            if(used[i]!=0)
                keys[used[i]-1].setVisibility(View.INVISIBLE); //将不可使用的数字对应的Button设置为隐藏
        }
    }
}