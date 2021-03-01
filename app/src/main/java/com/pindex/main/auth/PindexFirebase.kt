package com.pindex.main.auth

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
    fun signInAnonymously() {
        auth.signInAnonymously()
    }

}
