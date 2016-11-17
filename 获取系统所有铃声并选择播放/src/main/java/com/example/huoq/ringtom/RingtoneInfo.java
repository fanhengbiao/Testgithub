package com.example.huoq.ringtom;

/**
 * Created by fanhengbiao on 16-11-17.
 */

public class RingtoneInfo {
    String RingUrl;
    String Title;
    boolean isClick;

    @Override
    public String toString() {
        return "RingtoneInfo{" +
                "RingUrl='" + RingUrl + '\'' +
                ", Title='" + Title + '\'' +
                ", isClick=" + isClick +
                '}';
    }

    public String getRingUrl() {
        return RingUrl;
    }

    public void setRingUrl(String ringUrl) {
        RingUrl = ringUrl;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean click) {
        isClick = click;
    }
}
