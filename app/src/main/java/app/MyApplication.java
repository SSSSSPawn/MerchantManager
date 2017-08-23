package app;

import android.app.Application;

/**
 * Created by admin on 2017/8/23.
 */

public class MyApplication extends Application {

    private static MyApplication instanse;

    @Override
    public void onCreate() {
        super.onCreate();
        instanse = this;
    }

    public static MyApplication getInstance(){
        return instanse;
    }
}
