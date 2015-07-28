package com.example.camera;

import android.support.v7.app.ActionBarActivity;
import android.provider.MediaStore;
import android.provider.MediaStore.*;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Build;

public class MainActivity extends ActionBarActivity implements OnClickListener {

	private static final int CAM_REQ = 1888;
	ImageView img;
    Button click;
    Uri output;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //output = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        img=(ImageView)findViewById(R.id.img);
        click = (Button)findViewById(R.id.click);
        click.setOnClickListener(this);
                
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		Intent camin = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		camin.putExtra(MediaStore.EXTRA_OUTPUT, output);
		startActivityForResult(camin, CAM_REQ);
	}
	
	@Override
	protected void onActivityResult(int requestCode,int resultcode,Intent data)
	{
		Bitmap ph = (Bitmap)data.getExtras().get("data");
		img.setImageBitmap(ph);
	}

    /**
     * A placeholder fragment containing a simple view.
     */
   

}
