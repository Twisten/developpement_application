package utils;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Utils {
    private Utils() {
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    public static void closeWindow(Window window) {
        window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
    }
}
