package com.erp.project.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MyInfoData (
        @SerializedName("E_NO")
        var e_no :String = "",
        @SerializedName("E_NAME")
        var e_name :String = "",
        @SerializedName("D_NAME")
        var d_name :String = "",
        @SerializedName("E_POS")
        var e_pos :String = "",
        @SerializedName("E_GENDER")
        var e_gender :String = "",
        @SerializedName("E_BIRTH")
        var e_birth :String = "",
        @SerializedName("E_EMAIL")
        var e_email :String = "",
        @SerializedName("E_PHONE")
        var e_phone :String = "",
        @SerializedName("EOI_CALL")
        var eoi_call :String = ""
):Parcelable