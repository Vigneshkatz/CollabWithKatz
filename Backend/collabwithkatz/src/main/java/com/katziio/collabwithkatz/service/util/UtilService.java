package com.katziio.collabwithkatz.service.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.domain.Pageable;

public class UtilService {
    public static String generateUniqueString(){
        return RandomStringUtils.randomAlphanumeric(10);
    }

//    public static Pageable getPageableOfPosts(String sortBy, int offset, int pageSize){
//        if (sortBy != null) {
//            if (sortBy.equalsIgnoreCase(TITLE)) {
//                sortBy = "title";
//            } else if (sortBy.equalsIgnoreCase(PUBLISHED_DATE)) {
//                sortBy = "published_date";
//            } else if (sortBy.equalsIgnoreCase(AUTHOR)) {
//                sortBy = "author";
//            }
//            return PageRequest.of(offset, pageSize, Sort.by(sortBy));
//        }
//        return PageRequest.of(offset, pageSize);
//    }
}
