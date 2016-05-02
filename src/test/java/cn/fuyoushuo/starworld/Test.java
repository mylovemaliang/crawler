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

import java.util.Date;

/**
 * Created by MALIANG on 2016/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class Test {

     @org.junit.Test
     public void test1(){
            long beginTime = new Date().getTime();
            Spider spider = Spider.create(new PageProcessor() {
             @Override
             public void process(Page page) {
                 Html html = page.getHtml();
                 String ename = html.$(".star_dpage_table table tbody").xpath("//tr[4]/td[2]/text()").get();
                 page.putField("ename",ename);
             }
            @Override
             public Site getSite() {
                 return Site.me().setSleepTime(0);
             }
         });
         Object o = spider.get("http://ent.qianzhan.com/ent/star/b0110def.html");
         spider.close();
         long endTime = new Date().getTime();
         System.out.println(endTime - beginTime);
     }



}