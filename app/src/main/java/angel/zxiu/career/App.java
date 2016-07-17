package angel.zxiu.career;

import android.app.Application;
import android.content.SharedPreferences;

/**
 * Created by zxiu on 17.07.16.
 */
public class App extends Application {
    public static Application context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static SharedPreferences getSharedPreferences() {
        return context.getSharedPreferences(context.getString(R.string.app_name), Application.MODE_PRIVATE);
    }
    public static SharedPreferences.Editor getEditor() {
        return getSharedPreferences().edit();
    }
}
