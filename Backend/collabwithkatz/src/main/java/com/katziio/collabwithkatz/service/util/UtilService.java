package com.katziio.collabwithkatz.service.util;

import org.apache.commons.lang3.RandomStringUtils;

public class UtilService {
    public static String generateUniqueString(){
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
