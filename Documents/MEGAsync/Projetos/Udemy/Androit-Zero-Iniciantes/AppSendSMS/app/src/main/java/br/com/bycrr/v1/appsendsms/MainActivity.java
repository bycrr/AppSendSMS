package br.com.bycrr.v1.appsendsms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

  // criar um objeto p/o SMS - SDK Android
  SmsManager objSmsManager;
  Button btnEnviar;
  EditText editSMSPara, editSMSMensagem;

  // variáveis
  String smsPara, smsMensagem;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //objSmsManager.
    editSMSPara = findViewById(R.id.editSMSPara);
    editSMSMensagem = findViewById(R.id.editSMSMensagem);
    btnEnviar = findViewById(R.id.btnEnviar);

    btnEnviar.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        smsPara = editSMSPara.getText().toString();
        smsMensagem = editSMSMensagem.getText().toString();

        try {
          objSmsManager = SmsManager.getDefault();
          objSmsManager.sendTextMessage(smsPara, null, smsMensagem, null, null);
          Toast.makeText(getApplicationContext(), "SMS Enviado...", Toast.LENGTH_LONG).show();

        } catch (Exception e) {
          Toast.makeText(getApplicationContext(), "FALHA! SMS não enviado...", Toast.LENGTH_LONG).show();
        }
      }
    });
  }
}
