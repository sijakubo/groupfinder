package de.sijakubo.groupfinder.entrypoint.resources

import de.sijakubo.groupfinder.domain.group.Group
import de.sijakubo.groupfinder.domain.group.GroupCategory
import java.util.*

class GroupResource {

    private val id: UUID
    private val name: String?
    private val category: GroupCategory?

    constructor(id: UUID, name: String?, category: GroupCategory?) {
        this.id = id
        this.name = name
        this.category = category
    }

    constructor(group: Group) {
        this.id = group.id
        this.name = group.name
        this.category = group.category
    }
}

