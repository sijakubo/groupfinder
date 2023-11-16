package de.sijakubo.groupfinder.entrypoint.resources

import de.sijakubo.groupfinder.domain.group.Group
import de.sijakubo.groupfinder.domain.group.GroupCategory

class GroupCreateResource(private val name: String, private val category: GroupCategory) {

    fun toDomain(): Group {
        return Group(
            name = name,
            category = category,
            peoples = emptyList()
        )
    }
}
