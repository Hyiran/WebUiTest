package webtest.core.util;

import java.util.Calendar;

/**
 * Created by Administrator on 2016-04-11.
 * 获取当前电脑时间
 */
public class getDate {
    /**
     * 获取电脑时间
     * @return 返回日期格式例如：2016-4-12
     * 注意！注意！！注意！！！这个返回的日期是当前日期的时间加一天因我要用这样的数据所以这样封装的
     * 例如当前系统时间为2016年4月12号，那么返回的数据为：2016-04-13
     */
    public static String getDate() {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int monthR = month+1;
        int dateR = c.get(Calendar.DATE);
        if(monthR == 1 || monthR == 3 || monthR == 5 || monthR == 7 || monthR == 8 || monthR == 10 || monthR == 12) {
            if(dateR == 31) {
                monthR++;
                dateR = 1;
            } else {
                dateR++;
            }
        } else if(monthR == 2){
            if(dateR == 28) {
                monthR++;
                dateR = 1;
            }else {
                dateR++;
            }
        } else {
            if(dateR == 30) {
                monthR++;
                dateR = 1;
            }else {
                dateR++;
            }
        }
        String date1 = year + "-" + monthR + "-" + dateR;
        return date1;
    }
    /**
     * 获取电脑时间
     * @return 返回具体时分秒格式例如：17:36:52
     */
    public static String getDateSceond() {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        String date2 = hour + ":" + minute + ":" + second;
        return date2;
    }

    /**
     * 获取电脑时间
     * @return 返回具体时分秒格式例如：int 数组
     */
    public static int[] getIntArrayDateSceond() {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        int date2[] = {hour , minute , second};
        return date2;
    }

    /**
     * 获取电脑时间
     * @return 返回具体时分秒格式例如：String 数组
     */
    public static String[] getStringArrayDateSceond() {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        String hourR = "";
        String minuteR = "";
        String secondR = "";
        if(hour < 10) {
            hourR = "0" + String.valueOf(hour);
        } else {
            hourR = String.valueOf(hour);
        }
        if(minute < 10) {
            minuteR = "0" + String.valueOf(minute);
        } else {
            minuteR = String.valueOf(minute);
        }
        if(second < 10) {
            secondR = "0" + String.valueOf(second);
        } else {
            secondR = String.valueOf(second);
        }

        String date1[] = {hourR , minuteR , secondR};
        return date1;
    }

    /**
     * 获取电脑时间
     * @return 返回日期格式例如：int 数组
     */
    public static int[] getIntArrayDate() {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int monthR = month+1;
        int date = c.get(Calendar.DATE);
        int dateR = date;
        int date2[] = {year,monthR,dateR};
        return date2;
    }

    /**
     * 获取电脑时间
     * @return 返回日期格式例如：String 数组
     */
    public static String[] getStringArrayDate() {
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int monthR = month+1;
        int date = c.get(Calendar.DATE);
        int dateR = date;
        String datea = "";
        if(dateR < 10) {
            datea = "0" + String.valueOf(dateR);
        } else {
            datea = String.valueOf(dateR);
        }
        String montha = "";
        if(monthR < 10) {
            montha = "0" + String.valueOf(monthR);
        } else {
            montha = String.valueOf(monthR);
        }
        String date1[] = {String.valueOf(year),montha,datea};
        return date1;
    }


}
