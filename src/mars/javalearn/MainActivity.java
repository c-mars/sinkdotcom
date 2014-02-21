package mars.javalearn;

import c.mars.javalearn.R;
import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
	private EditText mEditText;
	private TextView mTextView;
	String mEnterGuess = "Enter guess here";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		mTextView = (TextView)findViewById(R.id.textView);
    	
		int[] a = {2, 3, 4};
		StringBuilder sb = new StringBuilder();
		
		for (int e : a) {
			sb.append(e + " ");
		}
		
		mTextView.setText(sb.toString());
		
		mEditText = (EditText)findViewById(R.id.editText);
		Button b = (Button)findViewById(R.id.button);
		
		mEditText.setText(mEnterGuess);
		mEditText.setOnClickListener(
			new View.OnClickListener() {
				public void onClick(View view) {
					if (mEditText.getText().toString().equals(mEnterGuess))
						mEditText.setText("");
					}
				}
		);
		
		b.setText("Click to guess");
		b.setOnClickListener( 
			new View.OnClickListener() {
				public void onClick(View view) {
					String s = mEditText.getText().toString();
					try {
						int guess = Integer.parseInt(s);
						StringBuilder sb = new StringBuilder();
						sb.append("Guess is ");
						sb.append(guess);
						mTextView.setText(sb.toString());
					}
					catch(Exception e) {
						mTextView.setText("Wrong input. Retry.");
					}
					}
				}
		);
	}
}
