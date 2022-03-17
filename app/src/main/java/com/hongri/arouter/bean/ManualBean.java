package com.hongri.arouter.bean;


import android.os.Parcel;
import android.os.Parcelable;

public class ManualBean implements Parcelable {

    private String name;
    private int age;

    public ManualBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected ManualBean(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }

    public static final Creator<ManualBean> CREATOR = new Creator<ManualBean>() {
        @Override
        public ManualBean createFromParcel(Parcel in) {
            return new ManualBean(in);
        }

        @Override
        public ManualBean[] newArray(int size) {
            return new ManualBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }

    @Override
    public String toString() {
        return "ManualBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
