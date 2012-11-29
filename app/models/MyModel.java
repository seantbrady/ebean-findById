package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyModel extends Model {

    @Id
    public Long id;

    public static Finder<Long, MyModel> find = new Finder(Long.class, MyModel.class);

}
