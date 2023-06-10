package com.example.shopapp.UI.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.shopapp.R
import com.example.shopapp.firestore.FirestoreClass
import com.example.shopapp.models.User
import com.example.shopapp.utils.Constants
import com.example.shopapp.utils.GlideLoader
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : BaseActivity(), View.OnClickListener {

    private lateinit var mUserDetails: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        setupActionBar()

        tv_edit_setting.setOnClickListener(this@SettingsActivity)

        btn_logout_setting.setOnClickListener(this@SettingsActivity)
    }


    /**
     * onResume() method works when the first start of the activity and not work again until the user close the application and reopen it again
     */
    override fun onResume() {
        super.onResume()

        getUserDetails()
    }


    /**
     * A function for actionBar Setup.
     */
    private fun setupActionBar() {

        setSupportActionBar(toolbar_settings_activity_setting)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_white_color_back_24dp)
        }

        toolbar_settings_activity_setting.setNavigationOnClickListener { onBackPressed() }
    }


    /**
     * A function to get the user details from firestore.
     */
    private fun getUserDetails() {

        // Show the progress dialog
        showProgressDialog(resources.getString(R.string.please_wait))

        // Call the function of Firestore class to get the user details from firestore which is already created.
        FirestoreClass().getUserDetails(this@SettingsActivity)
    }


    /**
     * A function to receive the user details and populate it in the UI.
     */
    fun userDetailsSuccess(user: User) {

        mUserDetails = user

        // Hide the progress dialog
        hideProgressDialog()

        // Load the image using the Glide Loader class.
        GlideLoader(this@SettingsActivity).loadUserPicture(user.image, iv_user_photo_setting)

        tv_name_setting.text = "${user.firstName} ${user.lastName}"
        tv_gender_setting.text = user.gender
        tv_email_setting.text = user.email
        tv_mobile_number_setting.text = "${user.mobile}"
    }


    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id) {

                R.id.tv_edit_setting -> {
                    val intent = Intent(this@SettingsActivity, UserProfileActivity::class.java)
                    intent.putExtra(Constants.EXTRA_USER_DETAILS, mUserDetails)
                    startActivity(intent)
                }

                R.id.btn_logout_setting -> {

                    FirebaseAuth.getInstance().signOut()

                    val intent = Intent(this@SettingsActivity, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
            }
        }
    }
}