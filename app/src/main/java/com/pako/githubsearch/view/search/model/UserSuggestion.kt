package com.pako.githubsearch.view.search.model

import android.os.Parcel
import android.os.Parcelable
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion
import com.pako.githubsearch.domain.search.model.User

class UserSuggestion : SearchSuggestion {

    private var mUser: User? = null
    var isHistory = false

    constructor(user: User) {
        this.mUser = user
    }

    constructor(source: Parcel) {
        this.mUser = source.readParcelable(User.javaClass.classLoader)
        this.isHistory = source.readInt() != 0
    }

    override fun getBody(): String? {
        return mUser?.name
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeParcelable(mUser, flags)
        dest.writeInt(if (isHistory) 1 else 0)
    }

    companion object CREATOR : Parcelable.Creator<UserSuggestion> {
        override fun createFromParcel(parcel: Parcel): UserSuggestion {
            return UserSuggestion(parcel)
        }

        override fun newArray(size: Int): Array<UserSuggestion?> {
            return arrayOfNulls(size)
        }
    }
}
