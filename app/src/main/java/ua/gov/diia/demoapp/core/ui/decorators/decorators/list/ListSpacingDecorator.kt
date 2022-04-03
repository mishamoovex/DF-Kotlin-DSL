package ua.gov.diia.demoapp.core.ui.decorators.decorators.list

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * The [RecyclerView] items spacing decorator for [LinearLayoutManager] which applies spacing
 * between [RecyclerView] and child.
 *
 * Works for both orientations [LinearLayoutManager.HORIZONTAL]
 * and [LinearLayoutManager.VERTICAL] based on the [orientation] parameter.
 *
 * Optionally can apply spacing between [RecyclerView] edges and his child
 * based on the[includeAllEdges] parameter.
 *
 * @param spacing the required item spacing in Px. Note that depend on in which unit this value
 *                was passed to this decorator (Px or Dp(Dpi)) spacing may be different.
 *
 * @param includeAllEdges indicated if need to add an item spacing for [RecyclerView] edges
 *
 * @throws IllegalArgumentException if [RecyclerView] has unsupported orientation for this binding operation
 */
class ListSpacingDecorator(
    private var includeAllEdges: Boolean = false,
    private var includeTopAges: Boolean = false,
    private var spacing: Int,
    private var orientation: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val itemPosition = parent.getChildAdapterPosition(view)
        val itemsCount = parent.adapter?.itemCount
        val isLasListItem = (itemPosition == itemsCount?.minus(1) ?: itemPosition)
        val isFirstListItem = itemPosition == 0
        val isLayoutReversed = (parent.layoutManager as LinearLayoutManager).reverseLayout

        when (orientation) {
            LinearLayoutManager.VERTICAL -> {
                if (includeAllEdges) {
                    if (isFirstListItem) {
                        outRect.top = spacing
                    }
                    outRect.left = spacing
                    outRect.right = spacing
                    outRect.bottom = spacing

                }

                else if (includeTopAges){
                    if (isFirstListItem) {
                        outRect.top = spacing
                    }
                    outRect.bottom = spacing
                }

                else {
                    if (!isLasListItem) {
                        outRect.bottom = spacing
                    }
                }
            }

            LinearLayoutManager.HORIZONTAL -> {
                if (includeAllEdges) {
                    if (isLayoutReversed){
                        if (isFirstListItem){
                            outRect.right = spacing
                        }
                        outRect.top = spacing
                        outRect.bottom = spacing
                        outRect.left = spacing
                    }else{
                        if (isFirstListItem) {
                            outRect.left = spacing
                        }
                        outRect.top = spacing
                        outRect.bottom = spacing
                        outRect.right = spacing
                    }
                }

                if (includeTopAges){
                    if (isLayoutReversed){
                        if (isFirstListItem){
                            outRect.right = spacing
                        }
                        outRect.left = spacing
                    }else{
                        if (isFirstListItem) {
                            outRect.left = spacing
                        }
                        outRect.right = spacing
                    }
                }

                else {
                    if (!isLasListItem) {
                        if (isLayoutReversed){
                            outRect.left = spacing
                        }else{
                            outRect.right = spacing
                        }
                    }
                }
            }

            else -> throw IllegalArgumentException("Unknown orientation type -> $orientation")
        }

    }
}