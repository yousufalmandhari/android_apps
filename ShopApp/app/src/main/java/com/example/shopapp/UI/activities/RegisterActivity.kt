package com.example.shopapp.UI.activities

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.example.shopapp.R
import com.example.shopapp.firestore.FirestoreClass
import com.example.shopapp.models.User
import kotlinx.android.synthetic.main.activity_register.*

@Suppress("DEPRECATION")
class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        /* This code to hide the top bar in the screen */
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        // Move to Login Activity
        tv_login.setOnClickListener {
            onBackPressed()
        }

        // call function to do button on the top bar
        setupActionBar()

        // register button
        btn_register.setOnClickListener {
            try {
                registerUser()
            }catch (e :Exception){
                Toast.makeText(this, e.message.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }

    /**
     * This function to make a button at the top bar to go back
     */
    private fun setupActionBar() {
        setSupportActionBar(toolbar_register_activity)
        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_black_color_back_24)
        }

        toolbar_register_activity.setNavigationOnClickListener {
            // same as when back button clicked
            onBackPressed()
        }
    }

    /**
     * A function to validate the entries of a new user.
     */
    private fun validateRegisterDetails(): Boolean {
        return when {
            TextUtils.isEmpty(et_first_name_profile.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_first_name), true)
                false
            }

            TextUtils.isEmpty(et_last_name_profile.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_last_name), true)
                false
            }

            TextUtils.isEmpty(et_email_profile.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }

            TextUtils.isEmpty(et_password.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
                false
            }

            TextUtils.isEmpty(et_confirm_password.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_confirm_password), true)
                false
            }

            et_password.text.toString().trim { it <= ' ' } != et_confirm_password.text.toString()
                    .trim { it <= ' ' } -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_password_and_confirm_password_mismatch), true)
                false
            }
            !cb_terms_and_condition.isChecked -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_agree_terms_and_condition), true)
                false
            }
            else -> {
//                showErrorSnackBar("Your details are valid.", false)
                true
            }
        }
    }


    private fun registerUser() {
        // Check with validate function if the entries are valid or not.
        if (validateRegisterDetails()) {

            // show dialog
            showProgressDialog(resources.getString(R.string.please_wait))

            val email: String = et_email_profile.text.toString().trim { it <= ' ' }
            val password: String = et_password.text.toString().trim { it <= ' ' }

            // Create an instance and create a register a user with email and password.
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(
                            OnCompleteListener<AuthResult> { task ->

                                // hide the dialog
                                hideProgressDialog()

                                // If the registration is successfully done
                                if (task.isSuccessful) {

                                    // Firebase registered user
                                    val firebaseUser: FirebaseUser = task.result!!.user!!

                                    try {
                                        // Instance of User data model class.
                                        val user = User(
                                            firebaseUser.uid,
                                            et_first_name_profile.text.toString().trim { it <= ' ' },
                                            et_last_name_profile.text.toString().trim { it <= ' ' },
                                            et_email_profile.text.toString().trim { it <= ' ' }
                                        )

                                        FirestoreClass().registerUser(this@RegisterActivity, user)
                                    }catch (e: Exception){
                                        Toast.makeText(this, e.message.toString(), Toast.LENGTH_LONG).show()
                                    }
                                    showErrorSnackBar(
                                            "You are registered successfully. Your user id is ${firebaseUser.uid}",
                                            false
                                    )

                                    // wait one second
                                    @Suppress("DEPRECATION")
                                    Handler().postDelayed(
                                            {
                                                // then logout
                                                FirebaseAuth.getInstance().signOut()
                                                finish()
                                            },
                                            1000
                                    )

                                } else {
                                    // If the registering is not successful then show error message.
                                    showErrorSnackBar(task.exception!!.message.toString(), true)
                                }
                            })
        }
    }
}