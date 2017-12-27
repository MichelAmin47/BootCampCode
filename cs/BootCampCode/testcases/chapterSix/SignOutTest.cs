using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace BootCampCode.testcases.chapterSix
{
    [TestClass]
    public class SignOutTest
    {
        [TestMethod]
        public void SignOut()
        {
            driver = new FirefoxDriver();
            driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php");
            driver.Manage().Window.Maximize();
        }
    }
}
