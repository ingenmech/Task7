package by.epam.evm.pyramid.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {

    private final static String VALID_PATTERN = "(?:\\w<-?\\d+.?\\d*;-?\\d+.?\\d*;-?\\d+.?\\d*>){5}";

    public boolean isValid(String verifyData) {

        Pattern pattern = Pattern.compile(VALID_PATTERN);
        Matcher matcher = pattern.matcher(verifyData);

        return matcher.matches();
    }
}
