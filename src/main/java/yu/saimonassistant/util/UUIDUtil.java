package yu.saimonassistant.util;


import java.util.UUID;

public class UUIDUtil {
    private UUIDUtil(){}
    /**
     * 获取一个UUID
     */
    public static String getOneUUID() {
        //Get single UUID and replace "-" with ""
        return UUID.randomUUID().
                toString().replaceAll("-", "");
    }

    /**
     * 获得指定数目的UUID
     *
     * @param count int 需要获得的UUID数量
     * @return String[] UUID数组
     */
    public static String[] getUUID(int count) {
        if (count < 1)
            return null;

        var uuids = new String[count];

        for (int i = 0; i < count; i++)
            uuids[i] = getOneUUID();

        return uuids;
    }
}