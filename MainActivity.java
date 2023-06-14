package com.example.sinemtokgoz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText isim;
    TextView soru1, soru2;
    Spinner spinnercevap1, spinnercevap2;
    Button digerekran;
    RadioGroup cinsiyet;
    RadioButton kadin, erkek;
    String cevapbir = "";
    String cevapiki = "";

    public void init() {
        isim = findViewById(R.id.isim);
        soru1 = findViewById(R.id.soru1);
        soru2 = findViewById(R.id.soru2);
        spinnercevap1 = findViewById(R.id.spinnercevap1);
        spinnercevap2 = findViewById(R.id.spinnercevap2);
        digerekran = findViewById(R.id.digerekran);
        cinsiyet = findViewById(R.id.cinsiyet);
        kadin = findViewById(R.id.kadin);
        erkek = findViewById(R.id.erkek);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        digerekran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder sonuc = new StringBuilder();
                sonuc.append(isim.getText());
                if (kadin.isChecked())
                    sonuc.append("\nCinsiyetiniz kadın");
                if (erkek.isChecked())
                    sonuc.append("\nCinsiyetiniz Erkek");

                String secilenislem = spinnercevap1.getSelectedItem().toString();
                switch (secilenislem) {
                    case "Çok kötü":
                        sonuc.append("Çok Kötü");
                        break;
                    case "Kötü":
                        sonuc.append("Kötü");
                        break;
                    case "Orta":
                        sonuc.append("Orta");
                        break;
                    case "İyi":
                        sonuc.append("İyi");
                        break;
                    case "Çok iyi":
                        sonuc.append("Çok iyi");
                        break;
                }

                String secilenislem2 = spinnercevap2.getSelectedItem().toString();
                switch (secilenislem2) {
                    case "Çok kötü":
                        sonuc.append("Çok Kötü");
                        break;
                    case "Kötü":
                        sonuc.append("Kötü");
                        break;
                    case "Orta":
                        sonuc.append("Orta");
                        break;
                    case "İyi":
                        sonuc.append("İyi");
                        break;
                    case "Çok iyi":
                        sonuc.append("Çok iyi");
                        break;
                }

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("bilgi", (CharSequence) sonuc);
                intent.putExtra("deger", secilenislem);
                intent.putExtra("deger2", secilenislem2);
                startActivity(intent);
            }
        });


    }
}