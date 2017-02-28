package me.fahmisdk6.avatarview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * Created by FahmiSDK on 16/02/2015.
 */
public class FontTextView extends TextView {

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //Typeface.createFromAsset doesn't work in the layout editor. Skipping...
        if (isInEditMode()) {
            return;
        }

        TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.FontTextView);
        String fontName = styledAttrs.getString(R.styleable.FontTextView_tfont);
        styledAttrs.recycle();

        if (fontName != null) {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontName);
            setTypeface(typeface);
        }
    }

    public void setFont(String fontName){
        if (fontName != null) {
            Typeface typeface = Typeface.createFromAsset(getContext().getAssets(), fontName);
            setTypeface(typeface);
        }
    }

}
