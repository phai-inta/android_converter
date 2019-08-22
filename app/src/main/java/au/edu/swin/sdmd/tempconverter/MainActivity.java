package au.edu.swin.sdmd.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Conversion conversion = new Conversion();
    private CheckBox inche2Metre;
    private CheckBox feet2Metre;
    private CheckBox mile2Metre;
    private TextView cm;
    private TextView inches;
    private TextView feet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialiseUI(savedInstanceState);
    }

    void initialiseUI(Bundle state) {
        if (state != null) {
            restoreState(state);
        }

        Button inchesConvert = findViewById(R.id.inchesConvert);
        inchesConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertInches2Cm();
            }
        });

        Button feetConvert = findViewById(R.id.feetConvert);
        feetConvert.setOnClickListener(feetClickListener);

        Button mileConvert = findViewById(R.id.mileConvert);
        mileConvert.setOnClickListener(mileClickListener);
    }

    View.OnClickListener feetClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            convertFeet2Inches();
        }
    };

    View.OnClickListener mileClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            convertMile2Feet();
        }
    };

    //called by runtime when the activity is paused and save data to the Bundle
    @Override
    protected void onSaveInstanceState(Bundle state){
        cm = findViewById(R.id.cmView);
        inches = findViewById(R.id.inchesView);
        feet = findViewById(R.id.feetView);

        String sCm = cm.getText().toString();
        String sInche = inches.getText().toString();
        String sFeet = feet.getText().toString();

        state.putString("CM", sCm);
        state.putString("INCHE", sInche);
        state.putString("FOOT", sFeet);
        super.onSaveInstanceState(state);
    }

    private void restoreState(Bundle state){
        String savedCm = state.getString("CM");
        String savedInche = state.getString("INCHE");
        String savedFoot = state.getString("FOOT");

        inche2Metre = findViewById(R.id.inchetoMetre);
        feet2Metre = findViewById(R.id.feet2Metre);
        mile2Metre = findViewById(R.id.mile2Metre);

        if (!inche2Metre.isChecked()) {
            cm = findViewById(R.id.cmView);
            cm.setText(savedCm);
        } else {
            cm = findViewById(R.id.cmView);
            cm.setText(savedCm);
        }

        if (!feet2Metre.isChecked()) {
            inches = findViewById(R.id.inchesView);
            inches.setText(savedInche);
        } else {
            inches = findViewById(R.id.inchesView);
            inches.setText(savedInche);
        }

        if (!mile2Metre.isChecked()) {
            feet = findViewById(R.id.feetView);
            feet.setText(savedFoot);
        } else {
            feet = findViewById(R.id.feetView);
            feet.setText(savedFoot);
        }
        Log.i("savedState: ", savedCm + "/" + savedInche + "/" + savedFoot);
    }


    void convertInches2Cm() {
        EditText inches = findViewById(R.id.incheInput);
        inche2Metre = findViewById(R.id.inchetoMetre);
        if (!inche2Metre.isChecked()) {
            String sCm = conversion.toCentimeter(inches.getText().toString());
            cm = findViewById(R.id.cmView);
            cm.setText(sCm);
        } else {
            String sCm = conversion.inche2Metre(inches.getText().toString());
            cm = findViewById(R.id.cmView);
            cm.setText(sCm);
        }
    }

    void convertFeet2Inches() {
        EditText feet = findViewById(R.id.feetInput);
        feet2Metre = findViewById(R.id.feet2Metre);
        if (!feet2Metre.isChecked()) {
            String sInches = conversion.toInches(feet.getText().toString());
            inches = findViewById(R.id.inchesView);
            inches.setText(sInches);
        } else {
            String sInches = conversion.feet2Metre(feet.getText().toString());
            inches = findViewById(R.id.inchesView);
            inches.setText(sInches);
        }
    }

    void convertMile2Feet() {
        EditText mile = findViewById(R.id.mileInput);
        mile2Metre = findViewById(R.id.mile2Metre);
        if (!mile2Metre.isChecked()) {
            String sFeet = conversion.toFeet(mile.getText().toString());
            feet = findViewById(R.id.feetView);
            feet.setText(sFeet);
        } else {
            String sFeet = conversion.mile2Metre(mile.getText().toString());
            feet = findViewById(R.id.feetView);
            feet.setText(sFeet);
        }
    }
}