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
    var list = arrayListOf("Physics", "Maths", "Java", "Python")
    var studentList = arrayListOf<Student>()
    var baseAdapterClass = BaseAdapterClass(studentList)
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
        studentList.add(Student(rollNo = 1, "Brandon", "Physics"))
        studentList.add(Student(rollNo = 2, "Yvette", "Maths"))
        studentList.add(Student(rollNo = 3, "Greg", "Java"))
        studentList.add(Student(rollNo = 3, "Michael", "Python"))
        binding?.listView?.adapter = baseAdapterClass

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
                    list.add(etName.text.toString())
                    dialog.dismiss()
                    baseAdapterClass.notifyDataSetChanged()
                }
            }
        }

        binding?.listView?.setOnItemClickListener { parent, view, position, id ->
            list.removeAt(position)
            baseAdapterClass.notifyDataSetChanged()
        }
        binding?.listView?.setOnItemLongClickListener { parent, view, position, id ->

            return@setOnItemLongClickListener true


        }
        binding?.fab?.setOnClickListener {
            studentList.add(Student(4, "Daniel", "Kotlin"))
            baseAdapterClass.notifyDataSetChanged()
        }
    }
}