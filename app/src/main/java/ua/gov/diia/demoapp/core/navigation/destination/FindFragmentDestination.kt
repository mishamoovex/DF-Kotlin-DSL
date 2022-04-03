package ua.gov.diia.demoapp.core.navigation.destination

import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

val Fragment.currentDestinationId: Int?
    get() = findNavController().currentDestination?.id

val Fragment.previousDestinationId: Int?
    get() = findNavController().previousBackStackEntry?.destination?.id

fun NavController.observeDestination(): Flow<Int> = callbackFlow {
    val navigationListener = NavController.OnDestinationChangedListener { _, destination, _ ->
        trySend(destination.id)
    }
    addOnDestinationChangedListener(navigationListener)
    awaitClose { removeOnDestinationChangedListener(navigationListener) }
}
