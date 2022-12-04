package com.chat.chatapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse

class SignInActivity : AppCompatActivity() {
    private val RC_SIGN_IN = 1
    private lateinit var signInBtn:Button
    private val signInProviders =
        listOf(
            AuthUI.IdpConfig.EmailBuilder()
            .setAllowNewAccounts(true)
            .setRequireName(true)
            .build())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        signInBtn = findViewById(R.id.account_sign_in)


        signInBtn.setOnClickListener{
            val intent = AuthUI.getInstance().createSignInIntentBuilder()
                .setAvailableProviders(signInProviders)
                .setLogo(R.drawable.ic_baseline_people_24)
                .build()
            startActivityForResult(intent, RC_SIGN_IN)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val response = IdpResponse.fromResultIntent(data)

            if (resultCode == Activity.RESULT_OK) {
//                val progressDialog = indeterminateProgressDialog("Setting up your account")
//                FirestoreUtil.initCurrentUserIfFirstTime {
//                    startActivity(intentFor<MainActivity>().newTask().clearTask())
//
//                    val registrationToken = FirebaseInstanceId.getInstance().token
//                    MyFirebaseInstanceIDService.addTokenToFirestore(registrationToken)

//                    progressDialog.dismiss()
//                }
            }
            else if (resultCode == Activity.RESULT_CANCELED) {
//                if (response == null) return
//
//                when (response.error?.errorCode) {
//                    ErrorCodes.NO_NETWORK ->
//                        longSnackbar(constraint_layout, "No network")
//                    ErrorCodes.UNKNOWN_ERROR ->
//                        longSnackbar(constraint_layout, "Unknown error")
//                }
            }
        }
    }
}