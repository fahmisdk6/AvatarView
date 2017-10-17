package me.fahmisdk6.avatarview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by USER on 10/17/2017.
 */

public class CircleAvatarView extends FrameLayout {

    CircleImageView imgAvatar;
    FontTextView textAvatar;

    public CircleAvatarView(Context context) {
        super(context);
    }

    public CircleAvatarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_circle_avatar, this);
        imgAvatar = (CircleImageView) findViewById(R.id.round_img_avatar);
        textAvatar = (FontTextView) findViewById(R.id.text_avatar_name);

        TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.CircleAvatarView);
        int bgColor = styledAttrs.getColor(R.styleable.CircleAvatarView_cavBgTextColor, Color.parseColor("#964357"));
        int textColor = styledAttrs.getColor(R.styleable.CircleAvatarView_cavTextColor, Color.parseColor("#FFFFFF"));
        float textSize = styledAttrs.getDimension(R.styleable.CircleAvatarView_cavTextSize, 24f);
        String font = styledAttrs.getString(R.styleable.CircleAvatarView_cavFont);
        styledAttrs.recycle();




        //setting bg color and corner radius
        GradientDrawable drawable = (GradientDrawable) textAvatar.getBackground();
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
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            textAvatar.setVisibility(GONE);
                            return false;
                        }
                    })
                    .into(imgAvatar);
        }
    }
}
