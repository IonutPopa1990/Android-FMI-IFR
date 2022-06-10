package com.example.proiectfmi.ui.actions

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.proiectfmi.MainActivity
import com.example.proiectfmi.databinding.FragmentActionsBinding
import kotlinx.android.synthetic.main.fragment_actions.view.*
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult

class ActionsFragment : Fragment() {

    private lateinit var actionsViewModel: ActionsViewModel
    private var _binding: FragmentActionsBinding? = null
    lateinit var callbackManager: CallbackManager

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        actionsViewModel =
                ViewModelProvider(this).get(ActionsViewModel::class.java)

        _binding = FragmentActionsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnExplicit.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }

        binding.btnImplicit.setOnClickListener {
            var intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_TEXT, "Acest text este din aplicatia Android")
            intent.type = "text/plain"
            startActivity(intent)
        }

        val textView: TextView = binding.textActions
        actionsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        var activity : FragmentActivity = this.requireActivity()

        callbackManager = CallbackManager.Factory.create()

        val loginButton = root.login_button
        loginButton.setReadPermissions(listOf("public_profile", "email"))
        loginButton.setFragment(this)

        // Callback registration
        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult?> {
            override fun onSuccess(loginResult: LoginResult?) {
                // Get User's Info
                Toast.makeText( activity, "Autentificare Reusita: " + loginResult!!.getAccessToken().getUserId().toString(), Toast.LENGTH_LONG).show()
            }

            override fun onCancel() {
                Toast.makeText(activity, "Autentificarea nu a fost cu succes", Toast.LENGTH_LONG).show()
            }

            override fun onError(exception: FacebookException) {
                Toast.makeText(activity, exception.message, Toast.LENGTH_LONG).show()
            }
        })

        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}