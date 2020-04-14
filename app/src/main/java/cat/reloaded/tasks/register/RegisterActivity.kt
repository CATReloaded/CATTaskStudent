package cat.reloaded.tasks.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import cat.reloaded.tasks.MainActivity
import cat.reloaded.tasks.R
import cat.reloaded.tasks.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_register.*
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        btnLogin.setOnClickListener { finish() }
        ArrayAdapter.createFromResource(
            this,
            R.array.circles,
            android.R.layout.simple_spinner_item
        ).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            circle.adapter = this
        }
        btnRegister.setOnClickListener {
            if (!isValidEmail(etEmail.text.toString())
                || etName.text.toString().isEmpty()
                || etPwd.text.toString().isEmpty()
                || etPwdAgain.text.toString().isEmpty()
                || etCommunication.text.toString().isEmpty()){
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
            else if (etPwd.text.toString() != etPwdAgain.text.toString()){
                Toast.makeText(this, "Please check your password", Toast.LENGTH_SHORT).show()}
            else{
                signUp(etEmail.text.toString(), etPwd.text.toString())

                val docRef = db.collection("Users").document()
                val path = docRef.path

                Log.d("XXXXXXXXX", path)

                val user = User(auth.currentUser?.uid,
                    etEmail.text.toString(),
                    etName.text.toString(),
                    circle.selectedItem.toString(),
                    etCommunication.text.toString(),
                    path)

                docRef.set(user)
            }
        }
    }

    private fun signUp(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {task ->
                if (task.isSuccessful){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this, "Signing up failed: " + task.exception, Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun isValidEmail(email: String): Boolean{
        val expression = "^[\\w.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }
}
