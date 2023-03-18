/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.logiin;

import java.text.SimpleDateFormat;

/**
 *
 * @author ADMIN
 */
public class XDate {
    static SimpleDateFormat sdf = new SimpleDateFormat();

    public static java.util.Date toDate(String date, String pattern) {
        try {
            sdf.applyPattern(pattern);
            return sdf.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String toString(java.util.Date date, String pattern) {
        sdf.applyPattern(pattern);
        return sdf.format(date);
    }

    public static java.util.Date addDays(java.util.Date date, long days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }
}
