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
import android.view.inputmethod.EditorInfo;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import angel.zxiu.career.App;
import angel.zxiu.career.R;

/**
 * Created by zxiu on 17.07.16.
 */
public class TextInputEditTextView extends TextInputEditText {

    public String key;

    public TextInputEditTextView(Context context) {
        this(context, null);
    }

    public TextInputEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.TextInputEditTextView);
        key = a.getString(R.styleable.TextInputEditTextView_key);
        a.recycle();

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInputDateTime()) {
                    showDatePicker();
                }
                ;
            }
        });
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
//        Toast.makeText(getContext(), "Save "+key, Toast.LENGTH_LONG).show();
        App.getEditor().putString(key, getText().toString()).apply();
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused && isInputDateTime()) {
            showDatePicker();
        } else {
            saveValue();
        }
    }

    public boolean isInputDateTime() {
        return getInputType() == InputType.TYPE_CLASS_DATETIME;
    }

    void showDatePicker() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(R.string.birthday);
        final DatePicker datePicker = new DatePicker(getContext());
        builder.setView(datePicker);
        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                setText(datePicker.getYear() + "-" + datePicker.getMonth() + "-" + datePicker.getDayOfMonth());
            }
        });
        builder.setNegativeButton(android.R.string.cancel, null);
        builder.show();
    }
}
