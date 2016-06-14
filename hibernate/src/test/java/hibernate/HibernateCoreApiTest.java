package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bjsxt.hibernate.models.Classes;
import com.bjsxt.hibernate.models.Student;
import com.bjsxt.hibernate.models.StudentPK;
import com.bjsxt.hibernate.models.Teacher;
import com.bjsxt.hibernate.util.HibernateUtil;

public class HibernateCoreApiTest {
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
		pk.setName("zhangsan5555");
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
		// TeacherPK pk = new TeacherPK();
		// pk.setId(1);
		// pk.setName("t2");
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("t1");
		// t.setPk(pk);
		t.setTitle("middle");

		// SessionFactory sessionFactory = new
		// AnnotationConfiguration().configure().buildSessionFactory();
		// SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(t);
		System.out.println(t.getId());
		session.getTransaction().commit();
	}

	@Test
	public void testDelete() {
		Teacher t = new Teacher();
		t.setId(1);
		// t.setName("t1");
		// // t.setPk(pk);
		// t.setTitle("middle");

		// SessionFactory sessionFactory = new
		// AnnotationConfiguration().configure().buildSessionFactory();
		// SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.delete(t);
		session.getTransaction().commit();
	}

	@Test
	public void testLoad() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher) session.load(Teacher.class, 2);
		System.out.println(t.getName());
		session.getTransaction().commit();
	}

	@Test
	public void testGet() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Teacher t = (Teacher) session.get(Teacher.class, 2);
		System.out.println(t.getName());
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

	@Test
	public void testUpdate() {
		Session s = sessionFactory.openSession();
		s.beginTransaction();
		Classes c = (Classes) s.get(Classes.class, 1);
		s.update(c);
		c.setName("初3");
		s.getTransaction().commit();
		
//		c.setName("初3");
//		
//		Session s2 = sessionFactory.openSession();
//		s2.beginTransaction();
//		s2.update(c);
//		s2.getTransaction().commit();
	}

	@Test
	public void testUpdate2() {
		Classes c3 = new Classes();
		c3.setId(1);
		c3.setName("初1");
		c3.setNo("8");
		Session s2 = sessionFactory.openSession();
		s2.beginTransaction();
		s2.update(c3);
		s2.getTransaction().commit();
	}

	public static void main(String[] args) {
		// beforeClass();
	}
}
