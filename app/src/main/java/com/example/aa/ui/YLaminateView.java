package com.example.aa.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Scroller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 添加进来的view的hashCode必须不一样
 * 勇哥写的上下滑动
 * @author yorun
 */
public class YLaminateView extends RelativeLayout
{

	LinkedList<View> slidViews;

	LinkedList<View> currentViews;

	ArrayList<View> totalViews;

	ArrayList<Float> currentYs;

	Scroller scroller;

	float effectiveEdgeHeight = 100;// 奏效的距离

	private long duration = 300;

	boolean isAnimating;// 任何一张图片滚动时 其他图片取消动画处理

	int velocity = 500;// 奏效的速度

	OnPageChangeListener onPageChangeListener;

	/**
	 * Determines speed during touch scrolling
	 */
	private VelocityTracker mVelocityTracker;

	private int mTouchSlop;
	private int mMinimumVelocity;
	private int mMaximumVelocity;

	private Context mContext;

	public YLaminateView(Context context, AttributeSet attrs, int defStyleAttr)
	{
		super(context, attrs, defStyleAttr);

		init(context, attrs, defStyleAttr);
	}

	private void init(Context context, AttributeSet attrs, int defStyleAttr)
	{
		mContext = context;
		slidViews = new LinkedList<View>();
		currentViews = new LinkedList<View>();
		currentYs = new ArrayList<Float>();
		totalViews = new ArrayList<View>();
		scroller = new Scroller(context);

		final ViewConfiguration configuration = ViewConfiguration.get(context);
		mTouchSlop = configuration.getScaledTouchSlop();
		mMinimumVelocity = configuration.getScaledMinimumFlingVelocity();
		mMaximumVelocity = configuration.getScaledMaximumFlingVelocity();
		WindowManager wm = (WindowManager) getContext()
                .getSystemService(Context.WINDOW_SERVICE);
		mHeight = wm.getDefaultDisplay().getHeight();
		Log.e("mHeight", String.valueOf(mHeight));
	}

	@SuppressLint("NewApi")
	public void setView(List<View> views)
	{
		totalViews.clear();
		slidViews.clear();
		currentViews.clear();

		for (int i = views.size() - 1; i >= 0l; i--)
		{
			View view = views.get(i);
			currentViews.push(view);
			addView(view);
			view.setClickable(true);
			currentYs.add(0f);
		}
		for (int i = 0; i < currentViews.size(); i++)
		{
			OnSubViewTouchListener l = new OnSubViewTouchListener(i);
			View view = currentViews.get(i);
			view.setOnTouchListener(l);
			view.setTag(l);
			totalViews.add(view);
		}
	}

	public YLaminateView(Context context, AttributeSet attrs)
	{
		this(context, attrs, 0);
	}

	public YLaminateView(Context context)
	{
		this(context, null);
	}

	float mYDownTemp;
	float mYDown;

	private int mHeight;

	@SuppressLint("NewApi")
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev)
	{

		switch (ev.getAction())
		{
		case MotionEvent.ACTION_DOWN:
		{

			mYDownTemp = ev.getY();
			break;
		}
		case MotionEvent.ACTION_MOVE:
		{
			// 下滑拦截
			if ((ev.getY() - mYDownTemp > 0) && slidViews.peek() != null)
			{
				OnSubViewTouchListener l = (OnSubViewTouchListener) currentViews
						.peek().getTag();
				// 如果当前页面正在执行动画 则不拦截
				if (l.last == 0.0 || l.last == -getHeight())
				{
					return true;
				}
			}

			// if ((ev.getY() - mYDown > 0) && slidViews.peek() != null) {
			// return true;
			// }
		}
		default:
			break;
		}
		return super.onInterceptTouchEvent(ev);
	}

	@SuppressLint("NewApi")
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{

		initVelocityTrackerIfNotExists();

		float rawY = event.getY();
		View peek = slidViews.peek();
		OnSubViewTouchListener l = (OnSubViewTouchListener) (peek.getTag());

		switch (event.getAction())
		{
		case MotionEvent.ACTION_DOWN:
		{
			mVelocityTracker.clear();
			l.animator.cancel();
			mYDownTemp = rawY;
			mYDown = rawY;
			break;
		}
		case MotionEvent.ACTION_MOVE:
		{
			mVelocityTracker.addMovement(event);
			float dy = rawY - mYDownTemp;
			handleEdgeMove(peek, dy);
			mYDownTemp = rawY;
			break;
		}
		case MotionEvent.ACTION_UP:
		{
			float dy = rawY - mYDown;
			handleUp(l, peek, slidViews.size() - 1, event, dy);
			break;
		}
		default:
			break;
		}
		return true;
	}

	@SuppressLint("NewApi")
	private void handleEdgeMove(View peek, float dy)
	{

		OnSubViewTouchListener l = (OnSubViewTouchListener) peek.getTag();
		float end = l.last + dy;
		ObjectAnimator.ofFloat(peek, "translationY", l.last, end)
				.setDuration(0).start();
		l.last = end;
	}

	@SuppressLint("NewApi")
	public class OnSubViewTouchListener implements OnTouchListener,
			AnimatorListener, AnimatorUpdateListener
	{

		int position;

		float last;

		ObjectAnimator animator;

		boolean isCancel;

		public OnSubViewTouchListener(int position)
		{
			super();
			this.position = position;
		}

		float yDownTemp = 0;
		float yDown = 0;
		View v;

		@SuppressLint("NewApi")
		@Override
		public boolean onTouch(View v, MotionEvent event)
		{
			initVelocityTrackerIfNotExists();
			if (isAnimating && (animator == null || !animator.isRunning()))
			{
				// 有控件在执行 并且不是当前对象 不接受当前事件
				return false;
			}

			float y = event.getRawY();
			switch (event.getAction())
			{
			case MotionEvent.ACTION_DOWN:
			{
				mVelocityTracker.clear();
				if (animator == null)
				{
					animator = ObjectAnimator.ofFloat(v, "translationY", 0);
					animator.addListener(this);
					animator.addUpdateListener(this);
					animator.setDuration(duration);

					this.v = v;
				}

				isCancel = this.last != 0;

				animator.cancel();
				yDownTemp = y;
				yDown = y;
				break;
			}
			case MotionEvent.ACTION_MOVE:
			{
				mVelocityTracker.addMovement(event);
				float dy = y - yDownTemp;
				handleMove(this, v, position, dy);
				yDownTemp = y;
				break;
			}
			case MotionEvent.ACTION_UP:
			{
				if (animator == null)
				{
					animator = ObjectAnimator.ofFloat(v, "translationY", 0);
					animator.addListener(this);
					animator.addUpdateListener(this);
					animator.setDuration(duration);
					
					this.v = v;
				}
				float dy = y - yDown;
				handleUp(this, v, position, event, dy);
				break;
			}
			default:
				break;
			}
			return false;
		}

		@Override
		public void onAnimationStart(Animator animation)
		{

		}

		@Override
		public void onAnimationEnd(Animator animation)
		{

			if (this.last == -getHeight() && currentViews.size() > 0)
			{

				if (slidViews.size() - 1 != position)
				{

					slidViews.push(currentViews.pop());

					if (onPageChangeListener != null)
					{
						onPageChangeListener.onPageChange(position + 1,
								totalViews, YLaminateView.this);
					}
				}
			}

			if (this.last == 0 && slidViews.size() > 0
					&& slidViews.peek() == this.v)
			{
				currentViews.push(slidViews.pop());
				if (onPageChangeListener != null)
				{
					onPageChangeListener.onPageChange(position, totalViews,
							YLaminateView.this);

				}
			}

			isAnimating = false;
		}

		@Override
		public void onAnimationCancel(Animator animation)
		{
		}

		@Override
		public void onAnimationRepeat(Animator animation)
		{
		}

		@Override
		public void onAnimationUpdate(ValueAnimator animation)
		{
			this.last = (Float) animation.getAnimatedValue();
		}
	}

	@SuppressLint("NewApi")
	private void handleMove(OnSubViewTouchListener l, View v, int position,
			float dy)
	{
		int y = (int) v.getY();
		int bottom = v.getBottom();
		Log.e("bottom", String.valueOf(bottom));
		// 第一张不让往下滑
		if(dy>0  && slidViews.size() == 0  && y>=0)
		{
			return;
		}
		
		// 最后一张不让往上滑
		if (dy < 0 && currentViews.size() == 1)
		{
			return;
		}
		if (dy > 0 && currentViews.size() == 1)
		{
			return; 
		}

		float end = l.last + dy;
		ObjectAnimator.ofFloat(v, "translationY", l.last, end).setDuration(0)
				.start();
		l.last = end;

	}

	public void handleUp(OnSubViewTouchListener l, View v, int position,
			MotionEvent event, float dy)
	{

		final VelocityTracker velocityTracker = mVelocityTracker;
		velocityTracker.computeCurrentVelocity(1000, mMaximumVelocity);
		int initialVelocity = Math.abs((int) velocityTracker.getYVelocity(event
				.getPointerId(0)));
		isAnimating = true;

		int height = getHeight();

		if (totalViews.get(position) == currentViews.peek())
		{// 滑动的是当前布局

			if (l.last < -height / 2 || (initialVelocity > velocity && dy < 0)
					|| (l.last < -effectiveEdgeHeight))
			{
				if (position != totalViews.size() - 1)
				{

					crosse(l, v, position, true);// 划上去
				}
			} else
			{
				reset(l, v, position, false);
			}
		} else
		{// 滑动的是上一个布局
			if (l.last > -height / 2 || initialVelocity > velocity
					|| (l.last < (-height + effectiveEdgeHeight)))
			{
				reset(l, v, position, false);
			} else
			{
				crosse(l, v, position, true);
			}
		}
	}

	@SuppressLint("NewApi")
	private void crosse(OnSubViewTouchListener l, View v, int position,
			boolean isUp)
	{

		int height = getHeight();
		if (isUp)
		{
			l.animator.setFloatValues(l.last, -height);
		} else
		{
			l.animator.setFloatValues(l.last, height);
		}
		l.animator.start();
	}

	@SuppressLint("NewApi")
	private void reset(final OnSubViewTouchListener l, View v, int position,
			boolean isUp)
	{
		if(l.animator!=null)
		{
			l.animator.setFloatValues(l.last, 0);
			l.animator.start();
		}
		
	}

	private void initVelocityTrackerIfNotExists()
	{
		if (mVelocityTracker == null)
		{
			mVelocityTracker = VelocityTracker.obtain();
		}
	}

	public void setDuration(long duration)
	{
		this.duration = duration;
	}

	public void setOnPageChangeListener(
			OnPageChangeListener onPageChangeListener)
	{
		this.onPageChangeListener = onPageChangeListener;
	}

	public static interface OnPageChangeListener
	{
		void onPageChange(int i, ArrayList<View> totalViews,
						  YLaminateView parent);
	}
}
