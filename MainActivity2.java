package com.example.sinemtokgoz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    EditText boy, kilo;
    Button hesapla, temizle;
    TextView textView, hesap;
    double vki = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        boy = findViewById(R.id.boy);
        kilo = findViewById(R.id.kilo);
        hesapla = findViewById(R.id.hesapla);
        textView = findViewById(R.id.textView);
        hesap = findViewById(R.id.hesap);
        temizle = findViewById(R.id.temizle);

        Bundle bundle = getIntent().getExtras();
        String gelenAd = bundle.getString("bilgi");
        String gelenislem = bundle.getString("deger");
        String gelenislem2 = bundle.getString("deger2");
        textView.setText("Adınız: " + gelenAd + "\n1.soru: " + gelenislem + "\n2.soru: " + gelenislem2);


        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double boyu = Double.parseDouble(boy.getText().toString());
                int kilosu = Integer.parseInt(kilo.getText().toString());
                vki = kilosu / boyu * boyu;

                if (vki < 18.5)
                    hesap.setText(vki + " Zayıf");
                else if (vki < 24.9)
                    hesap.setText(vki + " Normal");
                else if (vki < 29.9)
                    hesap.setText(vki + " Fazla Kilolu");
                else if (vki < 34.9)
                    hesap.setText(vki + " Obez");
                else if (vki < 39.9)
                    hesap.setText(vki + " Obez");
                else if (vki < 40)
                    hesap.setText(vki + " Süper Obez");
                else
                    hesap.setText("Yanlış değer");

            }
        });

        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boy.setText(null);
                kilo.setText(null);
                hesap.setText(" ");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.renk1:
                hesap.setBackgroundColor(Color.RED);
                break;

            case R.id.renk2:
                hesap.setBackgroundColor(Color.GREEN);
                break;

            case R.id.renk3:
                hesap.setBackgroundColor(Color.BLUE);
                break;

            case R.id.renk4:
                hesap.setBackgroundColor(Color.YELLOW);
                break;

        }
        return true;
    }
}