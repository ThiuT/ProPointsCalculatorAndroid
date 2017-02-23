package fr.tiucorps.propointscalculator;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by bdj on 22/02/17.
 * For project ProPointsCalculatorAndroid
 */

class ValueWatcher implements TextWatcher {

    NutritionWatcher watcher;
    boolean isValid = false;
    float value = 0f;

    public ValueWatcher(NutritionWatcher _watcher) {
        watcher = _watcher;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable e) {
        try {
            value = Float.parseFloat(e.toString());
            isValid = (value >= 0f);
        } catch (Exception ex) {
            isValid = false;
        }

        if(isValid) {
            watcher.onValueChanged();
        }
    }
}
