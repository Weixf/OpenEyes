package zjhl.wxf.openeyes.api;

import com.google.gson.JsonObject;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Weixf
 * Date on 2017/2/21.
 * Describe 使用Retrofit进行网络请求
 */

public interface ApiServer {
    //得到精选部分的数据
    @GET("api/v4/tabs/selected")
    Observable<JsonObject> getChoicenessData(@Query("date") long date, @Query("num") int num, @Query("page") int page);

}
