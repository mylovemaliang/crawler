package cn.fuyoushuo.crawler.service;

import cn.fuyoushuo.crawler.config.CrawlerConfig;
import cn.fuyoushuo.crawler.config.FieldItem;
import us.codecraft.webmagic.Spider;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by MALIANG on 2016/4/29.
 */
public class CrawlerService {



    public static void crawlContent(CrawlerConfig crawlerConfig,String RootUrl){
          if(!crawlerConfig.validate()) return;
          String urlRegex = crawlerConfig.getUrlRegex();
          if(!Pattern.matches(urlRegex,RootUrl)) return;
          List<FieldItem> fields = crawlerConfig.getFields();
          Spider.


    }


}
