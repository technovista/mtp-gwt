package pos.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.hibernate.transform.ResultTransformer;

import com.Exam.shared.Test;
import com.Exam.shared.TestObjective;
import com.google.gwt.user.client.Window;
import com.pos.shared.User;
public class MySQLRdbHelper {

	/**
	 * @uml.property  name="session"
	 * @uml.associationEnd  readOnly="true"
	 */
	private Session session;
	/**
	 * @uml.property  name="sessionFactory"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="com.pos.shared.User"
	 */
	private SessionFactory sessionFactory;
	/**
	 * @param sessionFactory
	 * @uml.property  name="sessionFactory"
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public User getAuthentication(String userid, String password)
	{

		User users = null;
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("emailId", userid));
		crit.add(Restrictions.eq("password", password));

		List rsList = crit.list();
		for(Iterator it=rsList.iterator();

		it.hasNext();
		)
		{
			users = (User)it.next();
			System.out.println(users.getEmailId());
		}
		session.close();
		return users;
	}

	public ArrayList<Test> fetchTestTypes() {
		Test testType ;
		ArrayList<Test> testTypes = new ArrayList<Test>();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(Test.class);

		ProjectionList proList = Projections.projectionList();
		
		//		  proList.add(Projections.property("testType"));
		//		  proList.add(Projections.property("testId"));
		//		  crit.setProjection(proList);
		//		  crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		//          
		//		crit.setProjection(Projections.distinct(Projections.property("testType")));

		List rsList = crit.list();
		//		final ResultTransformer trans = new DistinctRootEntityResultTransformer();
		//		crit.setResultTransformer(trans);
		//		List rsList = trans.transformList(crit.list());

		for(Iterator it=rsList.iterator();it.hasNext();)
		{
			testType = new Test();
			testType = (Test)it.next();

			testTypes.add(testType);

		}
		session.close();
		return testTypes;
	}


	public ArrayList<TestObjective> fetchTestObjectives(int testId) {
		TestObjective testObjective ;
		ArrayList<TestObjective> testSubTypes = new ArrayList<TestObjective>();
		Session session = sessionFactory.openSession();
		Criteria crit = session.createCriteria(TestObjective.class);
		crit.add(Restrictions.eq("testId", testId));
		List rsList = crit.list();
		for(Iterator it=rsList.iterator();it.hasNext();)
		{
			testObjective = new TestObjective();
			testObjective = (TestObjective)it.next();

			testSubTypes.add(testObjective);

		}
		session.close();
		return testSubTypes;
	}
}
