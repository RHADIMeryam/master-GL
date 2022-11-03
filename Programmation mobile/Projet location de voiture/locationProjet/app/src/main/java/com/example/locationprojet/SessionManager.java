package com.example.locationprojet;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
     SharedPreferences userSession;
     SharedPreferences.Editor editor;
    //Quel activité appele cette classe
     Context context;
     ListAnnonceUtilisateur listAnnonceUtilisateur;
    private static final String IS_LOGIN= "IsLoggedIn";
    public static final String KEY_USERNAME="username";
    public static final String KEY_EMAIL="email";
    public static final String KEY_PASSWORD="password";
    public static final String KEY_PHONE="numero";
    public static final String KEY_TYPEPROFILE="typeProfile";

    public SessionManager(Context contexte) {
        this.context=contexte;
       //definir contexte d ou on vas utiliser
        userSession= context.getSharedPreferences("userLoginSession",Context.MODE_PRIVATE);
        editor= userSession.edit();
    }

    public void createLoginSession(String username,String email,String telephone,String password,String typeProfile){

        editor.putBoolean(IS_LOGIN,true);
        editor.putString(KEY_USERNAME,username);
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_PHONE,telephone);
        editor.putString(KEY_PASSWORD,password);
        editor.putString(KEY_TYPEPROFILE,typeProfile);
        editor.commit();
    }

    public HashMap<String,String> getUserDetailFromSession(){
        HashMap<String,String> userData= new HashMap<String,String>();
        userData.put(KEY_USERNAME,userSession.getString(KEY_USERNAME,null));
        userData.put(KEY_EMAIL,userSession.getString(KEY_EMAIL,null));
        userData.put(KEY_PHONE,userSession.getString(KEY_PHONE,null));
        userData.put(KEY_PASSWORD,userSession.getString(KEY_PASSWORD,null));
        userData.put(KEY_TYPEPROFILE,userSession.getString(KEY_TYPEPROFILE,null));
        return userData;
    }

    public boolean checkLogin() {
        if (userSession.getBoolean(IS_LOGIN, true)) {
            return true;
        } else {
            return false;
        }
    }
     public void logoutUserFromSession(){
            editor.clear();
            editor.commit();
        }

    }

