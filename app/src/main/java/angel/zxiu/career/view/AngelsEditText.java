package angel.zxiu.career.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.design.widget.TextInputEditText;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import angel.zxiu.career.App;
import angel.zxiu.career.R;

/**
 * Created by zxiu on 17.07.16.
 */
public class AngelsEditText extends TextInputEditText {

    public String key;
    public List<String> paths = new ArrayList<>();

    public AngelsEditText(Context context) {
        this(context, null);
    }

    public AngelsEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.AngelsEditText);
        key = a.getString(R.styleable.AngelsEditText_key);
        a.recycle();
        setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                saveValue();
                return true;
            }
        });
        setText(App.getSharedPreferences().getString(key, null));
    }

    protected void saveValue() {
        App.getEditor().putString(key, getText().toString()).apply();
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (!focused) {
            saveValue();
        }
    }
}
