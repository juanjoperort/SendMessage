package com.example.sendmessage.data;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * Clase modelo que contiene el dato del usuario y el mensaje que manda
 * @author Juan Jose Perálvarez
 * @version 1.0
 */
public class Message implements Serializable, Parcelable {
    private String user;
    private String content;

    // Por defecto si no se declara un constructor, java implementa el constructor vacío implicitamente

    /**
     * Constructor con parámetros
     * @param user usuario
     * @param content mensaje
     */
    public Message(String user, String content) {
        this.user = user;
        this.content = content;
    }



    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * En este método se devuelve la representación de un objeto Message
     * @return
     */
    @NonNull
    @Override
    public String toString() {
        return getUser() + "--> " + getContent();
    }

    //region MÉTODOS CREADOS DE LA INTERFAZ PARCELABLE
    protected Message(Parcel in) {
        user = in.readString();
        content = in.readString();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user);
        dest.writeString(content);
    }

    @Override
    public int describeContents() {
        return 0;
    }
    //endregion
}
