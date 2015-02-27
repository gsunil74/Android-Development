package com.example.bmicalculatorapp;

import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText enteredWeight = (EditText) findViewById(R.id.WeightEditText);
		final EditText enteredHeight = (EditText) findViewById(R.id.HeightEditText);
		final TextView resultView = (TextView) findViewById(R.id.ResultTextView);
		final TextView resultstmt = (TextView) findViewById(R.id.Resultstmt);
		final Button calculate = (Button) findViewById(R.id.calculate);
		final RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup1);
		final RadioButton EngRadio = (RadioButton) findViewById(R.id.EnglishUnits);
		final RadioButton MetRadio = (RadioButton) findViewById(R.id.MetricUnits);

		EngRadio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if (arg1) {
					enteredWeight.setHint("Weight in Pounds");
					enteredHeight.setHint("Height in Inches");
				}

			}
		});
		MetRadio.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				if (arg1) {
					enteredWeight.setHint("Weight in Kg's");
					enteredHeight.setHint("Height in Meter's");
				}

			}
		});
		calculate.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if(enteredWeight.getText()
						.toString().length()>0 && enteredHeight.getText()
						.toString().length()>0){
				double weight = Float.parseFloat(enteredWeight.getText()
						.toString());
				double height = Float.parseFloat(enteredHeight.getText()
						.toString());

				DecimalFormat d = new DecimalFormat("0.00");
				if (MetRadio.isChecked()) {
					double result = weight / (height * height);
					resultView.setText("Your BMI is :" + "" + d.format(result));
					if (result < 18.5) {
						resultstmt.setText("You are UnderWeight");
					}
					if (result > 18.5 && result < 24.9) {
						resultstmt.setText("You are Normal Weight");
					}
					if (result > 25 && result < 29.9) {
						resultstmt.setText("You are Overweight");
					}
					if (result > 30) {
						resultstmt.setText("You are Obese");
					}
				} else if (EngRadio.isChecked()) {
					double result = ((weight * 703) / (height * height));
					resultView.setText("Your BMI is :" + "" + d.format(result));
					if (result < 18.5) {
						resultstmt.setText("You are UnderWeight");
					}
					if (result > 18.5 && result < 24.9) {
						resultstmt.setText("You are Normal Weight");
					}
					if (result > 25 && result < 29.9) {
						resultstmt.setText("You are Overweight");
					}
					if (result > 30) {
						resultstmt.setText("You are Obese");
					}
				}
			}else{
				Toast.makeText(MainActivity.this, "enter values ", Toast.LENGTH_SHORT).show();
			}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
