package com.example.crm.postgresql_rest.dao.tasks

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*


@Repository
interface TasksRepository : CrudRepository<TasksDao, Long> {

    fun findAllByDoctorIdAndDate(doctorId: Long, date: LocalDate): ArrayList<TasksDao>?

    @Query(nativeQuery = true, value = """select t.id, t.time, t.date, u.name, u.surname, s.name as procedure, s.description, s.cost from tasks t
join doctors d on t.doctor_id = d.id
join user_info u on d.user_id = u.user_id
join services s on t.procedure_id = s.id
where t.user_id = :uId""")
    fun getMyTasks(@Param("uId") uId: Long): List<MyTasks>?

}