package example.myapplication.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    //declare variables
    String tag = "Assignment1";
    private TextView resultText;
    private TextView history;
    Button plusBTN, timesBTN, divideBTN, minusBTN, equalBTN, clearBTN, historyBTN;
    Button oneBTN, twoBTN, threeBTN, fourBTN, fiveBTN, sixBTN, sevenBTN, eightBTN, nineBTN, zeroBTN;
    private Calculator myCalculator;

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(tag, "in OnCreate");
        setContentView(R.layout.activity_main);

        //TextView
        resultText = findViewById(R.id.resultText);
        history = findViewById(R.id.history);
        //operators
        timesBTN = findViewById(R.id.timesBTN);
        plusBTN = findViewById(R.id.plusBTN);
        minusBTN = findViewById(R.id.minusBTN);
        divideBTN = findViewById(R.id.divideBTN);
        equalBTN = findViewById(R.id.equalBTN);
        clearBTN = findViewById(R.id.clearBTN);
        historyBTN = findViewById(R.id.historyBTN);
        //numbers
        oneBTN = findViewById(R.id.oneBTN);
        twoBTN = findViewById(R.id.twoBTN);
        threeBTN = findViewById(R.id.threeBTN);
        fourBTN = findViewById(R.id.fourBTN);
        fiveBTN = findViewById(R.id.fiveBTN);
        sixBTN = findViewById(R.id.sixBTN);
        sevenBTN = findViewById(R.id.sevenBTN);
        eightBTN = findViewById(R.id.eightBTN);
        nineBTN = findViewById(R.id.nineBTN);
        zeroBTN = findViewById(R.id.zeroBTN);
        //operators
        timesBTN.setOnClickListener(this);
        plusBTN.setOnClickListener(this);
        minusBTN.setOnClickListener(this);
        divideBTN.setOnClickListener(this);
        //numbers
        oneBTN.setOnClickListener(this);
        twoBTN.setOnClickListener(this);
        threeBTN.setOnClickListener(this);
        fourBTN.setOnClickListener(this);
        fiveBTN.setOnClickListener(this);
        sixBTN.setOnClickListener(this);
        sevenBTN.setOnClickListener(this);
        eightBTN.setOnClickListener(this);
        nineBTN.setOnClickListener(this);
        zeroBTN.setOnClickListener(this);

        history.setEnabled(false);

        //for equal
        equalBTN.setOnClickListener(view -> {
            //it does not work if user click equal button without 2 num and 1 op
            if (myCalculator.calcArray.size() > 2) {
                String currentInput = resultText.getText().toString();
                String result = String.valueOf(myCalculator.calculate());
                resultText.setText(currentInput + "=" + result);
                myCalculator.calcArray.clear();
                myCalculator.input += resultText.getText() + "\n";
            }
            if (history.isEnabled()) {
                history.setText(myCalculator.input);
            }
        });

        //clear
        clearBTN.setOnClickListener(view -> {
            myCalculator.calcArray.clear();
            resultText.setText("");
        });

        historyBTN.setOnClickListener(view -> {
//            historyBTN.setBackgroundColor(R.color.Sienna);
            if (history.isEnabled()) {
                historyBTN.setText("ADVANCE - WITH HISTORY");
                history.setEnabled(false);
                myCalculator.input = ""; //clear
                resultText.setText("");
                history.setText("");
            } else {
                historyBTN.setText("STANDARD - NO HISTORY");
                history.setEnabled(true);
                myCalculator.input = "";
                resultText.setText("");
            }
        });
    }

    @Override
    public void onClick(View view) {
        prepareForCalc(view);
    }

    void prepareForCalc(View view) {
        //まずは全てStringに変換しておく
        String op = ((Button) view).getText().toString();
        if (!myCalculator.validateUserInput(op)) {
//            System.out.println("invalid input");
            return;
        }
        myCalculator.push(op);
        resultText.setText(myCalculator.getCalcArray());
    }

    //procedures
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(tag, "in onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(tag, "in onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        myCalculator = new Calculator();
        Log.d(tag, "in onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(tag, "in onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(tag, "in onDestroy");
    }


}