package todd.games.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("skeetergories")
public interface SkeetergoriesService extends RemoteService {
	String[] getQuestionList();
	String[] getQuestionList(int listNumber);
}
