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

package org.wso2.custom.transformer.test;

import com.nimbusds.jwt.JWTClaimsSet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.apimgt.common.gateway.jwttransformer.DefaultJWTTransformer;

import java.text.ParseException;

public class ExtendedJWTTransformer extends DefaultJWTTransformer {
    private static final Log log = LogFactory.getLog(ExtendedJWTTransformer.class);
    /**
     * You can define your own custom issuer.
     */
    private static final String ISSUER = "http://localhost:8080/realms/master";
    private static final String CLAIM_NAME = "roles";

    public ExtendedJWTTransformer() {
        super();
    }

    /**
     * This method used to transform JWT claimset from given JWT.
     *
     * @param jwtClaimsSet jwtClaimSet from given JWT
     * @return transformed JWT Claims.
     **/

    @Override
    public JWTClaimsSet transform(JWTClaimsSet jwtClaimsSet) {
        JWTClaimsSet tempJWTClaimsSet = super.transform(jwtClaimsSet);
        JWTClaimsSet.Builder jwtBuilder = new JWTClaimsSet.Builder();
        for (String key : tempJWTClaimsSet.getClaims().keySet()) {
            if (key.equals(CLAIM_NAME)) {
                try {
                    if (tempJWTClaimsSet.getStringArrayClaim(CLAIM_NAME) != null
                            && tempJWTClaimsSet.getStringArrayClaim(CLAIM_NAME).length > 0) {
                        String convertedString = String.join(" ", tempJWTClaimsSet.getStringArrayClaim(CLAIM_NAME));
                        jwtBuilder.claim(key, convertedString);
                    } else {
                        jwtBuilder.claim(key, tempJWTClaimsSet.getClaim(CLAIM_NAME));
                    }
                } catch (ParseException e) {
                    log.warn("Claim roles is not an array");
                    jwtBuilder.claim(key, tempJWTClaimsSet.getClaim("roles"));
                }
            } else {
                jwtBuilder.claim(key, tempJWTClaimsSet.getClaim(key));
            }
        }

        return jwtBuilder.build();
    }

    @Override
    public String getIssuer() {
        return ISSUER;
    }
}
