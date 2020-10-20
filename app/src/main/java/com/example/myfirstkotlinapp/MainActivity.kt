package com.example.myfirstkotlinapp

import android.app.DatePickerDialog
import android.icu.util.LocaleData
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

class MainActivity : AppCompatActivity() {
    var date = 0
    var month = 0
    var yearN = 0
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun datePick(view : View) {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val dob = findViewById<TextInputEditText>(R.id.dob)

        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                // Display Selected date in textbox
                dob.setText("" + year + " / " + monthOfYear + " / " + dayOfMonth)
                this.yearN = year
                date = dayOfMonth
                this.month = monthOfYear
            },
            year,
            month,
            day
        )

        dpd.show()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun onSubmit(view : View) {
        val dob = findViewById<TextInputEditText>(R.id.dob)

        if (dob.text.toString().length == 0) {
            Toast.makeText(this, "Enter the Date", Toast.LENGTH_LONG).show()
            return
        }
        val date2 = Calendar.getInstance().time
        val date1 = Date(yearN-1900, month, date)

        val diff: Long =  date2.time -  date1.time
        val seconds = diff / 1000
        val minutes = seconds / 60
        val hours = minutes / 60
        val days = hours / 24

        val display = findViewById<TextView>(R.id.display)
        display.text = "Days : " + days
    }
}