package com.example.facture;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText montant ;
        TextView total;
        Button calculer;
        RadioButton radioButtonQuebec,radioButtonOntario;
        ImageView imageView;

        montant = findViewById(R.id.montant);
        total = ( TextView) findViewById(R.id.total);
        calculer = findViewById(R.id.calculer);
        radioButtonQuebec = findViewById(R.id.radioButtonQuebec);
        radioButtonOntario = findViewById(R.id.radioButtonOntario);
        imageView = findViewById(R.id.imageView);

        DecimalFormat df = new DecimalFormat("0.00");

        calculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (montant.getText().toString().length() > 0){
                    double montantDonne;
                    montantDonne = Double.parseDouble(montant.getText().toString());
                    if (montantDonne > 0) {
                        if (radioButtonQuebec.isChecked()) {
                            double tps = montantDonne * 5 / 100;
                            double tvq = montantDonne * 9.975 / 100;
                            double totalTax = montantDonne + tps + tvq;
                            imageView.setImageResource(R.drawable.quebec);

                            total.setText("TPS: $" + Double.toString(tps) + "\nTVQ: $" + Double.toString(tvq) + "\n\nTOTAL: $" + Double.toString(totalTax));

                        } else if (radioButtonOntario.isChecked()) {
                            double hst = montantDonne * 13 / 100;
                            double totalTax = montantDonne + hst;
                            imageView.setImageResource(R.drawable.ontario);

                            total.setText("HST: $" + Double.toString(hst) + "\n\nTOTAL: $" + Double.toString(totalTax));
                        } else {
                            Toast.makeText(MainActivity.this, "Please select a province", Toast.LENGTH_LONG).show();
                        }
                    }

                    }else{
                        Toast.makeText(MainActivity.this, "Please enter a valid amount", Toast.LENGTH_LONG).show();
                    }

//                    number = df.parse(montant.getText().toString());
                    // pt total total.setText(montant.toString())
                }


        });

    }
}