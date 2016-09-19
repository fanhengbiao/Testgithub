package serviceUtil;

import java.lang.reflect.Field;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by fanhengbiao on 16-8-23.
 */

public class ServiceFactory {


    private static class SingletonHolder {
        private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();
    }

    /**
     * 获得对象
     *
     * @return
     */
    public static ServiceFactory getlintence() {
        return SingletonHolder.SERVICE_FACTORY;
    }

    /**
     * retrofit
     *
     * @param sClass
     * @param
     * @param <S>
     * @return
     */
    public <S> S CreatClass(Class<S> sClass) {
        String baseUrl = "";
        try {
            Field field1 = sClass.getField("BASE_URL");
            baseUrl = (String) field1.get(sClass);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.getMessage();
            e.printStackTrace();
        }

        Retrofit Retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return Retrofit.create(sClass);
    }

}
