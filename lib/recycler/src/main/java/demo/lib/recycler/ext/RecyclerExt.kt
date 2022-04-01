package demo.lib.recycler.ext

import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.cleanUpItemDecorators() {
    if (itemDecorationCount > 0) {
        for (i in 0 until itemDecorationCount) {
            removeItemDecorationAt(i)
        }
    }
}