package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bjsxt.hibernate.Classes;
import com.bjsxt.hibernate.Student;
import com.bjsxt.hibernate.StudentPK;
import com.bjsxt.hibernate.Teacher;
import com.bjsxt.hibernate.TeacherPK;
import com.bjsxt.hibernate.util.HibernateUtil;

public class test {
	private static SessionFactory sessionFactory = null;

	@BeforeClass
	public static void beforeClass() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	@AfterClass
	public static void afterClass() {
		sessionFactory.close();
	}

	@Test
	public void testStudent() {
		StudentPK pk = new StudentPK();
		pk.setId(1);
		pk.setName("zhangsan");
		Student s = new Student();
		// s.setId(1);
		// s.setName("zhangsan");
		s.setPk(pk);
		s.setAge(8);

		// SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(s);
		session.getTransaction().commit();
	}

	@Test
	public void testTeacher() {
//		TeacherPK pk = new TeacherPK();
//		pk.setId(1);
//		pk.setName("t2");
		Teacher t = new Teacher();
		 t.setId(1);
		 t.setName("t1");
//		t.setPk(pk);
		t.setTitle("middle");

		// SessionFactory sessionFactory = new
		// AnnotationConfiguration().configure().buildSessionFactory();
		// SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
	}

	@Test
	public void testClasses() {
		Classes c = new Classes();
		c.setId(1);
		c.setName("初三");
		c.setNo("8");

		Session s = sessionFactory.openSession();
		s.beginTransaction();
		s.save(c);
		s.getTransaction().commit();
	}

	public static void main(String[] args) {
		beforeClass();
	}
}
