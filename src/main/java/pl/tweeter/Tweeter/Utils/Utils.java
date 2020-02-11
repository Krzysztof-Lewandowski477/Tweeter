package pl.tweeter.Tweeter.Utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class Utils {
    public static String getName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
