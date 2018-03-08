package com.basspro.bassprocommerce.localstorage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by jgreve on 2/28/18.
 */

public class AppData {
    static SharedPreferences sharedPreferences;
    static SharedPreferences.Editor editor;

    public static final String KEY_GUEST = "guest";
    public static final String KEY_RESTERING ="resitering";
    public static final String KEY_RESTERED ="resitered";
    public static final String KEY_USERDETAILS ="userdetails";


    private static final String PREF_NAME = "BassPro";

    public static void createSharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static boolean isGuest() {
        boolean isGuest = sharedPreferences.getBoolean(KEY_GUEST, false);
        return isGuest;
    }


    public static void  setGuest(boolean guest) {
        editor.putBoolean(KEY_GUEST, guest);
        editor.commit();
    }
    public static boolean isRegistering() {
        boolean isGuest = sharedPreferences.getBoolean(KEY_RESTERING, false);
        return isGuest;
    }


    public static void  setRegistering(boolean resitering) {
        editor.putBoolean(KEY_RESTERING, resitering);
        editor.commit();
    }
    public static boolean isRegistered() {
        boolean isGuest = sharedPreferences.getBoolean(KEY_RESTERED, false);
        return isGuest;
    }


    public static void  setRegistered(boolean resitered) {
        editor.putBoolean(KEY_RESTERED, resitered);
        editor.commit();
    }
    public void setResisteringData(RegisterModel registerModel){
        Gson gson = new Gson();
        String json = gson.toJson(registerModel);
        editor.putString(KEY_USERDETAILS, json);
        editor.commit();
    }

    public RegisterModel getresisteringData(){
        Gson gson = new Gson();
        String json = sharedPreferences.getString(KEY_USERDETAILS, "");
        RegisterModel obj = gson.fromJson(json, RegisterModel.class);
        return  obj;
    }
}

   /* private static SharedPreferences sharedPreferences;

    private static final String GUEST_NUMBER = "GUEST";

    private static final String PREF_APP_ID = "BPS_PREFS";
    private static final String KEY_USER_ID = "userID";
    private static final String KEY_EMAIL = "userEmail";
    private static final String KEY_PASSWORD = "userPassword";

    private static final String KEY_SERVICE_STORE = "serviceStoreId";


    private static boolean isNew = false;
    private static boolean isMissingData = false;

    private static String userId;
    private static String userEmail;
    private static String password;
    private static String serviceStoreId;
    ///private static String prefferedStore; //do not share
    // future category preferences


    public static String getUserId() {
        return userId;
    }

    public static void setUserId(String userId) {
        AppData.userId = userId;
        setPreference(KEY_USER_ID, userId);
    }

    public static boolean isGuest() {
        return userId.equalsIgnoreCase(GUEST_NUMBER);
    }

    public static boolean isNew() {
        return isNew;
    }

    public static boolean isIsMissingData() {
        return isMissingData;
    }


    public static String getUserEmail() {
        return userEmail;
    }

    public static void setUserEmail(String userEmail) {
        AppData.userEmail = userEmail;
        setPreference(KEY_EMAIL, userEmail);
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        AppData.password = password;
        setPreference(KEY_PASSWORD, password);
    }

    public static String getServiceStoreId() {
        return serviceStoreId;
    }

    public static void setServiceStoreId(String serviceStoreId) {
        AppData.serviceStoreId = serviceStoreId;
        setPreference(KEY_SERVICE_STORE, serviceStoreId);
    }


    public static void loadOnSplash(Activity activity) {

        // WARNING if this doesn't run first thing in the app you may crash if yo utry to set a preference.

        SharedPreferences sharedPreferences = activity.getSharedPreferences(PREF_APP_ID, Context.MODE_PRIVATE);

        if (sharedPreferences.contains(KEY_USER_ID)) {
            userId = sharedPreferences.getString(KEY_USER_ID, "");

            if (sharedPreferences.contains(KEY_EMAIL)) {
                userEmail = sharedPreferences.getString(KEY_EMAIL, "");
            } else {
                isMissingData = true;
            }
            if (sharedPreferences.contains(KEY_PASSWORD)) {
                password = sharedPreferences.getString(KEY_PASSWORD, "");
            } else {
                isMissingData = true;
            }
        } else {
            // we are new
            isNew = true;
        }
    }

    //  Helpers  -----------------------------------------------------------------------------------------------------------------------------------

    private static void setPreference(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }*/


