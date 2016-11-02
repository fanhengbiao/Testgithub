package com.timecount.testgithub;

import android.annotation.SuppressLint;
import android.os.CountDownTimer;
import android.widget.Button;

@SuppressLint("ResourceAsColor")
public class TimeCount extends CountDownTimer
{
	private Button mBtnGetcode;

	public TimeCount(long millisInFuture, long countDownInterval,Button btnGetcode) {
		super(millisInFuture, countDownInterval);
		mBtnGetcode = btnGetcode;
	}

	@SuppressLint("ResourceAsColor")
	@Override
	public void onTick(long millisUntilFinished) {
//		mBtnGetcode.setBackgroundColor(R.drawable.yanzhenmahou);
		mBtnGetcode.setBackgroundResource(R.mipmap.yanzhenmahou);
		mBtnGetcode.setClickable(false);
		mBtnGetcode.setText(millisUntilFinished / 1000 + "秒后可重新发送");
	}

	@Override
	public void onFinish() {
		mBtnGetcode.setText("重新获取验证码");
		mBtnGetcode.setClickable(true);
		mBtnGetcode.setBackgroundResource(R.mipmap.yanzhengma);

	}
}
