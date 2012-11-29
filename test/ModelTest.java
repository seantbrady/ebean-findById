import models.MyModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import play.test.FakeApplication;

import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.*;

public class ModelTest {

    protected static FakeApplication application;

    @Before
    public void setUp() {
        application = fakeApplication();
        try {
            start(application);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        stop(application);
    }

    @Test
    public void findById() {
        MyModel m1 = new MyModel();
        m1.save();

        MyModel m2 = new MyModel();
        m2.save();

        MyModel mFound = MyModel.find.byId(1L);

        assertThat(mFound).isNotNull();
        assertThat(mFound.id).isEqualTo(1L);
    }

    @Test(expected = NullPointerException.class)
    public void findByNullId() {
        MyModel m1 = new MyModel();
        m1.save();

        MyModel m2 = new MyModel();
        m2.save();

        MyModel mFound = MyModel.find.byId(null);

        assertThat(mFound).isNull();
    }

    @Test
    public void idEq() {
        MyModel m1 = new MyModel();
        m1.save();

        MyModel m2 = new MyModel();
        m2.save();

        MyModel mFound = MyModel.find.where().idEq(1L).findUnique();

        assertThat(mFound).isNotNull();
        assertThat(mFound.id).isEqualTo(1L);
    }

    @Test(expected = NullPointerException.class)
    public void idEqOneRowNullId() {
        MyModel m1 = new MyModel();
        m1.save();

        MyModel mFound = MyModel.find.where().idEq(null).findUnique();
        System.out.println("Searched for NULL and found id: " + mFound.id);

        assertThat(mFound).isNull();
    }

    @Test(expected = NullPointerException.class)
    public void idEqNullId() {
        MyModel m1 = new MyModel();
        m1.save();

        MyModel m2 = new MyModel();
        m2.save();

        MyModel mFound = MyModel.find.where().idEq(null).findUnique();

        assertThat(mFound).isNull();
    }
}
