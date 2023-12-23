package com.example.booking.mapper;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
@Component
public class DateConverter extends DtoConverter{
    public Long convertToMinute(String allDate) throws ParseException {
        List<String> list = List.of(allDate.split("T"));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        List<String> time =  List.of(list.getLast().split(":"));
        return format.parse(list.getFirst()).getTime() / 60000 + Integer.parseInt(time.getFirst()) * 60L + Integer.parseInt(time.getLast());
    }
}
