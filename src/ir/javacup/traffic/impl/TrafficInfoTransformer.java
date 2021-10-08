package ir.javacup.traffic.impl;


import ir.javacup.traffic.Transformer;

import java.util.Base64;

public class TrafficInfoTransformer<T,I> implements Transformer<TrafficInfo , String> {

    @Override
    public TrafficInfo transform(String input) {
        if(!input.matches ("^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$")){
            throw new IllegalArgumentException("the input is not a base64 string");
        }
        String decodedString;
        byte[] decodedBytes = Base64.getDecoder().decode(input);
        decodedString = new String(decodedBytes);
        if(!decodedString.contains(",")){
            throw new IllegalArgumentException("the decoded input doesn't contain \",\" ");
        }
        String[] params = decodedString.split(",");
        TrafficInfo trafficInfo=  new TrafficInfo( );
        trafficInfo.setLocationCode(params[0]);
        trafficInfo.setTrafficLevel(Integer.valueOf(params[1]));
        return trafficInfo;
    }
}
