import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class JulykanTest {
    //    /TC_1_1  - Тест кейс:
//    //1. Открыть страницу https://openweathermap.org/
//    //2. Набрать в строке поиска город Paris
//    //3. Нажать пункт меню Search
//    //4. Из выпадающего списка выбрать Paris, FR
//    //5. Подтвердить, что заголовок изменился на "Paris, FR"
    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);
        Thread.sleep(5000);

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id ='weather-widget']//input[@placeholder='Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//button[@type='submit']"));

        searchButton.click();
        Thread.sleep(1000);
        WebElement parisFrChoiceInDropDownMenu = driver.findElement(
                By.xpath("//ul[@class='search-dropdown-menu']/li/span[text()='Paris, FR ']")
        );
        parisFrChoiceInDropDownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id='weather-widget']//h2")
        );
        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();


    }


//    @Test
//    public void testName(){
//        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
//        WebDriver driver = new ChromeDriver();
//
//
//        driver.quit();
//        driver.close();
//
//    }
//    TC_11_01
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню Guide
//3.  Подтвердить, что вы перешли на страницу со ссылкой https://openweathermap.org/guide
//    и что title этой страницы OpenWeatherMap API guide - OpenWeatherMap

    @Test
    public void testGuideTitle_WhenClickingMainMenu() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(5000);

        WebElement guideMainMenuField = driver.findElement(
                By.xpath("//div[@id='desktop-menu']//a[@href='/guide']")
        );
        guideMainMenuField.click();

        String actualResult = driver.getTitle();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();


    }
//    TC_11_02
//1.  Открыть базовую ссылку
//2.  Нажать на единицы измерения Imperial: °F, mph
//3.  Подтвердить, что температура для города показана в Фарингейтах


    @Test
    public void testSwitchToFahrenheit_WhenChoosingMetric() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "F";

        driver.get(url);
        Thread.sleep(5000);

        WebElement clickMetricFahrenheit = driver.findElement(
                By.xpath("//div[@id='weather-widget']//div[@class='switch-container']/div[text()='Imperial: °F, mph']")
        );
        clickMetricFahrenheit.click();


        WebElement currentTemp = driver.findElement(
                By.xpath("//div[@class='current-temp']//span[@class='heading']"));

        String str = currentTemp.getText();
        char c = str.charAt(str.length() - 1);
        String actualResult = String.valueOf(c);
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();


    }
//    TC_11_03
//1.  Открыть базовую ссылку
//2. Подтвердить, что внизу страницы есть панель с текстом
// “We use cookies which are essential for the site to work.
// We also use non-essential cookies to help us improve our services. Any data collected is anonymised.
// You can allow all cookies or manage them individually.”
// 3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”

    @Test
    public void testManageCookies_MainPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "We use cookies which are essential for the site to work." +
                " We also use non-essential cookies to help us improve our services. " +
                "Any data collected is anonymised. " +
                "You can allow all cookies or manage them individually.";

        driver.get(url);
        Thread.sleep(5000);

        WebElement acceptCookiesField = driver.findElement(
                By.xpath("//div[@id='stick-footer-panel']//p")
        );

        String actualResult = acceptCookiesField.getText();

        Assert.assertEquals(actualResult, expectedResult);


        WebElement acceptCookiesButton = driver.findElement(
                By.xpath("//div[@id='stick-footer-panel']//button"));

        expectedResult = "Allow all";
        actualResult = acceptCookiesButton.getText();

        Assert.assertEquals(actualResult, expectedResult);

        WebElement manageCookiesButton = driver.findElement(
                By.xpath("//div[@id='stick-footer-panel']//a")
        );
        expectedResult = "Manage cookies";
        actualResult = manageCookiesButton.getText();


        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();
    }

    //    TC_11_04
//1.  Открыть базовую ссылку
//2.  Подтвердить, что в меню Support есть 3 подменю с названиями “FAQ”, “How to start” и “Ask a question”
    @Test
    public void testSupportMenu_MainPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "FAQ";

        driver.get(url);
        Thread.sleep(5000);

        WebElement SupportField = driver.findElement(
                By.xpath("//div[@id='support-dropdown']")
        );
        SupportField.click();
        WebElement FAQField = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li[1]/a")
        );

        String actualResult = FAQField.getText();
        Assert.assertEquals(actualResult, expectedResult);


        WebElement howToStartField = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li[2]/a")
        );

        expectedResult = "How to start";
        actualResult = howToStartField.getText();

        WebElement askQuestionField = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li[3]/a")
        );

        expectedResult = "Ask a question";
        actualResult = askQuestionField.getText();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }

//    05.Открыть базовую ссылку
//2. Нажать пункт меню Support → Ask a question
//3. Заполнить поля Email, Subject, Message
//4. Не подтвердив CAPTCHA, нажать кнопку Submit
//5. Подтвердить, что пользователю будет показана ошибка “reCAPTCHA verification failed, please try again.”

    @Test
    public void testCaptcha_AskQuestionPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        String email = "abc@gmail.com";
        String message = "abracadabra";
        String url = "https://openweathermap.org/";


        driver.get(url);
        Thread.sleep(5000);

        WebElement SupportField = driver.findElement(
                By.xpath("//div[@id='support-dropdown']")
        );
        SupportField.click();

        WebElement askQuestionField = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li[3]/a")
        );
        askQuestionField.click();
        Thread.sleep(5000);
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

// Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        WebElement emailField = driver.findElement(
        By.id("question_form_email")
        );
        emailField.click();
        emailField.sendKeys(email);

        WebElement questionField = driver.findElement(
                By.xpath("//select[@id='question_form_subject']")
        );
        questionField.click();

        WebElement answerQuestionField = driver.findElement(
                By.xpath("//select[@id='question_form_subject']/option[2]")
        );
        answerQuestionField.click();

        WebElement messageElement = driver.findElement(
                By.xpath("//textarea[@id='question_form_message']")
        );
        messageElement.click();
        messageElement.sendKeys(message);

        //form[@id="new_question_form"]//input[@type='submit']
        WebElement submitElement = driver.findElement(
                By.xpath("//form[@id='new_question_form']//input[@type='submit']")
        );
        submitElement.click();

        WebElement notificationElement = driver.findElement(
                By.xpath("//form[@id=\"new_question_form\"]//div[@class='help-block']")
        );
        String expectedResult = "reCAPTCHA verification failed, please try again.";
        String actualResult = notificationElement.getText();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }

//        TC_11_06
//    1.  Открыть базовую ссылку
//    2.  Нажать пункт меню Support → Ask a question
//    3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
//                4. Оставить пустым поле Email
//    5. Заполнить поля  Subject, Message
//    6. Подтвердить CAPTCHA
//    7. Нажать кнопку Submit
//    8. Подтвердить, что в поле Email пользователю будет показана ошибка “can't be blank”

    @Test
    public void testEmptyEmail_AskQuestionPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();
        String email = "abc@gmail.com";
        String message = "abracadabra";
        String url = "https://openweathermap.org/";


        driver.get(url);
        Thread.sleep(5000);

        WebElement SupportField = driver.findElement(
                By.xpath("//div[@id='support-dropdown']")
        );
        SupportField.click();

        WebElement askQuestionField = driver.findElement(
                By.xpath("//ul[@id='support-dropdown-menu']/li[3]/a")
        );
        askQuestionField.click();
        Thread.sleep(5000);
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();

// Switch to new window opened
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        WebElement questionField = driver.findElement(
                By.xpath("//select[@id='question_form_subject']")
        );
        questionField.click();

        WebElement answerQuestionField = driver.findElement(
                By.xpath("//select[@id='question_form_subject']/option[2]")
        );
        answerQuestionField.click();

        WebElement messageElement = driver.findElement(
                By.xpath("//textarea[@id='question_form_message']")
        );
        messageElement.click();
        messageElement.sendKeys(message);

        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//form[@id='new_question_form']//input[@type='submit']"))).click();

//       driver.switchTo().defaultContent();
//
//
//        WebElement submitElement = driver.findElement(
//                By.xpath("//form[@id='new_question_form']//input[@type='submit']")
//        );
//        submitElement.click();
        Thread.sleep(5000);

//
//        WebElement notificationElement = driver.findElement(
//                By.xpath("//form[@id=\"new_question_form\"]//div[@class='help-block']")
//        );
//        String expectedResult = "reCAPTCHA verification failed, please try again.";
//        String actualResult = notificationElement.getText();
//
//        Assert.assertEquals(actualResult, expectedResult);
//        driver.quit();

    }



//        TC_11_07
//    1.  Открыть базовую ссылку
//    2.  Нажать на единицы измерения Imperial: °F, mph
//
//    3.  Нажать на единицы измерения Metric: °C, m/s
//    4.  Подтвердить, что в результате этих действий, единицы измерения температуры изменились с F на С

    @Test
    public void testSwitchToCelsius_WhenChoosingMetric() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "C";

        driver.get(url);
        Thread.sleep(5000);

        WebElement clickMetricFahrenheit = driver.findElement(
                By.xpath("//div[@id='weather-widget']//div[@class='switch-container']/div[text()='Imperial: °F, mph']")
        );
        clickMetricFahrenheit.click();

        WebElement clickMetricCelsius = driver.findElement(
                By.xpath("//div[@id='weather-widget']//div[@class='switch-container']/div[text()='Metric: °C, m/s']")
        );
        clickMetricCelsius.click();


        WebElement currentTempCelsius = driver.findElement(
                By.xpath("//div[@class='current-temp']//span[@class='heading']"));

        String str = currentTempCelsius.getText();
        char c = str.charAt(str.length() - 1);
        String actualResult = String.valueOf(c);
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();

    }

//        TC_11_08
//    1.  Открыть базовую ссылку
//    2.  Нажать на лого компании
//
//    3.  Дождаться, когда произойдет перезагрузка сайта, и подтвердить, что текущая ссылка не изменилась

    @Test
    public void testClickingLogo_MainPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        String expectedResult = "https://openweathermap.org/";

        driver.get(url);
        Thread.sleep(5000);

        WebElement LogoField = driver.findElement(
                By.xpath("//ul[@id='first-level-nav']/li[1]/a/img")
        );

        LogoField.click();

        Thread.sleep(1000);

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();


    }

    //    TC_11_09
    //1.  Открыть базовую ссылку
    //2.  В строке поиска в навигационной панели набрать “Rome”
    //3.  Нажать клавишу Enter
    //4.  Подтвердить, что вы перешли на страницу в ссылке которой содержатся слова “find” и “Rome”
    //5.  Подтвердить, что в строке поиска на новой странице вписано слово “Rome”

    @Test
    public void testCiteName_WhenSearchingWeatherInYourCity() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Rome";
        String expectedResult = "Rome";

        driver.get(url);
        Thread.sleep(5000);

        WebElement weatherCityField = driver.findElement(
                By.xpath("//div[@id='desktop-menu']/form/input[@placeholder='Weather in your city']")
        );
        weatherCityField.click();
        weatherCityField.sendKeys(cityName);
        weatherCityField.submit();

        WebElement searchField = driver.findElement(
        By.id("search_str"));
        String actualResult = searchField.getAttribute("value");

        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();


    }

//    TC_11_10
//1.  Открыть базовую ссылку
//2.  Нажать на пункт меню API
//3.  Подтвердить, что на открывшейся странице пользователь видит 30 оранжевых кнопок




    @Test
    public void testApiMenu_MainPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";

        driver.get(url);
        Thread.sleep(5000);

        WebElement apiMainMenu = driver.findElement(
                By.xpath("//div[@id='desktop-menu']//a[@href='/api']")
        );
        apiMainMenu.click();
        int actualResult = driver.findElements(By.xpath("//a[contains(@class, 'orange')]")).size();
        int expectedResult = 30;
        Assert.assertEquals(actualResult, expectedResult);
        driver.quit();


    }

}
