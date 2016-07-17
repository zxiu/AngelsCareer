package angel.zxiu.career.util;

import android.app.Application;
import android.util.Log;

/**
 * Created by zxiu on 17.07.16.
 */
public class Logger {
    static String tag = "AngelsCareer";

    public static void i(String message) {
        Log.i(tag, message);
    }
}
