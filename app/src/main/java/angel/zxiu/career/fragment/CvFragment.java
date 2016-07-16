package angel.zxiu.career.fragment;

import android.support.v4.view.ViewPager;

import angel.zxiu.career.R;
import angel.zxiu.career.page.AngelsPage;
import angel.zxiu.career.page.PersonalInfoPage;
import angel.zxiu.career.page.WorkingExpPage;

/**
 * Created by zxiu on 14.07.16.
 */
public class CvFragment extends AngelsPagerFragment {
    ViewPager pager;


    @Override
    public int getTitleResId() {
        return R.string.menu_cv;
    }

    @Override
    protected Class<AngelsPage>[] getPages() {
        return new Class[]{PersonalInfoPage.class, WorkingExpPage.class, PersonalInfoPage.class};
    }


}
