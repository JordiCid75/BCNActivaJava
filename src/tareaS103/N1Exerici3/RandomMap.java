package tareaS103.N1Exerici3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RandomMap extends HashMap {
    public RandomMap() {
        super();
    }

    public RandomMap(Map map) {
        super(map);
    }

    /**
     * Randomize the values on every call to values()
     *
     * @return randomized Collection
     */
    @Override
    public Collection values() {
        List randomList = new ArrayList(super.values());
        Collections.shuffle(randomList);

        return randomList;
    }

}
