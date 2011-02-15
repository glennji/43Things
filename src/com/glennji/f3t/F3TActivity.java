package com.glennji.f3t;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class F3TActivity extends Activity {
    
    private F3TDao dao;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        dao = F3TDaoFactory.getFactory(getApplicationContext()).getDao();
        List<Goal> goals = dao.getAllGoals();
        
        // Test adding a goal
        Goal testGoal = new Goal("Test goal");
        Goal testGoal2 = new Goal("Test goal 2");
        goals.add(testGoal);
        goals.add(testGoal2);
        
        final ListView goalListView = (ListView) findViewById(R.id.goalListView);
        
        // Create the array adapter to bind the array to the listview
        final ArrayAdapter<Goal> aa;
        aa = new ArrayAdapter<Goal>(this, android.R.layout.simple_list_item_1,
                goals);
        
        goalListView.setAdapter(aa);
        
    }
}