package cn.fuyoushuo.starworld;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.util.List;

import java.util.Date;

/**
 * Created by MALIANG on 2016/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class Test {

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
}