package angel.zxiu.career.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import angel.zxiu.career.R;
import angel.zxiu.career.util.Logger;

/**
 * Created by zxiu on 19.07.16.
 */
public class AngelsLinearLayout extends LinearLayout {
    public String path;
    public AngelsLinearLayout(Context context) {
        this(context, null);
    }

    public AngelsLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.AngelsLinearLayout);
        path = a.getString(R.styleable.AngelsLinearLayout_path);
        a.recycle();
    }
}
