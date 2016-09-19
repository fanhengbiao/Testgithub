package serviceUtil;

import java.util.List;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: com.youdiandiancn.application.main.supplier.XxEntity.java
 * @author: chenph
 * @date: 2016-08-19 17:26
 */
public   class XxEntity {
    /**
     * Age : 12
     * Name : 小范
     * createdAt : 2016-07-26 09:46:21
     * objectId : 0135598dae
     * updatedAt : 2016-07-26 09:46:21
     */

    private List<ResultsBean> results;

    public List<ResultsBean> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "XxEntity{" +
                "results=" + results +
                '}';
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        private String Age;
        private String Name;
        private String createdAt;
        private String objectId;
        private String updatedAt;

        public String getAge() {
            return Age;
        }

        public void setAge(String Age) {
            this.Age = Age;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getObjectId() {
            return objectId;
        }

        public void setObjectId(String objectId) {
            this.objectId = objectId;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "Age='" + Age + '\'' +
                    ", Name='" + Name + '\'' +
                    ", createdAt='" + createdAt + '\'' +
                    ", objectId='" + objectId + '\'' +
                    ", updatedAt='" + updatedAt + '\'' +
                    '}';
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }
    }

}
