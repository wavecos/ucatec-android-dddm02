package bo.edu.ucatec.postgrado.cursos.android.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this, "onCreate() llamado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onCreate() llamado")
    }

    override fun onStart() {
        super.onStart()

        Toast.makeText(this, "onStart() llamado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onStart() llamado")
    }

    override fun onPostResume() {
        super.onPostResume()

        Toast.makeText(this, "onPostResume() llamado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onPostResume() llamado")
    }

    override fun onPause() {
        super.onPause()

        Toast.makeText(this, "onPause() llamado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onPause() llamado")
    }

    override fun onStop() {
        super.onStop()

        Toast.makeText(this, "onStop() llamado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onStop() llamado")
    }

    override fun onRestart() {
        super.onRestart()

        Toast.makeText(this, "onRestart() llamado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onRestart() llamado")
    }

    override fun onDestroy() {
        super.onDestroy()

        Toast.makeText(this, "onDestroy() llamado", Toast.LENGTH_LONG).show()
        Log.d(TAG, "onDestroy() llamado")
    }

}