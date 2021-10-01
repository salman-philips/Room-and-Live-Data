package com.roomandlivedataroom1.Utils;

import androidx.room.TypeConverter;

import java.util.Date;

public class Converters {
    @TypeConverter
    public static Date timeStampToDate(Long value) {
        if (value == null) {
            return null;
        } else {
            return new Date(value);
        }
    }

    @TypeConverter
    public static Long dateToTimeStamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.getTime();
        }
    }
}
