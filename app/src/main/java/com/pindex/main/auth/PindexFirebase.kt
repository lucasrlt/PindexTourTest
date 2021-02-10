package com.pindex.main.auth

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

/**
 * Singleton to sign in to Firebase.
 */
object PindexFirebase {

    private var auth: FirebaseAuth = Firebase.auth

    /**
     * Anonymously log in the user ; the user does not have
     * to be registered.
     */
    fun signInAnonymously(activity: AppCompatActivity) {
        auth.signInAnonymously()
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    Toast.makeText(activity, user.toString(),
                        Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

}
