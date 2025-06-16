package com.example.android56_day7.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.example.android56_day7.interfaces.db_product_listener.InsertProductListener;
import com.example.android56_day7.models.Product;

import java.util.ArrayList;

public class CartDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "products.sql";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "products";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_DES = "description";
    private static final String COLUMN_PRICE = "price";
    private static final String COLUMN_THUMB = "thumbnail";


    public CartDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                COLUMN_TITLE + " TEXT NOT NULL," +
                COLUMN_DES + " TEXT," +
                COLUMN_PRICE + " INTEGER NOT NULL," +
                COLUMN_THUMB + " TEXT)";

        db.execSQL(sql);
    }

    public void insertProduct(Product product, InsertProductListener callback) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_TITLE, product.getTitle());
        contentValues.put(COLUMN_PRICE, product.getPrice());
        contentValues.put(COLUMN_DES, product.getDescription());
        contentValues.put(COLUMN_THUMB, product.getThumbnail());

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            callback.onInsertFail("Insert fail");
        } else {
            callback.onInsertSuccess();
        }
        db.close();
    }


    public void updateProductTitle(int id, String title) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(COLUMN_TITLE, title);
            db.update(TABLE_NAME, contentValues, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    public void removeProduct(int id) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            db.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[]{String.valueOf(id)});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            db.close();
        }
    }

    public ArrayList<Product> getAllProductFromLocal() {
        ArrayList<Product> result = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                int idIndex = cursor.getColumnIndex(COLUMN_ID);
                int id = cursor.getInt(idIndex);
                int titleIndex = cursor.getColumnIndex(COLUMN_TITLE);
                String title = cursor.getString(titleIndex);
                int priceIndex = cursor.getColumnIndex(COLUMN_PRICE);
                int price = cursor.getInt(priceIndex);
                int desIndex = cursor.getColumnIndex(COLUMN_DES);
                String des = cursor.getString(desIndex);
                int thumbIndex = cursor.getColumnIndex(COLUMN_THUMB);
                String thumb = cursor.getString(thumbIndex);

                Product product = new Product();
                product.setId(id);
                product.setTitle(title);
                product.setPrice(price + 0.0);
                product.setDescription(des);
                product.setThumbnail(thumb);

                result.add(product);
            } while (cursor.moveToNext());
        }


        db.close();

        return result;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // todo DROP ALTERS TABLE IF EXISTS
    }
}
