package util;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * UtilsTest
 * 时间日期工具类,封装工作中常用的一些时间日期计算方法等
 * 还可以提供更多的重载方法,用于时间的转化等
 */
public class DateUtil {
    private DateUtil(){

    }

    public static final String hhmmFormat="HH:mm";
    public static final String MMddFormat="MM-dd";
    public static final String yyyyFormat="yyyy";
    public static final String yyyyChineseFormat="yyyy年";
    public static final String yyyyMMFormat="yyyy-MM";
    public static final String yyyyMMddFormat="yyyy-MM-dd";
    public static final String fullFormat="yyyy-MM-dd HH:mm:ss";
    public static final String fullFormatNopot="yyyyMMddHHmmss";
    public static final String MMddChineseFormat="MM月dd日";
    public static final String yyyyMMddChineseFormat="yyyy年MM月dd日";
    public static final String fullChineseFormat="yyyy年MM月dd日 HH时mm分ss秒";
    public static final String [] WEEKS={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
    public static final String [] WEEKS_EN={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};


    /**
     * 得到指定时间的时间日期格式
     *
     * @param date
     *            指定的时间
     * @param format
     *            时间日期格式
     * @return
     */
    public static String formatDate(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 得到指定时间的时间日期格式
     *
     * @param date
     *            指定的时间
     * @param format
     *            时间日期格式
     * @param land
     *            语言类型 en=英文，zh_CN=中文
     * @return
     */

    public static String formatDate(Date date, String format, String land) {
        String time;
        String week;
        DateFormat df = new SimpleDateFormat(format);
        time = df.format(date);
        week = land.equals("zh_CN") ? WEEKS[getWeek(date) - 1] : WEEKS_EN[getWeek(date) - 1];
        time = time + "  " + week;
        return time;
    }

    /**
     * 将 yyyy-MM-dd HH:mm:ss 转换成yyyy-MM-dd
     *
     * @param time
     *            yyyy-MM-dd HH:mm:ss
     * @return
     * @throws ParseException
     */
    public static String formatDate(String time, String oldf, String newf) {
        SimpleDateFormat df = new SimpleDateFormat(oldf);
        String timeString = null;
        try {
            Date date = df.parse(time);
            SimpleDateFormat df2 = new SimpleDateFormat(newf);
            timeString = df2.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeString;
    }

    public static Long formatDate(String dateStr, String format) {
        DateFormat df = new SimpleDateFormat(format);
        Date date = null;
        try {
            date = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formatDate(date);
    }

    public static Long formatDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getTimeInMillis();
    }

    public static Date parseDate(Long dateL) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(dateL);
        return cal.getTime();
    }

    public static Date parseDate(String dateStr, String format) {
        DateFormat df = new SimpleDateFormat(format);
        Date res = null;
        try {
            res = df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }




    /**
     * 得到指定时间的时间日期格式
     * @param date 指定的时间
     * @param format 时间日期格式
     * @return
*/
    public static String getFormatDateTime(Date date,String format){
        DateFormat df=new SimpleDateFormat(format);
        return df.format(date);
    }
    /**
     * 得到指定时间的时间日期格式
     * @param date 指定的时间
     * @param format 时间日期格式
     * @param land 语言类型 en=英文，zh_CN=中文
     * @return
     */

    public static String getFormatDateTime(Date date,String format,String land){
        String time;
        String week;
        DateFormat df=new SimpleDateFormat(format);
        time = df.format(date);
        week = land.equals("zh_CN") ? WEEKS[getWeek(date)-1] : WEEKS_EN[getWeek(date)-1];
        time = time +"  "+week;
        return time;
    }
    /**
     * 判断是否是润年
     * @param date 指定的时间
     * @return true:是润年,false:不是润年
*/
    public static boolean isLeapYear(Date date) {
       Calendar cal=Calendar.getInstance();
       cal.setTime(date);
       return isLeapYear(cal.get(Calendar.YEAR));
    }

    /**
     * 判断是否是润年
     * @param date 指定的年
     * @return true:是润年,false:不是润年
*/
    public static boolean isLeapYear(int year) {
       GregorianCalendar calendar = new GregorianCalendar();
       return calendar.isLeapYear(year);
    }

    /**
     * 判断指定的时间是否是今天
     * @param date 指定的时间
     * @return true:是今天,false:非今天
*/
    public static boolean isInToday(Date date){
        boolean flag=false;
        Date now=new Date();
        String fullFormat=getFormatDateTime(now,DateUtil.yyyyMMddFormat);
        String beginString=fullFormat+" 00:00:00";
        String endString=fullFormat+" 23:59:59";
        DateFormat df=new SimpleDateFormat(DateUtil.fullFormat);
        try {
            Date beginTime=df.parse(beginString);
            Date endTime=df.parse(endString);
            flag=date.before(endTime)&&date.after(beginTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return flag;
    }

    /**
     * 判断两时间是否是同一天
     * @param from 第一个时间点
     * @param to 第二个时间点
     * @return true:是同一天,false:非同一天
*/
    public static boolean isSameDay(Date from,Date to){
        boolean isSameDay=false;
        DateFormat df=new SimpleDateFormat(DateUtil.yyyyMMddFormat);
        String firstDate=df.format(from);
        String secondDate=df.format(to);
        isSameDay=firstDate.equals(secondDate);
        return isSameDay;
    }

    /**
     * 求出指定的时间那天是星期几
     * @param date 指定的时间
     * @return 星期X
*/
    public static String getWeekString(Date date){
        return DateUtil.WEEKS[getWeek(date)-1];
    }

    /**
     * 求出指定时间那天是星期几
     * @param date 指定的时间
     * @return 1-7
*/
    public static int getWeek(Date date){
        int week=0;
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        week=cal.get(Calendar.DAY_OF_WEEK);
        return week;
    }


    /**
     * 取得指定时间离现在是多少时间以前，如：3秒前,2小时前等
     * 注意：此计算方法不是精确的
     * @param date 已有的指定时间
     * @return 时间段描述
*/
    public static String getAgoTimeString(Date date){
        Date now=new Date();
        Calendar cal=Calendar.getInstance();
        cal.setTime(date);
        Date agoTime=cal.getTime();
        long mtime=now.getTime()-agoTime.getTime();
        String str="";
        long stime=mtime/1000;
        long minute=60;
        long hour=60*60;
        long day=24*60*60;
        long weeks=7*24*60*60;
        long months=100*24*60*60;
        if(stime<minute){
            long time_value=stime;
            if(time_value<=0){
                time_value=1;
            }
            str=time_value+"秒前";
        }else if(stime>=minute && stime<hour){
            long time_value=stime/minute;
            if(time_value<=0){
                time_value=1;
            }
            str=time_value+"分前";
        }else if(stime>=hour && stime<day){
            long time_value=stime/hour;
            if(time_value<=0){
                time_value=1;
            }
            str=time_value+"小时前";
        }else if(stime>=day&&stime<weeks){
            long time_value=stime/day;
            if(time_value<=0){
                time_value=1;
            }
            str=time_value+"天前";
        }else if(stime>=weeks&&stime<months){
            DateFormat df=new SimpleDateFormat(DateUtil.MMddFormat);
            str=df.format(date);
        }else{
            DateFormat df=new SimpleDateFormat(DateUtil.yyyyMMddFormat);
            str=df.format(date);
        }
        return str;
    }

    /**
     * 判断指定时间是否是周末
     * @param date 指定的时间
     * @return true:是周末,false:非周末
*/
    public static boolean isWeeks(Date date){
        boolean isWeek=false;
        isWeek=(getWeek(date)-1==0||getWeek(date)-1==6);
        return isWeek;
    }

    /**
     * 得到今天的最开始时间
     * @return 今天的最开始时间
*/
    public static Date getTodayBeginTime(){
        String beginString=DateUtil.formatDate(new Date(), DateUtil.yyyyMMddFormat)+" 00:00:00";
        DateFormat df=new SimpleDateFormat(DateUtil.fullFormat);
        Date beginTime=new Date();
        try {
            beginTime=df.parse(beginString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return beginTime;
    }

    /**
     * 得到今天的最后结束时间
     * @return 今天的最后时间
*/
    public static Date getTodayEndTime(){
        String endString=DateUtil.yyyyMMddFormat+" 23:59:59";
        DateFormat df=new SimpleDateFormat(DateUtil.fullFormat);
        Date endTime=new Date();
        try {
            endTime=df.parse(endString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return endTime;
    }

    /**
     * 取得本周的开始时间
     * @return 本周的开始时间
*/
    public static Date getThisWeekBeginTime(){
        Date beginTime=null;
        Calendar cal=Calendar.getInstance();
        int week=getWeek(cal.getTime());
        week=week-1;
        int days=0;
        if(week==0){
            days=6;
        }else{
            days=week-1;
        }
        cal.add(Calendar.DAY_OF_MONTH, -days);
        beginTime=cal.getTime();
        return beginTime;
    }

    /**
     * 取得本周的开始日期
     * @param format 时间的格式
     * @return 指定格式的本周最开始时间
*/
    public static String getThisWeekBeginTimeString(String format){
        DateFormat df=new SimpleDateFormat(format);
        return df.format(getThisWeekBeginTime());
    }


    /**
     * 取得本周的结束时间
     * @return 本周的结束时间
*/
    public static Date getThisWeekEndTime(){
        Date endTime=null;
        Calendar cal=Calendar.getInstance();
        int week=getWeek(cal.getTime());
        week=week-1;
        int days=0;
        if(week!=0){
            days=7-week;
        }
        cal.add(Calendar.DAY_OF_MONTH, days);
        endTime=cal.getTime();
        return endTime;
    }


    /**
     * 取得本周的结束日期
     * @param format 时间的格式
     * @return 指定格式的本周结束时间
*/
    public static String getThisWeekEndTimeString(String format){
        DateFormat df=new SimpleDateFormat(format);
        return df.format(getThisWeekEndTime());
    }

    /**
     * 取得两时间相差的天数
     * @param from 第一个时间
     * @param to 第二个时间
     * @return 相差的天数
*/
    public static long getBetweenDays(Date from, Date to){
        long days=0;
        long dayTime=24*60*60*1000;
        long fromTime=from.getTime();
        long toTime=to.getTime();
        long times=Math.abs(fromTime-toTime);
        days=times/dayTime;
        return days;
    }

    /**
     * 取得两时间相差的秒数
     * @param from 第一个时间
     * @param to 第二个时间
     * @return 相差的秒数
*/
    public static long getBetweenSecond(Date from,Date to){
        long hours=0;
        long hourTime=1000;
        long fromTime=from.getTime();
        long toTime=to.getTime();
        long times=Math.abs(fromTime-toTime);
        hours=times/hourTime;
        return hours;
    }

    /**
     * 取得两时间相差的分钟数
     * @param from 第一个时间
     * @param to 第二个时间
     * @return 相差的分钟数
     */
    public static long getBetweenMin(Date from,Date to){
        long hours=0;
        long hourTime=60*1000;
        long fromTime=from.getTime();
        long toTime=to.getTime();
        long times=Math.abs(fromTime-toTime);
        hours=times/hourTime;
        return hours;
    }



    /**
     * 取得在指定时间上加减days天后的时间
     * @param date 指定的时间
     * @param days 天数,正为加，负为减
     * @return 在指定时间上加减days天后的时间
*/
    public static Date addDays(Date date,int days){
        Date time=null;
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DAY_OF_MONTH, days);
        time=cal.getTime();
        return time;
    }

    /**
     * 取得在指定时间上加减months月后的时间
     * @param date 指定时间
     * @param months 月数，正为加，负为减
     * @return 在指定时间上加减months月后的时间
*/
    public static Date addMonths(Date date,int months){
        Date time=null;
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.MONTH, months);
        time=cal.getTime();
        return time;
    }

    /**
     * 取得在指定时间上加减years年后的时间
     * @param date 指定时间
     * @param years 年数，正为加，负为减
     * @return 在指定时间上加减years年后的时间
*/
    public static Date addYears(Date date,int years){
        Date time=null;
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.YEAR, years);
        time=cal.getTime();
        return time;
    }
     /**
      * 获得当前时间
      * yyyy-MM-dd HH:mm:ss
      * @return String(时间戳)
      */
    public static String getCurrentTimestamp(){
        return DateUtil.getFormatDateTime(new Date(),DateUtil.fullFormat);
    }
    /**
     * 将 yyyyMMddHHmmss类型的字符串转成Timestamp
     * @param yyyyMMddHHmmss
     * @return "yyyy-MM-dd HH:mm:ss"
    * @throws ParseException
     */
    public static String getTimestamp(String time) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date=df.parse(time);
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeString = df2.format(date);
        return timeString;
    }

    /**
     *  将 yyyy-MM-dd HH:mm:ss 转换成yyyy-MM-dd
     * @param time yyyy-MM-dd  HH:mm:ss
     * @return
     * @throws ParseException
     */
    public static String getDate(String time) throws ParseException{
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=df.parse(time);
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
        String timeString = df2.format(date);
        return timeString;
    }
    /**
     * yyyy-MM-dd HH:mm:ss 转成DATE
     * @param str
     * @return
     */
    public static Date stringToDate(String str) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            // Fri Feb 24 00:00:00 CST 2012
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//         // 2012-02-24
//         date = java.sql.Date.valueOf(str);

        return date;
    }


    /**
     * 获取最基本的Timestamp  0000-00-00 00:00:00
     * @return "0000-00-00 00:00:00"
     */
    public static String getBaseTimestamp() {
        return "0000-00-00 00:00:00";
    }


    public static String getDateStringByType(String type,long time){
        Date date=new Date(time);
        if(type.equals("year")){
           return DateUtil.getFormatDateTime(date, DateUtil.yyyyFormat);
        }else if(type.equals("month")){
           return DateUtil.getFormatDateTime(date, DateUtil.yyyyMMFormat);
        }else{
           return DateUtil.getFormatDateTime(date, DateUtil.yyyyMMddFormat);
        }
    }

    /**
     * 得到本月的最开始时间
     *
     * @return 最开始时间
     */
    public static Date getMonthBeginTime() {
        String formatString = "yyyy-MM-01" + " 00:00:00";
        DateFormat df = new SimpleDateFormat(formatString);
        String beginStr = df.format(new Date());
        df = new SimpleDateFormat(fullFormat);
        try {
            return df.parse(beginStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 得到今年的最开始时间
     *
     * @return 最开始时间
     */
    public static Date getYearBeginTime() {
        String formatString = "yyyy-01-01" + " 00:00:00";
        DateFormat df = new SimpleDateFormat(formatString);
        String beginStr = df.format(new Date());
        df = new SimpleDateFormat(fullFormat);
        try {
            return df.parse(beginStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 功能描述：返回月
     *
     * @param date
     *            Date 日期
     * @return 返回月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 功能描述：返回日
     *
     * @param date
     *            Date 日期
     * @return 返回日份
     */
    public static int getDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 功能描述：返回小
     *
     * @param date
     *            日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 功能描述：返回分
     *
     * @param date
     *            日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date
     *            Date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 功能描述：返回毫
     *
     * @param date
     *            日期
     * @return 返回毫
     */
    public static long getMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }



    /**
     * @param args
*/
    public static void main(String[] args) {

        System.out.println(getFormatDateTime(new Date(),DateUtil.yyyyMMddFormat,"en"));

       /* System.out.println(getFormatDateTime(new Date(),DateUtil.fullChineseFormat));
        System.out.println(isLeapYear(new Date()));
        Calendar cal=Calendar.getInstance();
        System.out.println(isInToday(cal.getTime()));
        Calendar cal2=Calendar.getInstance();
        cal2.set(2011, 06, 05);
        System.out.println(isSameDay(cal.getTime(),cal2.getTime()));
        System.out.println(WEEKS[getWeek(new Date())]);  //星期几
        DateFormat df=new SimpleDateFormat(DateUtil.fullFormat);
        String fullString="2011-06-03 22:37:20";
        try {
            Date fulldate=df.parse(fullString);
            System.out.println(getBetweenDays(fulldate,cal.getTime()));
            System.out.println("ago:"+getAgoTimeString(fulldate));
            System.out.println(isWeeks(fulldate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(getThisWeekBeginTimeString(DateUtil.yyyyMMddChineseFormat));
        System.out.println(getThisWeekEndTimeString(DateUtil.yyyyMMddChineseFormat));
        System.out.println(addDays(new Date(),3));
        System.out.println(addDays(new Date(),-3));
        System.out.println(addMonths(new Date(),2));
        System.out.println(addMonths(new Date(),-2));
        System.out.println(addYears(new Date(),1));
        System.out.println(addYears(new Date(),-1));
          */
    }
}