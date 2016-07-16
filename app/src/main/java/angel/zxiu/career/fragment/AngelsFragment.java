package angel.zxiu.career.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import angel.zxiu.career.page.AngelsPage;

/**
 * Created by zxiu on 14.07.16.
 */
public abstract class AngelsFragment extends Fragment {

    public abstract int getLayoutResId();

    public abstract int getTitleResId();

    protected abstract Class<AngelsPage>[] getPages();

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutResId(), null);
    }

    @Override
    public abstract void onViewCreated(View view, @Nullable Bundle savedInstanceState);
}
