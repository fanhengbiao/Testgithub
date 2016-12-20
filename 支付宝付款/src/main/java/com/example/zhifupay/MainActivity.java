package com.example.zhifupay;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import com.alipay.sdk.app.PayTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 支付宝付款，这只能看代码，不能运行的
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_zhipay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String payJsInfo="";
                    JSONObject jsonObject = new JSONObject(payJsInfo);
                    String seller_id = jsonObject.getString("seller");
                    String subject = jsonObject.getString("subject");
                    String body = jsonObject.getString("body");
                    String price = jsonObject.getString("price");
                    String out_trade_no = jsonObject.getString("tradeNo");
                    String it_b_pay = jsonObject.getString("timeout");
                    String notify_url = jsonObject.getString("notifyUrl");
                    String orderInfo = getOrderInfo(subject, body, price, seller_id, out_trade_no, it_b_pay, notify_url);
                    /**
                     * 特别注意，这里的签名逻辑需要放在服务端，切勿将私钥泄露在代码中！
                     */
                    String sign = sign(orderInfo);
                    try {
                        /**
                         * 仅需对sign 做URL编码
                         */
                        sign = URLEncoder.encode(sign, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    final String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + getSignType();
                    Runnable payRunnable = new Runnable() {

                        @Override
                        public void run() {
                            // 构造PayTask 对象
                            PayTask alipay = new PayTask(MainActivity.this);
                            // 调用支付接口，获取支付结果
                            String result = alipay.pay(payInfo, true);

                            Message msg = new Message();
                            msg.what = SDK_PAY_FLAG;
                            msg.obj = result;
                            Mhandler.sendMessage(msg);
                        }
                    };
                    // 必须异步调用
                    Thread payThread = new Thread(payRunnable);
                    payThread.start();
                    Toast.makeText(MainActivity.this, payInfo, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private static int SDK_PAY_FLAG = 3;
    Handler Mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == SDK_PAY_FLAG) {//支付宝支付
                String result = (String) msg.obj;
                String substring = result.split(";")[0].split("=")[1];
                String resultStatus = substring.substring(1, substring.length() - 1);
                if ("9000".equalsIgnoreCase(resultStatus)) {
//                    mwebview.loadUrl("javascript:success(" + resultStatus + ")");
                    Toast.makeText(MainActivity.this, "支付成功", Toast.LENGTH_SHORT).show();
                } else {
//                    mwebview.loadUrl("javascript:error(" + resultStatus + ")");
                }
//                        Toast.makeText(MainActivity.this,""+resultStatus,Toast.LENGTH_SHORT).show();
            }

        }
    };
    /**
     * @param subject      描述
     * @param body         详情
     * @param price        价格
     * @param seller_id    商家支付宝账号
     * @param out_trade_no 唯一订单号
     * @param it_b_pay     设置未付款交易的超时时间
     *                     notify_url    服务器异步通知页面路径
     * @return
     */
    private String getOrderInfo(String subject, String body, String price, String seller_id, String out_trade_no, String it_b_pay, String notify_url) {

        // 签约合作者身份ID
        String orderInfo = "partner=" + "\"" + Sharedparms.PayInfo.PARTNER + "\"";

        // 签约卖家支付宝账号
        orderInfo += "&seller_id=" + "\"" + seller_id + "\"";

        // 商户网站唯一订单号
        orderInfo += "&out_trade_no=" + "\"" + out_trade_no + "\"";

        // 商品名称
        orderInfo += "&subject=" + "\"" + subject + "\"";

        // 商品详情
        orderInfo += "&body=" + "\"" + body + "\"";

        // 商品金额
        orderInfo += "&total_fee=" + "\"" + price + "\"";

        // 服务器异步通知页面路径
        orderInfo += "&notify_url=" + "\"" + notify_url + "\"";

        // 服务接口名称， 固定值
        orderInfo += "&service=\"mobile.securitypay.pay\"";

        // 支付类型， 固定值
        orderInfo += "&payment_type=\"1\"";

        // 参数编码， 固定值
        orderInfo += "&_input_charset=\"utf-8\"";

        // 设置未付款交易的超时时间
        // 默认30分钟，一旦超时，该笔交易就会自动被关闭。
        // 取值范围：1m～15d。
        // m-分钟，h-小时，d-天，1c-当天（无论交易何时创建，都在0点关闭）。
        // 该参数数值不接受小数点，如1.5h，可转换为90m。
        orderInfo += "&it_b_pay=" + "\"" + it_b_pay + "\"";

        // extern_token为经过快登授权获取到的alipay_open_id,带上此参数用户将使用授权的账户进行支付
        // orderInfo += "&extern_token=" + "\"" + extern_token + "\"";

        // 支付宝处理完请求后，当前页面跳转到商户指定页面的路径，可空
//            orderInfo += "&return_url=\"m.alipay.com\"";

        return orderInfo;
    }

    /**
     * sign the order info. 对订单信息进行签名
     *
     * @param content 待签名订单信息
     */
    private String sign(String content) {
        return SignUtils.sign(content, Sharedparms.PayInfo.RSA_PRIVATE);
    }

    /**
     * get the sign type we use. 获取签名方式
     */
    private String getSignType() {
        return "sign_type=\"RSA\"";
    }
}
