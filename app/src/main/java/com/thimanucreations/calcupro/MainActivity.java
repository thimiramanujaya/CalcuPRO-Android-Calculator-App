package com.thimanucreations.calcupro;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
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
    private MediaPlayer One, Two, Three, Four, Five, Six, Seven, Eight, Nine, Zero, Plus, Minus, Multi, Divide, Point, Clear, Cut, Bracket, Equal;
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

    /*   Zero = MediaPlayer.create(this, R.raw.zero);

        Zero.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Zero.start();
            }
        });
        Zero.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Zero.release();
            }
        });  */
    }

    public void one(View view) {
        updateText("1");
    /*    One = MediaPlayer.create(this, R.raw.one);

        One.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                One.start();
            }
        });
        One.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                One.release();
            }
        });  */
    }

    public void two(View view) {
        updateText("2");

    /*    Two = MediaPlayer.create(this, R.raw.two);

        Two.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Two.start();
            }
        });
        Two.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Two.release();
            }
        });  */
    }

    public void three(View view) {
        updateText("3");

    /*    Three = MediaPlayer.create(this, R.raw.three);

        Three.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Three.start();
            }
        });
        Three.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Three.release();
            }
        }); */

    }

    public void four(View view) {
        updateText("4");

    /*    Four = MediaPlayer.create(this, R.raw.four);

        Four.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Four.start();
            }
        });
        Four.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Four.release();
            }
        });  */
    }

    public void five(View view) {
        updateText("5");

    /*    Five = MediaPlayer.create(this, R.raw.five);

        Five.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Five.start();
            }
        });
        Five.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Five.release();
            }
        });  */
    }

    public void six(View view) {
        updateText("6");

     /*   Six = MediaPlayer.create(this, R.raw.six);

        Six.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Six.start();
            }
        });
        Six.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Six.release();
            }
        });  */
    }

    public void seven(View view) {
        updateText("7");

    /*    Seven = MediaPlayer.create(this, R.raw.seven);

        Seven.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Seven.start();
            }
        });
        Seven.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Seven.release();
            }
        }); */
    }

    public void eight(View view) {
        updateText("8");

    /*    Eight = MediaPlayer.create(this, R.raw.eight);

        Eight.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Eight.start();
            }
        });
        Eight.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Eight.release();
            }
        }); */
    }

    public void nine(View view) {
        updateText("9");

    /*    Nine = MediaPlayer.create(this, R.raw.nine);

        Nine.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Nine.start();
            }
        });
        Nine.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Nine.release();
            }
        }); */
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


    /*    Plus = MediaPlayer.create(this, R.raw.plus);

        Plus.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Plus.start();
            }
        });
        Plus.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Plus.release();
            }
        }); */
    }


    public void subtract(View view) {
        updateText("-");

    /*    Minus = MediaPlayer.create(this, R.raw.minus);

        Minus.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Minus.start();
            }
        });
        Minus.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Minus.release();
            }
        }); */

    }

    public void multify(View view) {
        updateText("×");

    /*    Multi = MediaPlayer.create(this, R.raw.multi);

        Multi.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Multi.start();
            }
        });
        Multi.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Multi.release();
            }
        }); */
    }

    public void divide(View view) {
        updateText("÷");

    /*    Divide = MediaPlayer.create(this, R.raw.divide);

        Divide.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Divide.start();
            }
        });
        Divide.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Divide.release();
            }
        }); */
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

    /*    Bracket = MediaPlayer.create(this, R.raw.bracket);

        Bracket.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Bracket.start();
            }
        });
        Bracket.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Bracket.release();
            }
        }); */
    }

    public void clear(View view) {
        display.setText("");
        display.setTextColor(Color.parseColor("#DAFFFFFF"));
        display.setSelection(display.getText().length());

        if(display.getText().toString().equals("0")) {
            display.setEnabled(true);
        }
        display.setTextSize(64);
    /*    Clear = MediaPlayer.create(this, R.raw.clear);

        Clear.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Clear.start();
            }
        });
        Clear.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Clear.release();
            }
        }); */
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

     /*   Cut = MediaPlayer.create(this, R.raw.cut);

        Cut.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Cut.start();
            }
        });
        Cut.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Cut.release();
            }
        }); */

    }

    public void point(View view) {
        updateText(".");

    /*    Point = MediaPlayer.create(this, R.raw.point);

        Point.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Point.start();
            }
        });
        Point.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Point.release();
            }
        }); */

    }

    public void plusmins(View view) {
        updateText("-");

    /*    Minus = MediaPlayer.create(this, R.raw.minus);

        Minus.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Minus.start();
            }
        });
        Minus.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Minus.release();
            }
        }); */

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


    /*    Equal = MediaPlayer.create(this, R.raw.eqal);

        Equal.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Equal.start();
            }
        });
        Equal.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Equal.release();
            }
        });  */

        if(display.getText().toString().equals("NaN")) {
            display.setText("Error");
            display.setTextColor(Color.parseColor("#FD005C"));

            if(display.getText().toString().equals("Error")) {
                display.setEnabled(false);
            }
        }
    }

}