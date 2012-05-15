package com.myonlinebd.catalog.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * author webmaster1803@gmail.com
 */
public class MainAppPlace extends Place {

    public static class Tokenizer implements PlaceTokenizer<MainAppPlace> {

        @Override
        public MainAppPlace getPlace(String token) {
            return new MainAppPlace();
        }

        @Override
        public String getToken(MainAppPlace place) {
            return MainAppPlace.class.toString();
        }
    }

}
