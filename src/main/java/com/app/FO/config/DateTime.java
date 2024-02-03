package com.app.FO.config;

import org.springframework.stereotype.Component;

import java.time.*;
import java.time.format.DateTimeFormatter;

@Component
public class DateTime {

    public static final String ZONE_ID = "Europe/Bucharest";


    public static void util() {
        //All avaleble ZoneID
        //System.out.println(ZoneId.getAvailableZoneIds());

        //From msto zone
        long centuryMills = DateTime.nowMillis();
        ZonedDateTime openTime;
        Instant.ofEpochMilli(centuryMills).atZone(ZoneId.systemDefault());
        openTime = Instant.ofEpochMilli(centuryMills).atZone(ZoneId.of("GMT"));

        //text to LocalDateTime
        String textDate = "2022-09-29 09:45";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(textDate, formatter);
        System.out.println(localDateTime);
        //LocalDateTime to ZonedDateTime
        ZonedDateTime startTimeZone = localDateTime.atZone(ZoneId.of("GMT"));
        System.out.println(startTimeZone);
    }

    public static long nowMillis() {
        return System.currentTimeMillis();
    }

    public static ZonedDateTime convertCenturyMillsToZoneDateTimeZoneID(long centuryMills, String zoneID) {
        ZonedDateTime zonedDateTime;
        Instant instant = Instant.ofEpochMilli(centuryMills);
        ZoneId zoneId = ZoneId.of(ZONE_ID);
        zonedDateTime = instant.atZone(zoneId);
        return zonedDateTime;
    }

    public static ZonedDateTime convertCenturyMillsToZoneDateTimeZoneRO(long centuryMills) {
        ZonedDateTime zonedDateTime;
        Instant instant = Instant.ofEpochMilli(centuryMills);
        ZoneId zoneId = ZoneId.of("Europe/Bucharest");
        zonedDateTime = instant.atZone(zoneId);
        return zonedDateTime;
    }

    public static ZonedDateTime convertCenturyMillsToZoneDateTimeZoneGMT(long centuryMills) {
        ZonedDateTime zonedDateTime;
        Instant instant = Instant.ofEpochMilli(centuryMills);
        ZoneId zoneId = ZoneId.of("GMT");
        zonedDateTime = instant.atZone(zoneId);
        return zonedDateTime;
    }

    public static ZonedDateTime convertCenturyMillsToZoneDateTimeZone(long centuryMills) {
        Instant instant = Instant.ofEpochMilli(centuryMills);
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());

        return zonedDateTime;
    }

    public static ZonedDateTime changeZoneDateTimeToAnotherZone(ZonedDateTime zonedDateTime, String zone) {
        ZonedDateTime newZonedDateTime;
        newZonedDateTime = zonedDateTime.withZoneSameInstant(ZoneId.of(zone));

        return newZonedDateTime;
    }

    public static ZonedDateTime changeZoneDateTimeToSystemDefault(ZonedDateTime zonedDateTime) {
        if (zonedDateTime == null) {
            return null;
        }
        return zonedDateTime.withZoneSameInstant(ZoneId.systemDefault());
    }

    public static long convertZoneDateTimeToCenturyMills(ZonedDateTime zonedDateTime) {
        return zonedDateTime.toInstant().toEpochMilli();
    }

    public static long convertDateToCenturyMills(LocalDateTime date) {
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, ZoneId.systemDefault());
        return convertZoneDateTimeToCenturyMills(zonedDateTime);
    }

    public static LocalDateTime textToLocalDateTime(String textDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(textDateTime, dateTimeFormatter);
    }

    public static LocalTime textToLocalTime(String textDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        return LocalTime.parse(textDateTime, dateTimeFormatter);
    }

    public static ZonedDateTime textToZoneDateTime(String textDateTime, String zone) {
        ZoneId zoneId = ZoneId.of(zone);
        LocalDateTime localDateTime = textToLocalDateTime(textDateTime);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("GMT"));
        return zonedDateTime;
    }

    public static ZonedDateTime textToZoneDateTimeGMT(String textDateTime) {
        return textToZoneDateTime(textDateTime, "GMT");
    }

    public static long textToCenturyMills(String textDate) {
        LocalDateTime localDateTime = textToLocalDateTime(textDate);
        return convertDateToCenturyMills(localDateTime);
    }

    public static String dataTimeToString(LocalDateTime dateTime) {
        return dateTime.toString();
    }
}