package com.erp.project.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChatListData (
        @SerializedName("E_NAME")
        var e_name :String = "",
        @SerializedName("D_NAME")
        var d_name :String = ""
):Parcelable