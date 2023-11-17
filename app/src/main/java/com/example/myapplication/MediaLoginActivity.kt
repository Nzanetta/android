import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.HomeActivity
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient

class MediaLoginActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener {

    private var mGoogleApiClient: GoogleApiClient? = null
    private val RC_SIGN_IN = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_login)

        google()
        login()

        // Configuración de inicio de sesión con Google
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        mGoogleApiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this, this)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()
    }

    private fun google() {
        val btnGoogle = findViewById<Button>(R.id.btnGoogle)
        btnGoogle.setOnClickListener {
            // Iniciar sesión con Google
            val signInIntent = mGoogleApiClient?.let { it1 ->

                Auth.GoogleSignInApi.getSignInIntent(
                    it1

                )
            }
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
    }

    private fun login() {
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val ventanaMain = Intent(applicationContext, MainActivity::class.java)
            startActivity(ventanaMain)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Resultado del inicio de sesión con Google
        if (requestCode == RC_SIGN_IN) {
            val result = data?.let { Auth.GoogleSignInApi.getSignInResultFromIntent(it) }
            if (result != null) {
                handleSignInResult(result)
            }
        }
    }

    private fun handleSignInResult(result: GoogleSignInResult) {
        if (result.isSuccess) {
            // Inicio de sesión exitoso, obtén la cuenta de Google
            val account = result.signInAccount
            // Aquí puedes obtener información de la cuenta, como el nombre y el correo electrónico
            val displayName = account?.displayName
            val email = account?.email

            Log.d("GoogleSignIn", "Nombre: $displayName, Correo Electrónico: $email")

            // Ir directamente a HomeActivity después de iniciar sesión con Google
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish() // Cierra la actividad actual para que no vuelva atrás con el botón "Atrás"
        } else {
            // Inicio de sesión fallido
            Log.e("GoogleSignIn", "Fallo en el inicio de sesión con Google")
        }
    }

    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        // Manejar fallos en la conexión con Google API
        Log.e("GoogleSignIn", "Error de conexión con Google: ${connectionResult.errorMessage}")
    }
}