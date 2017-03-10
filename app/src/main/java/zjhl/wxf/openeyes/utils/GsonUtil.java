package zjhl.wxf.openeyes.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;

/**
 * Created by Weixf
 * Date on 2017/3/7.
 * Describe 使用gson转化实体的工具类
 */

public class GsonUtil {
    /**
     * 对象转换成json字符串
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    /**
     * json字符串转成对象
     * @return
     */
    public static <T> T fromJson(String str, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }

    public static <T> T fromJson(JsonElement str, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }

    /**
     * json字符串转成对象
     * @return
     */
    public static <T> T fromJson(String str, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }
    public static <T> T fromJson(JsonElement str, Class<T> type) {
        Gson gson = new Gson();
        return gson.fromJson(str, type);
    }
}
