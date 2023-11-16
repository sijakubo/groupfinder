package de.sijakubo.groupfinder.entrypoint

import groovy.json.JsonSlurper
import org.springframework.mock.web.MockHttpServletResponse
import spock.lang.Specification

@ControllerIntegrationTest
class ControllerIntegrationSpecification extends Specification {

  static {
    MockHttpServletResponse.metaClass.getJson << { -> return new JsonSlurper().parseText(getContentAsString(StandardCharsets.UTF_8)) }
    MockHttpServletResponse.metaClass.getSlurped << { -> return new JsonSlurper().parseText(getContentAsString(StandardCharsets.UTF_8)) }
    MockHttpServletResponse.metaClass.getJsonPretty << { -> JsonOutput.prettyPrint(JsonOutput.toJson(json)) }
  }
}
