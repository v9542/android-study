package com.somo.test;

/**
 * Created by yebonkim on 2016. 11. 24..
 */

public interface DBLiteral {
    String DATABASE_NAME = "test";
    int DATABASE_VERSION = 1;

    String PRODUCT_TABLE = "product";
    String MART_TABLE = "mart";
    String USER_TABLE = "user";

    String id_column = "id";
    String name_column = "name";
    String price_column = "price";
    String group_id_column = "group_id";

    String address_column = "address";
    String lat_column = "lat";
    String long_column = "long";

    String user_id_column = "user_id";

    String WHERE_ID_EQUALS = id_column + "=?";

    String CREATE_USER_TABLE = "CREATE TABLE IF NOT EXISTS "+
            USER_TABLE + "("+id_column+" INTEGER PRIMARY KEY,"+
            user_id_column + " TEXT"+
            ");";

    String CREATE_MART_TABLE = "CREATE TABLE IF NOT EXISTS "+
            MART_TABLE + "(" + id_column + " INTEGER PRIMARY KEY,"+
            name_column + " TEXT, "+
            address_column + " TEXT, "+
            lat_column + " DOUBLE, " +
            long_column + " DOUBLE"+
            ");";

    String CREATE_PRODUCT_TABLE = "CREATE TABLE IF NOT EXISTS " +
            PRODUCT_TABLE + "(" + id_column + " INTEGER PRIMARY KEY," +
            name_column + " TEXT," +
            price_column + " INTEGER, "+
            group_id_column + " INTEGER, "+
            "FOREIGN KEY ("+ group_id_column + ") REFERENCES " +
            MART_TABLE + "("+id_column+") ON DELETE CASCADE ON UPDATE CASCADE"+
            ");";

}
