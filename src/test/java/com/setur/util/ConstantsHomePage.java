package com.setur.util;

import org.openqa.selenium.By;

public class ConstantsHomePage {
    // Burada ekranda Otel Tab'nın içinde yazan "Kaç Kişi Konaklayacaksınız?" textini seçtik. Diğer tablarda bu text yoktu.
    // Bu text ekranda varsa Otel Tab'ı aktiftir.
    public static final By OTEL_TAB = By.xpath("//span[contains(text(),'Kaç Kişi Konaklayacaksınız?')]");

    public static final By CLOSE_POPUP = By.cssSelector(".ins-close-button");
    public static final By CLOSE_COOKIE_MODAL = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinDeclineAll");

    // İki türlü seçebiliyoruz Otel inputunu
    public static final By OTEL_INPUT = By.cssSelector("[placeholder='Otel Adı Veya Konum']");
    //public static final By OTEL_INPUT = By.cssSelector("[aria-label='search-input']");
}
