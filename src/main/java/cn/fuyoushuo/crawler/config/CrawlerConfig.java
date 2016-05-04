package cn.fuyoushuo.crawler.config;

import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by MALIANG on 2016/4/29.
 */
public class CrawlerConfig {

       //判断url是否满足爬取规则
       private String urlRegex;

       //爬取字段定义
       private List<FieldItem> fields;

       //是否有子任务
       private Boolean hasChildTask;

       //子任务url筛选
       private String childUrlRegex;

       //待定字段(含义暂未定义)
       private List<String> resultFields;

       //配置判断是否生效
       public boolean validate(){
           if(StringUtils.isEmpty(this.urlRegex)){
               return false;
           }
           return true;
       }

       public String getUrlRegex() {
            return urlRegex;
        }

        public void setUrlRegex(String urlRegex) {
            this.urlRegex = urlRegex;
        }

        public List<FieldItem> getFields() {
            return fields;
        }

        public void setFields(List<FieldItem> fields) {
            this.fields = fields;
        }

        public Boolean hasChildTask() {
            return hasChildTask;
        }

        public void setHasChildTask(Boolean hasChildTask) {
            this.hasChildTask = hasChildTask;
        }

        public String getChildUrlRegex() {
            return childUrlRegex;
        }

        public void setChildUrlRegex(String childUrlRegex) {
            this.childUrlRegex = childUrlRegex;
        }

        public List<String> getResultFields() {
            return resultFields;
        }

        public void setResultFields(List<String> resultFields) {
            this.resultFields = resultFields;
        }


}
