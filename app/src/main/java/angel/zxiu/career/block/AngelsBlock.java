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

/**
 * Created by zxiu on 17.07.16.
 */
public abstract class AngelsBlock extends FrameLayout {
    public List<TextInputLayout> textInputLayouts = new ArrayList<>();

    public abstract int getContentLayoutResId();

    public AngelsBlock(Context context) {
        this(context, null);
    }

    public AngelsBlock(Context context, AttributeSet attrs) {
        super(context, attrs);
        traverseViews(inflate(context, getContentLayoutResId(), this));
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    void traverseViews(final View view) {
        if (view instanceof TextInputLayout) {
            textInputLayouts.add((TextInputLayout) view);
        }
        if (view instanceof ViewGroup) {
            for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
                traverseViews(((ViewGroup) view).getChildAt(i));
            }
        }
    }

    public void setHintEnable(boolean enable) {
        for (TextInputLayout layout : textInputLayouts) {
            layout.setHintEnabled(enable);
        }
    }
}
