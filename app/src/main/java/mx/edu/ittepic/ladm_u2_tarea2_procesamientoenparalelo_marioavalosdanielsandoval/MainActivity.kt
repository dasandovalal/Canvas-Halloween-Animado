package mx.edu.ittepic.ladm_u2_tarea2_procesamientoenparalelo_marioavalosdanielsandoval

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))
    }
}