package angel.zxiu.career;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.orm.SugarApp;

import angel.zxiu.career.bean.AngelsData;
import angel.zxiu.career.bean.UsersData;

/**
 * Created by zxiu on 17.07.16.
 */
public class App extends SugarApp {
    public static Application context;
    public static UsersData usersData;

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
        getEditor().putString("AngelsData", JSON.toJSONString(usersData));
    }

    public static AngelsData getData() {
        if (usersData == null) {
            String dataString = getSharedPreferences().getString("AngelsData", null);
            if (!TextUtils.isEmpty(dataString)) {
                usersData = JSON.parseObject(dataString, UsersData.class);
            }
        }
        if (usersData == null) {
            usersData = new UsersData();
        }
        return usersData;
    }
}
