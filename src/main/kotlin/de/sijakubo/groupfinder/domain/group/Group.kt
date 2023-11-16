package de.sijakubo.groupfinder.domain.group

import de.sijakubo.groupfinder.domain.people.People
import jakarta.persistence.*
import org.hibernate.Hibernate
import java.util.*

@Entity(name = "groups")
class Group(
    @Id val id: UUID = UUID.randomUUID(),
    @Column(nullable = false) val name: String,
    @Column(nullable = false) val category: GroupCategory,
    @ManyToMany
    @JoinTable(
        name = "group_people",
        joinColumns = [JoinColumn(name = "group_id")],
        inverseJoinColumns = [JoinColumn(name = "people_id")]
    )
    val peoples: List<People>
) {

    @Override
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Group

        return id == other.id
    }

    @Override
    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return "Group(id=$id, name=$name, category=$category, peoples=$peoples)"
    }


}
