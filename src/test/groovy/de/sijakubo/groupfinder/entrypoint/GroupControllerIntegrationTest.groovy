package de.sijakubo.groupfinder.entrypoint

import de.sijakubo.groupfinder.domain.group.Group
import de.sijakubo.groupfinder.domain.group.GroupCategory
import de.sijakubo.groupfinder.domain.group.GroupRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@ControllerIntegrationTest
class GroupControllerIntegrationTest extends Specification {

  @Autowired
  MockMvc mockMvc

  @Autowired
  GroupRepository groupRepository

  @Transactional
  def "should get groups"() {
    given:
      groupRepository.save(new Group(
        UUID.randomUUID(), "test group", GroupCategory.DOG_WALK, []
      ))

    when:
      def response = mockMvc.perform(get(GroupController.MAPPING)
        .contentType(MediaType.APPLICATION_JSON))
        .andReturn().response

    then:
      response.status == HttpStatus.OK.value()
  }
}
