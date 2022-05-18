package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.attendence.R


class MainActivity : AppCompatActivity(),AdapterView.OnItemSelectedListener {

    val courses = arrayOf("CS", "CEN")
    val numbers = arrayOf("0","1", "2", "4","5", "6", "7","8", "9")
    var spinner:Spinner? = null
    var textView_msg:TextView? = null
    var textView2_msg:TextView? = null
    var textView_nmbr1:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// Select department
        val textView_msg = this.courses
        spinner = this.spinner
        spinner!!.onItemSelectedListener = this
        var New_Spinner_ID = 1
        val TextView = findViewById(R.id.textView) as TextView

        // Create an ArrayAdapter using a simple spinner layout and courses array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, courses)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner!!.adapter = aa
        spinner!!.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?)
            {
                TextView.text = "please select an option"
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                TextView.text= spinner!!.getSelectedItem().toString()
            }
        }

        //Select first course number

        spinner!!.id = New_Spinner_ID
        New_Spinner_ID = 2
        val textView2_msg = this.numbers
        spinner!!.onItemSelectedListener = this


        val n1 = ArrayAdapter(this, android.R.layout.simple_spinner_item, numbers)
        // Set layout to use when the list of choices appear
        n1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        spinner!!.adapter = n1

    }


    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        when (view?.id) {
            1 -> showToast(message = "Spinner 2 Position:${position} and language: ${courses[position]}")
            else -> {
                showToast(message = "Spinner 1 Position:${position} and language: ${numbers[position]}")
            }
        }
    }

    private fun showToast(message: String) {

    }


    override fun onNothingSelected(arg0: AdapterView<*>) {

    }
}


