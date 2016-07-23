package angel.zxiu.career;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;

import angel.zxiu.career.bean.AngelsData;

/**
 * Created by zxiu on 17.07.16.
 */
public class App extends Application {
    public static Application context;
    public static AngelsData angelsData;

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

    public static void saveData() {
        getEditor().putString("AngelsData", JSON.toJSONString(angelsData));
    }

    public static AngelsData getData() {
        if (angelsData == null) {
            String dataString = getSharedPreferences().getString("AngelsData", null);
            if (!TextUtils.isEmpty(dataString)) {
                angelsData = JSON.parseObject(dataString, AngelsData.class);
            }
        }
        if (angelsData == null) {
            angelsData = new AngelsData();
        }
        return angelsData;
    }
}
