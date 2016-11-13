package vn.tungdx.mediapicker.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;

import vn.tungdx.mediapicker.R;


/**
 * @author TUNGDX
 */

/**
 * Display thumbnail of video, photo and state when video, photo selected or
 * not.
 */
public class PickerImageView extends ImageView {
    private Paint paintBorder;

    private boolean isSelected;
    private int borderSize = 1;

    public PickerImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public PickerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PickerImageView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paintBorder = new Paint();
        paintBorder.setAntiAlias(true);
        paintBorder.setColor(ContextCompat.getColor(getContext(), R.color.picker_color));
        borderSize = getResources().getDimensionPixelSize(R.dimen.picker_border_size);
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        if (isSelected != this.isSelected) {
            this.isSelected = isSelected;
            invalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        setMeasuredDimension(width, width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSelected) {
            canvas.drawRect(0, 0, borderSize, getHeight(), paintBorder);
            canvas.drawRect(getWidth() - borderSize, 0, getWidth(),
                            getHeight(), paintBorder);
            canvas.drawRect(0, 0, getWidth(), borderSize, paintBorder);
            canvas.drawRect(0, getHeight() - borderSize, getWidth(),
                            getHeight(), paintBorder);
        }
    }
}