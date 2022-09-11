package Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetDigits {

    public static int findIntegers(String stringToSearch) {
        Pattern integerPattern = Pattern.compile("-?\\d+");
        Matcher matcher = integerPattern.matcher(stringToSearch);

        String integerString = "";
        while (matcher.find()) {
            integerString += matcher.group();
        }

        return Integer.parseInt(integerString);
    }
}
