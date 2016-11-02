package com.example.aa.testgithub;

import java.util.List;

/**
 * Created by fanhengbiao on 16-10-25.
 */

public class text {

    /**
     * Id : 677b15f0-80f5-460d-b110-de2cff27fc77
     * AppId : 24850d67-e430-4d68-9830-8812a13744c5
     * MemberId : b4301a4c-9e35-4b95-8763-b148614457b2
     * MemberLocationId : 6252cb6f-9515-4316-93ee-824339c0e61d
     * LocationId : 240af6d3-487e-404c-b8b5-7a90620b4310
     * LocationPid : 10c8fe8b-2142-449e-a8d0-f7acee0b8e98
     * LocationName : 808
     * LocationNumber : 0808
     * LocationFullName : 联发新天地>1号楼>2单元>808
     * LocationCode : CN-FJ-XM-LFXTD-01-02-0808
     * UnitCode : CN-FJ-XM-LFXTD
     * LocationAccount : CN-FJ-XM-LFXTD-01-02-0808-554433289@121.40.75.178
     * LocationPassword : xmcrtech
     * LocationGroup : 3
     * LocationAccountId : 3700
     * LocationType : customer
     * LocationGpsOn : 0
     * IsGate : false
     */

    private String Id;
    private String AppId;
    private String MemberId;
    private String MemberLocationId;
    private String LocationId;
    private String LocationPid;
    private String LocationName;
    private String LocationNumber;
    private String LocationFullName;
    private String LocationCode;
    private String UnitCode;
    private String LocationAccount;
    private String LocationPassword;
    private String LocationGroup;
    private String LocationAccountId;
    private String LocationType;
    private String LocationGpsOn;
    private boolean IsGate;
    /**
     * ErrorCode : 0
     * Message : 返回成功5条住址信息
     */

    private ResponseStatusBean ResponseStatus;
    /**
     * Id : 677b15f0-80f5-460d-b110-de2cff27fc77
     * AppId : 24850d67-e430-4d68-9830-8812a13744c5
     * MemberId : b4301a4c-9e35-4b95-8763-b148614457b2
     * MemberLocationId : 6252cb6f-9515-4316-93ee-824339c0e61d
     * LocationId : 240af6d3-487e-404c-b8b5-7a90620b4310
     * LocationPid : 10c8fe8b-2142-449e-a8d0-f7acee0b8e98
     * LocationName : 808
     * LocationNumber : 0808
     * LocationFullName : 联发新天地>1号楼>2单元>808
     * LocationCode : CN-FJ-XM-LFXTD-01-02-0808
     * UnitCode : CN-FJ-XM-LFXTD
     * LocationAccount : CN-FJ-XM-LFXTD-01-02-0808-554433289@121.40.75.178
     * LocationPassword : xmcrtech
     * LocationGroup : 3
     * LocationAccountId : 3700
     * LocationType : customer
     * LocationGpsOn : 0
     * IsGate : false
     */

    private List<ResultBean> Result;

    @Override
    public String toString() {
        return "text{" +
                "Id='" + Id + '\'' +
                ", AppId='" + AppId + '\'' +
                ", MemberId='" + MemberId + '\'' +
                ", MemberLocationId='" + MemberLocationId + '\'' +
                ", LocationId='" + LocationId + '\'' +
                ", LocationPid='" + LocationPid + '\'' +
                ", LocationName='" + LocationName + '\'' +
                ", LocationNumber='" + LocationNumber + '\'' +
                ", LocationFullName='" + LocationFullName + '\'' +
                ", LocationCode='" + LocationCode + '\'' +
                ", UnitCode='" + UnitCode + '\'' +
                ", LocationAccount='" + LocationAccount + '\'' +
                ", LocationPassword='" + LocationPassword + '\'' +
                ", LocationGroup='" + LocationGroup + '\'' +
                ", LocationAccountId='" + LocationAccountId + '\'' +
                ", LocationType='" + LocationType + '\'' +
                ", LocationGpsOn='" + LocationGpsOn + '\'' +
                ", IsGate=" + IsGate +
                '}';
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String AppId) {
        this.AppId = AppId;
    }

    public String getMemberId() {
        return MemberId;
    }

    public void setMemberId(String MemberId) {
        this.MemberId = MemberId;
    }

    public String getMemberLocationId() {
        return MemberLocationId;
    }

    public void setMemberLocationId(String MemberLocationId) {
        this.MemberLocationId = MemberLocationId;
    }

    public String getLocationId() {
        return LocationId;
    }

    public void setLocationId(String LocationId) {
        this.LocationId = LocationId;
    }

    public String getLocationPid() {
        return LocationPid;
    }

    public void setLocationPid(String LocationPid) {
        this.LocationPid = LocationPid;
    }

    public String getLocationName() {
        return LocationName;
    }

    public void setLocationName(String LocationName) {
        this.LocationName = LocationName;
    }

    public String getLocationNumber() {
        return LocationNumber;
    }

    public void setLocationNumber(String LocationNumber) {
        this.LocationNumber = LocationNumber;
    }

    public String getLocationFullName() {
        return LocationFullName;
    }

    public void setLocationFullName(String LocationFullName) {
        this.LocationFullName = LocationFullName;
    }

    public String getLocationCode() {
        return LocationCode;
    }

    public void setLocationCode(String LocationCode) {
        this.LocationCode = LocationCode;
    }

    public String getUnitCode() {
        return UnitCode;
    }

    public void setUnitCode(String UnitCode) {
        this.UnitCode = UnitCode;
    }

    public String getLocationAccount() {
        return LocationAccount;
    }

    public void setLocationAccount(String LocationAccount) {
        this.LocationAccount = LocationAccount;
    }

    public String getLocationPassword() {
        return LocationPassword;
    }

    public void setLocationPassword(String LocationPassword) {
        this.LocationPassword = LocationPassword;
    }

    public String getLocationGroup() {
        return LocationGroup;
    }

    public void setLocationGroup(String LocationGroup) {
        this.LocationGroup = LocationGroup;
    }

    public String getLocationAccountId() {
        return LocationAccountId;
    }

    public void setLocationAccountId(String LocationAccountId) {
        this.LocationAccountId = LocationAccountId;
    }

    public String getLocationType() {
        return LocationType;
    }

    public void setLocationType(String LocationType) {
        this.LocationType = LocationType;
    }

    public String getLocationGpsOn() {
        return LocationGpsOn;
    }

    public void setLocationGpsOn(String LocationGpsOn) {
        this.LocationGpsOn = LocationGpsOn;
    }

    public boolean isIsGate() {
        return IsGate;
    }

    public void setIsGate(boolean IsGate) {
        this.IsGate = IsGate;
    }

    public ResponseStatusBean getResponseStatus() {
        return ResponseStatus;
    }

    public void setResponseStatus(ResponseStatusBean ResponseStatus) {
        this.ResponseStatus = ResponseStatus;
    }

    public List<ResultBean> getResult() {
        return Result;
    }

    public void setResult(List<ResultBean> Result) {
        this.Result = Result;
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

    public static class ResultBean {
        private String Id;
        private String AppId;
        private String MemberId;
        private String MemberLocationId;
        private String LocationId;
        private String LocationPid;
        private String LocationName;
        private String LocationNumber;
        private String LocationFullName;
        private String LocationCode;
        private String UnitCode;
        private String LocationAccount;
        private String LocationPassword;
        private String LocationGroup;
        private String LocationAccountId;
        private String LocationType;
        private String LocationGpsOn;
        private boolean IsGate;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getAppId() {
            return AppId;
        }

        public void setAppId(String AppId) {
            this.AppId = AppId;
        }

        public String getMemberId() {
            return MemberId;
        }

        public void setMemberId(String MemberId) {
            this.MemberId = MemberId;
        }

        public String getMemberLocationId() {
            return MemberLocationId;
        }

        public void setMemberLocationId(String MemberLocationId) {
            this.MemberLocationId = MemberLocationId;
        }

        public String getLocationId() {
            return LocationId;
        }

        public void setLocationId(String LocationId) {
            this.LocationId = LocationId;
        }

        public String getLocationPid() {
            return LocationPid;
        }

        public void setLocationPid(String LocationPid) {
            this.LocationPid = LocationPid;
        }

        public String getLocationName() {
            return LocationName;
        }

        public void setLocationName(String LocationName) {
            this.LocationName = LocationName;
        }

        public String getLocationNumber() {
            return LocationNumber;
        }

        public void setLocationNumber(String LocationNumber) {
            this.LocationNumber = LocationNumber;
        }

        public String getLocationFullName() {
            return LocationFullName;
        }

        public void setLocationFullName(String LocationFullName) {
            this.LocationFullName = LocationFullName;
        }

        public String getLocationCode() {
            return LocationCode;
        }

        public void setLocationCode(String LocationCode) {
            this.LocationCode = LocationCode;
        }

        public String getUnitCode() {
            return UnitCode;
        }

        public void setUnitCode(String UnitCode) {
            this.UnitCode = UnitCode;
        }

        public String getLocationAccount() {
            return LocationAccount;
        }

        public void setLocationAccount(String LocationAccount) {
            this.LocationAccount = LocationAccount;
        }

        public String getLocationPassword() {
            return LocationPassword;
        }

        public void setLocationPassword(String LocationPassword) {
            this.LocationPassword = LocationPassword;
        }

        public String getLocationGroup() {
            return LocationGroup;
        }

        public void setLocationGroup(String LocationGroup) {
            this.LocationGroup = LocationGroup;
        }

        public String getLocationAccountId() {
            return LocationAccountId;
        }

        public void setLocationAccountId(String LocationAccountId) {
            this.LocationAccountId = LocationAccountId;
        }

        public String getLocationType() {
            return LocationType;
        }

        public void setLocationType(String LocationType) {
            this.LocationType = LocationType;
        }

        public String getLocationGpsOn() {
            return LocationGpsOn;
        }

        public void setLocationGpsOn(String LocationGpsOn) {
            this.LocationGpsOn = LocationGpsOn;
        }

        public boolean isIsGate() {
            return IsGate;
        }

        public void setIsGate(boolean IsGate) {
            this.IsGate = IsGate;
        }
    }
}
