package de.sijakubo.groupfinder.domain.people

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.time.LocalDate
import java.util.*

@Entity
class People {

    @Id
    val id: UUID = UUID.randomUUID()

    @Column(nullable = false)
    val firstname: String? = null

    @Column(nullable = false)
    val lastname: String? = null

    val birthDate: LocalDate? = null
}
