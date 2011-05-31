package com.akser.ui;

import beans.User;

import com.akser.repository.UserRepository;
import com.akser.util.UserRestUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {
	/** Called when the activity is first created. */

	UserRestUtil userRestUtil = new UserRestUtil();
	EditText txtUsername, txtPassword;
	Button btnLogin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		txtUsername = (EditText) findViewById(R.id.editTextUsername);
		txtPassword = (EditText) findViewById(R.id.editTextPassword);

		btnLogin = (Button) findViewById(R.id.buttonLogin);
		btnLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if (v == btnLogin) {

			User u = new User();
			u.setUsername(txtUsername.getText().toString());
			u.setPassword(txtPassword.getText().toString());

			u = userRestUtil.auth(u, getApplicationContext());

			try {
				
				if (!u.getFullName().equals("")) {
					new UserRepository(u);
					startActivity(new Intent(this, MainTabs.class));
					
				} else {
					Toast.makeText(getApplicationContext(), "usuário e/ou senha inválido(s)",
							Toast.LENGTH_SHORT).show();
				}
			} catch (Exception e) {

			}

		}
	}
}