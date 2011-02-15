package com.glennji.f3t;

import com.glennji.f3t.R;
import android.app.Activity;
import android.os.Bundle;

public class F3TActivity extends Activity {
    
    private F3TDaoFactory factory;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        factory = F3TDaoFactory.getFactory(getApplicationContext());
    }
}