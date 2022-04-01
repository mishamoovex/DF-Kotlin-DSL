package demo.lib.navigation.navigation

import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import demo.lib.navigation.destination.currentDestinationId

fun Fragment.navigate(uri: String, popInclusive: Boolean = false) {
    val destinationId = currentDestinationId
        ?: throw IllegalArgumentException("Can't find current destination id")

    val options = navOptions {
        popUpTo(destinationId) {
            inclusive = popInclusive
        }
    }
    val request = NavDeepLinkRequest.Builder
        .fromUri(uri.toUri())
        .build()

    findNavController().navigate(request, options)
}