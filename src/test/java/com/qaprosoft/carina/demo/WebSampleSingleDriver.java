/*
 * Copyright 2013-2018 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.carina.demo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.tag.TestTag;
import com.qaprosoft.carina.demo.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs;
import com.qaprosoft.carina.demo.gui.components.compare.ModelSpecs.SpecType;
import com.qaprosoft.carina.demo.gui.pages.CompareModelsPage;
import com.qaprosoft.carina.demo.gui.pages.HomePage;

/**
 * This sample shows how create Web test with dependent methods which shares existing driver between methods.
 * 
 * @author qpsdemo
 */
public class WebSampleSingleDriver extends AbstractTest {
    HomePage homePage = null;
    CompareModelsPage comparePage = null;
    List<ModelSpecs> specs = new ArrayList<>();

    @BeforeSuite
    public void startDriver() {
        homePage = new HomePage(getDriver());
    }

//  работает
    @Test
    @MethodOwner(owner = "kapinus")
    @TestTag(name = "area test", value = "web")
    public void checkURL(){
        Assert.assertEquals("https://jsonplaceholder.typicode.com", homePage.getPageURL());
    }


    //этот тест работает
    @Test
    @MethodOwner(owner = "kapinus")
    @TestTag(name = "area test", value = "web")
    public void testOpenPage() {
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }

    @Test(dependsOnMethods="testOpenPage")
    @MethodOwner(owner = "kapinus")
    @TestTag(name = "area test", value = "web")
    public void testFind() {
        FooterMenu footerMenu = homePage.getFooterMenu();
        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");
        comparePage = footerMenu.openComparePage();
    }



//
//    //этот тест не работает ( "Footer menu wasn't found!" )
//    @Test(dependsOnMethods="testOpenPage")
//    @MethodOwner(owner = "kapinus")
//    @TestTag(name = "area test", value = "web")
//    public void testOpenCompare() {
//        FooterMenu footerMenu = homePage.getFooterMenu();
//        Assert.assertTrue(footerMenu.isUIObjectPresent(2), "Footer menu wasn't found!");
//        comparePage = footerMenu.openComparePage();
//    }
}
