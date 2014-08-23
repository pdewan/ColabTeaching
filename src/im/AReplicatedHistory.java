package im;

import java.util.ArrayList;
import java.util.List;

import trace.echo.modular.OperationName;
import trace.im.ListEditSent;
import util.session.Communicator;
import util.tags.ApplicationTags;
import util.trace.Tracer;
import util.trace.session.AddressedSentMessageInfo;
import echo.modular.ASimpleList;
import echo.modular.ListObserver;

public class AReplicatedHistory<ElementType> extends ASimpleList<ElementType> implements ReplicatedHistory<ElementType> {
	Communicator communicator;
	List<ListObserver<ElementType>> replicatingObservers = new ArrayList();

	public AReplicatedHistory(Communicator theCommunicator) {
		communicator = theCommunicator;
	}
	public synchronized void replicatedAdd(ElementType anInput) {
		int anIndex = size();
		super.observableAdd(anIndex, anInput);
		if (communicator == null) return;
//		communicator.toOthers(new ARemoteInput(input));
//		communicator.toOthers(input);
		ListEdit listEdit = new AListEdit<ElementType>(OperationName.ADD, anIndex, anInput, ApplicationTags.IM);
		ListEditSent.newCase(
				communicator.getClientName(),
				listEdit.getOperationName(), 
				listEdit.getIndex(), 
				listEdit.getElement(), 
				listEdit.getList(),
			AddressedSentMessageInfo.OTHERS, this);
		communicator.toOthers(listEdit);
//		notifyReplicatingObservers(normalizedIndex(anIndex), anInput);
		notifyReplicatingObservers(anIndex, anInput);



	}
	public void notifyReplicatingObservers(int index, ElementType newValue) {
//		ListEditNotified.newCase(OperationName.ADD, index, newValue, ApplicationTags.IM, this);
//		for (HistoryObserver<ElementType> observer:observers)
//			observer.elementAdded(index, newValue);
		notifyAdd(replicatingObservers, index, newValue);
	}

//	@Override
//	public void addReplicatingObserver(HistoryObserver<ElementType> anObserver) {
//		replicatingObservers.add(anObserver);
//		
//	}
//	
}
