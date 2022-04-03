package ua.gov.diia.demoapp.core.navigation.result

import androidx.fragment.app.Fragment
import androidx.navigation.NavBackStackEntry
import androidx.navigation.fragment.findNavController

/**
 * Unregisters result callback from the [NavBackStackEntry].
 *
 * @param key the key of the data request
 */
fun <T> Fragment.clearResultCallback(key: String) {
    findNavController()
        .currentBackStackEntry
        ?.savedStateHandle
        ?.remove<T>(key)
}