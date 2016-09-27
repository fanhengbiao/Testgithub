package com.example.aa.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 该类的两个方法要统一起来用，先调compressImageFromFile（）先把图片存在SD卡里，再去设它的缩比率
 * 该方法返回的Bitmap对像传进compressBmpFromBmp（）进去，精度和格式的转换
 */
public class ImageUtils
{
	static ImageUtils mImageUtils;
	private ExecutorService pool = Executors.newFixedThreadPool(20);// 创建线程池开启10条

	public static ImageUtils getDefaultImageUtils()
	{
		if (mImageUtils == null)
		{
			mImageUtils = new ImageUtils();
		}
		return mImageUtils;
	}
    public static Bitmap DrawableToBitmap(Drawable drawable)
    {
    	Bitmap bitmap = Bitmap
    			.createBitmap(
    			drawable.getIntrinsicWidth(),
    			drawable.getIntrinsicHeight(),
    			drawable.getOpacity() != PixelFormat.OPAQUE ? Config.ARGB_8888
    			: Config.RGB_565);
    			Canvas canvas = new Canvas(bitmap);
    			// canvas.setBitmap(bitmap);
    			drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
    			drawable.getIntrinsicHeight());
    			drawable.draw(canvas);
    			return bitmap;
    }
	@SuppressLint("NewApi")
	public Bitmap getBitmap(Context context, int imagID)
	{
		BitmapFactory.Options options = new BitmapFactory.Options();
		InputStream is = context.getResources().openRawResource(imagID);
		options.inJustDecodeBounds = true;
		Bitmap bitmap1 = BitmapFactory.decodeStream(is, null, options);
		double bitmapWith = options.outWidth;
		double bitmapHeight = options.outHeight;
		Screen screenPix = getScreenPix(context);
		double zoomWith = Math.ceil(bitmapWith / screenPix.widthPixels);
		double zoomHeight = Math.ceil(bitmapWith / screenPix.heightPixels);
		options.inSampleSize = (int) (zoomWith > zoomHeight ? zoomWith
				: zoomHeight);
		options.inJustDecodeBounds = false;
		options.inPreferredConfig = Config.ARGB_4444;
		options.inPurgeable = true;
		options.inInputShareable = true;
		Bitmap bitmap = BitmapFactory.decodeStream(is, null, options);
//		int byteCount = bitmap.getByteCount(); 2.3版本无此方法 报错
		return bitmap;
	}
	public Bitmap AdaptaBitmap(Context context, String pathName)
	{
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		Bitmap bitmap1 = BitmapFactory.decodeFile(pathName, options);
		double bitmapWith = options.outWidth;
		double bitmapHeight = options.outHeight;
		Screen screenPix = getScreenPix(context);
		double zoomWith = Math.ceil(bitmapWith / screenPix.widthPixels);
		double zoomHeight = Math.ceil(bitmapWith / screenPix.heightPixels);
		options.inSampleSize = (int) (zoomWith > zoomHeight ? zoomWith
				: zoomHeight);
		options.inJustDecodeBounds = false;
		options.inPreferredConfig = Config.RGB_565;
		options.inPurgeable = true;
		options.inInputShareable = true;
		Bitmap bitmap = BitmapFactory.decodeFile(pathName, options);
//		int byteCount = bitmap.getByteCount(); 2.3版本无此方法 报错
		return bitmap;
	}

	/**
	 * @param context
	 * @return 得到一个手机屏幕宽高的对像.
	 */
	public Screen getScreenPix(Context context)
	{
		DisplayMetrics dm = new DisplayMetrics();
		WindowManager windowManager = (WindowManager) context
				.getApplicationContext().getSystemService(
						Context.WINDOW_SERVICE);
		windowManager.getDefaultDisplay().getMetrics(dm);
		return new Screen(dm.widthPixels, dm.heightPixels);
	}

	public class Screen
	{
		public int widthPixels;
		public int heightPixels;

		public Screen()
		{
		}

		public Screen(int widthPixels, int heightPixels)
		{
			this.widthPixels = widthPixels;
			this.heightPixels = heightPixels;
		}

	}


	/**
	 * 将图片在内存中进行压缩
	 * 
	 * @param
	 *
	 * @param image
	 *            Bitmap对像
	 * @param num
	 *            这张图片要压缩多大 最好不要超过200
	 * @return 返回压缩后的图片
	 */
	public Bitmap compressBmpFromBmp(Bitmap image, int num)
	{
		Bitmap bitmap = null;
		// 图片的长宽
		int widthPx = image.getWidth();
		int heightPx = image.getHeight();
		long memoryNum = (heightPx * widthPx * 4) / (1024 * 1024);
		// 如果在程序中占用的内存大于0.5M 要进行压缩处理防止内存溢出
		long freeMemory = Runtime.getRuntime().freeMemory();
		// 图片内存中所占有的内存不能大于程序的剩余内存
		Log.e("memoryNum", "" + memoryNum);
		Log.e("freeMemory", "" + freeMemory);
		if (memoryNum >= freeMemory * 0.3)
		{
			if (memoryNum >= 0.5)
			{
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				int options = 100;
				image.compress(Bitmap.CompressFormat.JPEG, 100, baos);
				// 压缩到刚好小于100kb为止
				while (baos.toByteArray().length / 1024 > num)
				{
					baos.reset();
					options -= 10;
					image.compress(Bitmap.CompressFormat.JPEG, options, baos);
				}
				ByteArrayInputStream isBm = new ByteArrayInputStream(
						baos.toByteArray());
				bitmap = BitmapFactory.decodeStream(isBm, null, null);
			}
		} else
		{
			return image;
		}
		return bitmap;
	}

	public Bitmap loadImgThumbnail(String filePath, int w, int h)
	{
		Log.e("filePath", filePath);

		Bitmap bitmap = getBitmapByPath(filePath);
		return zoomBitmap(bitmap, w, h);
	}

	/**
	 * 获取bitmap
	 * 
	 * @param filePath
	 * @return
	 */
	public Bitmap getBitmapByPath(String filePath)
	{
		return getBitmapByPath(filePath, null);
	}

	public Bitmap getBitmapByPath(String filePath, BitmapFactory.Options opts)
	{
		FileInputStream fis = null;
		Bitmap bitmap = null;
		try
		{
			File file = new File(filePath);
			fis = new FileInputStream(file);
			bitmap = BitmapFactory.decodeStream(fis, null, opts);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (OutOfMemoryError e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				fis.close();
			} catch (Exception e)
			{
			}
		}
		return bitmap;
	}

	/**
	 * 放大缩小图片
	 * 
	 * @param bitmap
	 * @param w
	 * @param h
	 * @return
	 */
	public static Bitmap zoomBitmap(Bitmap bitmap, int w, int h)
	{
		Bitmap newbmp = null;
		if (bitmap != null)
		{
			int width = bitmap.getWidth();
			int height = bitmap.getHeight();
			Matrix matrix = new Matrix();
			float scaleWidht = ((float) w / width);
			float scaleHeight = ((float) h / height);
			matrix.postScale(scaleWidht, scaleHeight);
			newbmp = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix,
					true);
		}
		return newbmp;
	}

	/**
	 * Bitmap转换64位二进制编码
	 */
	public String BitmapToString(Bitmap bm)
	{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		bm.compress(Bitmap.CompressFormat.JPEG, 50, baos);
		byte[] appicon = baos.toByteArray();// 转为byte数组
		String encodeToString = Base64.encodeToString(appicon, 0,
				appicon.length, Base64.NO_WRAP);
		return Base64
				.encodeToString(appicon, 0, appicon.length, Base64.NO_WRAP);
	}


	public String BitmapToString(Context context, int imagID)
	{
		InputStream is = context.getResources().openRawResource(imagID);
		byte[] buffer = new byte[1024];
		return null;
	}

	public static Bitmap Bytes2Bimap(byte[] b)
	{
		if (b.length != 0)
		{
			return BitmapFactory.decodeByteArray(b, 0, b.length);
		} else
		{
			return null;
		}
	}
}
