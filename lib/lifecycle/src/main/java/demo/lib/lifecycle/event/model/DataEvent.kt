package demo.lib.lifecycle.event.model

class DataEvent<out T: Any>(private val data: T) {

    private var hasBeenHandled = false

    fun getDataIfNotHandled(): T? =
        if (hasBeenHandled){
            null
        } else{
            hasBeenHandled = true
            data
        }
}