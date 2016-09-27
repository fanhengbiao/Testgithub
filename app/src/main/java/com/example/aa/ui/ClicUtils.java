package com.example.aa.ui;

/**
 * 计算时间差
 */
public class ClicUtils
{
	//最后点击的时间
	private static long lastClickTime;
    //如果为true的情况下代表点击的时间太短     为false的情况下代表可以继续点击
	public static boolean isFastDoubleClick()
	{
		//当前的时间
		long time = System.currentTimeMillis();
		//计算与上次点击的时间差隔
		long timeD = time - lastClickTime;

		if (0 <= timeD && timeD < 1500)
		{
			return true;

		}
		//把当前的时候赋值给最后点击的时间
		lastClickTime = time;

		return false;
	}
	public static boolean isCartFastDoubleClick()
	{
		long time = System.currentTimeMillis();
		//计算与上次点击的时间差隔
		long timeD = time - lastClickTime;

		if (0 <= timeD && timeD < 300)
		{
			return true;

		}
		//把当前的时候赋值给最后点击的时间
		lastClickTime = time;

		return false;
	}
	
}
