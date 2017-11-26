package com.example.alina.goodmeal.Model;

import android.app.Activity;

/**
 * Created by Динара on 20.11.2017.
 */

public class Favorites extends Activity {
    private String ProductId;
    private String ProductName;
    //private String PrepTime;

    public Favorites() {
    }

    public Favorites(String productId, String productName ) {
        ProductId = productId;
        ProductName = productName;
        //PrepTime = prepTime;
    }

    public String getProductId() {
        return ProductId;
    }

   /* public void setProductId(String productId) {
        ProductId = productId;
    }
*/
    public String getProductName() {
        return ProductName;
    }

   /* public void setProductName(String productName) {
        ProductName = productName;
    }

   /* public String getPrepTime() {
        return PrepTime;
    }

    public void setPrepTime(String prepTime) {
        PrepTime = prepTime;
    }*/
}
