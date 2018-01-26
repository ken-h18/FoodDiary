package com.hooper.kenneth.fooddiary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SnacksTreatsWaterActivity extends AppCompatActivity {

    private final int treatMaxNumber = 15;
    private List<TextView> treatList = new ArrayList<>();
    private HashMap<TextView, Integer> timesTouched = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snacks_treats_water);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText snacksEditText;

        createAndInitialiseDoneButton();

        initialiseTreatList(treatList);

        snacksEditText = findViewById(R.id.snacksEdit);
        formatEditTextWithBulletPoints(snacksEditText);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void createAndInitialiseDoneButton()
    {
        Button doneButton = findViewById(R.id.SnacksDoneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                finish();
            }
        });
    }

    private void initialiseTreatList(List<TextView> treatList)
    {
        treatList.add((TextView)findViewById(R.id.treatsText1));
        treatList.add((TextView)findViewById(R.id.treatsText2));
        treatList.add((TextView)findViewById(R.id.treatsText3));
        treatList.add((TextView)findViewById(R.id.treatsText4));
        treatList.add((TextView)findViewById(R.id.treatsText5));
        treatList.add((TextView)findViewById(R.id.treatsText6));
        treatList.add((TextView)findViewById(R.id.treatsText7));
        treatList.add((TextView)findViewById(R.id.treatsText8));
        treatList.add((TextView)findViewById(R.id.treatsText9));
        treatList.add((TextView)findViewById(R.id.treatsText10));
        treatList.add((TextView)findViewById(R.id.treatsText11));
        treatList.add((TextView)findViewById(R.id.treatsText12));
        treatList.add((TextView)findViewById(R.id.treatsText13));
        treatList.add((TextView)findViewById(R.id.treatsText14));
        treatList.add((TextView)findViewById(R.id.treatsText15));

        for(int i=0; i< treatMaxNumber; i++)
        {
            timesTouched.put(treatList.get(i), 0);
        }
    }

    private void treatClickHandler(View target)
    {
        for(int i = 0; i < treatMaxNumber; i++) {
            if (target.getId() == treatList.get(i).getId()) {
                if(timesTouched.get(treatList.get(i)) %3 == 0) {
                    treatList.get(i).setBackgroundResource(R.drawable.rounded_corner_red);
                    timesTouched.put(treatList.get(i), 1);
                }
                else if(timesTouched.get(treatList.get(i)) %3 == 1)
                {
                    treatList.get(i).setBackgroundResource(R.drawable.rounded_corner_half_red);
                    timesTouched.put(treatList.get(i), 2);
                }
                else if(timesTouched.get(treatList.get(i)) %3 == 2)
                {
                    treatList.get(i).setBackgroundResource(R.drawable.rounded_corner_grey);
                    timesTouched.put(treatList.get(i), 3);
                }
            }
        }
    }

    private void formatEditTextWithBulletPoints(final EditText editText)
    {

        if(editText.getText().toString().isEmpty())
        {
            editText.append("\u2022" + " ");
        }

        editText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void afterTextChanged(Editable mEdit)
            {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after){

                System.out.println("BEFORE " + s.length());
                /*if(s.length() == 0)
                {
                    editTextNeedsBulletPoint = true;
                }*/
            }

            public void onTextChanged(CharSequence s, int start, int before, int count){
                System.out.println("AFTER " + s.length());

                if(s.length() > 0) {
                    if (s.toString().substring(s.length() - 1).equals("\n") && before == 0) {
                        editText.append("\u2022" + " ");
                        Toast.makeText(getApplicationContext(), Integer.toString(s.length()), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
