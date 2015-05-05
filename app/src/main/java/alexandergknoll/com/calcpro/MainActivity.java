package alexandergknoll.com.calcpro;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ActionMenuView;
import android.widget.TextView;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {
    TextView view;

    float storedVal = Float.parseFloat("0");
    boolean operatorPressed = true;
    String lastOperator = "AC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = (TextView)findViewById(R.id.textView);
    }

    public void calcPressAC (View v) {
        view.setText("0");
        storedVal = Float.parseFloat("0");
        operatorPressed = true;
        lastOperator = "AC";
    }

    public void calcPressNum (View v) {
        CharSequence firstVal = view.getText();
        CharSequence secondVal = ((Button)v).getText();
        if (operatorPressed || (firstVal.toString().equals("0"))) {
            view.setText(secondVal.toString());
            operatorPressed = false;
        } else if (!(secondVal.toString().equals("0") && (firstVal.toString().equals("0")))) {
            view.setText(firstVal.toString().concat(secondVal.toString()));
            operatorPressed = false;
        }
    }

    public void calcPressDecimal (View v) {
        CharSequence currentVal = view.getText();
        if (operatorPressed) {
            view.setText("0.");
        } else if (!currentVal.toString().contains(".")) {
            view.setText(currentVal.toString().concat("."));
        }
        operatorPressed = false;
    }

    public void calcPressOperator (View v) {
        CharSequence currentDisplay = view.getText();
        float currentVal = Float.parseFloat(currentDisplay.toString());

        if (lastOperator.equals("+")) {
            storedVal = storedVal + currentVal;
        } else if (lastOperator.equals("-")) {
            storedVal = storedVal - currentVal;
        } else if (lastOperator.equals("X")) {
            storedVal = storedVal * currentVal;
        } else if (lastOperator.equals("÷")) {
            storedVal = storedVal / currentVal;
        } else {
            storedVal = currentVal;
        }
        lastOperator = ((Button)v).getText().toString();
        operatorPressed = true;
        view.setText(Float.toString(storedVal));
    }

    public void calcPressNegate (View v) {
        CharSequence currentDisplay = view.getText();
        float currentVal = Float.parseFloat(currentDisplay.toString());
        float negatedVal = Float.parseFloat("0") - currentVal;
        operatorPressed = true;
        view.setText(Float.toString(negatedVal));
    }

}
