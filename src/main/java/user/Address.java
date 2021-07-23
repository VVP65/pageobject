package user;

import java.util.HashMap;
import java.util.Map;

public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}