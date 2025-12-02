package com.example.quanlisinhvien

import java.io.Serializable

data class SinhVien(
    var mssv: String,
    var hoten: String,
    var phone: String,
    var address: String
): Serializable
