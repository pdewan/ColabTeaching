package im;

import echo.modular.SimpleList;
import echo.modular.ListObserver;

public interface ReplicatedHistory<ElementType> extends SimpleList<ElementType> {
	void replicatedAdd(ElementType newVal);
//	void addReplicatingObserver(HistoryObserver<ElementType> anObserver) ;

	

}
