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

public class MyAskTab extends ListActivity {

	UserRepository userRepository = new UserRepository();
	QuestionRestUtil questionRestUtil = new QuestionRestUtil();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		if (userRepository.getUser() != null) {

			try {
			
				ArrayList<Question> questions = questionRestUtil
						.loadQuestionsFromUser(
								userRepository.getUser().getId(),
								getApplicationContext());
				
//				ArrayList<Question> questions = questionRestUtil
//				.loadAllQuestions();

				if (questions.size() > 0) {
				
					setListAdapter(new ArrayAdapter<Question>(this,
							android.R.layout.simple_list_item_1,
							questions));
				} else {
					
					setListAdapter(new ArrayAdapter<String>(this,
							android.R.layout.simple_list_item_1,
							new String[] { "vazio" }));
				}
			} catch (Exception e) {
				
				setListAdapter(new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1,
						new String[] { "exception: "+e.getMessage().toString() }));
			}

			// Question question = questionRestUtil
			// .loadQuestionsFromUser(userRepository.getUser().getId(),
			// getApplicationContext());
			//
			// if(question != null){
			// Toast.makeText(this,
			// "Opa, "+userRepository.getUser().getFullName(),
			// Toast.LENGTH_LONG).show();
			//
			// }else{
			// Toast.makeText(this, "foi não, em!", Toast.LENGTH_LONG).show();
			// }
			// setListAdapter(new ArrayAdapter<Question>(this,
			// android.R.layout.simple_list_item_1, questions));

		} else {

			setListAdapter(new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1,
					new String[] { "sem perguntas!" }));

		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		Question q = (Question) l.getItemAtPosition(position);
		
		Toast.makeText(getApplicationContext(), "pergunta feita por: "+q.getUser().getId(), Toast.LENGTH_LONG).show();

	}
}
