package com.example.quanlisinhvien

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtMSSV: EditText
    private lateinit var edtHoTen: EditText
    private lateinit var btnAdd: Button
    private lateinit var btnUpdate: Button
    private lateinit var lvSinhVien: ListView

    private var arrSV = ArrayList<SinhVien>()
    private lateinit var adapter: SinhVienAdapter
    private var selectedIndex = -1   // vị trí phần tử được chọn

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtMSSV = findViewById(R.id.edtMSSV)
        edtHoTen = findViewById(R.id.edtHoTen)
        btnAdd = findViewById(R.id.btnAdd)
        btnUpdate = findViewById(R.id.btnUpdate)
        lvSinhVien = findViewById(R.id.lvSinhVien)

        adapter = SinhVienAdapter(this, arrSV)
        lvSinhVien.adapter = adapter

        btnAdd.setOnClickListener {
            val mssv = edtMSSV.text.toString().trim()
            val hoten = edtHoTen.text.toString().trim()

            if (mssv.isNotEmpty() && hoten.isNotEmpty()) {
                arrSV.add(SinhVien(mssv, hoten))
                adapter.notifyDataSetChanged()

                edtMSSV.text.clear()
                edtHoTen.text.clear()
            }
        }

        lvSinhVien.setOnItemClickListener { _, _, position, _ ->
            selectedIndex = position
            val sv = arrSV[position]

            edtMSSV.setText(sv.mssv)
            edtHoTen.setText(sv.hoten)
        }

        btnUpdate.setOnClickListener {
            if (selectedIndex != -1) {
                arrSV[selectedIndex].mssv = edtMSSV.text.toString()
                arrSV[selectedIndex].hoten = edtHoTen.text.toString()

                adapter.notifyDataSetChanged()
                selectedIndex = -1

                edtMSSV.text.clear()
                edtHoTen.text.clear()
            }
        }
    }
}


