package todd.games.client;


import java.io.File;

import org.gwtbootstrap3.client.ui.Button;

import todd.games.client.widget.SkeetergoriesGameBoardViewImpl;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Skeetergories implements EntryPoint {
	private FlowPanel mainPanel = new FlowPanel();
	private VerticalPanel wordList = new VerticalPanel();
	private Button playGameButton = new Button("Play Game");
	private SkeetergoriesServiceAsync skeetergoriesService = (SkeetergoriesServiceAsync) GWT.create(SkeetergoriesService.class);
	
	
	@Override
	public void onModuleLoad() {
		// TODO Create table for stock data.
//		mainPanel.add(wordList);
//		mainPanel.add(playGameButton);
//		initializeWordList();
//		//initializePlayGameButton();
		
		mainPanel.add(new SkeetergoriesGameBoardViewImpl());
		
		
		RootPanel.get("skeetergories").add(mainPanel);
	}
	
	private void initializeWordList() {
		skeetergoriesService.getQuestionList(1, new AsyncCallback<String[]>() {

			@Override
			public void onSuccess(String[] questionList) {
				for (int i = 0; i < questionList.length; i++) {
					wordList.add(makeQuestionPanel(i + 1, questionList[i]));
				}
			}
			
			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				System.out.println("CRY!!");
			}
			
		});
		
	}

	private HorizontalPanel makeQuestionPanel(int questionNumber, String question) {
		HorizontalPanel questionPanel = new HorizontalPanel();
		questionPanel.add(new Label(questionNumber + "."));
		questionPanel.add(new Label(question));
		return questionPanel;
	}
	
}
