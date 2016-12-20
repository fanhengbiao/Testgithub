package com.example.weixin;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.tencent.mm.sdk.modelpay.PayReq;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 微信支付，只能看代码，不能运行
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            //开始是生成预订单，得到预订单号
            String wxPayInfo="";
            final JSONObject jsonObject = new JSONObject(wxPayInfo);
            final String tradeNo = jsonObject.getString("tradeNo");
            final String totalFee = jsonObject.getString("totalFee");
            final String body = jsonObject.getString("body");
            final String noncestr = UtilTool.genNonceStr();
            final String ipAddress = UtilTool.getIpAddress();
            List<NameValuePair> packageParams = new LinkedList<NameValuePair>();
            packageParams.add(new BasicNameValuePair("appid", Sharedparms.weixinInfo.WEIXIN_APPID));
            packageParams.add(new BasicNameValuePair("body", body));
            packageParams.add(new BasicNameValuePair("mch_id", Sharedparms.weixinInfo.WINXIN_PARTNERID));
            packageParams.add(new BasicNameValuePair("nonce_str", noncestr));
            packageParams.add(new BasicNameValuePair("notify_url", "http://jy.jnoo.com/notifywxapp.php"));
            packageParams.add(new BasicNameValuePair("out_trade_no", tradeNo));
            packageParams.add(new BasicNameValuePair("spbill_create_ip", ipAddress));
            packageParams.add(new BasicNameValuePair("total_fee", totalFee));
            packageParams.add(new BasicNameValuePair("trade_type", "APP"));
            final String sign = UtilTool.genPackageSign(packageParams);
            packageParams.add(new BasicNameValuePair("sign", sign));
            String xmlstring = UtilTool.toXml(packageParams);
            final String parme;

            parme = new String(xmlstring.toString().getBytes(), "ISO8859-1");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String url = String.format(Sharedparms.weixinInfo.WEIXIN_API);
                    byte[] buf = Util.httpPost(url, parme);
                    String content = new String(buf);
                    Map<String, String> xml = UtilTool.decodeXml(content);
                    if (xml.containsKey("prepay_id")) {
                        String prepay_id = xml.get("prepay_id");
                        Map<String, String> messMap = new HashMap<String, String>();
                        messMap.put("prepay_id", prepay_id);
                        messMap.put("noncestr", noncestr);
                        messMap.put("sign", sign);
                        Message message = new Message();
                        message.what = WEIXIN_PAY;
                        message.obj = messMap;
                        Mhandler.dispatchMessage(message);
                    }

                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static int WEIXIN_PAY = 4;//
    Handler Mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
             if (msg.what == WEIXIN_PAY) {
                Map<String, String> map = (Map<String, String>) msg.obj;
                String prepay_id = map.get("prepay_id");
                String noncestr = map.get("noncestr");
                String sign = map.get("sign");
                WXPay(prepay_id, noncestr, sign);

            }

        }
    };
    /**
     * 微信支付接口
     *
     * @param prepay_id
     * @param
     * @param
     * @param
     * @param noncestr
     * @param
     * @param sign
     */
    private void WXPay(String prepay_id, String noncestr, String sign) {
        try {
            if (!TextUtils.isEmpty(prepay_id)) {
                Log.e("微信支付:", "prepay_id" + Sharedparms.weixinInfo.WEIXIN_APPID + ".." + Sharedparms.weixinInfo.WINXIN_PARTNERID + ".." + prepay_id
                        + ".." + noncestr + ".." + UtilTool.genTimeStamp() + ".." + sign);
                PayReq req = new PayReq();
  /*
        *注册app到微信
        * */
                IWXAPI api = WXAPIFactory.createWXAPI(MainActivity.this, Sharedparms.weixinInfo.WEIXIN_APPID);
                api.registerApp(Sharedparms.weixinInfo.WEIXIN_APPID);
                req.appId = Sharedparms.weixinInfo.WEIXIN_APPID;
                req.partnerId = Sharedparms.weixinInfo.WINXIN_PARTNERID;
                req.prepayId = prepay_id;
                req.nonceStr = UtilTool.getRanDomNum();
                req.timeStamp = UtilTool.genTimeStamp();
                req.packageValue = "Sign=WXPay";
                List<NameValuePair> signParams = new LinkedList<NameValuePair>();
                signParams.add(new BasicNameValuePair("appid", req.appId));
                signParams.add(new BasicNameValuePair("noncestr", req.nonceStr));
                signParams.add(new BasicNameValuePair("package", req.packageValue));
                signParams.add(new BasicNameValuePair("partnerid", req.partnerId));
                signParams.add(new BasicNameValuePair("prepayid", req.prepayId));
                signParams.add(new BasicNameValuePair("timestamp", req.timeStamp));
                req.sign = UtilTool.genPackageSign(signParams);
                // 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
                boolean b = api.sendReq(req);
                Log.d("微信支付", "b" + b);
            } else {
                Log.e("微信支付", "服务器请求错误");

            }
        } catch (Exception e) {
            Log.e("微信支付", "异常：" + e.getMessage());

        }
    }
}
