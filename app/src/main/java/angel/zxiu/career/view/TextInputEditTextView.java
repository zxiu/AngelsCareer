package angel.zxiu.career.view;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.support.design.widget.TextInputEditText;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import angel.zxiu.career.R;

/**
 * Created by zxiu on 17.07.16.
 */
public class TextInputEditTextView extends TextInputEditText {


    public TextInputEditTextView(Context context) {
        this(context, null);
    }

    public TextInputEditTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isInputDateTime()) {
                    showDatePicker();
                }
            }
        });
    }

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (focused && isInputDateTime()) {
            showDatePicker();
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
