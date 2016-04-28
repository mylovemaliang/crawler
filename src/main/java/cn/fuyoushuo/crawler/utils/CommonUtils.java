package cn.fuyoushuo.crawler.utils;

import java.util.Random;

/**
 * Created by MALIANG on 2016/4/7.
 */
public class CommonUtils {

    /**
     * 获取随机数
     * @param min
     * @param max
     * @return
     */
    public static int getRandomInt(int min,int max){
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
    }


}
