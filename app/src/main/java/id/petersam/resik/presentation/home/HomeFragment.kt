package id.petersam.resik.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import id.petersam.resik.R
import id.petersam.resik.presentation.MainActivity

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        requireActivity().onBackPressedDispatcher.addCallback(object :
            OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                requireActivity().finish()
            }
        })
        setupToolbar()
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun setupToolbar() {
        (activity as MainActivity).showToolbar()
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_top, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).showStatusBar()
        (activity as MainActivity).showBottomNavigation()
    }
}
