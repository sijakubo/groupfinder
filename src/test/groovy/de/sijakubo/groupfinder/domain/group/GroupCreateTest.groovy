package de.sijakubo.groupfinder.domain.group

import spock.lang.Specification

class GroupCreateTest extends Specification {

  GroupRepository groupRepository = Mock()

  def "should create grou"() {
    given:
      def cut = new GroupCreate(groupRepository)

      def testGroup = new Group(UUID.randomUUID(), "test", GroupCategory.DOG_WALK, [])
    when:
      cut.handle(testGroup)

    then:
      1 * groupRepository.save(testGroup) >> testGroup
  }
}
