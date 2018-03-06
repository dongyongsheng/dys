package util;

public class ErrorMessage {
	/*ERRORCODE = 1*/
	public static String	UNKOWNSERIAL		= "打开通讯口%s失败,可能该通讯口已经被占用,或者不存在该通讯口";
	/*ERRORCODE = 2*/
	public static String	READDEVICEERROR		= "设备采集数据时发生%s次以上的异常,无法采集数据";
	/*ERRORCODE = 3*/
	public static String	WRITEDEVICEERROR	= "给电表重置%s寄存器时发生异常,无法更新表项数据";
	/*ERRORCODE = 4*/
	public static String	IOERROR				= "操作设备时发生I/O异常";
	/*ERRORCODE = 5*/
	public static String	ENCODINGERROR		= "操作设备时发生命令编码异常";
	/*ERRORCODE = 6*/
	public static String	NUMFORATERROR		= "操作设备时发生数据格式化异常";
	/*ERRORCODE = 7*/
	public static String	INTERUPERROR		= "操作设备时发生干扰中断异常";
	/*ERRORCODE = 8*/
	public static String	CRCERROR			= "操作设备时发生CRC校验异常";
	/*ERRORCODE = 9*/
	public static String	MODBUSERROR			= "操作的设备时发生Modbus异常";
	/*ERRORCODE = 10*/
	public static String	UNKOWNERROR			= "操作设备时发生未明异常";
	/*ERRORCODE = 11*/
	public static String	SERIALERROR			= "通讯口为:%s的采集工具出现异常，其下的所有设备均不能采集到数据";
	/*ERRORCODE = 12*/
	public static String	DLT645ERROR			= "操作设备时出现645规约配置异常";
	/*ERRORCODE = 13*/
	public static String	INDEXERROR			= "操作设备时发现返回的数据长度不够，出现越界操作异常";
	/*ERRORCODE = 14*/
	public static String	CONFIGERROR			= "操作设备时发生异常,请查看配置文件,该设备配置可能出现错误";
	/*ERRORCODE = 15*/
	public static String	DBERROR				= "无法从网关数据库中取到区域的控制参数,将按照默认方式控制";
	/*ERRORCODE = 16*/
	public static String	ENVERROR			= "区域ID：%s采集发生错误";

}
