package mcm.edu.ph.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.textView);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString()))
                    display.setText("");
            }
        });

    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);
        }
        else{
            display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }

    public void percent(View view){
        updateText("%");
    }

    public void button0(View view){ updateText("0"); }

    public void dot(View view){
        updateText(".");
    }

    public void button1(View view){
        updateText("1");
    }

    public void button2(View view){
        updateText("2");
    }

    public void button3(View view){
        updateText("3");
    }

    public void button4(View view){
        updateText("4");
    }

    public void button5(View view){
        updateText("5");
    }

    public void button6(View view){
        updateText("6");
    }

    public void button7(View view){
        updateText("7");
    }

    public void button8(View view){
        updateText("8");
    }

    public void button9(View view){
        updateText("9");
    }

    public void All_Clear(View view){
        display.setText("");
    }

    public void multiply(View view){
        updateText("×");
    }

    public void division(View view){
        updateText("÷");
    }

    public void addition(View view){
        updateText("+");
    }

    public void subtraction(View view){
        updateText("-");
    }

    public void equal(View view) {
        String userExp = display.getText().toString();

        userExp = userExp.replaceAll("÷", "/");
        userExp = userExp.replaceAll("×", "/");

        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

}