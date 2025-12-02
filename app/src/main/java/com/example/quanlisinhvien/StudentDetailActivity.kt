package com.example.quanlisinhvien

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class StudentDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_detail)

        val edtName: EditText = findViewById(R.id.edtName)
        val edtPhone: EditText = findViewById(R.id.edtPhone)
        val edtAddress: EditText = findViewById(R.id.edtAddress)
        val btnUpdate: Button = findViewById(R.id.btnUpdate)

        val student = intent.getSerializableExtra("student") as SinhVien
        val index = intent.getIntExtra("index", -1)

        edtName.setText(student.hoten)
        edtPhone.setText(student.phone)
        edtAddress.setText(student.address)

        btnUpdate.setOnClickListener {
            student.hoten = edtName.text.toString()
            student.phone = edtPhone.text.toString()
            student.address = edtAddress.text.toString()

            val intent = Intent()
            intent.putExtra("updateStudent", student)
            intent.putExtra("index", index)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
