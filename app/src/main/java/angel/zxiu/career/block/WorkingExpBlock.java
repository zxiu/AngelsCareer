package angel.zxiu.career.block;

import android.content.Context;
import android.util.AttributeSet;

import angel.zxiu.career.R;

/**
 * Created by zxiu on 17.07.16.
 */
public class WorkingExpBlock extends AngelsBlock {


    @Override
    public int getContentLayoutResId() {
        return R.layout.block_personal_info;
    }

    public WorkingExpBlock(Context context) {
        this(context, null);
    }

    public WorkingExpBlock(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



}
