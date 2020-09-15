package Tool_juc.copyOnWrite;

import java.util.Map;

// 黑名单服务
public class BlackListServiceImpl {
    private static CopyOnWriteMap<String, Boolean> blackListMap =
            new CopyOnWriteMap<String, Boolean>();

    public static boolean isBlackList(String id){
        return blackListMap.get(id) != null;
    }

    public static void addBlackList(String id){
        blackListMap.put(id, Boolean.TRUE);
    }

    /**
     * 批量添加黑名单
     */

    public static void addBlackList(Map<String, Boolean> ids){
        blackListMap.putAll(ids);
    }
}
