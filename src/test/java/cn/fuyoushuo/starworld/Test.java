package cn.fuyoushuo.starworld;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

/**
 * Created by MALIANG on 2016/4/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class Test {

     @org.junit.Test
     public void test1(){
         Spider.create(new PageProcessor() {
             @Override
             public void process(Page page) {
                 Html html = page.getHtml();
                 String ename = html.$(".star_dpage_table table tbody").xpath("//tr[4]/td[2]/text()").get();
                 System.out.println(ename);
             }
             @Override
             public Site getSite() {
                 return Site.me();
             }
         }).addUrl("http://ent.qianzhan.com/ent/star/b0110def.html").run();

     }



}