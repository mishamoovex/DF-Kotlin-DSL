package demo.lib.navigation.result

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.fragment.findNavController
import demo.lib.navigation.destination.currentDestinationId

/**
 * Registers for result callbacks from a Dialog or BottomSheet destination.
 * Receives results while the lifecycle owner alive.
 *
 * @param key the key of the data request
 *
 * @param resultEvent the result callback with the data returned from the [sendResult]
 */
inline fun <T : Any> Fragment.registerForDialogNavigationResult(
    key: String,
    crossinline resultEvent: (T) -> Unit
) {
    @IdRes val currentDestinationId = currentDestinationId ?: return
    val navBackStackEntry = findNavController().getBackStackEntry(currentDestinationId)

    val observer = LifecycleEventObserver { _, event ->
        if (event == Lifecycle.Event.ON_RESUME && navBackStackEntry.savedStateHandle.contains(key)) {
            val result = navBackStackEntry.savedStateHandle.get<T>(key)
            result?.run { resultEvent.invoke(this) }
        }
    }

    //add observer to the fragment back stack
    navBackStackEntry.lifecycle.addObserver(observer)
}