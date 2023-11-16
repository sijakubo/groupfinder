package de.sijakubo.groupfinder.entrypoint

import de.sijakubo.groupfinder.domain.group.GroupCreate
import de.sijakubo.groupfinder.domain.group.GroupRepository
import de.sijakubo.groupfinder.entrypoint.resources.GroupCreateResource
import de.sijakubo.groupfinder.entrypoint.resources.GroupResource
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(GroupController.MAPPING)
class GroupController(
    private val groupRepository: GroupRepository,
    private val groupCreate: GroupCreate
) {

    @GetMapping
    fun getGroups(@PageableDefault(size = 30, page = 0) pageable: Pageable): Page<GroupResource> {
        return groupRepository.findAll(pageable)
            .map { group -> GroupResource(group.id, group.name, group.category) }
    }

    @PostMapping("/group")
    fun createGroup(@RequestBody groupCreateResource: GroupCreateResource): ResponseEntity<GroupResource> {
        val createdGroup = groupCreate.handle(groupCreateResource.toDomain())
        return ResponseEntity.ok(GroupResource(createdGroup))
    }

    companion object {
        const val MAPPING: String = "/api/group"
    }
}
