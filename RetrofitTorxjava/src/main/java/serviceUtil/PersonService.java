package serviceUtil;


import retrofit2.http.GET;
import retrofit2.http.Header;
import rx.Observable;

/**
 * Created by fanhengbiao on 16-8-19.
 */

public interface PersonService {
    String BASE_URL = "https://api.bmob.cn/1/classes/Persons/";
    @GET("https://api.bmob.cn/1/classes/Persons/")
        Observable<XxEntity> getPersonal(@Header("Content-Type") String type,
                                     @Header("X-Bmob-Application-Id") String id, @Header("X-Bmob-REST-API-Key") String key
    );
}
