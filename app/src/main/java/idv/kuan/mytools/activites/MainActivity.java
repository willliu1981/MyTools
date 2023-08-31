package idv.kuan.mytools.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import idv.kuan.mytools.R;

public class MainActivity extends AppCompatActivity {

    private Button calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


    }


    private void init() {
        initComponents();
    }


    private void initComponents() {
        calculator = findViewById(R.id.main_btn_calculator);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalculatorActivity.class);
                startActivity(intent);

            }
        });
    }
}