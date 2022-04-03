package ua.gov.diia.demoapp.core.navigation.result

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * Registers for result callbacks from a Fragment destination.
 * Receives results while the lifecycle owner alive.
 *
 * @param key the key of the data request
 *
 * @param resultEvent the result callback with the data returned from the [sendNavigationResult]
 */
inline fun <T : Any> Fragment.registerForFragmentNavResult(
    key: String,
    crossinline resultEvent: (T) -> Unit
) {
    findNavController()
        .currentBackStackEntry
        ?.savedStateHandle
        ?.getLiveData<T>(key)
        ?.observe(viewLifecycleOwner) {
            resultEvent.invoke(it)
        }
}
