package com.erp.project.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NoticeBoardData (
    @SerializedName("BN_NO")
    var bn_no :String = "",
    @SerializedName("BN_NAME")
    var bn_name :String = "",
    @SerializedName("E_NAME")
    var e_name :String = "",
    @SerializedName("BN_DATE")
    var bn_date :String = "",
    @SerializedName("BN_HIT")
    var bn_hit :String = ""
):Parcelable