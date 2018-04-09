package lieuzz.zjgs.com.magicapp.Util;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import lieuzz.zjgs.com.magicapp.R;


/**
 * Created by Administrator on 2018/4/9.
 */

public class HardnessDialog extends Dialog {
    View keys[]=new View[5];

    public HardnessDialog(Context context) {
        super(context);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.hardness_table);
        int id[]=new int[]{R.id.easy,R.id.normal,R.id.hard,R.id.specialist,
                R.id.hell};


    }

}
