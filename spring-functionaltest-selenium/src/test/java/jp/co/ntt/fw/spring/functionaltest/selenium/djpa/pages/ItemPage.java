/*
 * Copyright(c) 2014-2017 NTT Corporation.
 */
package jp.co.ntt.fw.spring.functionaltest.selenium.djpa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import jp.co.ntt.fw.spring.functionaltest.selenium.Page;
import jp.co.ntt.fw.spring.functionaltest.selenium.WebElementOperations;

public class ItemPage implements Page<ItemPage> {

    private WebDriver driver;

    @CacheLookup
    @FindBy(id = "quantity")
    private WebElement quantity;

    @CacheLookup
    @FindBy(id = "update")
    private WebElement updateBtn;

    @CacheLookup
    @FindBy(id = "dirRelatedEntityUpdate")
    private WebElement dirRelatedEntityUpdateBtn;

    @CacheLookup
    @FindBy(id = "itStat")
    private WebElement itemStatus;

    @CacheLookup
    @FindBy(id = "delete")
    private WebElement deleteItemBtn;

    @CacheLookup
    @FindBy(id = "back")
    private WebElement backToOrderListLink;

    @CacheLookup
    @FindBy(id = "dirRelatedEntityDelete")
    private WebElement dirRelatedEntityDeleteBtn;

    @CacheLookup
    @FindBy(id = "deleteNoSuccess")
    private WebElement deleteNoSuccessBtn;

    public ItemPage(WebDriver driver2) {
        this.driver = driver2;
        reload();
    }

    @Override
    public ItemPage reload() {

        PageFactory.initElements(driver, this);
        return this;
    }

    public void setQuantity(Integer quantityVal) {
        WebElementOperations.setValue(quantity, String.valueOf(quantityVal));
    }

    public String getItemStatus() {
        return WebElementOperations.getElementTextValue(itemStatus);
    }

    public void clearQuantityField() {
        quantity.clear();
    }

    public OrdersPage backToOrdersPage() {
        backToOrderListLink.click();
        OrdersPage ordersPage = new OrdersPage(driver);
        return ordersPage;
    }

    public OrdersPage updateQuantity() {
        updateBtn.click();
        OrdersPage ordersPage = new OrdersPage(driver);
        return ordersPage;
    }

    public OrdersPage directUpdateRelatedEntity() {
        dirRelatedEntityUpdateBtn.click();
        OrdersPage ordersPage = new OrdersPage(driver);
        return ordersPage;
    }

    public OrdersPage directDeleteRelatedEntity() {
        dirRelatedEntityDeleteBtn.click();
        OrdersPage ordersPage = new OrdersPage(driver);
        return ordersPage;
    }

    public OrdersPage deleteRelatedEntity() {
        deleteItemBtn.click();
        OrdersPage ordersPage = new OrdersPage(driver);
        return ordersPage;
    }

    public OrdersPage deleteRelatedEntityOfManagedParentEntity() {
        deleteNoSuccessBtn.click();
        OrdersPage ordersPage = new OrdersPage(driver);
        return ordersPage;
    }

}
