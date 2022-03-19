/*package finalproject.stn991523983.org

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}

 */

package finalproject.stn991523983.org

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import com.google.firebase.firestore.FirebaseFirestore
import finalproject.stn991523983.org.databinding.ActivityMainBinding
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.SetOptions
import finalproject.stn991523983.org.databinding.ActivitySecondBinding
import finalproject.stn991523983.org.databinding.ActivitySecondBinding.*

const val TAG1 = "FIRESTORE"

class SecondActivity : AppCompatActivity() {

    private lateinit var database: DatabaseReference
    private lateinit var binding: ActivitySecondBinding

    //  private var database : DatabaseReference? = null
    //  private var binding: ActivityMainBinding? = null
    val fireStoreDatabase = FirebaseFirestore.getInstance()


/*
    fun sendMessage(view: View) {
    //   val editText = findViewById<EditText>(R.id.editTextTextPersonName)
     //   val message = editText.text.toString()
        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }
}
*/



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =  ActivitySecondBinding.inflate(layoutInflater)       //ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding?.root)



        //

        binding!!.btnUpdate.setOnClickListener() {


            val user = hashMapOf(
                "firstName" to binding.inputFirstName.text.toString(),
                "lastName" to binding.inputLastName.text.toString(),
                "weight" to binding.inputWeight.text.toString()
            )
//






            val query = fireStoreDatabase.collection("users1")
                .whereEqualTo(
                    "firstName",
                    binding.inputFirstName.text.toString()
                )
                .get()
            query.addOnSuccessListener {
                for (document in it) {
                    fireStoreDatabase.collection("users1").document(document.id)
                        .set(user, SetOptions.merge())
                }







                //
                Toast.makeText(
                    applicationContext,
                    "Information Updated",
                    Toast.LENGTH_SHORT
                ).show()
            }






        }




        binding!!.btnDelete.setOnClickListener() {
            if (binding.inputFirstName.text.isNotEmpty()) {
                val query = fireStoreDatabase.collection("users1")
                    .whereEqualTo(
                        "firstName",
                        binding.inputFirstName.text.toString()
                    )
                    .get()
                query.addOnSuccessListener {
                    for (document in it) {
                        fireStoreDatabase.collection("users1")
                            .document(document.id).delete()
                            .addOnSuccessListener {

                            }
                    }
                    Toast.makeText(
                        applicationContext,
                        "Data deleted.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

/*
        binding!!.btnUpdate.setOnClickListener() {

            val firstName: String = binding.inputFirstName.text.toString()
            val lastName: String = binding.inputLastName.text.toString()
            val distance: String = binding.inputDistance.text.toString()
              updateData(firstName, lastName, distance)

/*
            database = FirebaseDatabase.getInstance().getReference("users2")
            val user: MutableMap<String, Any> = HashMap()
            user["firstName"] = firstName
            user["lastName"] = lastName
            user["distance"] = distance

           database.child(firstName).updateChildren(user).addOnSuccessListener {
                binding!!.inputFirstName.text.clear()
                binding!!.inputLastName.text.clear()
                binding!!.inputDistance.text.clear()
            }

 */


        }

 */
//btnUploadData
        binding!!.btnUploadData.setOnClickListener() {

            var firstName: String = binding!!.inputFirstName.text.toString()
            var lastName: String = binding!!.inputLastName.text.toString()
            var weight: String = binding!!.inputWeight.text.toString()


            val user: MutableMap<String, Any> = HashMap()
            user["firstName"] = firstName
            user["lastName"] = lastName
            user["weight"] = weight

            fireStoreDatabase.collection("users1")
                .add(user)
                .addOnSuccessListener {
                    Log.d(TAG, "Added document with ID ${it.id}")
                }
                .addOnFailureListener {
                    Log.w(TAG, "Error adding document ${it}")
                }
            //  database!!.child(firstName!!).child("lastName").setValue(lastName) //
            //   database!!.child(firstName!!).child("distance").setValue(distance)  //


            binding!!.inputFirstName.text.clear()
            binding!!.inputLastName.text.clear()
            binding!!.inputWeight.text.clear()

        }

        binding!!.btnReadData.setOnClickListener() {
            fireStoreDatabase.collection("users1")
                .get()
                .addOnCompleteListener {

                    val result: StringBuffer = StringBuffer()
                    if (it.isSuccessful) {
                        for (document in it.result!!)
                            result.append("Name: ")
                                .append(document.data.getValue("firstName"))
                                .append("   ")
                                .append(document.data.getValue("lastName"))
                                .append("\n")
                                .append("Weight:  ")
                                .append(document.data.getValue("weight"))
                                .append("\n_______________________________________")
                                .append("\n")
                    }

                    Toast.makeText(
                        applicationContext,
                        "Information Displayed",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    binding?.textView?.setText(result)
                }
        }




    }

    private fun updateData(firstName: String, lastName: String, weight: String) {
        //  fireStoreDatabase.collection("users2")
        database = FirebaseDatabase.getInstance().getReference("users1")
        val user = mapOf<String, String>(
            "lastName" to lastName,
            "weight" to weight
        )
        database.child(firstName).updateChildren(user).addOnSuccessListener {
            binding.inputFirstName.text.clear()
            binding.inputLastName.text.clear()
            binding.inputWeight.text.clear()

            //  Toast.makeText(this,"Successfuly Updated",Toast.LENGTH_SHORT).show()
        }

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