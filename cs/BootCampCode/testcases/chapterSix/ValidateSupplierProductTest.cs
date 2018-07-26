﻿using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using OpenQA.Selenium.Support.UI;
using System.Collections.Generic;

namespace BootCampCode.testcases.chapterSix
{
    [TestClass]
    public class ValidateSupplierProductTest
    {
        [TestMethod]
        public void ValidateSupplierProduct()
        {
            IWebDriver driver = new ChromeDriver();

            WebDriverWait myWaitVar = new WebDriverWait(driver, TimeSpan.FromSeconds(20));

            // Open the website
            driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php");

            driver.Manage().Window.Maximize();

            SelectElement dropdown = new SelectElement(driver.FindElement(By.CssSelector("select[name='supplier_list']")));
            //try
            //{
                dropdown.SelectByText("AppleStore");
            //}
            //catch (StaleElementReferenceException e)
            //{
            //    Console.WriteLine(e);
            //}

            //myWaitVar.Until(ExpectedConditions.StalenessOf(driver.FindElement(By.XPath("//*[@id='suppliers_block_left']/div/form/div/div/select/option[2]"))));

            IList<IWebElement> supplierProducts = driver.FindElements(by: By.CssSelector("h5[itemprop='name']>a"));

            //option - bit messy but works
            Boolean macBookFound = false;
            for (int i = 0; i < supplierProducts.Count; i++)
            {
                if (supplierProducts[i].Text.Equals("MacBook Air"))
                {
                    macBookFound = true;
                    break;
                }
            }

            Assert.IsTrue(macBookFound, "Check if MacBook Air is in the list");

            driver.Quit();
        }
    }
}
