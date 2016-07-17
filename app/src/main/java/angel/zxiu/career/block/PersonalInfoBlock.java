package angel.zxiu.career.block;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import angel.zxiu.career.R;

/**
 * Created by zxiu on 17.07.16.
 */
public class PersonalInfoBlock extends AngelsBlock {


    @Override
    public int getContentLayoutResId() {
        return R.layout.block_personal_info;
    }

    public PersonalInfoBlock(Context context) {
        this(context, null);
    }

    public PersonalInfoBlock(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



}
