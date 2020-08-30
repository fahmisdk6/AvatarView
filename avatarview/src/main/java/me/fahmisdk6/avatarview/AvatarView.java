package me.fahmisdk6.avatarview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import me.fahmisdk6.avatarview.rounded.DynamicRoundedImageView;

/**
 * Created by USER on 2/13/2017.
 */

public class AvatarView extends FrameLayout {

    DynamicRoundedImageView imgAvatar;
    FontTextView textAvatar;

    public AvatarView(Context context) {
        super(context);
    }

    public AvatarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_avatar, this);
        imgAvatar = (DynamicRoundedImageView) findViewById(R.id.round_img_avatar);
        textAvatar = (FontTextView) findViewById(R.id.text_avatar_name);

        TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.AvatarView);
        int cornerRadius = styledAttrs.getDimensionPixelSize(R.styleable.AvatarView_avCornerRadius, 0);
        int bgColor = styledAttrs.getColor(R.styleable.AvatarView_avBgTextColor, Color.parseColor("#964357"));
        int textColor = styledAttrs.getColor(R.styleable.AvatarView_avTextColor, Color.parseColor("#FFFFFF"));
        float textSize = styledAttrs.getDimension(R.styleable.AvatarView_avTextSize, 24f);
        String font = styledAttrs.getString(R.styleable.AvatarView_avFont);
        styledAttrs.recycle();


        //setting Img corner radius
        imgAvatar.setCornerRadius((float) cornerRadius);


        //setting bg color and corner radius
        GradientDrawable drawable = (GradientDrawable) textAvatar.getBackground();
        drawable.setCornerRadius(cornerRadius);
        drawable.setColor(bgColor);
        textAvatar.invalidate();

        //text color and size
        textAvatar.setTextColor(textColor);
        textAvatar.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize);

        //text font
        textAvatar.setFont(font);

    }


    public void bind(String name, String pic) {
        textAvatar.setVisibility(VISIBLE);
        if(!TextUtils.isEmpty(name)){
            String nameArray[] = name.split(" ");
            String initial = "";
            for (int i = 0; i < nameArray.length; i++) {
                initial += nameArray[i].charAt(0);
            }
            textAvatar.setText(initial);
        }

        if (TextUtils.isEmpty(pic)) {
            imgAvatar.setImageDrawable(null);
        } else {
            Glide.with(getContext())
                    .load(pic)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            textAvatar.setVisibility(VISIBLE);
                            return false;
                        }
                    })
                    .into(imgAvatar);
        }
    }
}
