package com.example.digifarm.wrapper;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class TokenData {
    public String token;
    public Date expirationDate;
}
