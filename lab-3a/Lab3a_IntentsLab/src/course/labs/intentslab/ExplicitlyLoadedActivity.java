package course.labs.intentslab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.net.Uri;


public class ExplicitlyLoadedActivity extends Activity {

	static private final String TAG = "Lab-Intents";

	private EditText mEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.explicitly_loaded_activity);

		// Get a reference to the EditText field
		mEditText = (EditText) findViewById(R.id.editText);

		// Declare and setup "Enter" button
		Button enterButton = (Button) findViewById(R.id.enter_button);
		enterButton.setOnClickListener(new OnClickListener() {

			// Call enterClicked() when pressed

			@Override
			public void onClick(View v) {

				enterClicked();
			
			}
		});

	}

	// Sets result to send back to calling Activity and finishes
	
	private void enterClicked() {

		Log.i(TAG,"Entered enterClicked()");
		
		// XXX - Save user provided input from the EditText field
		String user_text = mEditText.getText().toString();
		Log.i(TAG,user_text);

		// XXX - Create a new intent and save the input from the EditText field as an extra
		String myBrowser = "course.labs.intentslab.mybrowser";
		Intent intent = new Intent();
		Log.i(TAG, intent.toString());
		intent = getApplicationContext().getPackageManager().getLaunchIntentForPackage(myBrowser);
		Log.i(TAG, intent.toString());
		intent.putExtra("user_text", user_text);

		//OPTIONAL BLOCK NOT IN ASSIGNMENT
		//intent.setData(Uri.parse(user_text));
		//startActivity(intent);

		// XX - Set Activity's result with result code RESULT_OK
		setResult(Activity.RESULT_OK);
		setResult(Activity.RESULT_OK, intent);

		// XXX - Finish the Activity
		finish();

	}
}

