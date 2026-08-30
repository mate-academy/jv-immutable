package core.basesyntax.utils;

import core.basesyntax.Wheel;
import java.util.ArrayList;
import java.util.List;

public class ListDeepCloneUtil {
    public static <T extends Wheel> List<T> deepCollectionClone(List<T> list) {
        List<T> clonedList = new ArrayList<>(list.size());
        for (T item : list) {
            clonedList.add((T) item.clone());
        }
        return clonedList;
    }
}
