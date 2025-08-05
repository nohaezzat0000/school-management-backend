package com.school.modules.GradesAndClasses.Repositories;

import com.school.modules.GradesAndClasses.Models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

}
