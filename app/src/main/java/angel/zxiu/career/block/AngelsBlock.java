package angel.zxiu.career.block;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import angel.zxiu.career.view.AngelsEditText;
import angel.zxiu.career.view.AngelsLinearLayout;

/**
 * Created by zxiu on 17.07.16.
 */
public abstract class AngelsBlock extends FrameLayout {
    public List<TextInputLayout> textInputLayouts = new ArrayList<>();
    public List<AngelsEditText> angelsEditTextList = new ArrayList<>();

    public abstract int getContentLayoutResId();

    public AngelsBlock(Context context) {
        this(context, null);
    }

    public AngelsBlock(Context context, AttributeSet attrs) {
        super(context, attrs);
        traverseViews(inflate(context, getContentLayoutResId(), this), new ArrayList<String>());
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    void traverseViews(final View view, List<String> paths) {
        if (view instanceof TextInputLayout) {
            textInputLayouts.add((TextInputLayout) view);
        } else if (view instanceof AngelsEditText) {
            ((AngelsEditText) view).paths = paths;
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                if (view instanceof AngelsLinearLayout && ((AngelsLinearLayout) view).path != null) {
                    List<String> newPaths = new ArrayList<>();
                    newPaths.addAll(paths);
                    newPaths.add(((AngelsLinearLayout) view).path);
                    traverseViews(((AngelsLinearLayout) view).getChildAt(i), newPaths);
                } else {
                    traverseViews(((ViewGroup) view).getChildAt(i), paths);
                }
            }
        }
    }

    public void setHintEnable(boolean enable) {
        for (TextInputLayout layout : textInputLayouts) {
            layout.setHintEnabled(enable);
        }
    }
}
