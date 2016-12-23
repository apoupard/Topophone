package io.enscene.topophone.model.artist;

import java.util.Date;
import java.util.GregorianCalendar;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableConcert.class)
@JsonDeserialize(as = ImmutableConcert.class)
public interface Concert {

    public static ImmutableConcert.Builder builder() {
        return ImmutableConcert.builder();
    }

    public static Concert of(int day, int month, int year, String place, String city) {
        return builder().city(city).place(place).date(new GregorianCalendar(year, month, day).getTime()).build();
    }

    Date getDate();

    String getPlace();

    String getCity();

}
