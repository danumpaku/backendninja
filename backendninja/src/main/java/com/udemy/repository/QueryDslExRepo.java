package com.udemy.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.entity.Course;
import com.udemy.entity.QCourse;

@Repository ("queryDslExRepo")
public class QueryDslExRepo {

	private QCourse qCurse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public List<Course> find() {
		JPAQuery<Course> query = new JPAQuery<>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCurse.name.eq("backendninja"));
		Predicate p = qCurse.name.startsWith("D");
		
		predicateBuilder.and(p);
		
		Course c = (Course) query.select(qCurse.name, qCurse.description).from(qCurse).where(predicateBuilder).fetchOne();
		return query.select(qCurse).from(qCurse).where(qCurse.hours.between(5, 10)).fetch();
	}
	
}
