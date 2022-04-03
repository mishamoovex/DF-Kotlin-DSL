package ua.gov.diia.demoapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.dynamicfeatures.DynamicExtras
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor
import androidx.navigation.findNavController
import androidx.navigation.navOptions
import ua.gov.diia.demoapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun navigateToAuth() {
        val navController = findNavController(R.id.navHost_main)

        val installMonitor = DynamicInstallMonitor()
        val dynamicExtras = DynamicExtras(installMonitor)

//        val navOptions = navOptions {
//            popUpTo(R.id.graphSplash) {
//                inclusive = false
//            }
//        }

        navController.navigate(
            R.id.graphAuthorization,
            null,
            null,
            dynamicExtras
        )
    }

}