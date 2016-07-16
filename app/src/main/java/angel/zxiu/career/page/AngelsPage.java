package angel.zxiu.career.page;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.text.TextUtilsCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxiu on 15.07.16.
 */
public abstract class AngelsPage extends FrameLayout {
    public abstract int getLayoutResId();

    List<View> editableViews = new ArrayList<>();

    public AngelsPage(Context context) {
        super(context);
        inflate(context, getLayoutResId(), this);
        traverseViews(this);
    }

    public abstract int getTitleResId();

    void traverseViews(final View view) {
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                traverseViews(((ViewGroup) view).getChildAt(i));
            }
        } else if (view instanceof EditText) {
            editableViews.add(view);
        }
    }

}
