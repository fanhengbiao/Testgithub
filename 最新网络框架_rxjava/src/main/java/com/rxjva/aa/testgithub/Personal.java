package com.rxjva.aa.testgithub;

import java.util.List;

/**
 * Created by fanhengbiao on 16-10-9.
 */

public class Personal {


    /**
     * ErrorCode : 0
     * Message : 返回成功。
     */

    private ResponseStatusBean ResponseStatus;
    /**
     * ID : 45299b48-a038-4d0a-948f-965d7dbd9de2
     * PID :
     * NID :
     * Title : 联发新天地-公告测试3
     * Content :  尊敬的业主/住户：
     据市气象台预报，我市未来几日天气寒冷、干燥，气温明显下降，最低温度约为5～7℃，在此服务处特别提醒您：
     一、 随时关注天气变化，做好防寒保暖和预防疾病的措施。
     二、 适当进行体育锻炼，户外运动要做好防寒措施。
     三、 在控制室温的同时，应注意及时开窗通风换气，保持空气流通。
     四、 使用电暖设备，注意用电安全。
     五、 安全使用燃气热水器，沐浴时间不宜过长，严防使用不当引起一 氧化碳中毒。
     感谢您对服务处工作的支持与配合
     * SimpleContent :  据市气象台预报，我市未来几日天气寒冷、干燥，气温明显下降，最低温度约为5～7℃，
     * Url :
     * Type : 0
     * State : 1
     * Author : 联发物业
     * CreateTime : 2015/12/14
     */

    private List<NewsBean> News;

    public ResponseStatusBean getResponseStatus() {
        return ResponseStatus;
    }

    public void setResponseStatus(ResponseStatusBean ResponseStatus) {
        this.ResponseStatus = ResponseStatus;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "ResponseStatus=" + ResponseStatus +
                ", News=" + News +
                '}';
    }

    public List<NewsBean> getNews() {
        return News;
    }

    public void setNews(List<NewsBean> News) {
        this.News = News;
    }

    public static class ResponseStatusBean {
        private String ErrorCode;
        private String Message;

        public String getErrorCode() {
            return ErrorCode;
        }

        public void setErrorCode(String ErrorCode) {
            this.ErrorCode = ErrorCode;
        }

        public String getMessage() {
            return Message;
        }

        public void setMessage(String Message) {
            this.Message = Message;
        }
    }

    public static class NewsBean {
        private String ID;
        private String PID;
        private String NID;
        private String Title;
        private String Content;
        private String SimpleContent;
        private String Url;
        private String Type;
        private String State;
        private String Author;
        private String CreateTime;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getPID() {
            return PID;
        }

        @Override
        public String toString() {
            return "NewsBean{" +
                    "ID='" + ID + '\'' +
                    ", PID='" + PID + '\'' +
                    ", NID='" + NID + '\'' +
                    ", Title='" + Title + '\'' +
                    ", Content='" + Content + '\'' +
                    ", SimpleContent='" + SimpleContent + '\'' +
                    ", Url='" + Url + '\'' +
                    ", Type='" + Type + '\'' +
                    ", State='" + State + '\'' +
                    ", Author='" + Author + '\'' +
                    ", CreateTime='" + CreateTime + '\'' +
                    '}';
        }

        public void setPID(String PID) {
            this.PID = PID;
        }

        public String getNID() {
            return NID;
        }

        public void setNID(String NID) {
            this.NID = NID;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public String getSimpleContent() {
            return SimpleContent;
        }

        public void setSimpleContent(String SimpleContent) {
            this.SimpleContent = SimpleContent;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getState() {
            return State;
        }

        public void setState(String State) {
            this.State = State;
        }

        public String getAuthor() {
            return Author;
        }

        public void setAuthor(String Author) {
            this.Author = Author;
        }

        public String getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(String CreateTime) {
            this.CreateTime = CreateTime;
        }
    }
}
