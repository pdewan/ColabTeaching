package im.access;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import util.annotations.Visible;
import util.session.Communicator;

public class AnAccessController implements AccessController {
	Communicator communicator;
	List<String> inputers = new ArrayList();
	List<String> administrators = new ArrayList();
	String owner;
	public AnAccessController(Communicator theCommunicator) {
		communicator = theCommunicator;
	}
	@Visible(false)
	public boolean hasOwnership(String theUser) {
		return theUser.equals(owner);
	}
	@Visible(false)
	public void setOwner(String theOwner) {
		JOptionPane.showMessageDialog(null, theOwner + " is the owner");
		owner = theOwner;
	}
	@Visible(false)
	public boolean canInput(String theUser) {
		return  inputers.contains(theUser);
	}
	@Visible(false)
	public void addInputterLocal(String newInputer) {
		inputers.add(newInputer);
		String aMessage = newInputer + " can input";
//		JOptionPane.showMessageDialog(null, newInputer + " can input");
		System.out.println(aMessage);
	}
	public void addInputter(String aNewInputer) {
		String aUserName = communicator.getClientName();
		if (!canAdminister(aUserName)) {
				String aMessage = aUserName +
						" does not have authorization to administer";
//				JOptionPane.showMessageDialog(null, aUserName +
//						" does not have authorization to administer");
				System.err.println(aMessage);
			return;
		}
		communicator.toAll(new AnInputAuthorization(aNewInputer));
	}
	@Visible(false)
	public boolean canAdminister(String theUser) {
		return administrators.contains(theUser);
	}
	@Visible(false)
	public void addAdministratorLocal(String newAdminsitrator) {
		administrators.add(newAdminsitrator);
		JOptionPane.showMessageDialog(null, newAdminsitrator + " can administer");
	}
	public void addAdministrator(String newAdminsitrator) {
		if (!hasOwnership(communicator.getClientName())) {
			String aMessage = communicator.getClientName() +
					" is not owner";
//			JOptionPane.showMessageDialog(null, communicator.getClientName() +
//					" is not owner");
			System.err.println(aMessage);
	        return;
	    }
		communicator.toAll(new AnAdministratorAuthorization(newAdminsitrator));
	}
//	@Visible(false)
//	public boolean veto(Object theInput) {
//		boolean retVal = !canInput (communicator.getClientName());
//		if (retVal) {
//			JOptionPane.showMessageDialog(null, communicator.getClientName() +
//					" does not have authorization to input");
//		}
//		return retVal;
//	}
	@Override
	@Visible(false)
	public void vetoableChange(PropertyChangeEvent evt)
			throws PropertyVetoException {
		if (!canInput (communicator.getClientName())) {
			String aMessage = communicator.getClientName() +
					" does not have authorization to input";
//			System.out.println(communicator.getClientName() +
//					" does not have authorization to input");
			System.err.println(aMessage);

			throw new PropertyVetoException(aMessage, evt);
					
		}		
	}
}
