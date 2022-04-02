package demo.features.authorization.presentation.method

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import demo.features.authorization.databinding.FragmentAuthorizationBinding
import demo.features.authorization.di.injectGraph

internal class SelectAuthMethodF : Fragment() {

    private val viewModel: SelectAuthMethodVM by viewModels()
    private var binding: FragmentAuthorizationBinding? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injectGraph()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding
    }
}