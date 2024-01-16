package com.insurance.insurance.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ErrorDetailes {

    private String message;
    private Date date;
    private String uri;

}
