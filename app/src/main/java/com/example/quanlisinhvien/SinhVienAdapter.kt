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

    override fun getCount() = list.size
    override fun getItem(position: Int) = list[position]
    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_sinhvien, parent, false)

        val tvName = view.findViewById<TextView>(R.id.tvHoTen)
        val tvMSSV = view.findViewById<TextView>(R.id.tvMssv)
        val btnDelete = view.findViewById<ImageView>(R.id.btnDelete)

        val sv = list[position]

        tvName.text = sv.hoten
        tvMSSV.text = sv.mssv

        btnDelete.setOnClickListener {
            list.removeAt(position)
            notifyDataSetChanged()
        }

        return view
    }
}
