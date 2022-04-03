package ua.gov.diia.demoapp.core.ui.decorators.decorators.grid

import android.content.Context
import android.graphics.Canvas
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridDevimiterDecorator(
    context: Context,
    @DrawableRes dividerRes: Int
) : RecyclerView.ItemDecoration() {

    private val mDividerHorizontal = ContextCompat.getDrawable(context, dividerRes)
    private val mDividerVertical = ContextCompat.getDrawable(context, dividerRes)

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val verticalDividerWidth = mDividerVertical?.intrinsicWidth ?: 0
        val horizontalDividerHeight = mDividerHorizontal?.intrinsicHeight ?: 0

        val vLeft = parent.width / 2
        val vRight = vLeft + verticalDividerWidth

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val layoutParams = child.layoutParams as RecyclerView.LayoutParams
            val layoutManager = parent.layoutManager as GridLayoutManager
            val column = layoutManager.spanSizeLookup.getSpanIndex(i, layoutManager.spanCount)
            val isFirstColumn = column < 1

            val hLeft =
                if (isFirstColumn) parent.paddingLeft else child.left + layoutParams.marginStart
            val hRight = child.right + layoutParams.marginEnd
            val hTop = child.bottom + layoutParams.bottomMargin
            val hBottom = hTop + horizontalDividerHeight

            mDividerHorizontal?.setBounds(hLeft, hTop, hRight, hBottom)
            mDividerHorizontal?.draw(c)

            if (isFirstColumn) {
                val vTop = child.top + layoutParams.topMargin

                mDividerVertical?.setBounds(vLeft, vTop, vRight, hBottom)
                mDividerVertical?.draw(c)
            }
        }

    }
}