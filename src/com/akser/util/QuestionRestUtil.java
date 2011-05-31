package com.akser.util;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import beans.Question;

public class QuestionRestUtil {

	ArrayList<Question> questions = new ArrayList<Question>();
	ArrayList<Question> listQuestions = new ArrayList<Question>();

	Question question = new Question();

	public ArrayList<Question> getListQuestions() {

		return listQuestions;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {

		this.question = question;
	}

	public void setQuestion(ArrayList<Question> questions) {

		this.questions = questions;
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public ArrayList<Question> loadQuestionsFromUser(long id, Context context) {
		WebService webService = new WebService(
				"http://10.0.2.2:8080/asker/question/loadQuestionsForUser/");

		Map<String, String> params = new HashMap<String, String>();
		params.put("uid", Long.toString(id));

		String response = webService.webGet("", params);
		Gson gSon = new Gson();

//		Toast.makeText(context, "Perguuuuntas ----> , " + response,
//				Toast.LENGTH_LONG).show();

		Type listType = new TypeToken<ArrayList<Question>>() {
		}.getType();
		
		
		questions = gSon.fromJson(response, listType);

		return questions;
	}

	public ArrayList<Question> loadAllQuestions() {
		WebService webService = new WebService("http://10.0.2.2:8080/asker/question/loadQuestions/");

		Map<String, String> params = new HashMap<String, String>();

		String response = webService.webGet("", params);
		Gson gSon = new Gson();

		Type type = new TypeToken<ArrayList<Question>>() {
		}.getType();
		
		listQuestions =  gSon.fromJson(response, type);
		
		Log.i("listando: ","tentanto listar as questions");
		for(Object q: listQuestions){
			
			//Question qe = (Question) q;
			Log.i("question: ", q.toString());
		}
		
		//listQuestions =  gSon.fromJson(response, ArrayList.class);
		
		return listQuestions;
	}
	
	public String sendAsk(long uid, String question){
		WebService webService = new WebService("http://10.0.2.2:8080/asker/question/sendQuestion/");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("uid", Long.toString(uid));
		params.put("question", question);

		String response = webService.webGet("", params);
		Gson gSon = new Gson();
		
		return response;
	}
	
}
