package com.example.quanlisinhvien

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var adapter: SinhVienAdapter
    private var list = ArrayList<SinhVien>()

    private val ADD_STUDENT = 100
    private val EDIT_STUDENT = 200

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lvStudents)

        adapter = SinhVienAdapter(this, list)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, StudentDetailActivity::class.java)
            intent.putExtra("student", list[position])
            intent.putExtra("index", position)
            startActivityForResult(intent, EDIT_STUDENT)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menuAdd) {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivityForResult(intent, ADD_STUDENT)
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK && data != null) {
            when (requestCode) {

                ADD_STUDENT -> {
                    val newStudent = data.getSerializableExtra("newStudent") as SinhVien
                    list.add(newStudent)
                    adapter.notifyDataSetChanged()
                }

                EDIT_STUDENT -> {
                    val updateStudent = data.getSerializableExtra("updateStudent") as SinhVien
                    val index = data.getIntExtra("index", -1)
                    list[index] = updateStudent
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }
}


