package Utils;

import android.graphics.drawable.StateListDrawable;
import android.widget.Toast;

import app.MyApplication;

/**
 * Created by admin on 2017/8/23.
 */

public class AppUtils {

    public static void showToast(String txt){
        Toast.makeText(MyApplication.getInstance().getApplicationContext(),txt,Toast.LENGTH_SHORT).show();
    }

    public static StateListDrawable getSelectListDrawable(int normal,int selected){
        StateListDrawable drawable = new StateListDrawable();
        drawable.addState(new int[]{android.R.attr.state_selected},MyApplication.getInstance().getResources().getDrawable(selected));
        drawable.addState(new int[]{},MyApplication.getInstance().getResources().getDrawable(normal));
        return drawable;
    }

}
