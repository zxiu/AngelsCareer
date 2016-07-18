package angel.zxiu.career.page;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import angel.zxiu.career.R;
import angel.zxiu.career.block.AngelsBlock;
import angel.zxiu.career.block.PersonalInfoBlock;

/**
 * Created by zxiu on 15.07.16.
 */
public class PersonalInfoPage extends AngelsPage {
    public PersonalInfoPage(Context context) {
        super(context);
    }

    @Override
    public int getTitleResId() {
        return R.string.page_personal_info;
    }

    @Override
    public AngelsBlock getDefaultBlock() {
        return new PersonalInfoBlock(getContext());
    }

}
