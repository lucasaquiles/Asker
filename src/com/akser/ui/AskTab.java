package com.akser.ui;

import java.util.ArrayList;

import beans.Question;

import com.akser.repository.UserRepository;
import com.akser.util.QuestionRestUtil;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AskTab extends ListActivity {

	UserRepository userRepository = new UserRepository();
	QuestionRestUtil questionRestUtil = new QuestionRestUtil();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		try {

			ArrayList<Question> questions = questionRestUtil.loadAllQuestions();

			if (questions.size() > 0) {
				setListAdapter(new ArrayAdapter<Question>(this,
						android.R.layout.simple_list_item_1, questions));
				
			} else {
				setListAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1,
						new String[] { "vazio" }));
			}

		} catch (Exception e) {

		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);

		Question q = (Question) l.getItemAtPosition(position);

		
		
		Toast.makeText(getApplicationContext(),
				"pergunta feita por: [" + q.getUser().getFullName() + "] e tem ["+q.getResponse().size()+"] respostas", Toast.LENGTH_LONG)
				.show();
	}

}
