package idv.kuan.mytools.calculator.activites;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import idv.kuan.mytools.R;

public class CalculatorActivity extends AppCompatActivity {

    private TextView txtvResult;
    private Button btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9, btnNum0;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide;
    private Button btnEquals, btnClear;
    private String lastOperation = "";
    private String lastArithmeticOperation = "prime";
    private String result = "";
    private double lastResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);


        init();
        initState();

    }


    private void init() {
        initComponents();
    }

    private void initComponents() {
        txtvResult = findViewById(R.id.calc_txtv_result);

        (btnNum1 = findViewById(R.id.calc_btn_num1)).setOnClickListener(new OnClickWithNumbersListener());
        (btnNum2 = findViewById(R.id.calc_btn_num2)).setOnClickListener(new OnClickWithNumbersListener());
        (btnNum3 = findViewById(R.id.calc_btn_num3)).setOnClickListener(new OnClickWithNumbersListener());
        (btnNum4 = findViewById(R.id.calc_btn_num4)).setOnClickListener(new OnClickWithNumbersListener());
        (btnNum5 = findViewById(R.id.calc_btn_num5)).setOnClickListener(new OnClickWithNumbersListener());
        (btnNum6 = findViewById(R.id.calc_btn_num6)).setOnClickListener(new OnClickWithNumbersListener());
        (btnNum7 = findViewById(R.id.calc_btn_num7)).setOnClickListener(new OnClickWithNumbersListener());
        (btnNum8 = findViewById(R.id.calc_btn_num8)).setOnClickListener(new OnClickWithNumbersListener());
        (btnNum9 = findViewById(R.id.calc_btn_num9)).setOnClickListener(new OnClickWithNumbersListener());
        (btnNum0 = findViewById(R.id.calc_btn_num0)).setOnClickListener(new OnClickWithNumbersListener());

        (btnAdd = findViewById(R.id.calc_btn_add)).setOnClickListener(new OnClickWithArithmeticOperationsListener());
        (btnSubtract = findViewById(R.id.calc_btn_subtract)).setOnClickListener(new OnClickWithArithmeticOperationsListener());
        (btnMultiply = findViewById(R.id.calc_btn_multiply)).setOnClickListener(new OnClickWithArithmeticOperationsListener());
        (btnDivide = findViewById(R.id.calc_btn_divide)).setOnClickListener(new OnClickWithArithmeticOperationsListener());


        (btnEquals = findViewById(R.id.calc_btn_equals)).setOnClickListener(new OnClickWithEqualsOperationListener());
        (btnClear = findViewById(R.id.calc_btn_clear)).setOnClickListener(new OnClickWithClearOperationListener());


    }


    class OnClickWithNumbersListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (lastOperation.equals("equals")) {
                initState();
            }

            result += ((TextView) view).getText().toString();

            lastOperation = "number";

            txtvResult.setText(result);
        }
    }

    class OnClickWithArithmeticOperationsListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            getResult();

            lastOperation = "operation";
            lastArithmeticOperation = ((TextView) view).getText().toString();
            txtvResult.setText(String.valueOf(lastResult));
        }
    }

    class OnClickWithEqualsOperationListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            getResult();

            lastArithmeticOperation = "";
            lastOperation = "equals";
            txtvResult.setText(String.valueOf(lastResult));
        }
    }

    class OnClickWithClearOperationListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            initState();
        }
    }

    private void getResult() {
        if (result.equals("")) {
            result = "0";
        }

        switch (lastArithmeticOperation) {
            case "+":
                lastResult = Double.parseDouble(result) + lastResult;
                break;
            case "-":
                lastResult = lastResult - Double.parseDouble(result);
                break;
            case "*":
                lastResult = Double.parseDouble(result) * lastResult;
                break;
            case "/":
                lastResult = lastResult / Double.parseDouble(result);
                break;
            case "prime":
                lastResult = Double.parseDouble(result);
        }

        result = "";

    }

    private void initState() {
        result = "0";
        lastResult = 0;
        lastOperation = "";
        lastArithmeticOperation = "prime";

        txtvResult.setText("0");
    }

}