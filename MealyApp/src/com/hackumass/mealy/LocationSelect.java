package com.hackumass.mealy;

import java.util.ArrayList;
import java.util.Arrays;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class LocationSelect extends ActionBarActivity implements OnItemClickListener {
	private ListView mLocationListView;
//	private View mContextmenu;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_select);
        
        mLocationListView = (ListView) findViewById(R.id.locations_list_view);
//        mContextmenu = 
        
        // Load the list of dining locations
//        ArrayList<String> locationsList = new ArrayList<String>();
        ArrayList<String> locationsList = new ArrayList<String>(Arrays.asList(
        		getResources().getStringArray(R.array.dining_locations)));
        ListAdapter locationListdapter = new ArrayAdapter<String>(this, 
        		R.layout.location_list_row, locationsList);
        
        mLocationListView.setOnItemClickListener((OnItemClickListener) this);
        
        // Display the list of dining locations
        mLocationListView.setAdapter(locationListdapter);
        registerForContextMenu(mLocationListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_select_context_menu, menu);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.option_view_menu:
                // your first action code
                return true;
            case R.id.option_buy_swipe:
                // your second action code
                return true;
            case R.id.option_sell_swipe:
            	return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    
//    @Override
//    public void onItemClick(View v) {
//    	// TODO Auto-generated method stub
////    	super.onClick(v);
//    	this.openContextMenu(v);
//    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.location_select, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		this.openContextMenu(view);
	}
}
