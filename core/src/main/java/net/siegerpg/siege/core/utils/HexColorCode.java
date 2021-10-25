package net.siegerpg.siege.core.utils;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HexColorCode {
    public static boolean isValidHexCode(final String str) {
        // Regex to check valid hexadecimal color code.
        final String regex = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";

        // Compile the ReGex
        final Pattern p = Pattern.compile(regex);

        // If the string is empty
        // return false
        if (str == null) {
            return false;
        }

        // Pattern class contains matcher() method
        // to find matching between given string
        // and regular expression.
        final Matcher m = p.matcher(str);

        // Return if the string
        // matched the ReGex
        return m.matches();
    }

    public static org.bukkit.Color hex2Rgb(final String colorStr) {
        return org.bukkit.Color.fromRGB(
                Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
                Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
                Integer.valueOf( colorStr.substring( 5, 7 ), 16 )
        );
    }
}
