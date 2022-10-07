package com.example.sendmessage.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.sendmessage.R;
import com.example.sendmessage.data.Message;

/**
 * Clase que muestra un mensaje de un usuario. Recoge un mensaje que implementa la interfaz
 * Parcelable.
 */
public class ViewMessageActivity extends AppCompatActivity {
    private TextView tvUserView;
    private TextView tvMessageView;
    private static final String TAG = "ViewMEssageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_message);

        tvUserView = findViewById(R.id.tvUserView);
        tvMessageView = findViewById(R.id.tvMessageView);

        //1. Recoger el bundle que me han enviado en el Intent que ha iniciado
        // esta actividad
        Bundle bundle = getIntent().getExtras();
        Message message = bundle.getParcelable("message");
        tvUserView.setText(message.getUser());
        tvMessageView.setText(message.getContent());

        //tvUserView.setText(bundle.getString("user"));
        //tvMessageView.setText(bundle.getString("message"));
    }

    //region CILCO DE VIDA
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessageActivity -> onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessageActivity -> onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessageActivity -> onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        tvUserView = null;
        tvMessageView = null;
        Log.d(TAG, "SendMessageActivity -> onCreate()");
    }
    //endregion

}