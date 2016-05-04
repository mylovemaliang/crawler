package cn.fuyoushuo.crawler.config;

import org.springframework.util.StringUtils;
import us.codecraft.webmagic.selector.Selectable;

import java.io.Serializable;

/**
 * Created by MALIANG on 2016/5/4.
 */
public class NestedItem implements Serializable{

    private String name;

    private String regex;

    private String afterRegex;

    public NestedItem() {
    }

    public NestedItem(String name, String regex) {
        this.name = name;
        this.regex = regex;
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


}
