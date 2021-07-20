package com.erp.project.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginData(
@SerializedName("E_NO")
var e_no :String = "",
@SerializedName("E_ENAME")
var e_name :String = "",
@SerializedName("D_DNAME")
var d_name :String = "",
@SerializedName("PA_AUTH")
var pa_auth :String = "",
@SerializedName("E_POS")
var e_pos :String = "",
@SerializedName("D_NO")
var d_no :String = ""
):Parcelable