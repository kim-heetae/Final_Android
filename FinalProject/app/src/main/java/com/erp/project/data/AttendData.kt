package com.erp.project.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AttendData(
        @SerializedName("W_DATE")
        var w_date: String = "",
        @SerializedName("W_ATTEND")
        var w_attend: String = "",
        @SerializedName("W_LEAVE")
        var w_leave: String = "",
) : Parcelable