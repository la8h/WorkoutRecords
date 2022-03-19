package finalproject.stn991523983.org

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class HelpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.action_one) {


            Toast.makeText(this, "Icon Clicked", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.action_two) {
            val Intent = Intent(this, HelpActivity::class.java)
            startActivity(Intent)

            Toast.makeText(this, "Help Page Clicked", Toast.LENGTH_LONG).show()
            return true
        }
        if (id == R.id.action_three) {
            val Intent = Intent(this, AboutActivity::class.java)
            startActivity(Intent)

            Toast.makeText(this, "About Page Clicked", Toast.LENGTH_LONG).show()
            return true
        }

        return super.onOptionsItemSelected(item)

    }




}