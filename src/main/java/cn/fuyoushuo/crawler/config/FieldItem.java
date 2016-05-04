package cn.fuyoushuo.crawler.config;

import org.springframework.util.StringUtils;
import us.codecraft.webmagic.selector.Selectable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MALIANG on 2016/4/29.
 */
public class FieldItem {


    /**
     *  对象 key 值
     */
    private String name;

    /**
     *  "nested": 对象数据
     *  "common": 普通数据
     */
    private String type;

    /**
     *  如不为空，默认为nested type
     */
    private String items;

    /**
     *  本层解析(css,xpath,regex)
     */
    private String regex;

    /**
     *  如果为对象数组，定义爬取对象数
     */
    private Integer size;

    /**
     *  后续处理（待定义）
     */
    private String afterRegex;

    /**
     * 对象属性定义
     */
    private List<NestedItem> nestedItems = new ArrayList<NestedItem>();

    public FieldItem() {
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

    public Integer getSize() {
        if(this.size == null){
            size = Integer.MAX_VALUE;
        }
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<NestedItem> getNestedItems() {
        return nestedItems;
    }

    public void setNestedItems(List<NestedItem> nestedItems) {
        this.nestedItems = nestedItems;
    }

    public static void main(String[] args) {
        String string= "2222";
        String[] strings = string.split("\\+");
        System.out.println("success");
    }
}
