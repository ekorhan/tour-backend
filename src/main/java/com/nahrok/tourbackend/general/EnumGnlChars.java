package com.nahrok.tourbackend.general;

import com.nahrok.tourbackend.model.CharVal;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnumGnlChars {

    @Getter
    public enum TourChars {
        SEASON(10096L, "season", Long.class),
        ACCOMMODATION(10097L, "accommodation", Boolean.class),
        VISA(10098L, "visa", Boolean.class),
        GIFT(10099L, "gift", String.class);

        private final Long id;
        private final String shortCode;
        private final Class<?> clazz;

        TourChars(Long id, String shortCode, Class<?> clazz) {
            this.id = id;
            this.shortCode = shortCode;
            this.clazz = clazz;
        }

        public static Map<TourChars, String> valMap(List<CharVal> charVal) {
            Map<TourChars, String> valMap = new HashMap<>();
            for (CharVal c : charVal) {
                valMap.put(findIdFromShortCode(c.getShortCode()), c.getVal());
            }

            return valMap;
        }

        public static TourChars findIdFromShortCode(String shortCode) {
            for (TourChars t : TourChars.values()) {
                if (t.shortCode.equals(shortCode)) {
                    return t;
                }
            }
            return null;
        }
    }
}
