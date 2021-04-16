package com.pedrolgsoares.conversordemoedas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

// Implementando a interface do OnClickListener
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //    Instanciando a classe ViewHolder fora do onCreate
    private Viewholder mviewHolder = new Viewholder();

    @Override
//    O onCreate:  É a primeira função a ser executada em uma Activity.
//    Geralmente é a responsável por carregar os layouts XML e outras operações de inicialização.
//    É executada apenas uma vez
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//   Esse método é responsável por configurar o layout XML.
//   Esse método normalmente é chamado no método onCreate para a criação da interface.
//   Sendo a classe R, responsável pelos recursos Ou seja toda vez que o android executar o onCreate
//   vai setar o layout no activity_main
        setContentView(R.layout.activity_main);

//        Agora instanciar os atributos abaixo do setContentView
        this.mviewHolder.valorBR = findViewById(R.id.valorBR);
        this.mviewHolder.valorUSD = findViewById(R.id.valorUSD);
        this.mviewHolder.converter = findViewById(R.id.converter);
        this.mviewHolder.sairApp = findViewById(R.id.sairApp);
        this.mviewHolder.darkMode = findViewById(R.id.darkMode);

//        Instanciando os atributos dos botões com suas funções
        this.mviewHolder.converter.setOnClickListener(this);
        this.mviewHolder.sairApp.setOnClickListener(this);

//      Referencia: https://medium.com/androiddevelopers/appcompat-v23-2-daynight-d10f90c83e94
        this.mviewHolder.darkMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    Log.d("Switch", "selecionado");

                }else{
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    Log.d("Switch", "não selecionado");
                }

            }
        });
        this.limpar();
    }

    @Override
    public void onClick(View v) {
        //            Para sair do app
        if (v.getId() == R.id.converter) {
            String valor = this.mviewHolder.valorBR.getText().toString();
            if ("".equals(valor)) {
                Toast.makeText(this, "Informe o valor para a conversão", Toast.LENGTH_LONG).show();
            } else {
//                Implementar API para cotação automática
                Double valorReal = Double.valueOf(valor);
                this.mviewHolder.valorUSD.setText(String.format("%.2f", valorReal * 5.62));
            }
        } else {
//            Sair da aplicação
        }
    }
//   Limpa os valores quando o app inicia
    public void limpar() {
        this.mviewHolder.valorBR.setText("");
        this.mviewHolder.valorUSD.setText("");
    }


    //    Criando a classe padrão ViewHolder
    private static class Viewholder {
        EditText valorBR;
        TextView valorUSD;
        Button converter;
        Button sairApp;
        Switch darkMode;
    }

}