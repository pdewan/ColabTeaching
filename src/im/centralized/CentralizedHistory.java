package im.centralized;

import echo.modular.SimpleList;

public interface CentralizedHistory<ElementType> extends SimpleList<ElementType> {
	void centralizedAdd(ElementType newVal, String aUserName);
	

}
