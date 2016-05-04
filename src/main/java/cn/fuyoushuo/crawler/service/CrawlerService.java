package cn.fuyoushuo.crawler.service;

import cn.fuyoushuo.crawler.config.CrawlerConfig;
import cn.fuyoushuo.crawler.ext.CommonPageProcesser;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Spider;

import java.util.regex.Pattern;

/**
 * Created by MALIANG on 2016/4/29.
 */
@Service
public class CrawlerService {


    public JSONObject crawlContent(CrawlerConfig crawlerConfig, String rootUrl){
          if(!crawlerConfig.validate()) return null;
          String urlRegex = crawlerConfig.getUrlRegex();
          if(!Pattern.matches(urlRegex,rootUrl)) return null;
          ResultItems resultItems = Spider.create(new CommonPageProcesser(crawlerConfig)).get(rootUrl);
          return new JSONObject(resultItems.getAll());
    }


}
