package com.erp.project.login

import android.os.Parcel
import android.os.Parcelable

/*파일을 하나에 묶어서 다른 activity에 보내는 방식*/
class DataConstructor(
    var pa_auth: String?,
    var e_pos: String?,
    var e_name: String?,
    var e_no: String?,
    var d_no: String?,
    var d_name: String?,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(pa_auth)
        parcel.writeString(e_pos)
        parcel.writeString(e_name)
        parcel.writeString(e_no)
        parcel.writeString(d_no)
        parcel.writeString(d_name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataConstructor> {
        override fun createFromParcel(parcel: Parcel): DataConstructor {
            return DataConstructor(parcel)
        }

        override fun newArray(size: Int): Array<DataConstructor?> {
            return arrayOfNulls(size)
        }
    }

}