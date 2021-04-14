   package com.pedrolgsoares.conversordemoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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
    }
}