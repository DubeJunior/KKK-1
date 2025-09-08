package com.example.fitkagehealth

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class Personal_info : AppCompatActivity() {
    private lateinit var editTextSteps: EditText
    private lateinit var btnConfirm: Button
    private lateinit var genderSpinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_info)

        editTextSteps = findViewById(R.id.editTextSteps)
        btnConfirm = findViewById(R.id.idAdd)
        genderSpinner = findViewById(R.id.gender_spinner)

        // Setup gender spinner with custom dark style
        ArrayAdapter.createFromResource(
            this,
            R.array.gender_array,
            R.layout.spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
            genderSpinner.adapter = adapter
        }

        btnConfirm.setOnClickListener {
            val stepsGoal = editTextSteps.text.toString().trim()
            val selectedGender = genderSpinner.selectedItem.toString()

            if (stepsGoal.isEmpty()) {
                Toast.makeText(this, "Please enter your step goal", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            Toast.makeText(
                this,
                "Saving goal: $stepsGoal and Gender: $selectedGender",
                Toast.LENGTH_SHORT
            ).show()

            val database = FirebaseDatabase.getInstance()
            val ref = database.getReference("users")

            val userId = "user_123" // Example user id
            val userData = mapOf(
                "stepsGoal" to stepsGoal,
                "gender" to selectedGender
            )

            ref.child(userId).setValue(userData)
                .addOnSuccessListener {
                    Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { exception ->
                    Toast.makeText(this, "Failed to save data: ${exception.message}", Toast.LENGTH_LONG).show()
                    exception.printStackTrace()
                }


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}