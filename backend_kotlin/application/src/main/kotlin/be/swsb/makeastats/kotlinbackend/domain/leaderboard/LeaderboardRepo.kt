package be.swsb.makeastats.kotlinbackend.domain.leaderboard

import be.swsb.makeastats.kotlinbackend.domain.leaderboard.Leaderboard
import be.swsb.makeastats.kotlinbackend.domain.leaderboard.LeaderboardHashId
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import java.util.*

interface LeaderboardRepo {
    @SqlUpdate("insert into leaderboard (id, lid, name) " +
            "values (:leaderboard.id, :leaderboard.lid, :leaderboard.name)")
    fun insert(leaderboard: Leaderboard)

    @SqlQuery("select id, lid, name from leaderboard")
    fun list(): List<Leaderboard>

    @SqlQuery("select id, lid, name from leaderboard where id=:id")
    fun findById(id: UUID): Leaderboard

    @SqlQuery("select id, lid, name from leaderboard where lid=:lid")
    fun findByLeaderboardId(lid: LeaderboardHashId): Leaderboard?

    fun insertAndFind(leaderboard: Leaderboard): Leaderboard {
        insert(leaderboard)
        return findById(leaderboard.id)
    }
}