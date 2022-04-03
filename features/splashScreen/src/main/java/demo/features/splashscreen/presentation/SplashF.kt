package demo.features.splashscreen.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import demo.features.splashscreen.databinding.FragmentSplashBinding
import demo.features.splashscreen.di.injectGraph
import ua.gov.diia.demoapp.presentation.MainActivity

internal class SplashF : Fragment() {

    private var binding: FragmentSplashBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectGraph()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false).apply {
            btnAuthSplash.setOnClickListener {
                (requireActivity() as MainActivity).navigateToAuth()
            }
        }
        return binding?.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}