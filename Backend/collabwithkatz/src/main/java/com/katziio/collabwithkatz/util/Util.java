package com.katziio.collabwithkatz.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Util {

        public static String generateUniqueFileName() {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String timestamp = dateFormat.format(new Date());
            String randomPart = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
            return timestamp + "_" + randomPart;
        }

}
