/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.mb.integration.common.utils.ui.pages.configure;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.wso2.mb.integration.common.utils.ui.UIElementMapper;

public class UserManagementPage {
    private static final Log log = LogFactory.getLog(TenantHomePage.class);
    private WebDriver driver;

    public UserManagementPage(WebDriver driver) {
        this.driver = driver;

        if(!driver.findElement(By.xpath(UIElementMapper.getInstance()
                        .getElement("configure.user.mgt.header.xpath"))).getText().contains("User Management")){

            throw new IllegalStateException("This is not the User Management page");
        }
    }

    public RolesPage getRolesPage() throws Exception {
        driver.findElement(By.xpath(UIElementMapper.getInstance().getElement("configure.usr.mgt.roles.link.xpath"))).click();
        return new RolesPage(driver);
    }

    public UsersPage getUsersPage() throws Exception {
        driver.findElement(By.xpath(UIElementMapper.getInstance().getElement("configure.usr.mgt.users.link.xpath"))).click();
        return new UsersPage(driver);
    }
}
