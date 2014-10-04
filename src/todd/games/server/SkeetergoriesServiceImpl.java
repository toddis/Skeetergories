package todd.games.server;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.RequestCallback;

import todd.games.client.SkeetergoriesService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class SkeetergoriesServiceImpl extends RemoteServiceServlet implements
		SkeetergoriesService {

	@Override
	public String[] getQuestionList() {
		 return new String[] {	"Question 1",
								"Question 2",
								"Question 3",
								"Question 4",
								"Question 5",
								"Question 6"};
	}

	@Override
	public String[] getQuestionList(int listNumber) {
		if (listNumber < 1 || listNumber > QuestionConstants.NUM_LISTS) throw new IllegalArgumentException("Invalid list number.");
		
		// Dumb way with string.
		String[] questions = QuestionConstants.QUESTIONS.split("\t");
		int startIndex = 0;
		String listHeader = QuestionConstants.QUESTION_LIST_HEADER + listNumber;
		while (!questions[startIndex].equals(listHeader)) {
			startIndex++;
		}
		int endIndex = startIndex + 1;
		while (!questions[endIndex].startsWith(QuestionConstants.QUESTION_LIST_HEADER))
			endIndex++;
		
		
		return Arrays.copyOfRange(questions, startIndex + 1, endIndex);
	}

	
}
