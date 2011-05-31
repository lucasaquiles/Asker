package com.akser.ui;

import com.akser.repository.UserRepository;
import com.akser.util.QuestionRestUtil;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Send extends Activity implements OnClickListener {

	UserRepository userRepository = new UserRepository();
	QuestionRestUtil questionRestUtil = new QuestionRestUtil();

	TextView txtView;
	EditText editTextQuestion;
	Button buttonSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.send_message);

		txtView = (TextView) findViewById(R.id.txtUser);
		txtView.setText(userRepository.getUser().getFullName());
		editTextQuestion = (EditText) findViewById(R.id.txtQuestion);

		buttonSend = (Button) findViewById(R.id.button1);
		buttonSend.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if (v == buttonSend) {
			
			
			String message = questionRestUtil.sendAsk(userRepository.getUser().getId(), editTextQuestion.getText().toString());
			
			if(message.equals("1")){
				
				Toast.makeText(this, "Oopa! pergunta enviada", Toast.LENGTH_SHORT).show();
				editTextQuestion.setText("");
			}else{
				Toast.makeText(this, "Oopa! sua pergunta não pôde ser enviada!", Toast.LENGTH_SHORT).show();
			}
			
		}
	}

}
