package com.akser.util;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.protocol.ResponseServer;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import beans.Question;
import beans.User;

import com.google.gson.Gson;

public class UserRestUtil {

	private User user = new User();

	public User getUser() {

		return user;
	}

	public void setUser(User user) {

		this.user = user;
	}

	public User auth(User u, Context context) {

		WebService webService = new WebService(
				"http://10.0.2.2:8080/asker/user/oauthUser");

		Map<String, String> params = new HashMap<String, String>();
		params.put("username", u.getUsername());
		params.put("password", u.getPassword());

		String response = webService.webGet("", params);
		Gson gSon = new Gson();
		
		user = gSon.fromJson(response, User.class);
		
		
		//Toast.makeText(context, "---> "+response+" u --> "+user.getFullName()+" question: "+user.getQuestions().get(0), Toast.LENGTH_LONG).show();
		return user;
	}
}
