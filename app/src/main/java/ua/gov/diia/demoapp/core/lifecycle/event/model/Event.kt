package ua.gov.diia.demoapp.core.lifecycle.event.model

class Event {

    private var hasBeenHandles = false

    fun getEventIfNoHandled(): Boolean =
        if (hasBeenHandles){
            false
        }else{
            hasBeenHandles = true
            true
        }
}