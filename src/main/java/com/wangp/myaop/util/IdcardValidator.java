package com.wangp.myaop.util;

import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

/**
 * <pre>
 * classname IdcardValidator
 * description
 * </pre>
 *
 * @author wangp
 * @date 2020/8/4 15:43
 **/
public class IdcardValidator {

    /**
     * 省，直辖市代码表： { 11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古", 21:"辽宁",22:"吉林",23:"黑龙江",31:"上海",32:"江苏",
     * 33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南", 42:"湖北",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",
     * 51:"四川",52:"贵州",53:"云南",54:"西藏",61:"陕西",62:"甘肃", 63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外"}
     */
    protected final static String[][] codeAndProvince = {{"11", "北京"}, {"12", "天津"},
            {"13", "河北"}, {"14", "山西"}, {"15", "内蒙古"}, {"21", "辽宁"},
            {"22", "吉林"}, {"23", "黑龙江"}, {"31", "上海"}, {"32", "江苏"},
            {"33", "浙江"}, {"34", "安徽"}, {"35", "福建"}, {"36", "江西"},
            {"37", "山东"}, {"41", "河南"}, {"42", "湖北"}, {"43", "湖南"},
            {"44", "广东"}, {"45", "广西"}, {"46", "海南"}, {"50", "重庆"},
            {"51", "四川"}, {"52", "贵州"}, {"53", "云南"}, {"54", "西藏"},
            {"61", "陕西"}, {"62", "甘肃"}, {"63", "青海"}, {"64", "宁夏"},
            {"65", "新疆"}, {"71", "台湾"}, {"81", "香港"}, {"82", "澳门"},
            {"91", "国外"}};

    private final static String[] CICY_CODE = {"11", "12", "13", "14", "15", "21", "22",
            "23", "31", "32", "33", "34", "35", "36", "37", "41", "42", "43",
            "44", "45", "46", "50", "51", "52", "53", "54", "61", "62", "63",
            "64", "65", "71", "81", "82", "91"};

    // 每位加权因子
    private final static int[] POWER = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    // 第18位校检码
    private final static String[] VERIFY_CODE = {"1", "0", "X", "9", "8", "7", "6", "5",
            "4", "3", "2"};

    //身份证长度
    private final static int id_card_len = 18;

    //身份证正则
    private final static String id_card_reg = "[0-9xX]+";

    //身份证特殊字符
    private final static String special_char_X = "X";


    /**
     * 验证所有的身份证的合法性
     *
     * @param idCard
     * @return
     */
    public static boolean isValidatedAllIdCard(String idCard) {
        idCard = idCard.replace("x", "X");
        if (idCard.length() == id_card_len && idCard.matches(id_card_reg)) {
            if (idCard.contains(special_char_X) && !(idCard.indexOf(special_char_X) == id_card_len - 1)) {
                return false;
            }
            return validLastCode(idCard);
        }
        return false;
    }

    private static boolean validLastCode(String idCard) {
        int sum = 0;
        for (int i = 0; i < idCard.toCharArray().length - 1; i++) {
            sum += (idCard.charAt(i) - 48) * POWER[i];
        }
        if (VERIFY_CODE[sum % 11].equals(idCard.substring(id_card_len - 1))) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * 判断18位身份证的合法性
     * </p>
     * 根据〖中华人民共和国国家标准【GB11643-1999】中有关公民身份号码的规定，公民身份号码是特征组合码，由十七位数字本体码和一位数字校验码组成。 排列顺序从左至右依次为：六位数字地址码，八位数字出生日期码，三位数字顺序码和一位数字校验码。
     * <p>
     * 顺序码: 表示在同一地址码所标识的区域范围内，对同年、同月、同 日出生的人编定的顺序号，顺序码的奇数分配给男性，偶数分配 给女性。
     * </p>
     * <p>
     * 1.前1、2位数字表示：所在省份的代码； 2.第3、4位数字表示：所在城市的代码； 3.第5、6位数字表示：所在区县的代码； 4.第7~14位数字表示：出生年、月、日； 5.第15、16位数字表示：所在地的派出所的代码；
     * 6.第17位数字表示性别：奇数表示男性，偶数表示女性； 7.第18位数字是校检码：也有的说是个人信息码，一般是随计算机的随机产生，用来检验身份证的正确性。校检码可以是0~9的数字，有时也用x表示。
     * </p>
     * <p>
     * 第十八位数字(校验码)的计算方法为： 1.将前面的身份证号码17位数分别乘以不同的系数。从第一位到第十七位的系数分别为：7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
     * </p>
     * <p>
     * 2.将这17位数字和系数相乘的结果相加。
     * </p>
     * <p>
     * 3.用加出来和除以11，看余数是多少？
     * </p>
     * 4.余数只可能有0 1 2 3 4 5 6 7 8 9 10这11个数字。其分别对应的最后一位身份证的号码为1 0 X 9 8 7 6 5 4 3 2。
     * <p>
     * 5.通过上面得知如果余数是2，就会在身份证的第18位数字上出现罗马数字的Ⅹ。如果余数是10，身份证的最后一位号码就是2。
     * </p>
     *
     * @param idCard
     * @return
     */
    public static User getUserInfo(String idCard) {
        if (!isValidatedAllIdCard(idCard)) {
            return null;
        }
        String province = acquireProvince(idCard);
        String city = acquireCity(idCard, province);
        String birth = idCard.substring(6, 14);
        String year = birth.substring(0, 4);
        String month = birth.substring(4, 6);
        String day = birth.substring(6, 8);
        String sex = acquireSex(idCard);
        return User.builder().province(province).city(city).year(year).month(month).day(day).sex(sex).build();
    }

    private static String acquireSex(String idCard) {
        String sex = idCard.substring(16, 17);
        if ((Integer.parseInt(sex) & 1) == 0) {
            sex = "女";
        } else {
            sex = "男";
        }
        return sex;
    }

    private static String acquireCity(String idCard, String province) {
        String city = idCard.substring(0, 4);
        city = CITY_MAP.get(city);
        return city;
    }

    private static String acquireProvince(String idCard) {
        String province = idCard.substring(0, 2);
        for (String[] strings : codeAndProvince) {
            if (strings[0].equals(province)) {
                province = strings[1];
            }
        }
        return province;
    }

    public static void main(String[] args) {
        System.out.println(getUserInfo("360313199710272037"));
    }


    //城市map
    public final static Map<String, String> CITY_MAP = new HashMap<>();

    static {
        CITY_MAP.put("1100", "北京");
        CITY_MAP.put("1200", "天津");
        CITY_MAP.put("1301", "石家庄");
        CITY_MAP.put("1302", "唐山");
        CITY_MAP.put("1303", "秦皇岛");
        CITY_MAP.put("1304", "邯郸");
        CITY_MAP.put("1305", "邢台");
        CITY_MAP.put("1306", "保定");
        CITY_MAP.put("1307", "张家口");
        CITY_MAP.put("1308", "承德");
        CITY_MAP.put("1309", "沧州");
        CITY_MAP.put("1310", "廊坊");
        CITY_MAP.put("1311", "衡水");
        CITY_MAP.put("1401", "太原");
        CITY_MAP.put("1402", "大同");
        CITY_MAP.put("1403", "阳泉");
        CITY_MAP.put("1404", "长治");
        CITY_MAP.put("1405", "晋城");
        CITY_MAP.put("1406", "朔州");
        CITY_MAP.put("1407", "晋中");
        CITY_MAP.put("1408", "运城");
        CITY_MAP.put("1409", "忻州");
        CITY_MAP.put("1410", "临汾");
        CITY_MAP.put("1411", "吕梁");
        CITY_MAP.put("1424", "晋中");
        CITY_MAP.put("1501", "呼和浩特");
        CITY_MAP.put("1502", "包头");
        CITY_MAP.put("1503", "乌海");
        CITY_MAP.put("1504", "赤峰");
        CITY_MAP.put("1505", "通辽");
        CITY_MAP.put("1506", "鄂尔多斯");
        CITY_MAP.put("1507", "呼伦贝尔");
        CITY_MAP.put("1508", "巴彦淖尔");
        CITY_MAP.put("1509", "乌兰察布");
        CITY_MAP.put("1522", "兴安盟");
        CITY_MAP.put("1525", "锡林郭勒");
        CITY_MAP.put("1529", "阿拉善盟");
        CITY_MAP.put("2101", "沈阳");
        CITY_MAP.put("2102", "大连");
        CITY_MAP.put("2103", "鞍山");
        CITY_MAP.put("2104", "抚顺");
        CITY_MAP.put("2105", "本溪");
        CITY_MAP.put("2106", "丹东");
        CITY_MAP.put("2107", "锦州");
        CITY_MAP.put("2108", "营口");
        CITY_MAP.put("2109", "阜新");
        CITY_MAP.put("2110", "辽阳");
        CITY_MAP.put("2111", "盘锦");
        CITY_MAP.put("2112", "铁岭");
        CITY_MAP.put("2113", "朝阳");
        CITY_MAP.put("2114", "葫芦岛");
        CITY_MAP.put("2200", "吉林");
        CITY_MAP.put("2201", "长春");
        CITY_MAP.put("2202", "吉林");
        CITY_MAP.put("2203", "四平");
        CITY_MAP.put("2204", "辽源");
        CITY_MAP.put("2205", "通化");
        CITY_MAP.put("2206", "白山");
        CITY_MAP.put("2207", "松原");
        CITY_MAP.put("2208", "白城");
        CITY_MAP.put("2224", "延边州");
        CITY_MAP.put("2301", "哈尔滨");
        CITY_MAP.put("2302", "齐齐哈尔");
        CITY_MAP.put("2303", "鸡西");
        CITY_MAP.put("2304", "鹤岗");
        CITY_MAP.put("2305", "双鸭山");
        CITY_MAP.put("2306", "大庆");
        CITY_MAP.put("2307", "伊春");
        CITY_MAP.put("2308", "佳木斯");
        CITY_MAP.put("2309", "七台河");
        CITY_MAP.put("2310", "牡丹江");
        CITY_MAP.put("2311", "黑河");
        CITY_MAP.put("2312", "绥化");
        CITY_MAP.put("2321", "哈尔滨");
        CITY_MAP.put("2327", "大兴安岭");
        CITY_MAP.put("3100", "上海");
        CITY_MAP.put("3201", "南京");
        CITY_MAP.put("3202", "无锡");
        CITY_MAP.put("3203", "徐州");
        CITY_MAP.put("3204", "常州");
        CITY_MAP.put("3205", "苏州");
        CITY_MAP.put("3206", "南通");
        CITY_MAP.put("3207", "连云港");
        CITY_MAP.put("3208", "淮安");
        CITY_MAP.put("3209", "盐城");
        CITY_MAP.put("3210", "扬州");
        CITY_MAP.put("3211", "镇江");
        CITY_MAP.put("3212", "泰州");
        CITY_MAP.put("3301", "杭州");
        CITY_MAP.put("3302", "宁波");
        CITY_MAP.put("3303", "温州");
        CITY_MAP.put("3304", "嘉兴");
        CITY_MAP.put("3305", "湖州");
        CITY_MAP.put("3306", "绍兴");
        CITY_MAP.put("3307", "金华");
        CITY_MAP.put("3308", "衢州");
        CITY_MAP.put("3309", "舟山");
        CITY_MAP.put("3310", "台州");
        CITY_MAP.put("3311", "丽水");
        CITY_MAP.put("3401", "合肥");
        CITY_MAP.put("3402", "芜湖");
        CITY_MAP.put("3403", "蚌埠");
        CITY_MAP.put("3404", "淮南");
        CITY_MAP.put("3405", "马鞍山");
        CITY_MAP.put("3406", "淮北");
        CITY_MAP.put("3407", "铜陵");
        CITY_MAP.put("3408", "安庆");
        CITY_MAP.put("3410", "黄山");
        CITY_MAP.put("3411", "滁州");
        CITY_MAP.put("3412", "阜阳");
        CITY_MAP.put("3413", "宿州");
        CITY_MAP.put("3415", "六安");
        CITY_MAP.put("3416", "亳州");
        CITY_MAP.put("3417", "池州");
        CITY_MAP.put("3418", "宣城");
        CITY_MAP.put("3422", "宿县");
        CITY_MAP.put("3501", "福州");
        CITY_MAP.put("3502", "厦门");
        CITY_MAP.put("3503", "莆田");
        CITY_MAP.put("3504", "三明");
        CITY_MAP.put("3505", "泉州");
        CITY_MAP.put("3506", "漳州");
        CITY_MAP.put("3507", "南平");
        CITY_MAP.put("3508", "龙岩");
        CITY_MAP.put("3509", "宁德");
        CITY_MAP.put("3601", "南昌");
        CITY_MAP.put("3602", "景德镇");
        CITY_MAP.put("3603", "萍乡");
        CITY_MAP.put("3604", "九江");
        CITY_MAP.put("3605", "新余");
        CITY_MAP.put("3606", "鹰潭");
        CITY_MAP.put("3607", "赣州");
        CITY_MAP.put("3608", "吉安");
        CITY_MAP.put("3609", "宜春");
        CITY_MAP.put("3610", "抚州");
        CITY_MAP.put("3611", "上饶");
        CITY_MAP.put("3701", "济南");
        CITY_MAP.put("3702", "青岛");
        CITY_MAP.put("3703", "淄博");
        CITY_MAP.put("3704", "枣庄");
        CITY_MAP.put("3705", "东营");
        CITY_MAP.put("3706", "烟台");
        CITY_MAP.put("3707", "潍坊");
        CITY_MAP.put("3708", "济宁");
        CITY_MAP.put("3709", "泰安");
        CITY_MAP.put("3710", "威海");
        CITY_MAP.put("3711", "日照");
        CITY_MAP.put("3712", "莱芜");
        CITY_MAP.put("3713", "临沂");
        CITY_MAP.put("3714", "德州");
        CITY_MAP.put("3715", "聊城");
        CITY_MAP.put("3716", "滨州");
        CITY_MAP.put("3717", "菏泽");
        CITY_MAP.put("4101", "郑州");
        CITY_MAP.put("4102", "开封");
        CITY_MAP.put("4103", "洛阳");
        CITY_MAP.put("4104", "平顶山");
        CITY_MAP.put("4105", "安阳");
        CITY_MAP.put("4106", "鹤壁");
        CITY_MAP.put("4107", "新乡");
        CITY_MAP.put("4108", "焦作");
        CITY_MAP.put("4109", "濮阳");
        CITY_MAP.put("4110", "许昌");
        CITY_MAP.put("4111", "漯河");
        CITY_MAP.put("4112", "三门峡");
        CITY_MAP.put("4113", "南阳");
        CITY_MAP.put("4114", "商丘");
        CITY_MAP.put("4115", "信阳");
        CITY_MAP.put("4116", "周口");
        CITY_MAP.put("4117", "驻马店");
        CITY_MAP.put("4201", "武汉");
        CITY_MAP.put("4202", "黄石");
        CITY_MAP.put("4203", "十堰");
        CITY_MAP.put("4205", "宜昌");
        CITY_MAP.put("4206", "襄阳");
        CITY_MAP.put("4207", "鄂州");
        CITY_MAP.put("4208", "荆门");
        CITY_MAP.put("4209", "孝感");
        CITY_MAP.put("4210", "荆州");
        CITY_MAP.put("4211", "黄冈");
        CITY_MAP.put("4212", "咸宁");
        CITY_MAP.put("4213", "随州");
        CITY_MAP.put("4228", "恩施州");
        CITY_MAP.put("4301", "长沙");
        CITY_MAP.put("4302", "株洲");
        CITY_MAP.put("4303", "湘潭");
        CITY_MAP.put("4304", "衡阳");
        CITY_MAP.put("4305", "邵阳");
        CITY_MAP.put("4306", "岳阳");
        CITY_MAP.put("4307", "常德");
        CITY_MAP.put("4309", "益阳");
        CITY_MAP.put("4310", "郴州");
        CITY_MAP.put("4311", "永州");
        CITY_MAP.put("4312", "怀化");
        CITY_MAP.put("4313", "娄底");
        CITY_MAP.put("4331", "湘西州");
        CITY_MAP.put("4401", "广州");
        CITY_MAP.put("4402", "韶关");
        CITY_MAP.put("4403", "深圳");
        CITY_MAP.put("4404", "珠海");
        CITY_MAP.put("4405", "汕头");
        CITY_MAP.put("4406", "佛山");
        CITY_MAP.put("4407", "江门");
        CITY_MAP.put("4408", "湛江");
        CITY_MAP.put("4409", "茂名");
        CITY_MAP.put("4412", "肇庆");
        CITY_MAP.put("4413", "惠州");
        CITY_MAP.put("4414", "梅州");
        CITY_MAP.put("4415", "汕尾");
        CITY_MAP.put("4416", "河源");
        CITY_MAP.put("4417", "阳江");
        CITY_MAP.put("4418", "清远");
        CITY_MAP.put("4419", "东莞");
        CITY_MAP.put("4420", "中山");
        CITY_MAP.put("4451", "潮州");
        CITY_MAP.put("4452", "揭阳");
        CITY_MAP.put("4453", "云浮");
        CITY_MAP.put("4501", "南宁");
        CITY_MAP.put("4502", "柳州");
        CITY_MAP.put("4503", "桂林");
        CITY_MAP.put("4504", "梧州");
        CITY_MAP.put("4505", "北海");
        CITY_MAP.put("4506", "防城港");
        CITY_MAP.put("4507", "钦州");
        CITY_MAP.put("4508", "贵港");
        CITY_MAP.put("4509", "玉林");
        CITY_MAP.put("4510", "百色");
        CITY_MAP.put("4511", "贺州");
        CITY_MAP.put("4512", "河池");
        CITY_MAP.put("4513", "来宾");
        CITY_MAP.put("4514", "崇左");
        CITY_MAP.put("4524", "贺州");
        CITY_MAP.put("4601", "海口");
        CITY_MAP.put("4602", "三亚");
        CITY_MAP.put("4690", "儋州");
        CITY_MAP.put("4690", "三沙");
        CITY_MAP.put("5000", "重庆");
        CITY_MAP.put("5101", "成都");
        CITY_MAP.put("5103", "自贡");
        CITY_MAP.put("5104", "攀枝花");
        CITY_MAP.put("5105", "泸州");
        CITY_MAP.put("5106", "德阳");
        CITY_MAP.put("5107", "绵阳");
        CITY_MAP.put("5108", "广元");
        CITY_MAP.put("5109", "遂宁");
        CITY_MAP.put("5110", "内江");
        CITY_MAP.put("5111", "乐山");
        CITY_MAP.put("5113", "南充");
        CITY_MAP.put("5114", "眉山");
        CITY_MAP.put("5115", "宜宾");
        CITY_MAP.put("5116", "广安");
        CITY_MAP.put("5117", "达州");
        CITY_MAP.put("5119", "巴中");
        CITY_MAP.put("5120", "资阳");
        CITY_MAP.put("5134", "凉山州");
        CITY_MAP.put("5201", "贵阳");
        CITY_MAP.put("5202", "六盘水");
        CITY_MAP.put("5203", "遵义");
        CITY_MAP.put("5204", "安顺");
        CITY_MAP.put("5205", "毕节");
        CITY_MAP.put("5206", "铜仁");
        CITY_MAP.put("5223", "黔西南州");
        CITY_MAP.put("5226", "黔东南州");
        CITY_MAP.put("5227", "黔南州");
        CITY_MAP.put("5301", "昆明");
        CITY_MAP.put("5303", "曲靖");
        CITY_MAP.put("5304", "玉溪");
        CITY_MAP.put("5305", "保山");
        CITY_MAP.put("5306", "昭通");
        CITY_MAP.put("5307", "丽江");
        CITY_MAP.put("5308", "普洱");
        CITY_MAP.put("5309", "临沧");
        CITY_MAP.put("5323", "楚雄州");
        CITY_MAP.put("5325", "红河州");
        CITY_MAP.put("5326", "文山州");
        CITY_MAP.put("5328", "西双版纳");
        CITY_MAP.put("5329", "大理州");
        CITY_MAP.put("5331", "德宏州");
        CITY_MAP.put("5333", "怒江州");
        CITY_MAP.put("5334", "迪庆州");
        CITY_MAP.put("5401", "拉萨");
        CITY_MAP.put("5421", "昌都");
        CITY_MAP.put("5422", "山南");
        CITY_MAP.put("5423", "日喀则");
        CITY_MAP.put("5426", "林芝");
        CITY_MAP.put("6101", "西安");
        CITY_MAP.put("6102", "铜川");
        CITY_MAP.put("6103", "宝鸡");
        CITY_MAP.put("6104", "咸阳");
        CITY_MAP.put("6105", "渭南");
        CITY_MAP.put("6106", "延安");
        CITY_MAP.put("6107", "汉中");
        CITY_MAP.put("6108", "榆林");
        CITY_MAP.put("6109", "安康");
        CITY_MAP.put("6110", "商洛");
        CITY_MAP.put("6201", "兰州");
        CITY_MAP.put("6202", "嘉峪关");
        CITY_MAP.put("6203", "金昌");
        CITY_MAP.put("6204", "白银");
        CITY_MAP.put("6205", "天水");
        CITY_MAP.put("6206", "武威");
        CITY_MAP.put("6207", "张掖");
        CITY_MAP.put("6208", "平凉");
        CITY_MAP.put("6209", "酒泉");
        CITY_MAP.put("6210", "庆阳");
        CITY_MAP.put("6211", "定西");
        CITY_MAP.put("6212", "陇南");
        CITY_MAP.put("6229", "临夏州");
        CITY_MAP.put("6230", "甘南州");
        CITY_MAP.put("6301", "西宁");
        CITY_MAP.put("6321", "海东");
        CITY_MAP.put("6322", "海北州");
        CITY_MAP.put("6323", "黄南州");
        CITY_MAP.put("6325", "海南州");
        CITY_MAP.put("6326", "果洛州");
        CITY_MAP.put("6327", "玉树州");
        CITY_MAP.put("6328", "海西州");
        CITY_MAP.put("6401", "银川");
        CITY_MAP.put("6402", "石嘴山");
        CITY_MAP.put("6403", "吴忠");
        CITY_MAP.put("6404", "固原");
        CITY_MAP.put("6405", "中卫");
        CITY_MAP.put("6501", "乌鲁木齐");
        CITY_MAP.put("6502", "克拉玛依");
        CITY_MAP.put("6521", "吐鲁番");
        CITY_MAP.put("6522", "哈密");
        CITY_MAP.put("6523", "昌吉州");
        CITY_MAP.put("6527", "博尔塔拉州");
        CITY_MAP.put("6528", "巴音郭楞");
        CITY_MAP.put("6530", "克孜勒苏州");
        CITY_MAP.put("6531", "喀什地区");
        CITY_MAP.put("6532", "和田地区");
        CITY_MAP.put("6540", "伊犁州");
        CITY_MAP.put("6542", "塔城地区");
        CITY_MAP.put("6590", "石河子");

    }
}

@Data
@Builder
class User {

    private String province;
    private String city;
    private String year;
    private String month;
    private String day;
    private String sex;
}