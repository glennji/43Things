package com.glennji.f3t;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class F3TGoalsActivity extends Activity {
    
    private F3TDao dao;
    private Cursor goalCursor;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        dao = F3TDaoFactory.getFactory(getApplicationContext()).getDao();
        final ListView goalListView = (ListView) findViewById(R.id.goalListView);
        goalCursor = dao.getAllGoalsCursor();
        startManagingCursor(goalCursor);
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                getApplicationContext(), android.R.layout.simple_list_item_1,
                goalCursor, new String[] { "_name" },
                new int[] { android.R.id.text1 });
        goalListView.setAdapter(adapter);
        
    }

    /* (non-Javadoc)
     * @see android.app.Activity#onDestroy()
     */
    @Override
    protected void onDestroy() {
        stopManagingCursor(goalCursor);
        super.onDestroy();
    }
    
    
}