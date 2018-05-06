package components.enums;

public enum WebDriverType {
    CHROME_DRIVER("ChromeDriver"),
    FIREFOX_DRIVER("FirefoxDriver");

    private String driverType;

    WebDriverType(String driverType){
        this.driverType = driverType;
    }
}
