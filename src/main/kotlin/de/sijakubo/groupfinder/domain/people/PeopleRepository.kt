package de.sijakubo.groupfinder.domain.people

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface PeopleRepository : JpaRepository<People, UUID> {

}
