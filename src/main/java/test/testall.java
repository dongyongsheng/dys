package test;

import net.minidev.json.JSONObject;
import util.DAPCUtil;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dys on 2018/1/29.
 */
public class testall {

    public static byte[] toBytes(String str) {
        if(str == null || str.trim().equals("")) {
            return new byte[0];
        }

        byte[] bytes = new byte[str.length() / 2];
        for(int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }

        return bytes;
    }

    /**
     * byte 转 int
     *
     * @param b
     * @return
     */
    public static int bytesToInt(byte b[]) {
        return b[3] & 0xff | (b[2] & 0xff) << 8
                | (b[1] & 0xff) << 16| (b[0] & 0xff) << 24;
    }
    public static byte intToByte(int x) {
        return (byte) x;
    }

    public static int byteToInt(byte b) {
        //Java 总是把 byte 当做有符处理；我们可以通过将其和 0xFF 进行二进制与得到它的无符值
        return b & 0xFF;
    }
    /**
     * byte 转 ints
     *特殊处理
     * @param
     * @return
     */


    public static byte[] intToByteArray(int a) {
        return new byte[]{
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 6) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }
    public static int byteArrayToInt(byte[] b) {
        return   b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }
    public static int bytesToInts(byte b[]) {
        return (b[1] & 0xff) | (b[0] & 0xff) << 8 |(b[3] & 0xff) << 16| (b[2] & 0xff) << 24;
    }
    public static int bytesToIntss(byte b[], int offset) {
        return ((b[offset] & 0xff) <<8)| ((b[offset + 1] & 0xff))
                | ((b[offset + 3] & 0xff)) << 16 | ((b[offset+2] & 0xff) << 24);
    }
    public static void main(String[] args) {
        /**
         * 遍历切割数据
         */

//        byte[] sendBuf = {(byte) 0x85, (byte) 0x16, (byte) 0x20, (byte) 0x82, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x80, (byte) 0x01, (byte) 0x01};
//        //1.3.22    1.3.25   1.3.30    1.2.23   1.2.33   1.2.26   1.2.31   1.1.24
//        Map<String, String> map = new HashMap<String, String>();
//        map.put("1.3.22", "1.3.22");
//        map.put("1.3.25", "1.3.25");
//        map.put("1.3.30", "1.3.30");
//        map.put("1.2.23", "1.2.23");
//        map.put("1.2.33", "1.2.33");
//        map.put("1.2.26", "1.2.26");
//        map.put("1.2.31", "1.2.31");
//        map.put("1.1.24", "1.1.24");
//        for (String keys : map.keySet()) {
//            String data = keys;
//            String[] dataArray = data.split("\\.");
//            int addr = Integer.parseInt(dataArray[0]) * 64 * 64 + Integer.parseInt(dataArray[1]) * 64 + Integer.parseInt(dataArray[2]);
//            addr = addr * 2;
//            int high = (addr >> 8) & 0xff;
//            int low = addr & 0xff;
//            sendBuf[2] = (byte) high;
//            sendBuf[3] = (byte) low;
//            System.out.println("high...:" + high + "   low....:" + low);
//            System.out.println(DAPCUtil.toHex(sendBuf));
//        }

    /**
     * 将小数点打印成百分数
     */
        double percent = 50.5D / 150D;

        //输出一下，确认你的小数无误
        System.out.println("小数：" + percent);

        //获取格式化对象
        NumberFormat nt = NumberFormat.getPercentInstance();

        //设置百分数精确度2即保留两位小数
        nt.setMinimumFractionDigits(2);

        //最后格式化并输出
        System.out.println("百分数：" + nt.format(percent));
        int tt=10080;
        byte [] da=toBytes("0d0b0000");
//        System.out.println(da);
//        int int3 = byteArrayToInt(da);
//        System.out.println("int3=" + int3);//int3=1417
//        System.out.println("int......：" + bytesToInt(da));
//        System.out.println("int......：" + bytesToInts(da));
         System.out.println("int......：" + bytesToIntss(da, 0));
int modbusAddr=4001;
        String dad="0d0b0000e1d1000026340000e4fc00000062000013870000cb4009142584000b84ac030830c402502738000027420000273800000fed000010290000106500001490000120ee00001670000100630000138500003250091e4f7c000717380335baac02692738000027420000273800001cd700001cc000001cb00000ec300001347f0000eeb0000100630000138500000da00525ed000f9e05c004f96a70074727380000274c000027420000116d0000119d000011cd00000276000003fc00000492000000350000";
        byte [] storeBuff=toBytes(dad);
        for (int i = 0; i < storeBuff.length; i = i + 4) {
          int j=  (modbusAddr + i* 2 / 4 );
            System.out.println("int......：" + bytesToIntss(storeBuff, i)+"j....:"+j);
        }
//        for (int j = 0; j < dad.length(); j = j + 8) {
//            String dataFor = dad.substring(j, j + 8);
//            System.out.println("dataFor....:"+dataFor);
//            byte[] das = toBytes(dataFor);
//            System.out.println("das......：" + bytesToInts(das));
//        }
        String url="http://192.168.4.101:90/webapi/service/acs/getPlatAcsHistoryEventList";
        String tempUrl = null;
        tempUrl = url.substring("http://".length());
        int index = tempUrl.indexOf("/");
        String URI = tempUrl.substring(index);
        System.out.println(URI);
        String[] ss = URI.split("\\?");
        if (ss.length > 1) {
            System.out.println(11111);
        } else {
            System.out.println(22222);
        }



        JSONObject json = new JSONObject();
        json.put("appkey","9aee8c9e" );
        json.put("time", System.currentTimeMillis() );
        json.put("dst","http://192.168.1.3:80/webapi/service/");
        List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
        Map<String,Object> mapData=new HashMap<String,Object>();
        mapData.put("is_alarm",true);
        mapData.put("event_type",66306);
        Map<String,Object> mapData2=new HashMap<String,Object>();
        mapData2.put("is_alarm",true);
        mapData2.put("event_type",198400);
        Map<String,Object> mapData3=new HashMap<String,Object>();
        mapData3.put("is_alarm",true);
        mapData3.put("event_type",66305);
        list.add(mapData);
        list.add(mapData2);
        list.add(mapData3);
        json.put("types",list);
        String jsons=json.toJSONString();
        System.out.println("jsons'''''':"+jsons);

//        byte[] yy = { (byte) 0x8};
//        byte g3 = (byte) (yy[0] & 0x1);
//        System.out.println("上行.....:"+g3);
//        byte g1 = (byte) ((yy[0] & 0x2) >> 1);
//        System.out.println("下行.......:"+g1);
//        byte g2 = (byte) ((yy[0] & 0x4) >> 2);
//        System.out.println("停止.......:"+g2);
//        byte g4 = (byte) ((yy[0] & 0x8) >> 3);
//        System.out.println("锁梯.......:"+g4);
//        byte b6 = (byte) ((yy[0] & 0x64) >> 6);
//        System.out.println("故障.......:"+b6);

        byte[] info = { (byte) 0x9};
       byte b31 = (byte) ((info[0] & 0x2) >> 3);
        System.out.println("故障b31.......:"+b31);
        byte b3 = (byte) ((info[0] >>3)&0x2);
        System.out.println("故障b3.......:"+b3);
//        byte b31 = (byte) ((info[0] & 0x8) >> 3);
//        System.out.println("故障b31.......:"+b31);
//        byte b3 = (byte) ((info[0] >>3)&0x8);
//        System.out.println("故障b3.......:"+b3);

        String name="1234567890";
        int i=name.indexOf("5");
        //截取掉qieges从首字母起长度为beginIndex的字符串，将剩余字符串赋值给qieges
        String qieges=name.substring(name.indexOf("5") );
        //截取qiege中从beginIndex开始至endIndex结束时的字符串,并将其赋值给qiege.
        // beginIndex - 开始处的索引（包括),endIndex - 结束处的索引（不包括）。
        //返回一个新字符串，它是此字符串的一个子字符串。该子字符串从指定的 beginIndex 处开始，一直到索引 endIndex - 1 处的字符。
        // 因此，该子字符串的长度为 endIndex-beginIndex。
        String qiege=name.substring(2,4);
        System.out.println("切割后的数据....:"+qiege);
    }
}
