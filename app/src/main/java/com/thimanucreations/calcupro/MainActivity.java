package com.thimanucreations.calcupro;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;

import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private EditText display;
    Button clearButton;
    int i;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        display=findViewById(R.id.input);
        clearButton =findViewById(R.id.clear);


    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void zero(View view) {
        updateText("0");

    }

    public void one(View view) {
        updateText("1");
    
    }

    public void two(View view) {
        updateText("2");

    }

    public void three(View view) {
        updateText("3");

    }

    public void four(View view) {
        updateText("4");

    }

    public void five(View view) {
        updateText("5");

    }

    public void six(View view) {
        updateText("6");

    }

    public void seven(View view) {
        updateText("7");

    }

    public void eight(View view) {
        updateText("8");

    }

    public void nine(View view) {
        updateText("9");

    }
        String plusTwo;

        public void add (View view){
            updateText("+");

            display.addTextChangedListener(new TextWatcher() {   //not work..find solution
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    if (display.getText().toString().equals("++")) {
                        plusTwo = "++";
                    }
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    display.removeTextChangedListener(this);
                    plusTwo = "+";
                    display.setSelection(s.length());
                    display.addTextChangedListener(this);

                }
            });

    }


    public void subtract(View view) {
        updateText("-");

    }

    public void multify(View view) {
        updateText("×");

    }

    public void divide(View view) {
        updateText("÷");

    }

    public void percent(View view) {
        updateText("%");
    }

    public void exponent(View view) {
        updateText("^");
    }

    public void root(View view) {
        updateText("sqrt()");
        display.setSelection(display.getText().length()-1);

    }

    public void brackets(View view) {
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < cursorPos; i++) {
            if (display.getText().toString().startsWith("(", i)) {
                openPar += 1;
            }
            if (display.getText().toString().startsWith(")", i)) {
                closedPar += 1;
            }

        }

        if (openPar == closedPar || display.getText().toString().startsWith("(", textLen-1)) {
            updateText("(");
        }
        else if (closedPar < openPar && !display.getText().toString().startsWith("(", textLen-1)) {
            updateText(")");
        }
        display.setSelection(cursorPos + 1);

    }

    public void clear(View view) {
        display.setText("");
        display.setTextColor(Color.parseColor("#DAFFFFFF"));
        display.setSelection(display.getText().length());

        if(display.getText().toString().equals("0")) {
            display.setEnabled(true);
        }
        display.setTextSize(64);

    }

    public void backspace(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText() .length();
        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos,  "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);

        }

    }

    public void point(View view) {
        updateText(".");

    }

    public void plusmins(View view) {
        updateText("-");

    }


    public void equals(View view) {
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "*");
        userExp = userExp.replaceAll("–", "-");
        userExp = userExp.replaceAll("①", "1");
        userExp = userExp.replaceAll("②", "2");
        userExp = userExp.replaceAll("③", "3");
        userExp = userExp.replaceAll("④", "4");
        userExp = userExp.replaceAll("⑤", "5");
        userExp = userExp.replaceAll("⑥", "6");
        userExp = userExp.replaceAll("⑦", "7");
        userExp = userExp.replaceAll("⑧", "8");
        userExp = userExp.replaceAll("⑨", "9");
        userExp = userExp.replaceAll("∧", "^");
        userExp = userExp.replaceAll("•", ".");
        userExp = userExp.replaceAll("=", "=");
        userExp = userExp.replaceAll("√", "sqrt(");

        display.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                // Nothing to replace
                    if(s.length() == 0)
                        return;

                    String text = s.toString();
                    if(Pattern.matches(".*S.*", text)) {
                        int pos = text.indexOf("NaN");
                        s.replace(pos, pos + 1, "Error");

                        if(display.getText().toString().equals("Error")) {
                            display.setEnabled(false);
                        }
                    }
            }
        });



        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        if(display.getText().length() > 10) {
            display.setTextSize(40);
        }
        display.setSelection(result.length());


        if(display.getText().toString().equals("NaN")) {
            display.setText("Error");
            display.setTextColor(Color.parseColor("#FD005C"));

            if(display.getText().toString().equals("Error")) {
                display.setEnabled(false);
            }
        }
    }

}