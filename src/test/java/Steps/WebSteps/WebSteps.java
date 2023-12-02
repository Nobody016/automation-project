package Steps.WebSteps;

import Pages.WebPage;
import net.serenitybdd.annotations.Step;

public class WebSteps {
    private WebPage webPage = new WebPage();

    @Step
    public void navigateToUrl(String url) {
        webPage.navigateToUrl(url);
    }
    @Step
    public void waitForTimeInSeconds(String seconds) {
        webPage.wait(seconds);
    }

//    @Step
//    @SneakyThrows
//    public void clickElement(String locator) {
//        webPage.waitForPageToLoad();
//        RetryUtils.withMaximumRetryDurationOnException(WEB_WAIT_TIME_IN_SECONDS, 150, "Element not found: " + locator, () -> {
//            try {
//                webPage.clickObject(locator);
//            } catch (NoSuchElementException | ElementShouldBeEnabledException e) {
//                // Gets a list with all the iframes on page and iterates through it trying to locate the element in one of the frames
//                // If there is no iframe on page then an error is thrown in order to continue the retry process
//                List<WebElement> listOfIframes = webPage.getIFramesList();
//                int listSize = listOfIframes.size();
//                if (listSize > 0) {
//                    for (int i = 0; i < listSize; i++) {
//                        WebElement iFrame = listOfIframes.get(i);
//                        try {
//                            webPage.switchFrame(iFrame);
//                            webPage.clickObject(locator);
//                            break;
//                        } catch (Exception exception) {
//                            //switch back from frame if failed in order to be prepared for retrying without being into a frame
//                            webPage.switchBackFromFrame();
//                            if (i == listSize - 1) {
//                                throw new RuntimeException("Element wasn't found inside iFrame or element wasn't intractable!");
//                            }
//                        }
//                    }
//                } else {
//                    throw new RuntimeException("No iFrames identified!");
//                }
//                //switch back from frame if failed in order to be prepared for retrying without being into a frame
//                webPage.switchBackFromFrame();
//            }
//        });
//        log.debug("Clicked on the element identified with locator: " + locator);
//    }

}
