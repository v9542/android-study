package com.somo.test.server;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yebonkim on 2016. 11. 19..
 */

public class User implements Parcelable{
    int id;
    String user_id;

    public User() {
        super();
    }

    public User(Parcel in) {
        super();
        this.id = in.readInt();
        this.user_id = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(getId());
        dest.writeString(getUser_id());
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
