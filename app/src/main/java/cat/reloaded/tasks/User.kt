package cat.reloaded.tasks

import com.google.firebase.firestore.Exclude

data class User(val userID: String?, val email: String, val name: String, val circle: String, val communication: String,@Exclude val path: String) {
}