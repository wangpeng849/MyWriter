package com.wangp.myaop.coding;

public class ReturnSameWord {
    /**
     * 返回两个字符串公共单词
     *
     * 由于单词间有空格
     * 根据空格将字符串切割成字符串数组
     * 然后对数组进行比较
     * @param s
     * @param t
     * @return
     */
    public static String returnSameWord(String s, String t){
        String[] sArr = str2Arr(s);
        String[] tArr = str2Arr(t);

        for (int i = 0; i < sArr.length; i++) {
            for (int j = 0; j < tArr.length; j++) {
                if("".equals(tArr[j]) | "".equals(sArr[i])){
                    break;
                }
                if(sArr[i].equals(tArr[j])){
                    return sArr[i];
                }
            }
        }
        return "null";
    }

    /**
     * 字符串转数组
     * @param str
     * @return
     */
    public static String[] str2Arr(String str){
        String[] result = new String[100];
        for (int i = 0; i < result.length; i++) {
            result[i] = "";
        }
        //数组计数
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if(' '==str.charAt(i)){
                count ++;
                continue;
            }
            result[count]+=str.charAt(i)+"";
        }
        return result;
    }

    //测试结果
    public static void main(String[] args) {
        String str = "this is my name a s d eewr sad ";
        String str2 = "A your naw me eeswr sd";
        String word = returnSameWord(str, str2);
        System.out.println(word);
    }
}
