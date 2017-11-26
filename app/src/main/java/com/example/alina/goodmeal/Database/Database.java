package com.example.alina.goodmeal.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.alina.goodmeal.Model.Favorites;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Динара on 20.11.2017.
 */

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME="EatDB.db";
    private static final int DB_VER=1;
    public Database(Context context) {
        super(context,DB_NAME, null, DB_VER );
    }

    public List<Favorites> getFav()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {"ProductId", "ProductName"};
        String sqlTable="Favorites";

        qb.setTables(sqlTable);
        Cursor c = qb.query(db,sqlSelect,null, null, null, null, null);

        final List<Favorites> result = new ArrayList<>();
        if(c.moveToFirst())
        {
            do {
                result.add(new Favorites(c.getString(c.getColumnIndex("ProductId")),
                        c.getString(c.getColumnIndex("ProductName"))
                        //c.getString(c.getColumnIndex("PrepTime"))
                        ));
            }while (c.moveToNext());
        }
        return result;
    }

    public void addToFav(Favorites favorites)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("INSERT INTO Favorites(ProductId,ProductName) VALUES('%s','%s');",
                favorites.getProductId(),
                favorites.getProductName());
                //favorites.getPrepTime());
        db.execSQL(query);
    }

    public void cleanFav()
    {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM Favorites");
        db.execSQL(query);
    }
}
