package todd.games.client;


import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface SkeetergoriesServiceAsync {
	
	void getQuestionList(AsyncCallback<String[]> callback);
	void getQuestionList(int listNumber, AsyncCallback<String[]> callback);
}
