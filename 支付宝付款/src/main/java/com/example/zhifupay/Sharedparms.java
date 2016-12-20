package com.example.zhifupay;

/**
 * Created by fanhb on 2016/12/6.--公共参数
 */

public class Sharedparms {
    /*
    网页
    * */
    public static String WEBVIEW_UIL = "http://jy.leejia.cn";
    /*
    * webview的设置useragent，但是后面需要加入版本号
    * */
    public static String WEBVIEWA_AGENT = "app.Jnoo.com/";

    /**
     * 微信appid和appidsecret
     */
    public static class weixinInfo {
        public static String WEIXIN_APPID = "wx7c35ac6495868a48";
        public static String WINXIN_SECRET = "ec9423ddc4c6ec73395f0da8de91afbd";
        //商户号
        public static String WINXIN_PARTNERID="1359749402";
        //key
        public static String WEIXIN_KEY="641e3e03a32cfced53af2bacab970da8";
        //统一下单生成订单的接口
        public static String WEIXIN_API="https://api.mch.weixin.qq.com/pay/unifiedorder";

    }

    /**
     *支付宝支付信息
     */
    public static class PayInfo {
        // 商户PID
        public static final String PARTNER = "2088911648469578";
        // 商户私钥，pkcs8格式
        public static final String RSA_PRIVATE = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAK6aWJB0K6OLsOpq K6cxtO37bWHNbslSblvJh2Eo+ifXWce+fNPZpz09Z0P+6BYgSg8eDW2IDVm9KMkW oO3hIcihotu5krv0+SKISVhGp/OZ7sDG5o/YUgBdb/MfvwIHIPGTAOMNL4jJX2ks 3JuAwBzyX2Y0OXEZh5LZSfmAJyJ5AgMBAAECgYEArL2a/V9RhT5Ay8o6YfF1dTUY pHggMSFSeZDKVT+7LguKkWlOCjH9mULUlZrtdmZ/nrE2y7ScsLnKThgLIw1m43tc ojqBpLYmcJ6dVkSYL3w+A3wxeD4U79qluG7GixtdhyHVcraawtLq5teQ3OtFIeME uoA+LMUVpblgyk/jN7kCQQDVP9qUUVh7jCjjTFe+4HCE+7lG68LeL4o5Wt+/5/zf FhAX686AnWvBNANLzOk6eiIJnpfnworTmpFUyBFV1ycXAkEA0Zsejk3wehWesfRm MQiKTjes8NudgyrpPlUSyb7NPa07pZBUC6UdaYcgOKra1r3Uh/ZIlu0/8yz3GRJ2 ngn87wJADqv3AO9b1Bw/j+vnuZU9iJi9FZkQ7jJ9IxcSf+SZLEwbTVoG+ihaio9m jqeJgGF4yAqmTua+oHJo/1lIgAxufwJBAKqO3r5NDXFKRmfnx3/+wwwCoecbzX/+ Wu0trKwdZkTZwb9nQfx3zwcfvUhfPtOehGJeNZMaWv81h5wPOhY/amECQEt8zKvQ mze685yDK/Cc54uUGEV2gH6TGnqtfG27S2iZ3MXFF756v6lFLK65LR7qDJH4p7GR dLp+i2KLc8H36gM=";
        // 支付宝公钥
        public static final String RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
    }
}
