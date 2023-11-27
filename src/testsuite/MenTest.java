package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    /**
     * 1. userShouldAddProductSuccessFullyTo
     * ShoppingCart()
     * * Mouse Hover on Men Menu
     * * Mouse Hover on Bottoms
     * * Click on Pants
     * * Mouse Hover on product name
     * ‘Cronus Yoga Pant’ and click on size
     * 32.
     * * Mouse Hover on product name
     * ‘Cronus Yoga Pant’ and click on colour
     * Black.
     * * Mouse Hover on product name
     * ‘Cronus Yoga Pant’ and click on
     * ‘Add To Cart’ Button.
     * * Verify the text
     * ‘You added Cronus Yoga Pant to your shopping cart.’
     * * Click on ‘shopping cart’ Link into
     * message
     * * Verify the text ‘Shopping Cart.’
     * * Verify the product name ‘Cronus Yoga Pant’
     * * Verify the product size ‘32’
     * * Verify the product colour ‘Black’
     */
    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        //Mouse Hover on Men Menu
        mouseHoverToElement(By.id("ui-id-5"));
        //Mouse Hover on Bottoms
        mouseHoverToElement(By.xpath("//a[@id='ui-id-18']"));
        //Click on Pants
        clickOnElement(By.xpath("//a[@id='ui-id-23']"));
        //Mouse Hover on product name Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElement(By.xpath("//strong[@class='product name product-item-name']"));
        clickOnElement(By.id("option-label-size-143-item-175"));
        //Mouse Hover on product name Cronus Yoga Pant’ and click on colour Black.
        mouseHoverToElement(By.xpath("//strong[@class='product name product-item-name']"));
        clickOnElement(By.id("option-label-color-93-item-49"));
        //Mouse Hover on product name Cronus Yoga Pant’ and click on Add To Cart Button.
        mouseHoverToElement(By.xpath("//strong[@class='product name product-item-name']"));
        clickOnElement(By.xpath("//button[@title='Add to Cart']"));
        //Verify
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//div[@class='message-success success message']"));
        assertEqualsMethod("Text doesn't match",expectedText,actualText);
        //Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[text()='shopping cart']"));
        //Verify the text ‘Shopping Cart
        String expectedCart = "Shopping Cart";
        String actualCart = getTextFromElement(By.xpath("//span[@class='base']"));
        assertEqualsMethod("Error message",expectedCart,actualCart);
        //Verify the product name ‘Cronus Yoga Pant’
        String expectedPants = "Cronus Yoga Pant";
        String actualPants = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        assertEqualsMethod("Error message",expectedPants,actualPants);
        //Verify the product size ‘32’
        String expectedSize = "32";
        String actualSize = getTextFromElement(By.xpath("//dd[contains(text(),'32 ')]"));
        // Verify colour Black
        String expectedColour = "Black";
        String actualColour = getTextFromElement(By.xpath("//dd[contains(text(),'Black ')]"));
        assertEqualsMethod("Incorrect colour",expectedColour,actualColour);

    }
    @After
    public void setDown(){
        closeBrowser();
    }
}
