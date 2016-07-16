package angel.zxiu.career.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.InvocationTargetException;

import angel.zxiu.career.R;
import angel.zxiu.career.page.AngelsPage;
import angel.zxiu.career.page.PersonalInfoPage;

/**
 * Created by zxiu on 14.07.16.
 */
public abstract class AngelsPagerFragment extends AngelsFragment {
    ViewPager pager;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_angels_pager;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        pager = (ViewPager) view.findViewById(R.id.pager);
        pager.setAdapter(new AngelsPagerAdapter());
    }

    public class AngelsPagerAdapter extends PagerAdapter {

        AngelsPage[] pages = new AngelsPage[getCount()];

        @TargetApi(Build.VERSION_CODES.KITKAT)
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            try {
                container.addView(getPage(position));
                return getPage(position);
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | java.lang.InstantiationException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(pages[position]);
            pages[position] = null;
        }

        @Override
        public int getCount() {
            return AngelsPagerFragment.this.getPages().length;
        }

        public AngelsPage getPage(int position) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, java.lang.InstantiationException {
            AngelsPage page = pages[position];
            if (page == null) {
                Class<?>[] parameterTypes = new Class<?>[]{Context.class};
                Object[] args = new Object[]{getActivity()};
                page = getPages()[position].getConstructor(parameterTypes).newInstance(args);
                pages[position] = page;
            }
            return page;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            try {
                return getString(getPage(position).getTitleResId());
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
            return new String();
        }
    }

}
