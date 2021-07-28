package com.erp.project.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WorkPostDetail(
    @SerializedName("BW_NO")
    var bw_no: String = "",
    @SerializedName("BW_NAME")
    var bw_name: String = "",
    @SerializedName("E_NAME")
    var e_name: String = "",
    @SerializedName("BW_DATE")
    var bw_date: String = "",
    @SerializedName("BW_HIT")
    var bw_hit: String = "",
    @SerializedName("BW_CONTENT")
    var bw_content: String = "",

    ) : Parcelable