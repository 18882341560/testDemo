package com.gelin.mangodb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.bson.types.ObjectId;


import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * Created by 葛林 on 2018/1/11.
 */
public class MangodbTest {


    private static final String HOST = "127.0.0.1:27017";

    private static final String dbName = "test";

    private static Mongo mongo;

    private static DB db;

    static {
        try {
            mongo = new Mongo(HOST);
            db = mongo.getDB(dbName);
            // db.authenticate(username, passwd)
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }

    private MangodbTest() {
    }

    /**
     * 添加操作
     *
     * @param map
     * @param collectionName
     */
    public static void add(Map<String, Object> map, String collectionName) {
        DBObject dbObject = new BasicDBObject(map);
        getCollection(collectionName).insert(dbObject);
    }

    /**
     * 添加操作
     *
     * @param list
     * @param collectionName
     */
    public static void add(List<Map<String, Object>> list, String collectionName) {
        for (Map<String, Object> map : list) {
            add(map, collectionName);
        }
    }

    /**
     * 删除操作
     *
     * @param map
     * @param collectionName
     */
    public static void delete(Map<String, Object> map, String collectionName) {
        DBObject dbObject = new BasicDBObject(map);
        getCollection(collectionName).remove(dbObject);
    }

    /**
     * 删除操作,根据主键
     *
     * @param id
     * @param collectionName
     */
    public static void delete(String id, String collectionName) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("_id", new ObjectId(id));
        delete(map, collectionName);
    }

    /**
     * 删除全部
     *
     * @param collectionName
     */
    public static void deleteAll(String collectionName) {
        getCollection(collectionName).drop();
    }

    /**
     * 修改操作
     * 会用一个新文档替换现有文档,文档key结构会发生改变
     * 比如原文档{"_id":"123","name":"zhangsan","age":12}当根据_id修改age
     * value为{"age":12}新建的文档name值会没有,结构发生了改变
     *
     * @param whereMap
     * @param valueMap
     * @param collectionName
     */
    public static void update(Map<String, Object> whereMap, Map<String, Object> valueMap, String collectionName) {
        executeUpdate(collectionName, whereMap, valueMap, new UpdateCallback() {
            public DBObject doCallback(DBObject valueDBObject) {
                return valueDBObject;
            }
        });
    }

    /**
     * 修改操作,使用$set修改器
     * 用来指定一个键值,如果键不存在,则自动创建,会更新原来文档, 不会生成新的, 结构不会发生改变
     *
     * @param whereMap
     * @param valueMap
     * @param collectionName
     */
    public static void updateSet(Map<String, Object> whereMap, Map<String, Object> valueMap, String collectionName) {
        executeUpdate(collectionName, whereMap, valueMap, new UpdateCallback() {
            public DBObject doCallback(DBObject valueDBObject) {
                return new BasicDBObject("$set", valueDBObject);
            }
        });
    }

    /**
     * 修改操作,使用$inc修改器
     * 修改器键的值必须为数字
     * 如果键存在增加或减少键的值, 如果不存在创建键
     *
     * @param whereMap
     * @param valueMap
     * @param collectionName
     */
    public static void updateInc(Map<String, Object> whereMap, Map<String, Integer> valueMap, String collectionName) {
        executeUpdate(collectionName, whereMap, valueMap, new UpdateCallback() {
            public DBObject doCallback(DBObject valueDBObject) {
                return new BasicDBObject("$inc", valueDBObject);
            }
        });
    }

    /**
     * 修改
     *
     * @param collectionName
     * @param whereMap
     * @param valueMap
     * @param updateCallback
     */
    private static void executeUpdate(String collectionName, Map whereMap, Map valueMap, UpdateCallback updateCallback) {
        DBObject whereDBObject = new BasicDBObject(whereMap);
        DBObject valueDBObject = new BasicDBObject(valueMap);
        valueDBObject = updateCallback.doCallback(valueDBObject);
        getCollection(collectionName).update(whereDBObject, valueDBObject);
    }

    interface UpdateCallback {

        DBObject doCallback(DBObject valueDBObject);
    }

    /**
     * 获取集合(表)
     *
     * @param collectionName
     * @return
     */
    public static DBCollection getCollection(String collectionName) {
        return db.getCollection(collectionName);
    }


    public static void main(String[] args) {
//        DBCollection collection = getCollection("gl");
//        BasicDBObject queryObject = new BasicDBObject("urlMd5","bfa89e563d9509fbc5c6503dd50faf2e");
//
//        DBObject obj = collection.findOne(queryObject);
//        System.out.println(obj);

        Map map = new HashMap();
        map.put("1", "的大锅饭");


        Map map1 = new HashMap();
        map1.put("1", "发过的");

        updateSet(map, map1, "gl");
    }

}
