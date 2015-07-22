package im.access;

import util.models.PropertyVetoerRegisterer;
import util.models.Vetoer;
import util.models.VetoerRegisterer;
import im.ReplicatedSimpleList;

public interface ControlledReplicatedHistory<ElementType> extends ReplicatedSimpleList<ElementType>, PropertyVetoerRegisterer {

	

//	public void addVetoer(Vetoer theVetoer);
//	public void removeVetoer(Vetoer theVetoer);
}
