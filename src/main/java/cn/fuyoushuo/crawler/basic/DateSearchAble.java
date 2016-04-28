package cn.fuyoushuo.crawler.basic;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by MALIANG on 2015/11/9.
 */
public class DateSearchAble implements Serializable{

    @DateTimeFormat(pattern = "yyyy-MM-dd'")
    protected Date fromTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd'")
    protected Date toTime;

    public Date getFromTime() {
        return fromTime;
    }

    public void setFromTime(Date fromTime) {
        this.fromTime = fromTime;
    }

    public Date getToTime() {
        return toTime;
    }

    public void setToTime(Date toTime) {
        this.toTime = toTime;
    }
}
