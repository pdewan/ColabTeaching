package im.access;

import java.beans.VetoableChangeListener;

import util.models.Vetoer;

public interface AccessController extends VetoableChangeListener {
	boolean canInput(String theUser);
	boolean canAdminister(String theUser);
	void addAdministrator(String newAdminsitrator);
	void addInputter(String newInputter);
	void addAdministratorLocal(String newAdminsitrator);
	void addInputterLocal(String newInputter);
	void setOwner(String theOwner);
}
