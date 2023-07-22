package ir.android.filimo.customview

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

class FarsiTextview:AppCompatTextView {
    constructor(context: Context) : super(context) {
        val face = Typeface.createFromAsset(context.assets,"fonts/IRANSans.ttf")
        setTypeface(face)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        val face = Typeface.createFromAsset(context.assets,"fonts/IRANSans.ttf")
        setTypeface(face)
    }

    constructor(context: Context, attrs: AttributeSet?, style: Int) : super(context, attrs, style) {
        val face = Typeface.createFromAsset(context.assets,"fonts/IRANSans.ttf")
        setTypeface(face)
    }

}