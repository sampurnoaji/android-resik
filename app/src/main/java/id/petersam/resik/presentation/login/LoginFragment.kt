package id.petersam.resik.presentation.login

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import id.petersam.resik.R
import id.petersam.resik.data.vo.HttpResult
import id.petersam.resik.data.vo.LoadResult
import id.petersam.resik.databinding.FragmentLoginBinding
import id.petersam.resik.external.base.BaseFragment
import id.petersam.resik.presentation.MainActivity
import id.petersam.resik.presentation.util.gone
import id.petersam.resik.presentation.util.navigateTo
import id.petersam.resik.presentation.util.snackBar
import id.petersam.resik.presentation.util.visible

class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>() {

    override fun getLayoutResourceId(): Int = R.layout.fragment_login
    override fun getViewModelClass(): Class<LoginViewModel> = LoginViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar()
        checkLoginState()
        observeLoginResult()

        binding.btnLogin.setOnClickListener { onButtonLoginPressed() }
    }

    private fun setupToolbar() {
        (activity as MainActivity).hideToolbar()
    }

    private fun checkLoginState() {
        if (vm.isLoggedIn()) {
            snackBar("Already logged in")
        }
    }

    private fun observeLoginResult() {
        vm.login.observe(viewLifecycleOwner, Observer {
            when (it) {
                is LoadResult.Loading -> {
                    binding.pbLogin.visible()
                    binding.btnLogin.isEnabled = false
                }
                is LoadResult.Success -> {
                    snackBar("Login success")
                    navigateTo(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
                }
                is LoadResult.Error -> {
                    binding.pbLogin.gone()
                    binding.btnLogin.isEnabled = true

                    when (it.cause) {
                        HttpResult.NO_CONNECTION -> noConnectionAlertBottomSheet(retryAction = { onButtonLoginPressed() })
                        HttpResult.TIMEOUT -> timeoutAlertBottomSheet(retryAction = { onButtonLoginPressed() })
                        HttpResult.CLIENT_ERROR -> clientErrorAlertBottomSheet(retryAction = { onButtonLoginPressed() })
                        HttpResult.BAD_RESPONSE -> unknownAlertBottomSheet(retryAction = { onButtonLoginPressed() })
                        HttpResult.SERVER_ERROR -> serverErrorAlertBottomSheet(retryAction = { onButtonLoginPressed() })
                        HttpResult.NOT_DEFINED -> unknownAlertBottomSheet(retryAction = { onButtonLoginPressed() })
                    }

                }
            }
        })
    }

    private fun onButtonLoginPressed() {
//        vm.login("username", "password")
        navigateTo(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
    }
}
