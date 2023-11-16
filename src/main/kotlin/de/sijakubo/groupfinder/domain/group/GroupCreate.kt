package de.sijakubo.groupfinder.domain.group

import org.springframework.stereotype.Service

@Service
class GroupCreate(val groupRepository: GroupRepository) {

    fun handle(group: Group): Group {
        return groupRepository.save(group);
    }
}
