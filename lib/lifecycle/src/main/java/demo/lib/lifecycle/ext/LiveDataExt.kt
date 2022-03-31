package demo.lib.lifecycle.ext

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

inline fun <reified T> MutableLiveData<T>.asLiveData(): LiveData<T> = this