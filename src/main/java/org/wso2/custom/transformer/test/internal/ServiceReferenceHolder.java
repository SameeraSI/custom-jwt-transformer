/*
 * Copyright (c) 2020, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
 *
 */

package org.wso2.custom.transformer.test.internal;

import org.wso2.carbon.apimgt.impl.APIManagerConfigurationService;

public class ServiceReferenceHolder {

    private static final ServiceReferenceHolder instance = new ServiceReferenceHolder();
    private APIManagerConfigurationService amConfigService;

    private ServiceReferenceHolder() { }

    public static ServiceReferenceHolder getInstance() {
        return instance;
    }

    public APIManagerConfigurationService getApiManagerConfigurationService() {
        return amConfigService;
    }

    public void setAPIManagerConfigurationService(APIManagerConfigurationService amConfigService) {
        this.amConfigService = amConfigService;
    }

}
