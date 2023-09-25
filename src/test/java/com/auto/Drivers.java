package com.auto;

public class Drivers {

    public enum DriverEnum{
        CHROME("webdriver.chrome.driver"),
        FIREFOX("webdriver.gecko.driver"),
        IE("webdriver.ie.driver");
        private String resource;
        DriverEnum(String resource) {
            this.resource = resource;
        }
        public String getResource(){
            return resource;
        }
    }
}
