package cn.fuyoushuo.starworld;

import cn.fuyoushuo.crawler.config.CrawlerConfig;
import cn.fuyoushuo.crawler.config.FieldItem;
import cn.fuyoushuo.crawler.config.NestedItem;
import cn.fuyoushuo.crawler.service.CrawlerService;
import com.alibaba.fastjson.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;

/**
 * Created by MALIANG on 2016/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class Test {

    @Autowired
    CrawlerService crawlerService;

     @org.junit.Test
     public void test1(){
         ResultItems resultItems = Spider.create(new PageProcessor() {
             @Override
             public void process(Page page) {
                 Html html = page.getHtml();
                 List<String> all = html.css(".ent_lpage_list li:lt(3)").xpath("//p[1]/a/text() | //p[2]/text()").all();
                 System.out.println("success");
             }

             @Override
             public Site getSite() {
                 return Site.me().setSleepTime(0);
             }
         }).get("http://ent.qianzhan.com/ent/stars?page=1");
         System.out.println("success");
     }

    @org.junit.Test
    public void test2(){
        CrawlerConfig crawlerConfig = new CrawlerConfig();
        crawlerConfig.setUrlRegex("http://ent\\.qianzhan\\.com/ent/stars\\?page=[0-9]*");
        crawlerConfig.setHasChildTask(false);
        List<FieldItem> fields = new ArrayList<FieldItem>();
        //item1
        FieldItem item1 = new FieldItem();
        item1.setName("stars");
        item1.setRegex("css:.ent_lpage_list+xpath://ul/li");
        item1.setType("nested");
        item1.setSize(6);
        item1.getNestedItems().add(new NestedItem("starName","xpath://p[1]/a[1]/text()"));
        item1.getNestedItems().add(new NestedItem("job","xpath://p[2]/text()"));
        item1.getNestedItems().add(new NestedItem("nationality","xpath://p[3]/text()"));
        //item2
        FieldItem item2 = new FieldItem();
        item2.setType("common");
        item2.setName("title");
        item2.setRegex("xpath://title/text()");
        fields.add(item1);
        fields.add(item2);
        crawlerConfig.setFields(fields);
        JSONObject jsonObject = crawlerService.crawlContent(crawlerConfig, "http://ent.qianzhan.com/ent/stars?page=1");
        System.out.println("success");
    }
}