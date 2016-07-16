package angel.zxiu.career.page;

import android.content.Context;
import android.view.View;

import angel.zxiu.career.R;

/**
 * Created by zxiu on 15.07.16.
 */
public class WorkingExpPage extends AngelsPage{
    public WorkingExpPage(Context context) {
        super(context);
    }

    @Override
    public int getLayoutResId() {
        return R.layout.page_working_exp;
    }


    @Override
    public int getTitleResId() {
        return R.string.page_working_exp;
    }

}
