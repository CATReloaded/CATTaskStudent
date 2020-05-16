package cat.reloaded.tasks.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import cat.reloaded.tasks.MainActivity
import cat.reloaded.tasks.R
import cat.reloaded.tasks.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        btnLogin.setOnClickListener {
            if (TextUtils.isEmpty(etEmail.text.toString())){
                Toast.makeText(this, "Enter an e-mail", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            } else if (TextUtils.isEmpty(etPwd.text.toString())){
                Toast.makeText(this, "Enter a password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else {
                login(etEmail.text.toString(), etPwd.text.toString())
            }
        }
    }

    private fun login(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {task ->
                if (task.isSuccessful){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this, "Logging in failed: " + task.exception, Toast.LENGTH_SHORT).show()
                }

            }
    }

}
