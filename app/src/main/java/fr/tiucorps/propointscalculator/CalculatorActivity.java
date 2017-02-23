package fr.tiucorps.propointscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity implements NutritionWatcher {

    ValueWatcher m_ServingSizeWatcher;
    TextView m_Points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        EditText editText;

        m_ServingSizeWatcher = new ValueWatcher(this);
        editText = (EditText)findViewById(R.id.servingsize);
        if(editText.getText().length() > 0) {
            m_ServingSizeWatcher.isValid = true;
            m_ServingSizeWatcher.value = Float.parseFloat(editText.getText().toString());
        }
        editText.addTextChangedListener(m_ServingSizeWatcher);

        m_Points = (TextView)findViewById(R.id.points);
    }

    @Override
    public void onValueChanged() {

    }
}
