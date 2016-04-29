package cn.fuyoushuo.crawler.config;

import org.springframework.util.StringUtils;
import us.codecraft.webmagic.selector.Selectable;

/**
 * Created by MALIANG on 2016/4/29.
 */
public class FieldItem {

    private String name;

    private String items;

    private String regex;

    private String afterRegex;

    public FieldItem() {
    }

    public FieldItem(String items, String name, String regex, String afterRegex) {
        this.items = items;
        this.name = name;
        this.regex = regex;
        this.afterRegex = afterRegex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getAfterRegex() {
        return afterRegex;
    }

    public void setAfterRegex(String afterRegex) {
        this.afterRegex = afterRegex;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public Selectable parseRegex(Selectable html){
        String regex = this.regex;
        if(StringUtils.isEmpty(regex)) return null;
        String[] regexs = regex.split("\\+");
        for(String regexString : regexs){
            String[] regexItems = regexString.split(":");
            if(regexItems.length != 2) continue;
            String regexName = regexItems[0];
            String regexItem = regexItems[1];
            if("css".equals(regexName)){
                html = html.css(regexItem);
            }
            if("xpath".equals(regexName)){
                html = html.xpath(regexItem);
            }
            if("regex".equals(regexName)){
                html = html.regex(regexItem);
            }
        }
        return html;
        }


    public static void main(String[] args) {
        String string= "2222";
        String[] strings = string.split("\\+");
        System.out.println("success");
    }
}
