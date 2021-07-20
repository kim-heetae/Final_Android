package com.erp.project.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CalendarData(
        @SerializedName("SCH_DATE")
        var sch_date :String = "",
        @SerializedName("SCH_ENDDATE")
        var sch_enddate :String = "",
        @SerializedName("SCH_NAME")
        var sch_name :String = ""
):Parcelable