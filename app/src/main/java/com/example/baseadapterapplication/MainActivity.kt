package com.example.baseadapterapplication

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.baseadapterapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var array = arrayListOf("Brandon", "Yvette", "Greg", "Brian")
    var baseAdapterClass = BaseAdapterClass(array)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding?.listView?.adapter = baseAdapterClass

        binding?.fab?.setOnClickListener {
            var dialog = Dialog(this)
            dialog.setContentView(R.layout.customer_dialog)
            dialog.show()

            var etName = dialog.findViewById<EditText>(R.id.etName)
            var btnAdd = dialog.findViewById<Button>(R.id.btnAdd)

            btnAdd?.setOnClickListener {
                if (etName?.text?.toString().isNullOrEmpty()) {
                    etName?.error = "Enter the student"
                } else {
                    array.add(etName.text.toString())
                    dialog.dismiss()
                    baseAdapterClass.notifyDataSetChanged()
                }
            }
        }

        binding?.listView?.setOnItemClickListener { parent, view, position, id ->
            array.removeAt(position)
            baseAdapterClass.notifyDataSetChanged()
        }
        binding?.listView?.setOnItemLongClickListener { parent, view, position, id ->

            return@setOnItemLongClickListener true


        }
    }
}