package com.example.practica7_controles2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RadioButton rbtnLong,rbtnMasa,rbtnTemp,rbtnOp1,rbtnOp2,rbtnOp3,rbtnOpC1,rbtnOpC2,rbtnOpC3;
    Button btnCalc;
    EditText input;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.convertidor_crt);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnCalc = findViewById(R.id.btnConv);
        input = findViewById(R.id.input);
        resultado = findViewById(R.id.resultado);

        RadioGroup tipoGroup = findViewById(R.id.tipoGroup);
        rbtnLong = findViewById(R.id.rbtnOpc1);
        rbtnMasa = findViewById(R.id.rbtnOpc2);
        rbtnTemp = findViewById(R.id.rbtnOpc3);
        tipoGroup.clearCheck();
        tipoGroup.check(R.id.rbtnOpc1);
        RadioGroup firstGroup = findViewById(R.id.firstGroup);
        rbtnOp1 = findViewById(R.id.rbtnFOpc1);
        rbtnOp2 = findViewById(R.id.rbtnFOpc2);
        rbtnOp3 = findViewById(R.id.rbtnFOpc3);
        firstGroup.clearCheck();
        firstGroup.check(R.id.rbtnFOpc1);
        RadioGroup secondGroup = findViewById(R.id.secondGroup);
        rbtnOpC1 = findViewById(R.id.rbtnSOpc1);
        rbtnOpC2 = findViewById(R.id.rbtnSOpc2);
        rbtnOpC3 = findViewById(R.id.rbtnSOpc3);
        secondGroup.clearCheck();
        secondGroup.check(R.id.rbtnSOpc1);

        btnCalc.setOnClickListener(evento);

        rbtnLong.setOnClickListener(evento);
        rbtnMasa.setOnClickListener(evento);
        rbtnTemp.setOnClickListener(evento);
        rbtnOp1.setOnClickListener(evento);
        rbtnOp2.setOnClickListener(evento);
        rbtnOp3.setOnClickListener(evento);
        rbtnOpC1.setOnClickListener(evento);
        rbtnOpC2.setOnClickListener(evento);
        rbtnOpC3.setOnClickListener(evento);
    }

    private View.OnClickListener evento = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v instanceof RadioButton){
                String opc1 = (String) rbtnOp1.getText(), opc2 = (String) rbtnOp2.getText(), opc3 = (String) rbtnOp3.getText();
                if(v == rbtnLong){ //Longitud
                    opc1 = getString(R.string.opcionF1);
                    opc2 = getString(R.string.opcionF2);
                    opc3 = getString(R.string.opcionF3);
                } else if (v == rbtnMasa) {  //Masa
                    opc1 = getString(R.string.masaOp1);
                    opc2 = getString(R.string.masaOp2);
                    opc3 = getString(R.string.masaOp3);

                }else if (v == rbtnTemp){  //Temperatura
                    opc1 = getString(R.string.TempOp1);
                    opc2 = getString(R.string.TempOp2);
                    opc3 = getString(R.string.TempOp3);
                }
                rbtnOp1.setText(opc1);
                rbtnOp2.setText(opc2);
                rbtnOp3.setText(opc3);

                rbtnOpC1.setText(opc1);
                rbtnOpC2.setText(opc2);
                rbtnOpC3.setText(opc3);
            }
            if(v instanceof Button){
                if(v == btnCalc){
                    double inputValue;
                    if(input.getText().toString().isEmpty()){
                        Toast.makeText(getApplicationContext(), "El campo está vacío", Toast.LENGTH_SHORT).show();
                    }else{
                        inputValue = Double.parseDouble(input.getText().toString());
                        if(rbtnLong.isChecked()){  //Calculo Longitud
                            if(rbtnOp1.isChecked()){
                                if(rbtnOpC1.isChecked()){
                                    resultado.setText(String.valueOf(inputValue));
                                }
                                if(rbtnOpC2.isChecked()){
                                    resultado.setText(String.valueOf(inputValue*100).substring(0, 10));
                                }
                                if(rbtnOpC3.isChecked()){
                                    resultado.setText(String.valueOf(inputValue*1000).substring(0, 10));
                                }
                            }
                            if(rbtnOp2.isChecked()){
                                if(rbtnOpC1.isChecked()){
                                    resultado.setText(String.valueOf(inputValue/100).substring(0, 10));
                                }
                                if(rbtnOpC2.isChecked()){
                                    resultado.setText(String.valueOf(inputValue));
                                }
                                if(rbtnOpC3.isChecked()){
                                    resultado.setText(String.valueOf(inputValue*10).substring(0, 10));
                                }
                            }
                            if(rbtnOp3.isChecked()){
                                if(rbtnOpC1.isChecked()){
                                    resultado.setText(String.valueOf(inputValue/1000).substring(0, 10));
                                }
                                if(rbtnOpC2.isChecked()){
                                    resultado.setText(String.valueOf(inputValue/10).substring(0, 10));
                                }
                                if(rbtnOpC3.isChecked()){
                                    resultado.setText(String.valueOf(inputValue));
                                }
                            }
                        } else if (rbtnMasa.isChecked()) {  //Calculo Masa
                            inputValue = Double.parseDouble(input.getText().toString());
                            if(rbtnOp1.isChecked()){
                                if(rbtnOpC1.isChecked()){
                                    resultado.setText(String.valueOf(inputValue));
                                }
                                if(rbtnOpC2.isChecked()){
                                    resultado.setText(String.valueOf(inputValue*0.45359).substring(0, 10));
                                }
                                if(rbtnOpC3.isChecked()){
                                    resultado.setText(String.valueOf(inputValue*453.59237).substring(0, 10));
                                }
                            }
                            if(rbtnOp2.isChecked()){
                                if(rbtnOpC1.isChecked()){
                                    resultado.setText(String.valueOf(inputValue/0.45359).substring(0, 10));
                                }
                                if(rbtnOpC2.isChecked()){
                                    resultado.setText(String.valueOf(inputValue));
                                }
                                if(rbtnOpC3.isChecked()){
                                    resultado.setText(String.valueOf(inputValue*1000));
                                }
                            }
                            if(rbtnOp3.isChecked()){
                                if(rbtnOpC1.isChecked()){
                                    resultado.setText(String.valueOf(inputValue*0.002204).substring(0, 10));
                                }
                                if(rbtnOpC2.isChecked()){
                                    resultado.setText(String.valueOf(inputValue/1000));
                                }
                                if(rbtnOpC3.isChecked()){
                                    resultado.setText(String.valueOf(inputValue));
                                }
                            }
                        } else if (rbtnTemp.isChecked()){  //Calculo Temperatura
                            inputValue = Double.parseDouble(input.getText().toString());
                            if(rbtnOp1.isChecked()){
                                if(rbtnOpC1.isChecked()){
                                    resultado.setText(String.valueOf(inputValue));
                                }
                                if(rbtnOpC2.isChecked()){
                                    resultado.setText(String.valueOf(inputValue+273.15));
                                }
                                if(rbtnOpC3.isChecked()){
                                    resultado.setText(String.valueOf((inputValue*1.8)+32));
                                }
                            }
                            if(rbtnOp2.isChecked()){
                                if(rbtnOpC1.isChecked()){
                                    resultado.setText(String.valueOf(inputValue-273.15));
                                }
                                if(rbtnOpC2.isChecked()){
                                    resultado.setText(String.valueOf(inputValue));
                                }
                                if(rbtnOpC3.isChecked()){
                                    resultado.setText(String.valueOf((inputValue*1.8)-459.67));
                                }
                            }
                            if(rbtnOp3.isChecked()){
                                if(rbtnOpC1.isChecked()){
                                    resultado.setText(String.valueOf((inputValue-32)/(1.8)));
                                }
                                if(rbtnOpC2.isChecked()){
                                    resultado.setText(String.valueOf(((inputValue-32)/1.8)+273.15));
                                }
                                if(rbtnOpC3.isChecked()){
                                    resultado.setText(String.valueOf(inputValue));
                                }
                            }
                        }
                    }
                }
            }
        }
    };

}