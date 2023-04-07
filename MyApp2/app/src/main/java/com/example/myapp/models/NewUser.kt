package com.example.myapp.models

import android.os.Parcel
import android.os.Parcelable

data class NewUser(val email: String?, val password: String?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(email)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewUser> {
        override fun createFromParcel(parcel: Parcel): NewUser {
            return NewUser(parcel)
        }

        override fun newArray(size: Int): Array<NewUser?> {
            return arrayOfNulls(size)
        }
    }
}

