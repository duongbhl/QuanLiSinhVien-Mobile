package com.example.quanlisinhvien

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

class SinhVienAdapter(
    private val context: Context,
    private val list: ArrayList<SinhVien>
) : BaseAdapter() {

    override fun getCount(): Int = list.size
    override fun getItem(position: Int): Any = list[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_sinhvien, parent, false)

        val student = list[position]

        view.findViewById<TextView>(R.id.tvMssv).text = student.mssv
        view.findViewById<TextView>(R.id.tvHoTen).text = student.hoten

        return view
    }
}
