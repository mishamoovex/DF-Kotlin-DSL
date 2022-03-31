package demo.lib.lifecycle.live_data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

class CombinedLiveData<R>(
    vararg liveDatas: LiveData<*>,
    private val combine: (datas: List<Any?>) -> R
) : MediatorLiveData<R>() {

    private val _data: MutableList<Any?> = MutableList(liveDatas.size) { null }

    init {
        for (i in liveDatas.indices) {
            super.addSource(liveDatas[i]) {
                _data[i] = it
                value = combine(_data)
            }
        }
    }
}