package com.setur.page;

import com.setur.base.BasePage;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;

import static com.setur.util.ConstantsHomePage.*;
import static com.setur.util.ConstantsValues.*;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void SeturHomepage() {
        String url = getUrl();
        assertTrue("Setur Url Hatalı. Beklenen: " + HOME_PAGE + " Gerçekleşen: " + url, url.equals(HOME_PAGE));

        //Site ilk açıldığında pop'up lar geldiği için test senaryomuz patlıyordu, öncelikle popupları kapattık.
        // clickElement(CLOSE_POPUP);
        //Fakat hızlı çalıştığı için element yüklenmeden sayfada bulmaya çalışıyordu. Wait koyarak çözdüm.

        clickVisibleElement(CLOSE_POPUP, "Close Button Görüntülemedi.");


        //Çerez modalı kapattık.
        //clickElement(CLOSE_COOKIE_MODAL);
        clickVisibleElement(CLOSE_COOKIE_MODAL, "Çerez Reddetme Buttonu Görüntülemedi.");

        assertTrue("Otel Tabı aktif değil.", isElementVisible(OTEL_TAB) );

        sendKeys(Arrays.toString(openCsv().get(0)), OTEL_INPUT );
        webDriverWait();
    }
}
