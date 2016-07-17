package angel.zxiu.career.page;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import angel.zxiu.career.R;

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
