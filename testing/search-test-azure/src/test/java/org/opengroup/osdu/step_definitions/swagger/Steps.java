//  Copyright © Microsoft Corporation
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.

package org.opengroup.osdu.step_definitions.swagger;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.opengroup.osdu.common.swagger.SwaggerSteps;
import org.opengroup.osdu.util.AzureHTTPClient;
import org.opengroup.osdu.util.Config;

public class Steps extends SwaggerSteps {

  public Steps() {
    super(new AzureHTTPClient());
  }

  @Before
  public void before(Scenario scenario) {
    this.scenario = scenario;
    this.httpClient = new AzureHTTPClient();
  }

  /******************Inputs being set**************/

  @When("^I send get request to swagger endpoint$")
  public void i_send_get_request_to_swagger_endpoint() {
    super.i_send_get_request_to_swagger_endpoint();
  }

  /******************Assert final response**************/

  @Then("^I should get openapi spec in response$")
  public void i_should_get_openapi_spec_in_response() {
    super.i_should_get_openapi_spec_in_response();
  }

  @Override
  protected String getHttpMethod() {
    return "GET";
  }

  @Override
  protected String getApi() {
    return Config.getSearchBaseURL() + "api-docs";
  }
}
