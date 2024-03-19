package com.avsaroglu.hesapmakinesi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView anlik_txt,sonuc_txt;
    Button sil,yuzde,bol;
    Button btn7,btn8,btn9,carpmabtn;
    Button btn4,btn5,btn6,cikarmabtn;
    Button btn1,btn2,btn3,toplabtn;
    Button ac,btn0,virgul,esittir;
    private StringBuilder input = new StringBuilder();
    private StringBuilder historyStr = new StringBuilder();

    String operator;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anlik_txt = findViewById(R.id.anlik_txt);
        sonuc_txt = findViewById(R.id.sonuc_txt);
        sil = findViewById(R.id.sil_btn);
        yuzde = findViewById(R.id.yuzde_btn);
        bol = findViewById(R.id.bolme_btn);
        btn7 = findViewById(R.id.yedi_btn);
        btn8 = findViewById(R.id.sekiz_btn);
        btn9 = findViewById(R.id.dokuz_btn);
        btn4 = findViewById(R.id.dort_btn);
        btn5 = findViewById(R.id.bes_btn);
        btn6 = findViewById(R.id.alti_btn);
        carpmabtn = findViewById(R.id.carpma_btn);
        cikarmabtn = findViewById(R.id.cikarma_btn);
        btn1 = findViewById(R.id.bir_btn);
        btn2 = findViewById(R.id.iki_btn);
        btn3 = findViewById(R.id.uc_btn);
        toplabtn = findViewById(R.id.topla_btn);
        ac = findViewById(R.id.tumSil_btn);
        btn0 = findViewById(R.id.sifir_btn);
        virgul = findViewById(R.id.virgul_btn);
        esittir = findViewById(R.id.esittir_btn);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("0");
                updateDisplay();

            }

        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("1");
                updateDisplay();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("2");
                updateDisplay();

            }

        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("3");
                updateDisplay();

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("4");
                updateDisplay();

            }

        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("5");
                updateDisplay();


            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("6");
                updateDisplay();

            }

        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("7");
                updateDisplay();

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("8");
                updateDisplay();

            }

        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("9");
                updateDisplay();

            }
        });

        yuzde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("%");
                updateDisplay();
            }
        });

        toplabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("+");
                updateDisplay();
            }
        });
        carpmabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("x");
                updateDisplay();

            }
        });
        cikarmabtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("-");
                updateDisplay();

            }
        });
        bol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append("/");
                updateDisplay();

            }
        });
        virgul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.append(",");
                updateDisplay();

            }
        });
        esittir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String expressionStr = input.toString();


                String displayStr = expressionStr.replace("*", "x");


                expressionStr = expressionStr.replace("x", "*");

                //historyStr.append(expressionStr).append(" = ").append(result).append("\n");
                // anlik_txt.setText(historyStr.toString());
                Expression expression = new Expression(expressionStr);
                double result = expression.calculate();
                //sonuc_txt.setText(String.valueOf(result));
                sonuc_txt.setText(displayStr);
                historyStr.append(displayStr).append("\n");

                // Add the result to history on a new line
                historyStr.append("= ").append(result).append("\n");
                historyStr.append("\n");
                anlik_txt.setText(historyStr.toString());

                input.setLength(0);
                historyStr.setLength(0);
                //updateDisplay();

                // Clear the input StringBuilder for the next calculation
                input.setLength(0);
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button  = (Button) v;
                String buttonText = button.getText().toString();
                input.setLength(0);
                historyStr.setLength(0);
                anlik_txt.setText("");
                updateDisplay();
            }
        });
    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Button button  = (Button) v;
        String buttonText = button.getText().toString();
        anlik_txt.setText(buttonText);

    }
    private void updateDisplay() {
        sonuc_txt.setText(input.toString());
    }
}
