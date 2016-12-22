package io.enscene.topophone.model.artist;

import com.google.auto.value.AutoValue;

import java.util.Date;
import java.util.GregorianCalendar;

@AutoValue
public abstract class Concert {

    public static Builder builder() {
        return new AutoValue_Concert.Builder();
    }

    public static Concert of(int day, int month, int year, String place, String city) {
        return builder().city(city).place(place).date(new GregorianCalendar(year, month, day).getTime()).build();
    }

    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder date(Date s);

        public abstract Builder place(String s);

        public abstract Builder city(String s);

        public abstract Concert build();
    }

    public abstract Date getDate();

    public abstract String getPlace();

    public abstract String getCity();

}
