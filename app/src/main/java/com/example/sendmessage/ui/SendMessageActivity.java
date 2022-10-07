package com.example.sendmessage.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sendmessage.R;
import com.example.sendmessage.data.Message;

public class SendMessageActivity extends AppCompatActivity {
    private static final String TAG = "SendMessageActivity";
    private EditText etUser;
    private EditText etMessage;
    private Button btSend;
    private SendMessageOnClickListener delegate;

    /**
     * <h1>Proyecto SendMessage</h1>
     * En este proyecto aprenderemos a realizar las siguientes operaciones
     * <ol>
     *     <li>Crear un evento en un componente Button en codigo XML</li>
     *     <li>Crear un escuchador/listener del evento <code>OnClick()</code></li>
     *     <li>Crear un Intent y un elemento Bundle para pasar información entre Activitys</li>
     *     <li>Manejar la pila de Actividades</li>
     * </ol>
     * @author Juan José Perálvarez
     * @version 1.0
     * @see android.widget.Button
     * @see android.app.Activity
     * @see android.content.Intent
     * @see android.os.Bundle
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
        etUser = findViewById(R.id.etUser);
        etMessage = findViewById(R.id.etMessage);
        btSend = findViewById(R.id.btnSend);

        //Establecer el Listener OnClickListener al botón mediante una clase anónima que
        // implementa la interfaz View.OnClickListener
        btSend.setOnClickListener(view -> sendMessage());
                //view -> Toast.makeText(SendMessageActivity.this, "Esto es a través de una clase anónima", Toast.LENGTH_SHORT).show();

//        // Se inicializa el delegado
//        delegate = new SendMessageOnClickListener();
//        // Se establece el Listener OnClickListener al botón mediante una clase anónima que
//        // implementa la interfaz View.OnClickListener
//        btSend.setOnClickListener(delegate);

        Log.d(TAG, "SendMessageActivity -> onCreate()");
    }

    //region CICLO DE VIDA DE LA ACTIVITY
    /**
     * Este méttodo se ejcuta cuando se destruye la Activity
     */
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
        etUser = null;
        etMessage = null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");
    }
    //endregion

    /**
     * Este método es el que se llama cuando se pulsa sobre el botón btSend definido en el XML
     * <code>android:onClick="sendMessage"</code>
     * @param view
     */
    public void sendMessage(View view) {
        sendMessage();
    }

    public void sendMessage() {
        //TODO Se modificará este ejercicio para estudiar viewBinding
        //Toast.makeText(this, "Hemos pulsado el botón", Toast.LENGTH_SHORT).show();

        //1. Crear el contenedor para añadir los datos.
        Bundle bundle = new Bundle();

        //1.1 Pasar campo a campo
        //bundle.putString("user", etUser.getText().toString());
        //bundle.putString("message", etMessage.getText().toString());

        //1.2 Crear un objeto Message
        Message message = new Message(etUser.getText().toString(), etMessage.getText().toString());
        bundle.putParcelable("message",message);

        //2. Vamos a crear el objeto Intent explícito porque se conoce la Actividad
        // destino.
        Intent intent = new Intent(this, ViewMessageActivity.class);
        intent.putExtras(bundle);

        //3. Se inicia la transición entre una vista y otra mediante StarActivity
        startActivity(intent);

    }

    /**
     * Esta clase anónima implementa el listener que responde siempre al evento
     * OnClick
     */
    class SendMessageOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Toast.makeText(SendMessageActivity.this, "Esto es a través de un delegado", Toast.LENGTH_SHORT).show();
        }
    }
}