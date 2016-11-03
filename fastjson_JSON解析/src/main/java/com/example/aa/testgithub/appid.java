package com.example.aa.testgithub;

/**
 * Created by fanhengbiao on 16-11-2.
 */

public class appid {

    /**
     * userid : 1111111
     * sessionid : 22222
     * username : 158254655
     * mata : {"intercomtoken":"8723895735-23847283"}
     */

    private String userid;
    private String sessionid;
    private String username;
    /**
     * intercomtoken : 8723895735-23847283
     */

    private MataBean mata;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "appid{" +
                "userid='" + userid + '\'' +
                ", sessionid='" + sessionid + '\'' +
                ", username='" + username + '\'' +
                ", mata=" + mata +
                '}';
    }

    public MataBean getMata() {
        return mata;
    }

    public void setMata(MataBean mata) {
        this.mata = mata;
    }

    public static class MataBean {
        private String intercomtoken;

        public String getIntercomtoken() {
            return intercomtoken;
        }

        @Override
        public String toString() {
            return "MataBean{" +
                    "intercomtoken='" + intercomtoken + '\'' +
                    '}';
        }

        public void setIntercomtoken(String intercomtoken) {
            this.intercomtoken = intercomtoken;
        }
    }
}
