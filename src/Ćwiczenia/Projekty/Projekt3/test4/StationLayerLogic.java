package Ćwiczenia.Projekty.Projekt3.test4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public
    class StationLayerLogic {

    protected List<BaseStation> synchronizedStationsList;

    public StationLayerLogic() {
        this.synchronizedStationsList = Collections.synchronizedList(new ArrayList<>());
    }
}
