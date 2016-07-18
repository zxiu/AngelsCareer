package angel.zxiu.career.page;

import android.content.Context;
import android.view.View;

import angel.zxiu.career.R;
import angel.zxiu.career.block.AngelsBlock;
import angel.zxiu.career.block.WorkingExpBlock;

/**
 * Created by zxiu on 15.07.16.
 */
public class WorkingExpPage extends AngelsPage {
    public WorkingExpPage(Context context) {
        super(context);
    }

    public AngelsBlock getDefaultBlock() {
        return new WorkingExpBlock(getContext());
    }

    @Override
    public int getTitleResId() {
        return R.string.page_working_exp;
    }

}
