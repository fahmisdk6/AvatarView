package me.fahmisdk6.avatarview.rounded;

import android.content.Context;
import android.util.AttributeSet;

public class DynamicRoundedImageView extends RoundedImageView {

	private double mHeightRatio;

	public DynamicRoundedImageView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public DynamicRoundedImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public DynamicRoundedImageView(Context context) {
		super(context);
	}

	public void setHeightRatio(double ratio) {
		if (ratio != mHeightRatio) {
			mHeightRatio = ratio;
			requestLayout();
		}
	}

	public double getHeightRatio() {
		return mHeightRatio;
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		if (mHeightRatio > 0.0) {
			// set the image views size
			int width = MeasureSpec.getSize(widthMeasureSpec);
			int height = (int) (width * mHeightRatio);
			setMeasuredDimension(width, height);
		} else {
			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		}
	}

}
