package com.oneToMany.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
// a class which collects information to be included in custom error messages (TIme, message, and error message
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;
}
