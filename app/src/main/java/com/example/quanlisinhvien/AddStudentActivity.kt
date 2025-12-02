package com.example.quanlisinhvien

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val edtId: EditText = findViewById(R.id.edtId)
        val edtName: EditText = findViewById(R.id.edtName)
        val edtPhone: EditText = findViewById(R.id.edtPhone)
        val edtAddress: EditText = findViewById(R.id.edtAddress)
        val btnSave: Button = findViewById(R.id.btnSave)

        btnSave.setOnClickListener {
            val student = SinhVien(
                edtId.text.toString(),
                edtName.text.toString(),
                edtPhone.text.toString(),
                edtAddress.text.toString()
            )

            val intent = Intent()
            intent.putExtra("newStudent", student)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
