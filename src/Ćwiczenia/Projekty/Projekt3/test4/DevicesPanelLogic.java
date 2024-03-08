package Ćwiczenia.Projekty.Projekt3.test4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public
    class DevicesPanelLogic<T> {

    protected List<T> synchronizedDevices;

    public DevicesPanelLogic() {
        this.synchronizedDevices = Collections.synchronizedList(new ArrayList<>());
    }
}
